package net.rhuanbarros;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TelaPrincial extends ScreenAdapter {
	private static final float MOVE_TIME = 0.5F;
	//private static final float MOVE_TIME = 0.1F;
	private float timer = MOVE_TIME;
	
	private Carro carro1;
	private ControleSinaleira sinaleira1;
	private Lugar[][] tela;
	
	private SpriteBatch batch;
    private Texture carroTextura;
	private int tamanhoTelaX = 20;
	private int tamanhoTelaY = 15;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        carroTextura = new Texture(Gdx.files.internal("snakehead.png"));
        
        tela = new Lugar[tamanhoTelaX][tamanhoTelaY];
        for(int i=0;i<tamanhoTelaX;i++)
        	for(int j=0;j<tamanhoTelaY;j++)
        		tela[i][j] = new Lugar(i,j);
        		
        carro1 = new Carro(0,0, DirecaoEnum.DIREITA, carroTextura, tela);
        tela[0][0].setEntidadeMovimentavel(carro1);
        
        //sinaleira1 = new ControleSinaleira(CorEnum.VERMELHO, carroTextura);
        //tela[15][0].setEntidade(sinaleira1);
    }
    
    @Override
    public void render(float delta) {
        super.render(delta);
        
        timer -= delta;
        if (timer <= 0) {
            timer = MOVE_TIME;

			//implementar uma interface IMovimentavel que tem o metodo doMovimento()
            
            System.out.println("Entrou no loop principal");
            
        	for(int i=0;i<tamanhoTelaX;i++) {
            	for(int j=0;j<tamanhoTelaY;j++) {
    				Lugar lugarEmQuestao = tela[i][j];
    				//System.out.println("x: "+i+" y: "+j);
    				if( lugarEmQuestao.hasEntidade() ) { 
    					System.out.println("LOOP PRINCIPAL | entidade x: "+i+" y: "+j);
    					//System.out.println(lugarEmQuestao.getEntidade() instanceof Carro);
    					/*if( lugarEmQuestao.getEntidade() instanceof Carro ) {
    						//System.out.println("foi2222");
    						( (Carro) lugarEmQuestao.getEntidade()).doMovimento();
    					}*/
    					
    					carro1.doMovimento();
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

				if( lugarEmQuestao.hasEntidade() ) {
					//System.out.println("LOOP atualizaMovimentosNaTela | entidade x: "+i+" y: "+j);
        			int entidadeX = lugarEmQuestao.getEntidadeMovimentavel().getX();
					int entidadeY = lugarEmQuestao.getEntidadeMovimentavel().getY();
					boolean mudouDePosicao = entidadeX != i || entidadeY != j;
					
					if( mudouDePosicao ){
        				tela[entidadeX][entidadeY].setEntidade(lugarEmQuestao.getEntidade());
        				lugarEmQuestao.setNullEntidade();
					}
        		}
			}
    }
    
    private void draw() {
        batch.begin();
        for(int i=0;i<tamanhoTelaX;i++)
        	for(int j=0;j<tamanhoTelaY;j++) {
				Lugar lugarEmQuestao = tela[i][j];
				if( lugarEmQuestao.hasEntidade() )
        			batch.draw(lugarEmQuestao.getEntidade().getTextura(), lugarEmQuestao.getX(), lugarEmQuestao.getY());
			}
        batch.end();
    }
    
    private void clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

	
}
