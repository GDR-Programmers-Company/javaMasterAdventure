package com.inventary;
import com.effect.typewriterEffect;
import com.objects.*;
public class InventarioPersonaggio {
	 private Oggetto[] oggetti;
	 private int numeroOggetti;

	    public InventarioPersonaggio(int dimensioneMassima) {
	        this.oggetti = new Oggetto[dimensioneMassima];
	        this.numeroOggetti = 0;
	    }

	    public void aggiungiOggetto(Oggetto oggetto) {
	        if (numeroOggetti < oggetti.length) {
	            oggetti[numeroOggetti] = oggetto;
	            numeroOggetti++;
	            typewriterEffect.type("Oggetto aggiunto all'inventario: " + oggetto.getNome(), 500);
	        } else {
	            System.out.println("L'inventario è pieno, non è possibile aggiungere altri oggetti.");
	        }
	    }
}
