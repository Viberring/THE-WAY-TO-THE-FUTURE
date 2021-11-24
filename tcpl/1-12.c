#include <stdio.h>

#define IN 1
#define OUT 0

int main() {

    int c;
    int state = OUT;
    while((c = getchar()) != EOF) {
        if (c == ' ' || c == '\t' || c == '\n') {
            if (state == IN) {
                printf("\n");                
            }
            state = OUT;
        }
        else {
            state = IN;
        }
        if (state == IN) {
            putchar(c);
        }
    }
    printf("\n");
    
}
