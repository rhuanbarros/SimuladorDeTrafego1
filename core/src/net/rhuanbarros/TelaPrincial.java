package net.rhuanbarros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TelaPrincial extends ScreenAdapter {
	private static final float MOVE_TIME = 0.5F;
	private float timer = MOVE_TIME;
	
	private Carro carro1;
	private Carro carro2;
	private Carro carro3;
	private Carro carro4;
	private Carro carro5;
	private Calcada calcada1;
	private Sinaleira sinaleira1;
	private Lugar[][] tela;
	
	private SpriteBatch batch;
    private Texture carroTextura;
	private int tamanhoTelaX = 32;
	private int tamanhoTelaY = 24;
	private int tamanhoQuadrado = 20;
	
	//retorna um vetor de caracteres
	char[][] abrirMapaDeArquivo(String nomeArquivo) {
		char[][] mapa = new char[tamanhoTelaX][tamanhoTelaY];
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
	
	public void inicializaTela(char[][] mapa) {
		char charEmQuestao=0;
		Calcada calcada=null;
		Carro carro=null;
		Sinaleira sinaleira=null;
		
		tela = new Lugar[tamanhoTelaX][tamanhoTelaY];
        
		for(int i=0;i<tamanhoTelaX;i++)
        	for(int j=0;j<tamanhoTelaY;j++)
        		tela[i][j] = new Lugar(i,j, tamanhoQuadrado);
        		
		for(int i=0;i<tamanhoTelaX;i++)
        	for(int j=0;j<tamanhoTelaY;j++) {
        		charEmQuestao=mapa[i][j];
        		if(charEmQuestao == '2') { //CALÇADA
        			calcada = new Calcada(i,j);
        			setCalcadaTela(calcada);
        		} else
        		if(charEmQuestao == '3') { //CARRO
        			carro = new Carro(i,j, DirecaoEnum.DIREITA, tela);
        			setCarroTela(carro);
        		} else
        		if(charEmQuestao == '4') { //SINALEIRA
        			sinaleira = new Sinaleira(i, j, CorEnum.VERMELHO);
        			setSinaleiraTela(sinaleira);
        		}
        	}
        
        
        /*carro1 = new Carro(0,0, DirecaoEnum.DIREITA, tela);
        setCarroTela(carro1);
        carro5 = new Carro(1,0, DirecaoEnum.DIREITA, tela);
        setCarroTela(carro5);
        calcada1 =new Calcada(5,0);
        setCalcadaTela(calcada1);
        
        carro2 = new Carro(31,1, DirecaoEnum.ESQUERDA, tela);
        setCarroTela(carro2);
        carro3 = new Carro(5,23, DirecaoEnum.BAIXO, tela);
        setCarroTela(carro3);
        //carro4 = new Carro(18,0, DirecaoEnum.CIMA, tela);
        //setCarroTela(carro4);
        
        sinaleira1 = new Sinaleira(15, 0, CorEnum.VERMELHO);
        setSinaleiraTela(sinaleira1);*/
	}

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        inicializaTela( abrirMapaDeArquivo("C:\\Users\\rhuan\\OneDrive\\Facul 2015-2\\LP2\\trabalho final\\SimuladorDeTrafego1\\core\\Mapa3.mapa") );
        //inicializaTela( abrirMapaDeArquivo("Mapa3.mapa") );
    }
    
    @Override
    public void render(float delta) {
        super.render(delta);
        
        timer -= delta;
        if (timer <= 0) {
            timer = MOVE_TIME;
            
            System.out.println("Entrou no loop principal");
            //PARTE QUE FAZ CARRO SE MOVIMENTAREM
        	for(int i=0;i<tamanhoTelaX;i++) {
            	for(int j=0;j<tamanhoTelaY;j++) {
    				Lugar lugarEmQuestao = tela[i][j];
    				if( lugarEmQuestao.hasCarro() ) { 
   						lugarEmQuestao.getCarro().doMovimento();
    				}
            	}
        	}
        	
        	atualizaNaTela();
        }
               
        clearScreen();
        draw();
    }
    
    void atualizaNaTela() {
    	
    	for(int i=0;i<tamanhoTelaX;i++)
        	for(int j=0;j<tamanhoTelaY;j++) {
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
    
    private void draw() {
        batch.begin();
        for(int i=0;i<tamanhoTelaX;i++)
        	for(int j=0;j<tamanhoTelaY;j++) {
				Lugar lugarEmQuestao = tela[i][j];
				if( lugarEmQuestao.hasCalcada() )
        			batch.draw(lugarEmQuestao.getCalcada().getTextura(), lugarEmQuestao.getX(), lugarEmQuestao.getY());
				if( lugarEmQuestao.hasSinaleira() )
        			batch.draw(lugarEmQuestao.getSinaleira().getTextura(), lugarEmQuestao.getX(), lugarEmQuestao.getY());
				if( lugarEmQuestao.hasCarro() )
        			batch.draw(lugarEmQuestao.getCarro().getTextura(), lugarEmQuestao.getX(), lugarEmQuestao.getY());
			}
        batch.end();
    }
    
    private void clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
	
}
