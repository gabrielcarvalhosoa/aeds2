import java.util.Random;
import java.util.Scanner;

public class AlteracaoAleatoria {

    public static void alterar(String texto, Random random) {
        // Sorteio das letras
        char letra1 = (char) ('a' + (Math.abs(random.nextInt()) % 26));
        char letra2 = (char) ('a' + (Math.abs(random.nextInt()) % 26));

        // Armazena o resultado de forma acumulativa caractere por caractere
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c == letra1) { // Caso o caractere seja o mesmo que o sorteado, é substituído pela segunda letra
                resultado.append(letra2);
            } else {
                resultado.append(c);
            }
        }
        System.out.println(resultado);
    }

    // Verifica se a string lida é "FIM" para interromper a leitura
    public static boolean isFim(String frase){
        if (frase.length() < 3) {
            return false;            // Implementado para evitar que a verificação abaixo acesse posições não existentes em strings com menos de 2 caracteres
        }
        
        if(frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M'){
			return true;
		} else {
		return false;
		}
    }

    public static void main(String[] args) {
        Random random = new Random();
        random.setSeed(4);
        Scanner sc = new Scanner(System.in);
        
        String linha = sc.nextLine();
        while(!isFim(linha)) {
            alterar(linha, random);
            linha = sc.nextLine();
        }
    }
}