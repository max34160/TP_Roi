#include <stdio.h>
#include <stdlib.h>
#include "strings.h"



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

