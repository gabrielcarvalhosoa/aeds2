import java.util.Scanner;

class ciframentoCesar {
	
	public static void criptografia (String frase){
		StringBuilder sb = new StringBuilder("");
		
		for(int i = 0; i < frase.length(); i++){
			int tmp = frase.charAt(i); // Registra o valor do caractere na tabela ASCII
			char c;
				
			// Realiza o deslocamento de 3 posições na tabela ASCII
			tmp += 3;
			c = (char)tmp;
			sb.append(c);
		}

		System.out.println(sb);
	}
	
	// Verifica se a frase lida é "FIM" para finalizar a leitura
	public static int Fim (String frase){
		if(frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M'){
			return 1;
		} else {
		return 0;
		}
	}

	public static void main (String[] args){
		int chave = 3;
		Scanner sc = new Scanner(System.in);
		
		// Scan das linhas da entrada até encontrar a palavra "FIM"
		String frase = sc.nextLine();
		while(Fim(frase) == 0){
		criptografia(frase);
		frase = sc.nextLine();
		}
	}
}
