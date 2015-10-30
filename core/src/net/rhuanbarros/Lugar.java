package net.rhuanbarros;

public class Lugar {
	private int x;
	private int y;
	private int tamanhoBloco;
	private Carro carro;
	private Sinaleira sinaleira;
		
	
	public Lugar(int x, int y, int tamanhoBloco) {
		this.x = x;
		this.y = y;
		this.tamanhoBloco = tamanhoBloco;
	}
	
	/*
	public boolean canOcupar() {
		boolean retorno=true;
		/*
		if( entidade == null ) {
			retorno = true;
		} else {
			if( entidade instanceof Carro )
				retorno = false;
			if( entidade instanceof ControleSinaleira)
				if( ( (ControleSinaleira) entidade).getCorSinal() == CorEnum.VERDE )
					retorno = true;
		}*/
		/*
		return retorno;
	}*/

	public int getX() {
		return x*tamanhoBloco;
	}

	public int getY() {
		return y*tamanhoBloco;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	public boolean hasCarro() {
		if( carro == null ) return false;
		else return true;
	}
	
	public void setNullCarro() {
		carro = null;
	}

	public Sinaleira getSinaleira() {
		return sinaleira;
	}

	public void setSinaleira(Sinaleira sinaleira) {
		this.sinaleira = sinaleira;
	}
	
	public boolean hasSinaleira() {
		if( sinaleira == null ) return false;
		else return true;
	}
	
	public void setNullSinaleira() {
		sinaleira = null;
	}
}
