package net.rhuanbarros;

public class Lugar {
	private IMovimentavel entidadeMovimentavel=null;
	private int x;
	private int y;
	
	public Lugar(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
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
		
		return retorno;
	}

	public IMovimentavel getEntidadeMovimentavel() {
		return entidadeMovimentavel;
	}

	public void setEntidadeMovimentavel(IMovimentavel entidadeM) {
		this.entidadeMovimentavel = entidadeM;
	}
	
	public boolean hasEntidade() {
		if(entidadeMovimentavel==null) return false;
		else return true;
	}
	
	public void setNullEntidade() {
		entidadeMovimentavel = null;
	}

	public int getX() {
		return x*32;
	}

	public int getY() {
		return y*32;
	}
}
