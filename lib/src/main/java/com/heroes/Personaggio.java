package com.heroes;
import com.armor.Armatura;
import com.combatSystem.RisultatoAttacco;
import com.effect.TypewriterSequencer;

import com.food.Cibo;
import com.magicItems.oggettoMagico;
import com.missionObject.oggettoMissione;
import com.weapons.Arma;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Personaggio {
    private String nome;
    private String classe;
    private String risultatoAttacco;
    private int puntiVita;
    private boolean haChiave;
    private boolean escape;
    private TextArea textAreaGlobale;
    private Button sendButton;
    private boolean attacchiDisabilitati = false;

    private TypewriterSequencer typewriterSequencer;
    private static boolean sequenzaCompletata = false;

    private List<Arma> inventarioArmi;
    private List<Armatura> inventarioArmature;
    private List<oggettoMissione> inventarioOggettiMissione;
    private List<Cibo> inventarioCibo;
    private List<oggettoMagico> inventarioOggettiMagici;


    // Costruttore
    public Personaggio(String nome, String classe, int puntiVita, TextArea textAreaConsole, Button sendButton) {
        this.nome = nome;
        this.classe = classe;
        this.puntiVita = puntiVita;
        this.haChiave = false;
        this.textAreaGlobale = textAreaConsole;
        this.typewriterSequencer = new TypewriterSequencer(textAreaConsole);
        this.inventarioArmi = new ArrayList<>();
        this.inventarioArmature = new ArrayList<>();
        this.inventarioOggettiMissione = new ArrayList<>();
        this.inventarioCibo = new ArrayList<>();
        this.inventarioOggettiMagici = new ArrayList<>();
        this.sendButton = sendButton;
    }
    
    public Object[] dannoArma() {
    	 String nomeArmaUtilizzata;
    	 int dannoInflitto;
        if (inventarioArmi.isEmpty()) {
            // Se il personaggio non ha un'arma equipaggiata, ritorna un danno base
        	 // Se il personaggio non ha un'arma equipaggiata, restituisce un danno base senza arma
            nomeArmaUtilizzata = "Pugni";
            dannoInflitto = 1;

        } else {
            // Se il personaggio ha un'arma equipaggiata, calcola il danno in base all'arma
            Arma armaEquipaggiata = inventarioArmi.get(0); // Supponiamo di prendere solo la prima arma nell'inventario
        	nomeArmaUtilizzata = armaEquipaggiata.getNome();
        	dannoInflitto = armaEquipaggiata.getPotenza();
        }
        // Creiamo un array contenente il nome dell'arma e il danno inflitto
        Object[] risultato = {nomeArmaUtilizzata, dannoInflitto};
        return risultato;
    }


    public RisultatoAttacco attacca(Personaggio rivale) {
        Random random = new Random();
        Object[] armaEquipaggiata = dannoArma();
        String nomeArmaUtilizzata = (String) armaEquipaggiata[0];
        int dannoInflitto = (int) armaEquipaggiata[1];
        int dado = random.nextInt(20) + 1;

        String risultatoAttacco;
        boolean successo;

        if (dado >= 10) {
            int danno = random.nextInt(10) + 1;
            risultatoAttacco = "Colpito! " + rivale.getNome() + " con " + nomeArmaUtilizzata + " subisce " + (danno + dannoInflitto) + " danni! \n";
            rivale.subisciDanno(danno + dannoInflitto);
            successo = true;
        } else {
            risultatoAttacco = "Mancato! \n \n";
            successo = false;
        }

        Object[] messaggi = {
        		nome +" ha lanciato il dado e ottenuto: " + dado +"\n", 500,
        	    nome + " attacca " + rivale.getNome()+ "... \n", 500,
        	    risultatoAttacco, 500
        	};

        return new RisultatoAttacco(messaggi, successo);
    }


    
    /*
     *  
    	// Combinazione di oggetti (esempio: armatura con un cibo)
    	// Supponiamo che il personaggio indossi l'armatura di cuoio e mangi un pezzo di pane elfico per aumentare la salute
    	int nuovaDifesa = armaturaCuoio.getDifesa();
    	int saluteAggiuntiva = paneElfo.getRipristinoSalute();
    	System.out.println("Difesa dopo aver indossato l'armatura: " + nuovaDifesa);
    	System.out.println("Salute aggiunta mangiando il pane elfico: " + saluteAggiuntiva);
    */
    
 // Metodo per attaccare un nemico
    public boolean escape(Personaggio nemico) {
    	escape = false;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Lancio del dado
        typewriterSequencer.typeSequence("Premi Invio per lanciare il dado per cercare di scappare...", 100);

        scanner.nextLine();
        int dado = random.nextInt(20) + 1; // Simula il lancio di un dado da 1 a 20
        typewriterSequencer.typeSequence("Hai lanciato il dado e ottenuto: " + dado, 500);


        // Implementazione dell'attacco
        typewriterSequencer.typeSequence(nome + " cerca di divincolarsi dal " + nemico.getNome() + "...", 500);
        if (dado >= 6) {
        	typewriterSequencer.typeSequence("Sei riuscito a liberarti dal " + nemico.getNome(), 500);
            escape = true;
           
        } else {
        	typewriterSequencer.typeSequence("Il "+ nemico.getNome()+ " ha la meglio su di te...", 500);
            escape = false;
        }
        return escape;
    }

    // Metodo per subire danni
    public void subisciDanno(int danno) {
        puntiVita -= danno;

    }

    // Metodo per impostare la chiave
    public void setHaChiave(boolean haChiave) {
        this.haChiave = haChiave;
    }

    // Metodo per controllare se possiede la chiave
    public boolean haChiave() {
        return haChiave;
    }

    // Metodo per il Game Over
    public void gameOver() {
    	typewriterSequencer.typeSequence("Game Over. Ricomincia il gioco.", 500);

        // Altri eventi di ripristino del gioco potrebbero essere aggiunti qui
        // ad esempio, ripristinare i punti vita del personaggio e posizionarlo all'inizio del dungeon
    }

    // Getter per il nome del personaggio
    public String getNome() {
        return nome;
    }

    // Getter per i punti vita del personaggio
    public int getPuntiVita() {
        return puntiVita;
    }
    
    // Metodi per gestire l'inventario
    
    // Aggiungi oggetti
    public void aggiungiArma(Arma arma) {
        inventarioArmi.add(arma);
    }

    public void aggiungiArmatura(Armatura armatura) {
        inventarioArmature.add(armatura);
    }

    public void aggiungiOggettoMissione(oggettoMissione oggettoMissione) {
        inventarioOggettiMissione.add(oggettoMissione);
    }

    public void aggiungiCibo(Cibo cibo) {
        inventarioCibo.add(cibo);
    }
    
    public void aggiungiOggettiMagici(oggettoMagico oggettiMagici) {
        inventarioOggettiMagici.add(oggettiMagici);
    }
    
    //Rimuovi oggetti
    public void rimuoviArma(Arma arma) {
        inventarioArmi.remove(arma);
    }

    public void rimuoviArmatura(Armatura armatura) {
        inventarioArmature.remove(armatura);
    }

    public void rimuoviOggettoMissione(oggettoMissione oggettoMissione) {
        inventarioOggettiMissione.remove(oggettoMissione);
    }

    public void rimuoviCibo(Cibo cibo) {
        inventarioCibo.remove(cibo);
    }
    
    public void rimuoviOggettiMagici(oggettoMagico oggettiMagici) {
        inventarioOggettiMagici.remove(oggettiMagici);
    }
    public void setAttacchiDisabilitati(boolean disabilitati) {
        this.attacchiDisabilitati = disabilitati;
    }

    public boolean isAttacchiDisabilitati() {
        return attacchiDisabilitati;
    }
	
}
