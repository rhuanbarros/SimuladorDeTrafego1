package net.rhuanbarros;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainScreenLibgdx extends ScreenAdapter {
	private static final float MOVE_TIME = 0.5F;
	private float timer = MOVE_TIME;
	private SpriteBatch batch;
	private Tela tela;
    
	@Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        tela = new Tela(32, 24, 20, "C:\\Users\\rhuan\\OneDrive\\Facul 2015-2\\LP2\\trabalho final\\SimuladorDeTrafego1\\core\\Mapa4.mapa");
    }
    
    @Override
    public void render(float delta) {
        super.render(delta);
        
        timer -= delta;
        if (timer <= 0) {
            timer = MOVE_TIME;
            
            System.out.println("Entrou no loop principal");
            //PARTE QUE FAZ CARRO SE MOVIMENTAREM
        	for(int i=0;i<tela.getTamanhoTelaX();i++) {
            	for(int j=0;j<tela.getTamanhoTelaY();j++) {
    				Lugar lugarEmQuestao = tela.getLugar(i, j);
    				if( lugarEmQuestao.hasCarro() ) { 
   						lugarEmQuestao.getCarro().doMovimento();
    				}
            	}
        	}
        	
        	tela.atualizaNaTela();
        }
               
        clearScreen();
        draw();
    }
    
    private void draw() {
        batch.begin();
        for(int i=0;i<tela.getTamanhoTelaX();i++)
        	for(int j=0;j<tela.getTamanhoTelaY();j++) {
				Lugar lugarEmQuestao = tela.getLugar(i, j);
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
    
}
