package net.rhuanbarros;

public class Sinaleira extends Entidade {
	private CorEnum corSinal = null;
	private int tempo=0;
	private int tempoVerde=4;
	private int tempoAmarelo=2;
	private int tempoVermelho=6;

	public Sinaleira(int x, int y, CorEnum corSinal) {
		this.x = x;
		this.y = y;
		this.setCorSinal(corSinal);
	}
	
	public void controlaTempo() {
		if( corSinal == CorEnum.VERDE)
			if( tempo != tempoVerde ) tempo++;
			else { 
				//System.out.println("mudou pra amarelo");
				setCorSinal( CorEnum.AMARELO );
				tempo=0;
				return;
			}
		if( corSinal == CorEnum.AMARELO)
			if( tempo != tempoAmarelo ) tempo++;
			else {
				//System.out.println("mudou pra vermelho");
				setCorSinal( CorEnum.VERMELHO );
				tempo=0;
				return;
			}
		if( corSinal == CorEnum.VERMELHO)
			if( tempo != tempoVermelho ) tempo++;
			else { 
				//System.out.println("mudou pra verde");
				setCorSinal( CorEnum.VERDE );
				tempo=0;
				return;
			}
	}

	public CorEnum getCorSinal() {
		return corSinal;
	}

	public void setCorSinal(CorEnum corSinal) {
		this.corSinal = corSinal;
		if(corSinal == CorEnum.VERDE) setTextura("SinaleiraVerde.png");
		else if(corSinal == CorEnum.AMARELO) setTextura("SinaleiraAmarela.png");
		else if(corSinal == CorEnum.VERMELHO) setTextura("SinaleiraVermelha.png");
	}

}
