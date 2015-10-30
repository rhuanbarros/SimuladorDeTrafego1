package net.rhuanbarros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Testa {
	
	public static void main(String arghs[]) {
		String linha;
		int linhaCont=23;
	    try {
	      //Le arquivo e mostra na tela.
	      BufferedReader in  = new BufferedReader(new FileReader("C:\\Users\\rhuan\\OneDrive\\Facul 2015-2\\LP2\\trabalho final\\SimuladorDeTrafego1\\core\\Mapa3.mapa"));      
	      while( (linha = in.readLine()) != null ) {
	    	  System.out.printf("\ny:[%d]", linhaCont);
	    	  for(int i=0;i<linha.length();i++) {
	    		  char letra = linha.charAt(i);
	    		  System.out.printf("[%d]%c", i, letra);
	    	  }
	    	  linhaCont--;
	      }      
	      in.close();
	    }      
	    catch (IOException e) {
	      System.out.println("Erro ao acessar arquivo.");
	    }		
	}

}
