import java.util.Scanner;

class tpquest01 {
	public static void criptografia (String frase){
		StringBuilder sb = new StringBuilder("");
		for(int i = 0; i < frase.length(); i++){
			int tmp = frase.charAt(i);
			char c;
			if((tmp >= 65 && tmp <= 90) || (tmp >= 97 && tmp <= 122)){
				if((tmp + 3 > 90 && tmp + 3 < 97) || tmp + 3 > 122){
					tmp = tmp - 20 + 3;
					c = (char)tmp;
					sb.append(c);
				}
				else{
					tmp += 3;
					c = (char)tmp;
					sb.append(c);
				}
			} else {
				c = frase.charAt(i);
				sb.append(c);
			}
		}

		System.out.println(sb);
	}
	

	public static void main (String[] args){
		int chave = 3;
		Scanner sc = new Scanner(System.in);

		do {
		String frase = sc.nextLine();
		criptografia(frase);
		} while ( != "FIM");
	}
}
