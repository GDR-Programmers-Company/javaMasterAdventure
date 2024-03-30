package com.food;

import com.objects.Oggetto;

public class Cibo extends Oggetto { 
	    private int ripristinoSalute;

	    public Cibo(String nome, int ripristinoSalute) {
	    	super(nome);
	        this.ripristinoSalute = ripristinoSalute;
	    }

	    public int getRipristinoSalute() {
	        return ripristinoSalute;
	    }

		@Override
		public void usa() {
			// TODO Auto-generated method stub
			
		}

}
