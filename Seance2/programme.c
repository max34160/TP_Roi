#include <stdio.h>
#include <stdlib.h>
#include "list.h"

int str_len( const char * word){
    int count = 0;
    while(word[count] != '\0'){
        count++;
    }
    return count;
}


char* str_dup(const char* src){
    int i = 0;

    char* dup = malloc( (str_len(src) + 1) * sizeof(char) );

    while(src[i] != '\0' ){
        dup[i] = src[i];
        i++;
    }
    dup[i] = '\0';
    return dup;
}

char* str_concat_new(const char* a, const char* b){
    char* result = malloc( (str_len(a) +(str_len(b) + 1)) * sizeof(char) );
    int i = 0;
    int j = 0;
    while(a[j] != '\0' ){
        result[i] = a[i];
        i++;
        j++;
    }
    j = 0;
    while(b[j] != '\0' ){
        result[i] = b[j];
        i++;
        j++;
    }
    result[i] = '\0';
    return result;
}

char* str_sub(const char* src, int start, int length){
    char* result = malloc( (length + 1) * sizeof(char) );
    int i = 0;

    while(i != length && src[start] != '\0'){
        result[i] = src[start];
        i++;
        start++;
    }
    result[i] = '\0';
    return result;

}

char* str_repeat(const char* src, int n){
    char* result = malloc( ((str_len(src) * n) + 1) * sizeof(char) );
    int i = 0;
    int j = 0;
    int k = 0;

    while(i != n){
        while(j != str_len(src)){
            result[k] = src[j];
            k++;
            j++;
        }
        j = 0;
        i++;
    }

    result[k] = '\0';
    return result;

}

List* list_create(){
    List* l = malloc(sizeof(List));
    l->capacity = 4;
    l->size = 0;
    l->data = malloc(l->capacity * sizeof(int));
    return l;
}

void list_free(List* l){
    free(l->data);
    free(l);
}

void list_print(const List* l){
    int i = 0;

    while(i < l->size){
        printf(" %d", l->data[i]);
        i++;
    }
    printf("\n");
}

int list_get(const List* l, int index){
    if(index < 0 || index >= l->size){
        printf("erreur : index %d invalide\n", index);
        return -1;
    } 
    return  l->data[index];
}

void list_set(List* l, int index, int value){
    if(index < 0 || index >= l->size) {
        printf("erreur : index %d invalide\n", index);
        return;
    }
    l->data[index] = value;
}

void list_add(List* l, int value){
    if( l->size == l->capacity){
        l->capacity = l->capacity*2;
        l->data = realloc(l->data , l->capacity * sizeof(int));
    }
    l->data[l->size] = value;
    l->size++;
}

int list_pop(List* l){
    if(l->size == 0){
        printf("erreur : la liste est vide\n");
        return -1;
    }
    l->size--;           
    return l->data[l->size];
}

void list_remove(List* l, int index){
    if(index < 0 || index >= l->size) {
        printf("erreur : index %d invalide\n", index);
        return;
    }
    int i = index;
    while(i + 1 < l->size){
        l->data[i] = l->data[i+1];
        i++;
    }
    l->size--;

}

void list_clear(List* l){
    l->size = 0;
}

int main(void) {
    // char original[] = "Hello";
    // char* copie = str_dup(original);
    // printf("original : %s\n", original);   
    // printf("copie    : %s\n", copie); 
    // char part1[] = "Salut ";
    // char part2[] = "toto";
    // char* result = str_concat_new(part1,part2);
    // printf("original : %s\n",result); 
    // char original[] = "Hello";
    // char* result = str_sub(original,0,3);
    // printf("original : %s\n",result);
    // char original[] = "Hello";
    // char* result = str_repeat(original,3);
    // printf("original : %s\n",result);
    // free(result);
    // List* l = list_create();
    // printf("%d %d\n", l->size, l->capacity); 
    // List* l = list_create();
    // l->data[0] = 10;
    // l->data[1] = 20;
    // l->data[2] = 30;
    // l->size = 3;
    // list_print(l);
    // List* l = list_create();
    // l->data[0] = 10;
    // l->data[1] = 20;
    // l->data[2] = 30;
    // l->size = 3;
    // printf("%d\n", list_get(l, 0));      
    // printf("%d\n", list_get(l, 1));      
    // printf("%d\n", list_get(l, 2));
    // printf("%d\n", list_get(l, 3));      
    // printf("%d\n", list_get(l, -1));
    // list_set(l, 1, 99);
    // list_print(l);                       
    // list_set(l, 0, 5);
    // list_print(l); 
    // list_set(l, 3, 123);                 
    // list_set(l, -2, 123);                
    // list_print(l); 
    // List* l = list_create();
    // l->data[0] = 10;
    // l->data[1] = 20;
    // l->data[2] = 30;
    // l->size = 3;
    // list_add(l,40);
    // list_print(l);
    // list_add(l,50);
    // list_print(l);
    // printf("size=%d capacity=%d\n", l->size, l->capacity);
    // list_pop(l);
    // list_print(l);
    // List* l = list_create();
    // list_pop(l);
    // List* l = list_create();
    // l->data[0] = 10;
    // l->data[1] = 20;
    // l->data[2] = 30;
    // l->size = 3;
    // list_remove(l,1);
    // list_print(l);
    // List* l = list_create();
    // l->data[0] = 10;
    // l->data[1] = 20;
    // l->data[2] = 30;
    // l->size = 3;
    // list_remove(l,-1);
    // list_print(l);
    // List* l = list_create();
    // l->data[0] = 10;
    // l->data[1] = 20;
    // l->data[2] = 30;
    // l->size = 3;
    // list_remove(l,3);
    // list_print(l);
    List* l = list_create();
    l->data[0] = 10;
    l->data[1] = 20;
    l->data[2] = 30;
    l->size = 3;
    list_clear(l);
    list_print(l);
    list_free(l);
    return 0;
}