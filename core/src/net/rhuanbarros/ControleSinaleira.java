package net.rhuanbarros;

import com.badlogic.gdx.graphics.Texture;

public class ControleSinaleira extends Entidade {
	private CorEnum corSinal = null;

	public ControleSinaleira(CorEnum corSinal, Texture textura) {
		this.setCorSinal(corSinal);
		this.textura = textura;
	}

	public CorEnum getCorSinal() {
		return corSinal;
	}

	public void setCorSinal(CorEnum corSinal) {
		this.corSinal = corSinal;
	}
}
