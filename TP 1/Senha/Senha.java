import java.util.Scanner;

class Senha {
    // Verifica se a frase lida é "FIM" para finalizar a leitura
    public static boolean isFim(String str){
        if(str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'){
			return true;
		} else {
		return false;
		}
    }

    public static boolean senhaValida(String senha){
        // Senha só é válida se possuir mais de 8 caracteres
        if(senha.length() < 8){
            return false;
        }

        // Verificadores de senha válida
        boolean hasMaiuscula = false;
        boolean hasMinuscula = false;
        boolean hasNumero = false;
        boolean hasEspecial = false;

        for(int i = 0; i < senha.length(); i++){
            char c = senha.charAt(i);

            // Verificações de requisitos
            if(c >= 'A' && c <= 'Z'){
                hasMaiuscula = true;
            }
            else if(c >= 'a' && c <= 'z'){
                hasMinuscula = true;
            }
            else if(c >= '0' && c <= '9'){
                hasNumero = true;
            } else if (!Character.isWhitespace(c)){
                hasEspecial = true;
            }
        }

        // Retorna true apenas se todos requisitos estiverem true
        return hasMaiuscula && hasMinuscula && hasNumero && hasEspecial;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Leitura da entrada
        String str = sc.nextLine();
        while(!isFim(str)){
            if(senhaValida(str)){
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }

            str = sc.nextLine();
        }
    }
}