#include <stdio.h>

int ex15() {
    for(int i=1; i<=100; i++){
        printf("%i\n", i);
    }

}

int ex16(){
    for(int i=1; i<=100; i++){
        if(i%3 != 0 && i%7 != 0){
            printf("%i\n", i);
        }
    }
}

int main() {  
    ex16();
}
