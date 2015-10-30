package net.rhuanbarros;

import com.badlogic.gdx.graphics.Texture;

public class Carro extends Entidade {
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
		
		if(direcao == DirecaoEnum.DIREITA) {
			auxX=x;
			auxX++;
			Lugar proximoLugar = tela[auxX][y];
			boolean proximoLugarNaoTemCarro = !proximoLugar.hasCarro();
			if( proximoLugarNaoTemCarro ) { 
				if( proximoLugar.hasSinaleira() ) {
					System.out.println("Carro encontrou ControleSinaleira!");
					if( proximoLugar.getSinaleira().getCorSinal() == CorEnum.VERDE ) x++;
				} else x++;
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
