package net.rhuanbarros;

import com.badlogic.gdx.graphics.Texture;

public class Carro extends Entidade implements IMovimentavel {
	private DirecaoEnum direcao;
	private Lugar[][] tela=null;
	
	public Carro(int x, int y, DirecaoEnum direcao, Texture textura, Lugar[][] tela) {
		this.x = x;
		this.y = y;
		this.direcao = direcao;
		this.textura = textura;
		this.tela = tela;
	}
	
	/* PROBLEMA PODE TA POR AQUI!!!
	 * 
	 * */
	 
	
	public void doMovimento() {
		int auxX=0;
		
		/*if(direcao == DirecaoEnum.DIREITA) {
			auxX=x;
			auxX++;
			Lugar proximoLugar = tela[auxX][y];
			if( proximoLugar.hasEntidade() )
				if( proximoLugar.canOcupar() )
					x++;
		}*/
		x++;
		System.out.println("x do carro"+x);
	}

	public DirecaoEnum getDirecao() {
		return direcao;
	}

	public void setDirecao(DirecaoEnum direcao) {
		this.direcao = direcao;
	}
}
