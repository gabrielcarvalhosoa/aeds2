#include <stdio.h>
#include <stdlib.h>

// Verificação caso a string lida ser "FIM" para finalizar a leitura
int isFim(char *str){
    if(str[0] == 'F' && str[1] == 'I' && str[2] == 'M'){
        return 1;
    } else {
        return 0;
    }
}

// Processo de contagem da maior substring
void countSubstring(char *str){
    int ultimaPosicao[256]; // Aponta na tabela ASCII a última vez em que o caractere apareceu na string
    for(int k = 0; k < 256; k++){
        ultimaPosicao[k] = -1; // Indica que nenhum caractere foi visto ainda
    }

    int inicio = 0; // Começo da substring atual em análise
    int biggestCount = 0;

    for(int i = 0; str[i] != '\0'; i++){
        char c = (unsigned char)str[i];

        /* Caso o caractere lido já tenha aparecido anteriormente na substring, 
           a ultima posição dele será maior ou igual ao inicio da substring */
        if(ultimaPosicao[c] >= inicio){
            inicio = ultimaPosicao[c] + 1;
        }
        ultimaPosicao[c] = i;

        int tamanhoAtual = i - inicio + 1; // Tamanho da substring = distância entre seu início e a posição atual
        if(tamanhoAtual > biggestCount){
            biggestCount = tamanhoAtual; // Registra como a maior substring caso seja
        }
    }

    printf("%d\n", biggestCount);
}

int main(){
    char str[300];

    scanf("%s", str);
    while(!isFim(str)){
        countSubstring(str);
        scanf("%s", str);
    }
    
    return 0;
}