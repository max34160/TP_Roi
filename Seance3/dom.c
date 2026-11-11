#include <stdio.h>
#include <stdlib.h>
#include "dom.h"
#include "strings.h"

Element* create_element(const char* tag, const char* id, const char* text) {
    Element* e = malloc(sizeof(Element));
    if (e == NULL) {
        return NULL;
    }

    e->tag  = str_dup(tag);
    e->id   = id   ? str_dup(id)   : NULL;
    e->text = text ? str_dup(text) : NULL;
    e->nb_children = 0;
    e->capacity = 4;

    e->children = malloc(e->capacity * sizeof(Element*));
    if (e->children == NULL) {
        return NULL;
    }
    return e;
}

void append_child(Element* parent, Element* child) {
    if (parent->nb_children == parent->capacity) {
        parent->capacity *= 2;
        parent->children = realloc(parent->children, parent->capacity * sizeof(Element*));
    }
    parent->children[parent->nb_children] = child;
    parent->nb_children++;
}

int count_elements(const Element* e) {
    if(e->nb_children==0) return 1; // Condition d'arrêt explicite
    int total = 1;                                  // l'élément lui-même
    for (int i = 0; i < e->nb_children; i++) {
        total += count_elements(e->children[i]);    // + tout le sous-arbre de chaque enfant
    }
    return total;
}

int count_by_tag(const Element* e, const char* tag) {
    int total = 0;
    if(str_equals(e->tag, tag)){
        total +=  1;
    }
    for (int i = 0; i < e->nb_children; i++)
        total += count_by_tag(e->children[i], tag);
    return total;
}

int dom_height(const Element* e) {
    int max = 0;
    for (int i = 0; i < e->nb_children; i++) {
        int h = dom_height(e->children[i]);
        if (h > max) max = h;
    }
    return 1 + max;      
}

Element* find_by_id(Element* e, const char* id) {
    if (e->id != NULL && str_equals(e->id, id)) return e;
    for (int i = 0; i < e->nb_children; i++) {
        Element* r = find_by_id(e->children[i], id);
        if (r != NULL) return r;
    }
    return NULL;
}

int depth_of(const Element* e , const char* id) {
    if (e->id != NULL && str_equals(e->id, id)) return 0;
    for (int i = 0; i < e->nb_children; i++) {
        int h = depth_of(e->children[i] , id);
        if (h != -1) return h + 1;
    }
    return -1;      
}

void print_indent(int depth){
    for(int i = 0 ; i < depth * 2 ; i ++) printf(" ");
}

void render(const Element* e, int depth){
    print_indent(depth);
    if (e->id != NULL){
        printf("<%s id=\"%s\">\n", e->tag, e->id);
    }else{ 
        printf("<%s>\n", e->tag);
    }

    for (int i = 0; i < e->nb_children; i++) {
        render(e->children[i] , depth+1);
    }
    print_indent(depth);
    printf("</%s>\n", e->tag);

}

void free_element(Element* e) {
    for (int i = 0; i < e->nb_children; i++){
        free_element(e->children[i]);
    }     
    free(e->children);                  
    free(e->tag);
    free(e->id);                       
    free(e->text);
    free(e);                           
}