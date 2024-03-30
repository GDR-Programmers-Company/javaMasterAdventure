package com.magicItems;

import com.objects.Oggetto;

public class oggettoMagico extends Oggetto{
	    private String descrizione;
	    private String effetto;

	    public oggettoMagico(String nome,String effetto, String descrizione) {
	    	super(nome);
	        this.descrizione = descrizione;
	        this.effetto = effetto;
	    }

	    public String getDescrizione() {
	        return descrizione;
	    }
	    
	    public String getEffetto() {
	        return effetto;
	    }

		@Override
		public void usa() {
			// TODO Auto-generated method stub
			
		}
}
