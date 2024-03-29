package com.missionObject;

import com.objects.Oggetto;

public class oggettoMissione extends Oggetto {
    private String descrizione;

    public oggettoMissione(String nome, String descrizione) {
    	super(nome);
        this.descrizione = descrizione;

    }
    public String getDescrizione() {
        return descrizione;
    }

	@Override
	public void usa() {
		// TODO Auto-generated method stub
		
	}
}
