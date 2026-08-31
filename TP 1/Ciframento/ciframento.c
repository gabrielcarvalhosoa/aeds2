#include <stdio.h>
#include <stdlib.h>


// Verifica se a frase lida é "FIM" para finalizar a leitura
int isFim(char *str){
    if(str[0] == 'F' && str[1] == 'I' && str[2] == 'M' && str[3] == '\0'){
        return 1;
    } else {
        return 0;
    }
}

void criptografia(char *str, int i){
    // Caso o caractere lido seja o fim da string, quebra a linha na saída do terminal
    if (str[i] == '\0' || str[i] == '\n') {
        printf("\n");
        return;
    }

    // Caso contrário, printa o caractere atual + 3 posições na ASCII e chama a função novamente para o próximo caractere
    printf("%c", (char)(str[i] + 3));
    criptografia(str, i + 1);
}

int main(){
    char str[200];

    // Scan das linhas da entrada até encontrar a palavra "FIM"
    scanf("%[^\n]", str);
    while(!isFim(str)){
        criptografia(str, 0);
        scanf(" %[^\n]", str);
    }

    return 0;
}