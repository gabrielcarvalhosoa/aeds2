#include <stdio.h>
#include <stdlib.h>

void somar(int numero){
    int soma = 0, quant = 0;
    int tmp = numero * 10;

    // Contagem da quantidade de dígitos do número
    while(tmp != 0){
        quant++;
        tmp /= 10;
    }

    // Soma dos dígitos
    for(int i = 0; i < quant; i++){
        soma += numero % 10;
        numero /= 10;
    }

    printf("%d\n", soma);
}

int main(){
    int numero;
    
    while(scanf("%d", &numero) != EOF){
        somar(numero);
    }
}