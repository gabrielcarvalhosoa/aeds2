#include <stdio.h>
#include <stdlib.h>

void inversao(char *string){
    int i = 0;
    
    // Contagem do tamanho da string para alocação dinâmica da inversa
    while(string[i] != '\0'){
        i++;
    }
    char *inverso = (char *)malloc((i + 1) * sizeof(char));

    // Processo de inversão
    for(int j = 0; j < i; j++){
        inverso[j] = string[i - 1 - j];
    }
    inverso[i] = '\0';

    printf("%s\n", inverso);
    free(inverso);
}

// Verificação se a frase lida é "FIM"
int isFim(char *string){
    if(string[0] == 'F' && string[1] == 'I' && string[2] == 'M'){
        return 1;
    } else {
        return 0;
    }
}

int main(){
    char string[200];

    // Processo de leitura até a string ser "FIM", invocando a função de inversão
    scanf("%[^\n]s", string);
    while(isFim(string) == 0){
        inversao(string);
        scanf(" %[^\n]s", string);
    }

    return 0;
}