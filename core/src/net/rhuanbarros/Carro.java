package net.rhuanbarros;

public class Carro extends Entidade {
	private DirecaoEnum direcao;
	private Tela tela=null;
	
	public Carro(int x, int y, DirecaoEnum direcao, Tela tela) {
		this.x = x;
		this.y = y;
		this.direcao = direcao;
		this.tela = tela;
		setTextura("Carro.png");
	}

	public void doMovimento() {
		if( tela.carroPodeAndar(this) ) {	
			if(direcao == DirecaoEnum.DIREITA) x++;
			if(direcao == DirecaoEnum.ESQUERDA) x--;
			if(direcao == DirecaoEnum.CIMA) y++;
			if(direcao == DirecaoEnum.BAIXO) y--;
		}
	}
	
	public DirecaoEnum getDirecao() {
		return direcao;
	}

	public void setDirecao(DirecaoEnum direcao) {
		this.direcao = direcao;
	}
}
