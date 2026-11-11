typedef struct Element {
    char* tag;                    // nom de la balise : "div", "p"...
    char* id;                     // identifiant, ou NULL s'il n'y en a pas
    char* text;                   // texte contenu, ou NULL s'il n'y en a pas
    struct Element** children;    // tableau dynamique des enfants
    int nb_children;              // nombre d'enfants présents
    int capacity;                 // nombre de cases allouées
} Element;
Element* create_element(const char* tag, const char* id, const char* text);
void append_child(Element* parent, Element* child);
int count_elements(const Element* e);
int count_by_tag(const Element* e, const char* tag);
int dom_height(const Element* e);
Element* find_by_id(Element* e, const char* id);
int depth_of(const Element* e, const char* id);
void render(const Element* e, int depth);
void free_element(Element* e);
Element* clone_element(const Element* e);
// ElementList* get_elements_by_tag(Element* root, const char* tag);
Element* parse(const char* html);