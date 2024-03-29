package com.heroes;
import com.armor.Armatura;
import com.effect.typewriterEffect;
import com.enemy.*;
import com.food.Cibo;
import com.magicItems.oggettoMagico;
import com.missionObject.oggettoMissione;
import com.weapons.Arma;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Personaggio {
    private String nome;
    private String classe;
    private int puntiVita;
    private boolean haChiave;
    private boolean escape;
    private List<Arma> inventarioArmi;
    private List<Armatura> inventarioArmature;
    private List<oggettoMissione> inventarioOggettiMissione;
    private List<Cibo> inventarioCibo;
    private List<oggettoMagico> inventarioOggettiMagici;


    // Costruttore
    public Personaggio(String nome, String classe, int puntiVita) {
        this.nome = nome;
        this.classe = classe;
        this.puntiVita = puntiVita;
        this.haChiave = false;
        this.inventarioArmi = new ArrayList<>();
        this.inventarioArmature = new ArrayList<>();
        this.inventarioOggettiMissione = new ArrayList<>();
        this.inventarioCibo = new ArrayList<>();
        this.inventarioOggettiMagici = new ArrayList<>();

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
    // Metodo per attaccare un nemico
    public void attacca(Nemico nemico) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Object[] armaEquipaggiata = dannoArma();
        String nomeArmaUtilizzata = (String) armaEquipaggiata[0];
        int dannoInflitto = (int) armaEquipaggiata[1];

        // Lancio del dado
        typewriterEffect.type("Premi Invio per lanciare il dado per l'attacco...", 100);

        scanner.nextLine();
        int dado = random.nextInt(20) + 1; // Simula il lancio di un dado da 1 a 20
        typewriterEffect.type("Hai lanciato il dado e ottenuto: " + dado, 500);


        // Implementazione dell'attacco
        typewriterEffect.type(nome + " attacca " + nemico.getNome() + "...", 500);
        if (dado >= 10) {
            int danno = random.nextInt(10) + 1; // Danno casuale da 1 a 10
            typewriterEffect.type("Colpito! " + nemico.getNome() + " con "+ nomeArmaUtilizzata +" subisce " + (danno+dannoInflitto) + " danni!", 500);
            nemico.subisciDanno(danno+dannoInflitto);

        } else {
            typewriterEffect.type("Mancato!", 500);
        }
  
        
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
    public boolean escape(Nemico nemico) {
    	escape = false;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Lancio del dado
        typewriterEffect.type("Premi Invio per lanciare il dado per cercare di scappare...", 100);

        scanner.nextLine();
        int dado = random.nextInt(20) + 1; // Simula il lancio di un dado da 1 a 20
        typewriterEffect.type("Hai lanciato il dado e ottenuto: " + dado, 500);


        // Implementazione dell'attacco
        typewriterEffect.type(nome + " cerca di divincolarsi dal " + nemico.getNome() + "...", 500);
        if (dado >= 6) {
            typewriterEffect.type("Sei riuscito a liberarti dal " + nemico.getNome(), 500);
            escape = true;
           
        } else {
            typewriterEffect.type("Il "+ nemico.getNome()+ " ha la meglio su di te...", 500);
            escape = false;
        }
        return escape;
    }

    // Metodo per subire danni
    public void subisciDanno(int danno) {
        puntiVita -= danno;
        if (puntiVita <= 0) {
        	typewriterEffect.type(nome + " è stato sconfitto!", 500);
            gameOver();
        }
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
    	    typewriterEffect.type("Game Over. Ricomincia il gioco.", 500);

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
}
