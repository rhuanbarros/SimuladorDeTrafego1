package net.rhuanbarros;

public class Carro extends Entidade {
	private DirecaoEnum direcao;
	private Lugar[][] tela=null;
	
	public Carro(int x, int y, DirecaoEnum direcao, Lugar[][] tela) {
		this.x = x;
		this.y = y;
		this.direcao = direcao;
		this.tela = tela;
		setTextura("Carro.png");
	}

	/*boolean detectorDeColisoes(DirecaoEnum direcao) {
		int auxX=0;
		int auxY=0;
		
		auxX=x;
		auxX++;
		Lugar proximoLugar = tela[auxX][y];
		boolean proximoLugarNaoTemCarro = !proximoLugar.hasCarro();
		if( proximoLugarNaoTemCarro ) { 
			Lugar lugarAtual = tela[x][y];
			if( lugarAtual.hasSinaleira() ) {
				System.out.println("Carro encontrou Sinaleira!");
				if( lugarAtual.getSinaleira().getCorSinal() == CorEnum.VERDE ) x++;
			} else x++;
		}
	}*/
	
	public void doMovimento() {
		int auxX=0;
		int auxY=0;
		
		if(direcao == DirecaoEnum.DIREITA) {
			auxX=x;
			auxX++;
			Lugar proximoLugar = tela[auxX][y];
			boolean proximoLugarNaoTemCarro = !proximoLugar.hasCarro();
			boolean proximoLugarNaoTemCalcada = !proximoLugar.hasCalcada();
			if( proximoLugarNaoTemCarro && proximoLugarNaoTemCalcada ) { 
				Lugar lugarAtual = tela[x][y];
				if( lugarAtual.hasSinaleira() ) {
					System.out.println("Carro encontrou Sinaleira!");
					if( lugarAtual.getSinaleira().getCorSinal() == CorEnum.VERDE ) x++;
				} else x++;
			}
		}
		if(direcao == DirecaoEnum.ESQUERDA) {
			auxX=x;
			auxX--;
			Lugar proximoLugar = tela[auxX][y];
			boolean proximoLugarNaoTemCarro = !proximoLugar.hasCarro();
			boolean proximoLugarNaoTemCalcada = !proximoLugar.hasCalcada();
			if( proximoLugarNaoTemCarro && proximoLugarNaoTemCalcada ) { 
				Lugar lugarAtual = tela[x][y];
				if( lugarAtual.hasSinaleira() ) {
					System.out.println("Carro encontrou Sinaleira!");
					if( lugarAtual.getSinaleira().getCorSinal() == CorEnum.VERDE ) x--;
				} else x--;
			}
		}
		if(direcao == DirecaoEnum.CIMA) {
			auxY=y;
			auxY++;
			Lugar proximoLugar = tela[x][auxY];
			boolean proximoLugarNaoTemCarro = !proximoLugar.hasCarro();
			boolean proximoLugarNaoTemCalcada = !proximoLugar.hasCalcada();
			if( proximoLugarNaoTemCarro && proximoLugarNaoTemCalcada ) { 
				Lugar lugarAtual = tela[x][y];
				if( lugarAtual.hasSinaleira() ) {
					System.out.println("Carro encontrou Sinaleira!");
					if( lugarAtual.getSinaleira().getCorSinal() == CorEnum.VERDE ) y++;
				} else y++;
			}
		}
		if(direcao == DirecaoEnum.BAIXO) {
			auxY=y;
			auxY--;
			Lugar proximoLugar = tela[x][auxY];
			boolean proximoLugarNaoTemCarro = !proximoLugar.hasCarro();
			boolean proximoLugarNaoTemCalcada = !proximoLugar.hasCalcada();
			if( proximoLugarNaoTemCarro && proximoLugarNaoTemCalcada ) { 
				Lugar lugarAtual = tela[x][y];
				if( lugarAtual.hasSinaleira() ) {
					System.out.println("Carro encontrou Sinaleira!");
					if( lugarAtual.getSinaleira().getCorSinal() == CorEnum.VERDE ) y--;
				} else y--;
			}
		}
		
	}

	public DirecaoEnum getDirecao() {
		return direcao;
	}

	public void setDirecao(DirecaoEnum direcao) {
		this.direcao = direcao;
	}
}
