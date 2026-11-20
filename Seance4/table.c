#include <stdio.h>
#include <stdlib.h>
#include "table.h"
#include "strings.h"

int at(int day, int hour, int minute) { // day : 0 = lundi ... 6 = dimanche
    return day * 24 * 60 + hour * 60 + minute;
}

void print_time(int time) {
    const char* days[] = {"Lun", "Mar", "Mer", "Jeu", "Ven", "Sam", "Dim"};
    printf("%s %02d:%02d", days[time / (24 * 60)], (time % (24 * 60)) / 60, time % 60);
}

Row* create_row(int id, const char* value) {
    Row* row = malloc(sizeof(Row));
    if (row == NULL) return NULL;   

    row->id = id;
    row->value = str_dup(value);
    row->height = 1;
    row->left = NULL;
    row->right = NULL;
    return row;
}

void insert_row(Row* node, int id, const char* value){
    if(id == node->id){
        printf("Duplicate entry\n");
    }else if(id < node->id){
        if(node->left == NULL){
            node->left = create_row(id,value);
        }else{
            insert_row(node->left,id,value);
        }

    }else{
        if(node->right == NULL){
            node->right =create_row(id,value);
        }else{
            insert_row(node->right,id,value);
        }
    }
}

Row* select_on_id(Row* node, int id) {
    if (node == NULL) return NULL;                     // arbre vide : absente
    if (id == node->id) return node;                   // trouvée
    if (id < node->id) return select_on_id(node->left, id);
    return select_on_id(node->right, id);
}

void select_order_by(const Row* node){
    if(node == NULL) return;
    select_order_by(node->left);
    print_time(node->id);
    printf(" %s\n", node->value);
    printf(" %d\n", node->height);
    select_order_by(node->right);
}

Row* select_min(Row* node){
    if(node == NULL) return NULL;
    if(node->left == NULL)  return node;      
    return select_min(node->left);
}

Row* select_max(Row* node){
    if(node == NULL) return NULL;
    if(node->right == NULL)  return node;      
    return select_max(node->right);
}

Row *select_next(Row *node, int id){
    if (node == NULL) return NULL;
    if (id == node->id) return node;
    if (id > node->id) return select_next(node->right, id);
    if (id < node->id) {
        Row *r = select_next(node->left, id);
        if (r == NULL) return node;
        if (r != NULL)  return r;
    }
    return NULL;
}

Row* delete_row(Row* node, int id){
    if (node == NULL) return NULL;
    if (id < node->id){
        node->left = delete_row(node->left, id);
        return node;
    }

    if (id > node->id){
        node->right = delete_row(node->right, id);
        return node;
    }

    if (node->left == NULL){
        Row *child = node->right;
        free(node->value);
        free(node);
        return child;
    }

    if (node->right == NULL){
        Row *child = node->left;
        free(node->value);
        free(node);
        return child;
    }

    Row* next = select_min(node->right);
    node->id = next->id;
    free(node->value);
    node->value =  str_dup(next->value);
    node->right = delete_row(node->right, node->id);
    return node;
}

void drop_table(Row* node) {
    if (node == NULL) return;  
    drop_table(node->left);
    drop_table(node->right);                       
    free(node->value);
    free(node);                           
}
int node_height(const Row* node){
    if(node == NULL) return 0;
    return node->height;
}
void update_height(Row* node){
    if (node->left != NULL) update_height(node->left);
    if (node->right != NULL) update_height(node->right);

    int hl = node_height(node->left);
    int hr = node_height(node->right);

    if (hl > hr) {
        node->height = 1 + hl;
    } else {
        node->height = 1 + hr;
    }
    
}

Row* rotate_left(Row* node){
    Row* y = node->right;
    node->right = y->left;
    y->left = node;

    update_height(node);
    update_height(y);
    return y;
}

Row* rotate_right(Row* node){
    Row* y = node->left;
    node->left = y->right;
    y->right = node;

    update_height(node);
    update_height(y);
    return y;
}

Row* rebalance(Row* node){
    update_height(node);
    int balance = node_height(node->left) - node_height(node->right);

    if (balance >= 2) {                      
        if (node_height(node->left->left) < node_height(node->left->right)) {
            node->left = rotate_left(node->left);   
        }
        return rotate_right(node);
    }

    if (balance <= -2) {                     
        if (node_height(node->right->right) < node_height(node->right->left)) {
            node->right = rotate_right(node->right); 
        }
        return rotate_left(node);
    }

    return node;                            
}

Row* insert_balanced(Row* node, int id, const char* value){
    if (node == NULL) return create_row(id, value);  

    if (id == node->id){
        printf("Duplicate entry\n");
        return node;                                  
    }

    if (id < node->id){
        node->left = insert_balanced(node->left, id, value);
    } else {
        node->right = insert_balanced(node->right, id, value);
    }

    return rebalance(node);                           
}