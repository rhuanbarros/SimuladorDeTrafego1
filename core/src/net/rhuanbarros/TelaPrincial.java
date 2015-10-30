package net.rhuanbarros;

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
	private ControleSinaleira sinaleira1;
	private Lugar[][] tela;
	
	private SpriteBatch batch;
    private Texture carroTextura;
	private int tamanhoTelaX = 20;
	private int tamanhoTelaY = 15;
	
	public void setCarroTela(Carro carro) {
		tela[carro.getX()][carro.getY()].setCarro(carro);
	}
	
	public void setControleSinaleiraTela(ControleSinaleira controleSinaleira) {
		tela[controleSinaleira.getX()][controleSinaleira.getY()].setControleSinaleira(controleSinaleira);
	}

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        carroTextura = new Texture(Gdx.files.internal("snakehead.png"));
        
        tela = new Lugar[tamanhoTelaX][tamanhoTelaY];
        for(int i=0;i<tamanhoTelaX;i++)
        	for(int j=0;j<tamanhoTelaY;j++)
        		tela[i][j] = new Lugar(i,j, 32);
        		
        carro1 = new Carro(0,0, DirecaoEnum.DIREITA, carroTextura, tela);
        setCarroTela(carro1);
        
        sinaleira1 = new ControleSinaleira(15, 0, CorEnum.VERMELHO, carroTextura);
        setControleSinaleiraTela(sinaleira1);
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
    				//System.out.println("x: "+i+" y: "+j);
    				if( lugarEmQuestao.hasCarro() ) { 
    					//System.out.println("LOOP PRINCIPAL | entidade x: "+i+" y: "+j);
   						lugarEmQuestao.getCarro().doMovimento();
    				}
            	}
        	}
        	
        	atualizaMovimentosNaTela();
        }
               
        clearScreen();
        draw();
    }
    
    void atualizaMovimentosNaTela() {
    	
    	for(int i=0;i<tamanhoTelaX;i++)
        	for(int j=0;j<tamanhoTelaY;j++) {
				Lugar lugarEmQuestao = tela[i][j];

				if( lugarEmQuestao.hasCarro() ) {
					//System.out.println("LOOP atualizaMovimentosNaTela | entidade x: "+i+" y: "+j);
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
				if( lugarEmQuestao.hasCarro() )
        			batch.draw(lugarEmQuestao.getCarro().getTextura(), lugarEmQuestao.getX(), lugarEmQuestao.getY());
					//fazer o mesmo aqui para o controle sinaleira 
			}
        batch.end();
    }
    
    private void clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

	
}
