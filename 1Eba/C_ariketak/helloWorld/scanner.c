#include <stdio.h>
#include <math.h>

int main(int argc, char *argv[]){
    int zenb1;
    //Punteroekin froga
    int *punteroa;
    printf("Sartu zenbaki bat:");
    scanf("%i", &zenb1);
    printf("Zuk sartutako zenbakia hurrengokoa da: %i \n", zenb1);
    printf("Zuk sartutakoa hemen dago gordeta: %p \n", &zenb1);

    punteroa = &zenb1;
    *punteroa = 7;
    printf("Zuk sartutako zenbakia hurrengokoa da: %i \n" , zenb1);
    return 0;
}