package net.rhuanbarros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tela {
	private Lugar[][] tela;
	private int tamanhoTelaX;
	private int tamanhoTelaY;
	private int tamanhoQuadrado;
	
	public Tela(int tamanhoTelaX, int tamanhoTelaY, int tamanhoQuadrado, String mapa ){
		this.setTamanhoTelaX(tamanhoTelaX);
		this.setTamanhoTelaY(tamanhoTelaY);
		this.setTamanhoQuadrado(tamanhoQuadrado);
		inicializaTela( abrirMapaDeArquivo(mapa) );
	}
	
	public boolean carroPodeAndar(Carro carro, DirecaoEnum direcao) {
		int x = carro.getX();
		int y = carro.getY();
		int auxX=0;
		int auxY=0;
		boolean retorno = false;
		try {
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
						if( lugarAtual.getSinaleira().getCorSinal() == CorEnum.VERDE ) retorno = true;
					} else retorno = true;
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
						if( lugarAtual.getSinaleira().getCorSinal() == CorEnum.VERDE ) retorno = true;
					} else retorno = true;
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
						if( lugarAtual.getSinaleira().getCorSinal() == CorEnum.VERDE ) retorno = true;
					} else retorno = true;
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
						if( lugarAtual.getSinaleira().getCorSinal() == CorEnum.VERDE ) retorno = true;
					} else retorno = true;
				}
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("MORREUMORREUMORREUMORREUMORREUMORREU");
		}
		
		return retorno;
	}
	
	
	public Lugar getLugar(int x, int y) {
		return tela[x][y];
	}
	
	//retorna um vetor de caracteres
	private char[][] abrirMapaDeArquivo(String nomeArquivo) {
		char[][] mapa = new char[getTamanhoTelaX()][getTamanhoTelaY()];
		String linha;
		int linhaCont=23;
	    try {
	      BufferedReader in  = new BufferedReader(new FileReader(nomeArquivo));      
	      while( (linha = in.readLine()) != null ) {
	    	  System.out.printf("\ny:[%d]", linhaCont);
	    	  for(int i=0;i<linha.length();i++) {
	    		  char letra = linha.charAt(i);
	    		  mapa[i][linhaCont]=letra;
	    		  System.out.printf("[%d]%c", i, letra);
	    	  }
	    	  linhaCont--;
	      }      
	      in.close();
	    }
	    catch (IOException e) {
	      System.out.println("Erro ao acessar arquivo.");
	    }
	    return mapa;
	}
		
	private void inicializaTela(char[][] mapa) {
		char charEmQuestao=0;
		Calcada calcada=null;
		Carro carro=null;
		Sinaleira sinaleira=null;
		
		tela = new Lugar[getTamanhoTelaX()][getTamanhoTelaY()];
        
		for(int i=0;i<getTamanhoTelaX();i++)
        	for(int j=0;j<getTamanhoTelaY();j++)
        		tela[i][j] = new Lugar(i,j, getTamanhoQuadrado());
        		
		for(int i=0;i<getTamanhoTelaX();i++)
        	for(int j=0;j<getTamanhoTelaY();j++) {
        		charEmQuestao=mapa[i][j];
        		if(charEmQuestao == '2') { //CALÇADA
        			calcada = new Calcada(i,j);
        			setCalcadaTela(calcada);
        		} else
        		if(charEmQuestao == '3') { //SINALEIRA VERMELHA
        			sinaleira = new Sinaleira(i, j, CorEnum.VERMELHO);
        			setSinaleiraTela(sinaleira);
        		} else
    			if(charEmQuestao == '4') { //SINALEIRA AMARELA
        			sinaleira = new Sinaleira(i, j, CorEnum.AMARELO);
        			setSinaleiraTela(sinaleira);
        		} else
    			if(charEmQuestao == '5') { //SINALEIRA VERDE
        			sinaleira = new Sinaleira(i, j, CorEnum.VERDE);
        			setSinaleiraTela(sinaleira);
        		} else
    			if(charEmQuestao == '6') { //CARRO
        			carro = new Carro(i,j, DirecaoEnum.DIREITA, this);
        			setCarroTela(carro);
        		} else
    			if(charEmQuestao == '7') { //CARRO
        			carro = new Carro(i,j, DirecaoEnum.CIMA, this);
        			setCarroTela(carro);
        		} else
    			if(charEmQuestao == '8') { //CARRO
        			carro = new Carro(i,j, DirecaoEnum.ESQUERDA, this);
        			setCarroTela(carro);
        		} else
    			if(charEmQuestao == '9') { //CARRO
        			carro = new Carro(i,j, DirecaoEnum.BAIXO, this);
        			setCarroTela(carro);
        		}
        	}
	}
	
	public void atualizaNaTela() {
    	
    	for(int i=0;i<getTamanhoTelaX();i++)
        	for(int j=0;j<getTamanhoTelaY();j++) {
				Lugar lugarEmQuestao = tela[i][j];
				if( lugarEmQuestao.hasSinaleira() ) lugarEmQuestao.getSinaleira().controlaTempo();
				
				if( lugarEmQuestao.hasCarro() ) {
        			int entidadeX = lugarEmQuestao.getCarro().getX();
					int entidadeY = lugarEmQuestao.getCarro().getY();
					boolean mudouDePosicao = entidadeX != i || entidadeY != j;
					
					if( mudouDePosicao ){
        				tela[entidadeX][entidadeY].setCarro(lugarEmQuestao.getCarro());
        				lugarEmQuestao.setNullCarro();
					}
        		}
			}
    }
	
    public void setCarroTela(Carro carro) {
		tela[carro.getX()][carro.getY()].setCarro(carro);
	}
	
	public void setCalcadaTela(Calcada calcada) {
		tela[calcada.getX()][calcada.getY()].setCalcada(calcada);
	}
	
	public void setSinaleiraTela(Sinaleira sinaleira) {
		tela[sinaleira.getX()][sinaleira.getY()].setSinaleira(sinaleira);
	}

	public int getTamanhoTelaX() {
		return tamanhoTelaX;
	}

	public void setTamanhoTelaX(int tamanhoTelaX) {
		this.tamanhoTelaX = tamanhoTelaX;
	}

	public int getTamanhoTelaY() {
		return tamanhoTelaY;
	}

	public void setTamanhoTelaY(int tamanhoTelaY) {
		this.tamanhoTelaY = tamanhoTelaY;
	}

	public int getTamanhoQuadrado() {
		return tamanhoQuadrado;
	}

	public void setTamanhoQuadrado(int tamanhoQuadrado) {
		this.tamanhoQuadrado = tamanhoQuadrado;
	}

}
