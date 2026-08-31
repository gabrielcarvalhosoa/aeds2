import java.util.Scanner;

public class SomaDeDigitos {

    static int somar(int num) {
        if (num == 0) {
            return 0; // Resultado da soma dos dígitos quando a entrada for 0 será 0
        }
        return (num % 10) + somar(num / 10); // Soma dos últimos dígitos do número de entrada 
                                             // + o mesmo número dividido por 10, diminuindo um dígito da entrada pela direita
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leitura da entrada
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            System.out.println(somar(num));
        }
    }
}