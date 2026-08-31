import java.util.Scanner;

public class Is {

    // Verifica se a string é composta somente por vogais
    public static boolean isVogais(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                return false; // Encontrou um caractere que não é vogal
            }
        }
        return true; // Percorreu toda a string sem encontrar um caractere que não fosse vogal
    }

    // Verifica se a string é composta apenas por consoantes
    public static boolean isConsoantes(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            boolean vogal = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
            boolean letra = (c >= 'a' && c <= 'z');
            if (vogal || !letra) {
                return false; // É vogal ou não é uma letra, portanto não é consoante
            }
        }
        return true; // Percorreu toda a string sem encontrar vogal ou caractere não-letra
    }

    // Verifica se a string corresponde a um número inteiro
    public static boolean isInteiro(String s) {
        if (s.isEmpty()) {
            return false;
        }

        int inicio = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            inicio = 1; // Ignora o sinal
        }

        if (inicio == s.length()) {
            return false; // Caso não haja nenhum número, só sinal
        }

        for (int i = inicio; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    // Verifica se a string corresponde a um número real
    public static boolean isReal(String s) {
        if (s.isEmpty()) {
            return false;
        }

        int inicio = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            inicio = 1;
        }

        boolean temDigitoAntes = false;
        boolean temPonto = false;
        boolean temDigitoDepois = false;

        for (int i = inicio; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '.' && !temPonto) {
                temPonto = true; // Marca a posição do ponto decimal
            } else if (c >= '0' && c <= '9') {
                if (temPonto) {
                    temDigitoDepois = true;
                } else {
                    temDigitoAntes = true;
                }
            } else {
                return false; // Caractere inválido para número real
            }
        }

        return temPonto && temDigitoAntes && temDigitoDepois;
    }

    // Verifica se a frase lida é "FIM" para finalizar a leitura
    public static boolean isFim(String frase) {
        if (frase.length() < 3) {
            return false; // Evita acessar posições inexistentes do vetor para strings menores que 3 caracteres
        }

        if (frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M') {
            return true;
        } else {
            return false;
        }
    }

    // Converte um valor booleano para a saída "SIM"/"NAO"
    public static String sim(boolean valor) {
        return valor ? "SIM" : "NAO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leitura da entrada até encontrar "FIM"
        String linha = sc.nextLine();
        while (!isFim(linha)) {
            System.out.println(sim(isVogais(linha)) + " " + sim(isConsoantes(linha)) + " "
                    + sim(isInteiro(linha)) + " " + sim(isReal(linha)));
            linha = sc.nextLine();
        }
    }
}