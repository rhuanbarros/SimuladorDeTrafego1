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
		boolean podeMovimentar=false;
		
		if(direcao == DirecaoEnum.DIREITA) {
			auxX=x;
			auxX++;
			Lugar proximoLugar = tela[auxX][y];
			if( proximoLugar.hasControleSinaleira() )
				if( proximoLugar.getControleSinaleira().getCorSinal() == CorEnum.VERDE ) podeMovimentar=true;
			if( !proximoLugar.hasCarro() ) podeMovimentar=true;
			
			if(podeMovimentar == true ) x++; 
		}
		
	}

	public DirecaoEnum getDirecao() {
		return direcao;
	}

	public void setDirecao(DirecaoEnum direcao) {
		this.direcao = direcao;
	}
}
