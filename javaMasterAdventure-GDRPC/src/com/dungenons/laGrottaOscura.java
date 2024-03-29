package com.dungenons;
import com.treasure.*;
import com.warriors.*;
import com.weapons.Arma;
import com.creatures.*;
import java.util.Scanner;
import com.effect.*;
import com.food.Cibo;
import com.heroes.*;
import com.inventary.InventarioPersonaggio;
import com.magicItems.oggettoMagico;
import com.missionObject.oggettoMissione;
import com.objects.Oggetto;
import com.dungenons.*;
import com.dungeons.storyteller.laGrottaOscuraStory;
import com.armor.Armatura;
import com.combatSystem.*;
import com.dungeons.chest.*;


public class laGrottaOscura {
	public static void esegui() {
		
    // Creazione del personaggio
	     // Creazione di un'arma
        Arma spada = new Arma("Spada", 10);
        Arma matita = new Arma("Matita", 2);

        // Creazione di un'armatura
        Armatura armaturaCuoio = new Armatura("Armatura di cuoio", 5);

        // Creazione di un oggetto di missione
        oggettoMissione mappaDiKulukt = new oggettoMissione("Mappa del tesoro","Mappa del tesoro di Kulukt");
        
        // Creazione di un oggetto di missione
        oggettoMissione matitaMasticataInsanguinata = new oggettoMissione("Matita masticata","La matita con la quale hai ucciso il goblin che avevi in bocca a lezione");
        // Creazione di un cibo
        Cibo paneElfico = new Cibo("Pane elfico", 20);

        // Creazione di un oggetto magico
        oggettoMagico amuletoDiRosniak = new oggettoMagico("Amuleto di Rosniak","Magia del fuoco","Protegge il possessore dai danni magici del fuoco");
   
        //Creazione delle chest
        Oggetto[] oggettiForziere1 = {
        		spada,
        		armaturaCuoio,
        		paneElfico,
        		mappaDiKulukt,
        		amuletoDiRosniak
        	};
     // Creazione del forziere
        Chest forziere1 = new Chest(oggettiForziere1);
        
    Guerriero eroe = new Guerriero("Eroe", 10);
    InventarioPersonaggio inventarioEroe = new InventarioPersonaggio(30); // Crea un inventario con una capacità massima di 10 oggetti

    // Aggiunta degli oggetti all'inventario del personaggio
    eroe.aggiungiOggettoMissione(matitaMasticataInsanguinata);
    eroe.aggiungiArma(matita);

    // Storia e Scontro con un Goblin
    // Dialogo di intro
    laGrottaOscuraStory.intro();
    
    Crerature goblin = new Crerature("Goblin", 10);
    
    // Scontro col Goblin 1 = affronto ; 2 = scappo
    laGrottaOscuraStory.scontroColGoblin();

    Scanner scanner = new Scanner(System.in);
    int scelta = scanner.nextInt();

    // Azioni in base alla scelta del giocatore
    if (scelta == 1) {
          
        if ( combatSystem.combat(eroe, goblin)) {
            // Se l'eroe esce vittorioso dallo scontro con il Goblin
        	laGrottaOscuraStory.vittoriaSulGoblin();
        	
        	// Ricerca della chiave
        	laGrottaOscuraStory.ricercaChiave();

            scelta = scanner.nextInt();
            
            if (scelta == 1) {
                eroe.setHaChiave(true);
                laGrottaOscuraStory.trovaLaChiaveNelGoblin();
         

                // Trova la chiave e gestisci il forziere
                if (eroe.haChiave()) {
                	//Richiesta di apertura della porta per trovare il tesoro
                	laGrottaOscuraStory.richiestaAperturaPortaTesoro1();

                    scelta = scanner.nextInt();
                    if (scelta == 1) {
                    	//Richiesta di aprire il forziere
                    	laGrottaOscuraStory.richiestaAperturaForziere1();

                    scelta = scanner.nextInt();	
                    
                    if (scelta == 1) {
                        typewriterEffect.type("Visualizzazione del contenuto del forziere:", 200);
                        forziere1.visualizzaContenuto();
                        
                        boolean inputCorretto = false; // Variabile per indicare se l'input è corretto
                        while (!inputCorretto) {
                            typewriterEffect.type("Scegli i numeri degli oggetti che vuoi raccogliere (separati da spazio): ", 200);
                            scanner.nextLine(); // svuoto lo scanner per liberarlo
                            String oggettiSelezionati = scanner.nextLine();
                            String[] indiciOggetti = oggettiSelezionati.split(" ");
                            
                            // Verifica che gli indici siano validi e aggiungi gli oggetti all'inventario
                            if (forziere1.verificaIndici(indiciOggetti)) {
                                forziere1.raccogliOggetti(indiciOggetti, inventarioEroe);
                                inputCorretto = true; // Imposta a true se l'input è corretto
                            } else {
                                typewriterEffect.type("Scelta non valida. Riprova.", 200);
                             // Fine del livello Grotta oscura
                             // Prosegui la storia creando un altro livello
                            }
                        }

                        typewriterEffect.type("Ora con i tuoi nuovi oggetti puoi proseguire la tua avventura.", 500);
                    }

                    	else {
                    		
                        	typewriterEffect.type("Decidi intrepido di proseguire il tuo cammino.", 500);
                        	// Fine del livello Grotta oscura
                        	// Prosegui la storia creando un altro livello
                    	}
                    	// Fine del livello Grotta oscura   
                    	// Prosegui la storia creando un altro livello
                    	
                    } else if (scelta == 2) {
                    	laGrottaOscuraStory.fugaDalGoblinGameOver2();
                    	eroe.gameOver();
                    }
                }
            } else if (scelta == 2) {
            	typewriterEffect.type("Decidi di cercare una via d'uscita. \n" , 100);
            	
                // Altri eventi potrebbero essere aggiunti qui
            }
        }
			 
    } else {
        // Gestione della prima fuga
    	laGrottaOscuraStory.ilGoblinTiAcciuffa();
    	
    	//Riuscirai a fuggire ?
    	if(eroe.escape(goblin)) {
    		laGrottaOscuraStory.fuggiDalGoblinConSuccesso();
    	}
    	else {
    		laGrottaOscuraStory.fugaGoblinGameOver1();
        	eroe.gameOver();		
    	}
    }

}


}

