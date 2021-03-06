package net.rhuanbarros;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public abstract class Entidade {
	protected int x;
	protected int y;
	protected Texture textura;
	
	public Texture getTextura() {
		return textura;
	}

	public void setTextura(String nomeArquivo) {
		this.textura = new Texture(Gdx.files.internal(nomeArquivo));
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
