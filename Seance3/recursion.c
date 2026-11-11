#include <stdio.h>
#include <stdlib.h>
#include "recursion.h"

long fast_power(long x, int n, int* count){
    (*count)++; 

    if (n == 0) return 1;
    
    long half = fast_power(x, n / 2, count);    
    if (n % 2 == 0) {
        return half * half;
    } else {
        return x * half * half;
    }
}

void print_binary(unsigned int n) {
    if (n > 1) {                
        print_binary(n / 2);
    }
    printf("%u", n % 2);        
}

int main(void) {
    // int count = 0;
    // long r = fast_power(2, 10, &count);
    // printf("%ld, %d appels\n", r, count);
    print_binary(13342891);
    return 0;
}