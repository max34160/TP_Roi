#include <stdio.h>
#include <stdlib.h>
#include "table.h"

int main(void) {
    Row* events = create_row(at(2, 10, 0), "Réunion d'équipe");
    insert_row(events, at(1, 9, 0),  "Cours de C");
    insert_row(events, at(4, 14, 0), "Démo client");
    insert_row(events, at(0, 8, 30), "Café avec Léa");
    insert_row(events, at(1, 14, 0), "TP de C");
    insert_row(events, at(3, 11, 0), "Dentiste");
    insert_row(events, at(4, 18, 0), "Afterwork");
    insert_row(events, at(1, 12, 0), "Déjeuner");
    update_height(events);
    //insert_row(events, at(1, 9, 0), "doublon");
    // Row *r = select_on_id(events, at(1, 14, 0));
    // if (r != NULL) printf("%s\n", r->value); 
    // r = select_on_id(events, at(1, 15, 0));
    // if (r == NULL) printf("absente\n"); 
    // select_order_by(events);
    // Row *r =  select_min(events);
    // printf("%s\n", r->value);
    // print_time( r->id);
    // r = select_max(events);
    // printf("%s\n", r->value);
    // print_time( r->id);
    // Row* r = select_next(events, at(3, 9, 0));  
    // printf("%s", r->value);
    // print_time( r->id); 
    // printf("\n");
    // r = select_next(events, at(1, 9, 0));        
    // printf("%s", r->value);
    // print_time( r->id);
    // printf("\n"); 
    // r = select_next(events, at(4, 19, 0));       
    // printf("%s", r->value);
    // print_time( r->id); 
    // printf("\n");
    // events = delete_row(events, at(1, 9, 0)); 
    // select_order_by(events);
    // events = rotate_right(events);
    // events = rotate_left(events);
    // select_order_by(events);
    // Row *a = create_row(1, "un");
    // Row *b = create_row(3, "trois");
    // Row *c = create_row(2, "deux");
    // a->right = b; 
    // b->left = c;  
    // update_height(b); 
    // update_height(a); 
    // a = rebalance(a); 
    // printf("racine : %d\n", a->id);
    // select_order_by(a);
    // drop_table(a);
    // drop_table(events);
    Row* t1 = NULL;
    t1 = insert_balanced(t1, 1, "a");
    t1 = insert_balanced(t1, 3, "b");
    t1 = insert_balanced(t1, 2, "c");
    printf("racine (1,3,2) : %d\n", t1->id);          

    Row* t2 = NULL;
    t2 = insert_balanced(t2, 3, "a");
    t2 = insert_balanced(t2, 1, "b");
    t2 = insert_balanced(t2, 2, "c");
    printf("racine (3,1,2) : %d\n", t2->id);          

    Row* t3 = NULL;
    for (int i = 1; i <= 7; i++) {
        t3 = insert_balanced(t3, i, "x");
    }
    printf("racine (1..7)  : %d\n", t3->id);          
    printf("hauteur        : %d\n", t3->height);      

    t3 = insert_balanced(t3, 4, "y");                 

    drop_table(t1);
    drop_table(t2);
    drop_table(t3);
    return 0;
}
    