package com.dungenons;

import com.treasure.*;
import com.warriors.*;
import com.weapons.Arma;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import com.creatures.*;
import com.effect.*;
import com.food.Cibo;
import com.heroes.*;
import com.inventary.InventarioPersonaggio;
import com.magicItems.oggettoMagico;
import com.missionObject.oggettoMissione;
import com.objects.Oggetto;
import com.dungeons.*;
import com.dungeons.storyteller.laGrottaOscuraStory;
import com.armor.Armatura;
import com.combatSystem.*;
import com.dungeons.chest.*;
import com.interfaces.ActionWithTextArea;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

public class laGrottaOscura {
    private TextField inputText;
    private TextArea textAreaConsole;
    private Guerriero eroe;
    private Personaggio goblin;
    private TextArea textAreaGlobale;

    public void esegui(TextArea textAreaConsole, TextField inputField, Button sendButton, Button lanciaDadi) {
        this.textAreaConsole = textAreaConsole;
        Arma spada = new Arma("Spada", 10);
        Arma matita = new Arma("Matita", 2);
        Armatura armaturaCuoio = new Armatura("Armatura di cuoio", 5);
        oggettoMissione mappaDiKulukt = new oggettoMissione("Mappa del tesoro", "Mappa del tesoro di Kulukt");
        oggettoMissione matitaMasticataInsanguinata = new oggettoMissione("Matita masticata", "La matita con la quale hai ucciso il goblin che avevi in bocca a lezione");
        Cibo paneElfico = new Cibo("Pane elfico", 20);
        oggettoMagico amuletoDiRosniak = new oggettoMagico("Amuleto di Rosniak", "Magia del fuoco", "Protegge il possessore dai danni magici del fuoco");

        Oggetto[] oggettiForziere1 = {spada, armaturaCuoio, paneElfico, mappaDiKulukt, amuletoDiRosniak};
        Chest forziere1 = new Chest(oggettiForziere1);
        textAreaGlobale = this.textAreaConsole;

        eroe = new Guerriero("Eroe", 10, textAreaConsole, lanciaDadi);
        goblin = new Personaggio("Goblin", "Goblin", 10, textAreaConsole, lanciaDadi);

        InventarioPersonaggio inventarioEroe = new InventarioPersonaggio(30);
        eroe.aggiungiOggettoMissione(matitaMasticataInsanguinata);
        eroe.aggiungiArma(matita);

        laGrottaOscuraStory.intro(textAreaConsole);

        sendButton.setOnAction(event -> {
            String userInput = inputField.getText();
            gestisciInputUtente(userInput);
            inputField.clear();
        });
        
        // Aggiungi un gestore degli eventi al pulsante
        lanciaDadi.setOnAction(event -> {
        	
          	 switch (CombatSystem.combat(eroe, goblin,textAreaGlobale)) {
          	 default:
                 break;
             case "vinto":
            	 System.out.println("Hai Vinto");
            	// laGrottaOscuraStory.vittoriaSulGoblin(textAreaGlobale);
                 break;
             case "perso":
            	 System.out.println("Hai Perso");

            	 //eroe.gameOver();
                 break;
         }
        	
        
            
        });
    }

    private void gestisciInputUtente(String input) {
        switch (input) {
            case "1":
                affrontaGoblin();
                break;
            case "2":
                cercaUscita();
                break;
            default:
                // Gestisci input non valido
                break;
        }
    }

    private void affrontaGoblin() {
    	laGrottaOscuraStory.lanciaIDadi(textAreaGlobale);

    }

    private void cercaUscita() {
        laGrottaOscuraStory.ilGoblinTiAcciuffa(textAreaGlobale);
        if (eroe.escape(goblin)) {
            laGrottaOscuraStory.fuggiDalGoblinConSuccesso(textAreaGlobale);
        } else {
            laGrottaOscuraStory.fugaGoblinGameOver1(textAreaGlobale);
            eroe.gameOver();
        }
    }
}
