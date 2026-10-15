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

int str_count_chars(const char* s, char c){
    int i = 0;
    int j = 0;
    
    while(s[i] != '\0' ){
        if(s[i] == c){
            j++;
        }
        i++;
    }
    return j ;
};

void str_replace(char* dest, const char* src, char from, char to){
    int i = 0;
    
    while(src[i] != '\0' ){

        if(dest[i] != from) dest[i] = src[i];
        if(dest[i] == from) dest[i] = to;
        i++;
    }
    dest[i] = '\0';
};

int str_split(const char* s, char sep, char parts[][256], int max_parts){
    int a = 0;
    int b = 0;
    int c = 0;

    if (str_count_chars(s,sep)+1 > max_parts) return 0;

    while(s[a] != '\0' ){

        if(s[a] != sep){
            parts[b][c] = s[a];
            c++;
        }else{
            parts[b][c] = '\0';
            c = 0;
            b++;
        }

        a++;
    }
    parts[b][c] = '\0'; 
    return b+1 ;
    
};

void print_split(const char parts[][256], int nb_parts){
    int i = 0;
    while(i != nb_parts){
        printf("%s part %d \n",parts[i],i);
        i++;
    }
};

void str_join(char* dest, char parts[][256], int nb_parts, const char* sep){
    int i = 0;
    int j = 0;
    int a = 0;
    int b = 0;
    int c = 0;
    
    while(i < nb_parts){

        if(parts[a][b] == '\0') {

            if(i < nb_parts - 1){

                while(j < str_len(sep)){
                    dest[c] = sep[j];
                    j++;
                    c++;
                }
                j = 0;
            }
            a++;
            b = 0;      
            i++;        
        }else{
            dest[c] = parts[a][b];
            b++;
            c++;
        }
    }

    dest[c] = '\0';

};


int main(void) {
    //printf("%s : %d","longueur",str_len("Hello\n"));
    //print_str("Hello\n");
    //printf("%s : %d","result\n",str_equals("Hell","Hello"));
    // char dest[256];
    // str_concat(dest,"Hell","Hello");
    // printf("%s result\n",dest);
    // printf("%s : %d","result\n",str_contains("qsqdqdqdqdqhelsqlsqskqksqk","hwe"));
    // char b = 'q';
    // printf("%s : %d","result\n",str_count_chars("qsqdqdqdqdqhelsqlsqskqksqk",b));
    // char dest[256];
    // char b = 'q';
    // char a = 'O';
    // str_replace(dest,"qqqqttttttqqqqqq",b,a);
    // printf("%s result\n",dest);
    // char parts[20][256];
    // int n = str_split("a,b,c,d,g,f,d,d,f,fd,aaa", ',', parts, 20);
    // printf("%s : %d \n","result\n",n);
    // print_split(parts,11);
    char dest[256];
    char parts[12][256] = {"a","b","c","d","g","f","d","d","f","fd","aaa","jdhzdhzdh"};
    str_join(dest, parts, 12, ",");
    printf("Test : %s\n", dest);
    return 0;
}
