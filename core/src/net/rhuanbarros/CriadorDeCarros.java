package net.rhuanbarros;

public class CriadorDeCarros extends Entidade {
	private Tela tela; 
	private int quantidadeMaxima=1;
	private int quantidadeVivos=0;
	
	public CriadorDeCarros(int x, int y, int quantidadeMaxima, Tela tela) {
		this.x = x;
		this.y = y;
		this.quantidadeMaxima = quantidadeMaxima;
		this.tela = tela;
		setTextura("CriadorDeCarros.png");
	}

	public void criarCarro() {
		System.out.printf("quantidadeVivos: %d quantidadeMaxima:%d", quantidadeVivos, quantidadeMaxima);
		boolean criarMaisCarros = quantidadeVivos < quantidadeMaxima;
		boolean espacoLiberado = !tela.getLugar(x, y).hasCarro();
		boolean liberadoPraCriarMaisCarro = criarMaisCarros && espacoLiberado;
		if ( liberadoPraCriarMaisCarro ) {
			tela.setCarroTela( new Carro(x, y, DirecaoEnum.DIREITA, tela) );
			quantidadeVivos++;
			System.out.println("Carro criado");
		}
	}

}
