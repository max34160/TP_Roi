#include <stdio.h>
#include <stdlib.h>
#include "dom.h"

int main(void){
    Element *html = create_element("html", NULL, NULL);
    Element *body = create_element("body", NULL, NULL);
    Element *h1 = create_element("h1", "titre", "Mon site");
    Element *div = create_element("div", "contenu", NULL);
    Element *p1 = create_element("p", NULL, "Bonjour");
    Element *p2 = create_element("p", NULL, "Au revoir");
    append_child(html, body);
    append_child(body, h1);
    append_child(body, div);
    append_child(div, p1);
    append_child(div, p2);
    // count_elements(html);
    // printf("%d\n", count_by_tag(html, "p"));    
    // printf("%d\n", count_by_tag(html, "div"));  
    // printf("%d\n", count_by_tag(html, "h2"));
    // printf("%d\n", dom_height(html)); 
    // Element* trouve = find_by_id(html, "contenu");
    // printf("trouvé : %s\n", trouve->tag);
    // printf("%d\n", depth_of(html,"contenu")); 
    render(html,1);
    free_element(html);
    return 0;
}