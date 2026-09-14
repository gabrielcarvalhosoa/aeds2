import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOExcpetion;

class Veiculo{
	private int id;
	private String marca;
	private String modelo;
	private int ano;
	private String categoria;
	private String[] combustivel;
	private int cilindros;
	private double cilindrada;
	private String transmissao;
	private String tracao;
	private double consumoCidade;
	private double consumoEstrada;
	private double co2;
	private boolean turbo;
	private Data dataRegistro;


	public int getId(){
		return id;
	}
	public String getMarca(){
		return marca;
	}
	public String getModelo(){
		return modelo;
	}
	public int getAno(){
		return ano;
	}
	public String getCategoria(){
		return categoria;
	}
	public String[] getCombustivel(){
		return combustivel;
	}
	public int getCilindros(){
		return cilindros;
	}
	public double getCilindrada(){
		return cilindrada;
	}
	public String getTransmissao(){
		return transmissao;
	}
	public String getTracao(){
		return tracao;
	}
	public double getConsumoCidade(){
		return consumoCidade;
	}
	public double getConsumoEstrada(){
		return consumoEstrada;
	}
	public double getCo2(){
		return co2;
	}
	public boolean getTurbo(){
		return turbo;
	}
	public Data getDataRegistro(){
		return dataRegistro;
	}


	public Veiculo parseVeiculo(String s){
	
	}

	public String format(){
		String result = id + " ## " + marca + " ## " + modelo + " ## " + ano + " ## " + categoria + " ## ";
	}
}

class Data{
	private int ano;
	private int mes;
	private int dia;


	public int getAno(){
		return ano;
	}
	public int getMes(){
		return mes;
	}
	public int getDia(){
		return dia;
	}


	public Data parseData(String s){
		String[] resultado = s.split("-")
	}
	
	public String format(){
		String[10] data;
		if (dia > 9 && mes > 9) {
			data = dia + "/" + mes + "/" + ano;
			return data;
		} else {
			if (dia <= 9 && mes > 9) {
				data = "0" + dia + "/" + mes + "/" + ano;
				return data;
			} else if (dia > 9 && mes <= 9) {
				data = dia + "/0" + mes + "/" + ano;
				return data;
			} else {
				data = "0" + dia + "/0" + mes + "/" + ano;
				return data;
			}
		}
	}
}

class tp2{
	public static void main(String[] args){
		String filePath = "veiculos.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String linha;
			while((linha = br.readLine()) != null) {
				
			}
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo: " + e.getMessage());
		}
	}
}
