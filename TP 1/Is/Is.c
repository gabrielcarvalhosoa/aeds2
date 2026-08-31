#include <stdio.h>
#include <stdlib.h>

// Converte um caractere maiúsculo para minúsculo
char minusculo(char c){
    if(c >= 'A' && c <= 'Z'){
        return c + 32;
    }
    return c;
}

// Verifica se a string lida é "FIM" para encerrar o programa
int isFim(char *str){
    if(str[0] == 'F' && str[1] == 'I' && str[2] == 'M'){
        return 1;
    } else {
        return 0;
    }
}

// Verifica se a string é composta somente por vogais
int isVogais(char *str, int i){
    char c = minusculo(str[i]);

    if(c == '\0'){
        return 1; // Chegou ao fim da string sem encontrar um caractere que não fosse vogal
    }
    if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u'){
        return 0; // Encontrou um caractere que não é vogal
    }
    return isVogais(str, i + 1); // Continua a verificação a partir do próximo caractere
}

// Verifica se a string é composta somente por consoantes
int isConsoantes(char *str, int i){
    char c = minusculo(str[i]);

    if(c == '\0'){
        return 1; // Chegou ao fim da string e não encontrou um caractere que não fosse consoante
    }
    if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c < 'a' || c > 'z'){
        return 0; // Não é consoante
    }
    return isConsoantes(str, i + 1);
}

// Verifica se da posição i até o fim só existem dígitos
int isDigitosRec(char *str, int i, int temDigito){
    if(str[i] == '\0'){
        return temDigito; // Só é válido se pelo menos um dígito foi lido
    }
    if(str[i] < '0' || str[i] > '9'){
        return 0; // Encontrou um caractere que não é dígito
    }
    return isDigitosRec(str, i + 1, 1);
}

// Verifica se a string corresponde a um número inteiro
int isInteiro(char *str, int i){
    if(str[i] == '+' || str[i] == '-'){
        return isDigitosRec(str, i + 1, 0); // Ignora o sinal
    }
    return isDigitosRec(str, i, 0);
}

// Verifica os dígitos da parte decimal
int isDecimalRec(char *str, int i, int temDigito){
    if(str[i] == '\0'){
        return temDigito; // Precisa haver ao menos um dígito depois do ponto
    }
    if(str[i] < '0' || str[i] > '9'){
        return 0;
    }
    return isDecimalRec(str, i + 1, 1);
}

// Função que percorre a parte inteira até encontrar o ponto decimal
int isRealRec(char *str, int i, int temDigito){
    if(str[i] == '\0'){
        return 0; // Chegou ao fim sem encontrar o ponto decimal, então não é um número real
    }
    if(str[i] == '.'){
        return temDigito && isDecimalRec(str, i + 1, 0); // Precisa ter dígitos antes e depois do ponto
    }
    if(str[i] < '0' || str[i] > '9'){
        return 0;
    }
    return isRealRec(str, i + 1, 1);
}

// Verifica se a string corresponde a um número real
int isReal(char *str, int i){
    if(str[i] == '+' || str[i] == '-'){
        return isRealRec(str, i + 1, 0);
    }
    return isRealRec(str, i, 0);
}

int main(){
    char str[200];

    // Leitura da entrada até encontrar "FIM"
    scanf("%s", str);
    while(!isFim(str)){
        printf("%s %s %s %s\n",
               isVogais(str, 0) ? "SIM" : "NAO",
               isConsoantes(str, 0) ? "SIM" : "NAO",
               isInteiro(str, 0) ? "SIM" : "NAO",
               isReal(str, 0) ? "SIM" : "NAO");
        scanf("%s", str);
    }

    return 0;
}