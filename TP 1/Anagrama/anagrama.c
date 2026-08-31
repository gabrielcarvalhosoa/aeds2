#include <stdio.h>
#include <stdlib.h>


/* Função para converter um caractere maiúsculo para minúsculo, já que na tabela ASCII
   uma mesma letra maiúscula e minúscula têm valores diferentes, o que atrapalha a verificação de anagrama.*/
char minusculo(char c){
    if(c >= 'A' && c <= 'Z'){
        return c + 32; // Conversão para minúsculo
    }
    return c;
}

int isAnagrama(char *str1, char *str2){
    int tam1 = 0, tam2 = 0;
    
    // Verificação de mesmo tamanho das strings (caso não tenham mesmo tamanho, não são anagramas)
    for(int i = 0; str1[i] != '\0'; i++){
        tam1++;
    }
    for(int i = 0; str2[i] != '\0'; i++){
        tam2++;
    }
    if(tam1 != tam2){
        return 0;
    }


    // Contagem da ocorrência de cada caractere nas duas strings
    int tabelaASCII[256] = {0}; // Vetor cobrindo toda a tabela ASCII e inicializando todos os valores com ocorrência 0

    for(int i = 0; str1[i] != '\0'; i++){
        tabelaASCII[(unsigned char)minusculo(str1[i])]++; // Ocorrências de caracteres da primeira string adicionam ao vetor
    }
    for(int i = 0; str2[i] != '\0'; i++){
        tabelaASCII[(unsigned char)minusculo(str2[i])]--; // Ocorrências de caracteres da segunda string subtraem do vetor
    }

    // Se no final algum valor da tabela estiver diferente de 0, não são anagramas
    for(int i = 0; i < 256; i++){
        if(tabelaASCII[i] != 0){
            return 0;
        }
    }
    return 1; // Caso contrário, são anagramas
}

// Verifica se a string lida é "FIM" para encerrar o programa
int isFim(char *str){
    if(str[0] == 'F' && str[1] == 'I' && str[2] == 'M'){
        return 1;
    } else {
        return 0;
    }
}

int main(){
    char str1[200], str2[200];

    scanf("%s", str1);
    while(!isFim(str1)){
        scanf("%s", str2);
        printf("%s\n", isAnagrama(str1, str2)? "SIM" : "NAO");
        scanf("%s", str1);
    }

    return 0;
}