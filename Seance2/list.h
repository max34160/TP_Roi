char* str_dup(const char* src);
char* str_concat_new(const char* a, const char* b);
char* str_sub(const char* src, int start, int length);
char* str_repeat(const char* src, int n);
typedef struct { // On définit un nouveau type composé
    int* data; // le tableau, alloué sur le tas
    int size; // nombre d'éléments réellement présents
    int capacity; // nombre de cases allouées (size <= capacity)
} List;
int str_len( const char * word);
void list_free(List* l);
List* list_create();
void list_print(const List* l);
int list_get(const List* l, int index);
void list_set(List* l, int index, int value);
void list_add(List* l, int value);
int list_pop(List* l);
void list_remove(List* l, int index);
void list_clear(List* l);