package net.rhuanbarros;

public class Lugar {
	private int x;
	private int y;
	private int tamanhoBloco;
	private Carro carro;
	private Sinaleira sinaleira;
	private Calcada calcada;
	private CriadorDeCarros criadorDeCarros;
	private Tela tela;

	public Lugar(int x, int y, int tamanhoBloco, Tela tela) {
		this.x = x;
		this.y = y;
		this.tamanhoBloco = tamanhoBloco;
		this.tela = tela;
	}
	
	public DirecaoEnum getDirecaoRua() {
		DirecaoEnum retorno = DirecaoEnum.CIMA;
		int xEsquerdo = x--;
		int xDireito = x++;
		int yCima = y--;
		int yBaixo = y++;
		
		if( tela.getLugar(x, yBaixo).hasCalcada()) retorno = DirecaoEnum.DIREITA;
		
		return retorno;
	}
	
	public boolean hasCriadorDeCarros() {
		if( criadorDeCarros == null ) return false;
		else return true;
	}
	
	public void setNullCriadorDeCarros() {
		criadorDeCarros = null;
	}
	
	public int getX() {
		return x*tamanhoBloco;
	}

	public int getY() {
		return y*tamanhoBloco;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	public boolean hasCarro() {
		if( carro == null ) return false;
		else return true;
	}
	
	public void setNullCarro() {
		carro = null;
	}

	public Sinaleira getSinaleira() {
		return sinaleira;
	}

	public void setSinaleira(Sinaleira sinaleira) {
		this.sinaleira = sinaleira;
	}
	
	public boolean hasSinaleira() {
		if( sinaleira == null ) return false;
		else return true;
	}
	
	public void setNullSinaleira() {
		sinaleira = null;
	}

	public Calcada getCalcada() {
		return calcada;
	}

	public void setCalcada(Calcada calcada) {
		this.calcada = calcada;
	}
	
	public boolean hasCalcada() {
		if( calcada == null )return false;
		else return true;
	}
	
	public void setNullCalcada() {
		calcada = null;
	}

	public CriadorDeCarros getCriadorDeCarros() {
		return criadorDeCarros;
	}

	public void setCriadorDeCarros(CriadorDeCarros criadorDeCarros) {
		this.criadorDeCarros = criadorDeCarros;
	}
}
