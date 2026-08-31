import java.util.Scanner;

public class StringInversion {

    static String inverter(String s) {
        if (s.isEmpty()) { // Para a recursividade caso a string recebida na função for vazia ("")
            return s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(inverter(s.substring(1))); // Inverte todo o final da string recebida na função para a direita do primeiro caractere
        sb.append(s.charAt(0)); // Anexação do primeiro caractere ao final da string invertida
        return sb.toString();
    }

    // Verifica se a entrada lida é "FIM" para interromper a leitura
    static boolean isFim(String s) {
        if(s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'){
			return true;
		} else {
		return false;
		}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Leitura da entrada
        String linha = scanner.nextLine();
        while (!isFim(linha)) {
            System.out.println(inverter(linha));
            linha = scanner.nextLine();
        }
    }
}