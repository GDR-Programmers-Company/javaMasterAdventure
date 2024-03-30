package com.treasure;

import com.effect.typewriterEffect;
import com.inventary.InventarioPersonaggio;
import com.objects.Oggetto;
//Definizione della classe Forziere che contiene un array di Oggetto
public class Chest {
 private Oggetto[] oggetti;

 public Chest(Oggetto[] oggetti) {
     this.oggetti = oggetti;
 }

 // Metodo per visualizzare il contenuto del forziere
 public void visualizzaContenuto() {
	    System.out.println("Contenuto del forziere:"); // Stampa il titolo del contenuto del forziere
	    int i = 1; // Inizializza un contatore per numerare gli oggetti
	    for (Oggetto oggetto : oggetti) { // Itera attraverso tutti gli oggetti nel forziere
	        if (oggetto != null) { // Verifica se l'oggetto non è nullo
	            // Ottieni i valori di potenza, difesa e punti salute dell'oggetto
	            int potenza = oggetto.getPotenza();
	            int difesa = oggetto.getDifesa();
	            int puntiSalute = oggetto.getRipristinoSalute();
	            String descrizione = oggetto.getDescrizione();
	            
	                // Stampa il nome dell'oggetto e i suoi attributi (potenza, difesa, punti salute)
	                typewriterEffect.type(i + "- " + oggetto.getNome() +
	                      (potenza != 0 ? " | Potenza: " + potenza : "") +
	                      (difesa != 0 ? " | Difesa: " + difesa : "") +
	                      (puntiSalute != 0 ? " | Punti Salute: +" + puntiSalute : "")+
	                      (descrizione != "" ? " | Descrizione: " + descrizione : "")
	                      , 200);
	                i++; // Incrementa il contatore degli oggetti stampati
	            
	        }
	    }

	}
 
 public void raccogliOggetti(String[] indiciOggetti, InventarioPersonaggio inventarioPersonaggio) {
	    for (String indice : indiciOggetti) {
	        try {
	            int numero = Integer.parseInt(indice);
	            if (numero >= 1 && numero <= oggetti.length) {
	                Oggetto oggetto = oggetti[numero - 1];
	                if (oggetto != null) {
	                    inventarioPersonaggio.aggiungiOggetto(oggetto);
	                }
	            } else {
	                System.out.println("Indice non valido: " + numero);
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Indice non valido: " + indice);
	        }
	    }
	}

//Metodo per ottenere il numero totale di oggetti nel forziere
public int getNumeroOggetti() {
  return oggetti.length; // Restituisce la lunghezza dell'array di oggetti
}

// Metodo per verificare la validità degli indici degli oggetti selezionati
public boolean verificaIndici(String[] indici) {
    for (String indice : indici) {
        try {
            int indiceOggetto = Integer.parseInt(indice); // Converti l'indice in un intero
            if (indiceOggetto < 1 || indiceOggetto > getNumeroOggetti()) {
                // L'indice è fuori dai limiti del forziere
                return false;
            }
        } catch (NumberFormatException e) {
            // Se l'input non può essere convertito in un intero, è invalido
            return false;
        }
    }
    return true; // Tutti gli indici sono validi
}



}
