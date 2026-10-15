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
    int countA = 0;
    int sameA = 0;
    int countB = 0;
    int sameB = 0;
   
    while(a[countA] != '\0'){
        if(a[countA] == b[countA]){
            sameA++;
        }
        countA++;
    }

    while(b[countB] != '\0'){
        if(a[countB] == b[countB]){
            sameB++;
        }
        countB++;
    }

    if(sameA == sameB && countA == countB){
        return 1;
    }else{
        return 0;
    }
};

int main(void) {
    //printf("%s : %d","longueur",str_len("Hello\n"));
    //print_str("Hello\n");
    printf("%s : %d","result\n",str_equals("Hell","Hello\n"));
    return 0;
}