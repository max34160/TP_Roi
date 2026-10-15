#include <stdio.h>
#include "strings.h"

int str_len( const char * word){
    int count = 0;
    while(word[count] != '\0'){
        count++;
    }
    return count;
}

void print_str(const char* word){
    int count = 0;
    while(word[count] != '\0'){
        printf("%c \n",word[count]);
        count++;
    }
};

int str_equals(const char* a, const char* b){
    int i = 0 ;
    if(str_len(a) != str_len(b)) return 0;

    while(a[i] != '\0' ){
        if(a[i] != b[i]){
            return 0;
        }
        i++;
    }
    return 1;
};

void str_concat(char* dest, const char* a, const char* b){
    int i = 0;
    int j = 0;
    while(a[j] != '\0' ){
        dest[i] = a[i];
        i++;
        j++;
    }
    j = 0;
    while(b[j] != '\0' ){
        dest[i] = b[j];
        i++;
        j++;
    }
    dest[i] = '\0';

};

int str_contains(const char* haystack, const char* needle){
    if(str_len(needle) > str_len(haystack)) return 0;
    
    int i = 0;
    int j = 0;

    while(haystack[i] != '\0' ){
        if(haystack[i] == needle[j]){
            j++;
        }
        i++;
    }

    if(j == str_len(needle)) return 1;
    return 0; 

};

int main(void) {
    //printf("%s : %d","longueur",str_len("Hello\n"));
    //print_str("Hello\n");
    //printf("%s : %d","result\n",str_equals("Hell","Hello"));
    // char dest[256];
    // str_concat(dest,"Hell","Hello");
    // printf("%s result\n",dest);

    return 0;
}
