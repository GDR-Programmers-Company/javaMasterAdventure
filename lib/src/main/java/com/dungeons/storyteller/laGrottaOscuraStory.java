package com.dungeons.storyteller;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

import com.effect.TypewriterSequencer;
import com.interfaces.NextActionHandler; 


import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

public class laGrottaOscuraStory {
	
    private static TypewriterSequencer typewriterSequencer;
    private static TextArea textAreaConsole;
    private static boolean sequenzaCompletata = false;


    // Metodo per inizializzare la TextArea
    public void setTextArea(TextArea textArea) {
        this.textAreaConsole = textArea;
    }
    
	
	/*
	 * // Metodo per gestire l'azione successiva private static void
	 * handleNextAction(NextActionHandler nextActionHandler) { // Esegui l'azione
	 * successiva specificata dal gestore delle azioni successive
	 * nextActionHandler.handleNextAction(textAreaConsole); }
	 */
	  
    private static void handleTypewriterSequence(Object[][] messagesWithDelays, NextActionHandler nextActionHandler, TextArea textAreaConsole) {
        typewriterSequencer = new TypewriterSequencer(textAreaConsole);
        if (typewriterSequencer == null) {
            System.err.println("TypewriterSequencer non inizializzato correttamente");
            return;
        }

        typewriterSequencer.setOnFinished(new Consumer<Void>() {
            @Override
            public void accept(Void v) {
                // Qui inserisci ciò che vuoi fare quando la sequenza è terminata
                if (!sequenzaCompletata) {
                    sequenzaCompletata = true;
                    // Esegui l'azione successiva
                    nextActionHandler.handleNextAction(textAreaConsole);
                }
            }
        });

        // Converti l'array in un array di tipo Object per passarlo al typewriterSequencer
        Object[] messagesAndDelays = new Object[messagesWithDelays.length * 2];
        for (int i = 0; i < messagesWithDelays.length; i++) {
            messagesAndDelays[i * 2] = messagesWithDelays[i][0];
            messagesAndDelays[i * 2 + 1] = messagesWithDelays[i][1];
        }

        // Chiamiamo il typeSequence con l'array appena creato
        typewriterSequencer.typeSequence(messagesAndDelays);
    }
	 

	public static void intro(TextArea textAreaConsole) {
        //typewriterHandler = new TypewriterSequenceHandler(textAreaConsole);

		Object[][] introMessagesWithDelays = {
			    {"Sei in una tranquilla giornata di primavera e ti stai recando al corso Java ", 70},
			    {"Fiducioso di apprendere nuove nozioni sulla programmazione.\n", 500},
			    {"Arrivi nell'aula, saluti i tuoi compagni di corso e firmi il registro delle presenze.\n", 500},
			    {"L'insegnante comincia a spiegare la lezione, ma l'argomento che sta spiegando ti ipnotizza...\n", 1000},
			    {"Improvvisamente, ti trovi solo in una buia e fredda grotta, con in mano la matita che stavi masticando...\n", 500},
			    {"Un brivido corre lungo la tua schiena!", 500},
			    {"Di fronte a te un Goblin con denti aguzzi si avvicina minaccioso!\n", 500}
			};

		handleTypewriterSequence(introMessagesWithDelays, laGrottaOscuraStory::scontroColGoblin,textAreaConsole);	  
			
	}
	
	public static void scontroColGoblin(TextArea textAreaConsole) {
		typewriterSequencer.typeSequence(
			    "Cosa vuoi fare? \n", 500,
			    "1. Preso da molto ottimismo e ispirato da Jhon Wick attacchi il Goblin con una matita !", 1000,
			    "2. Fuggi perché il Goblin indossa una maglietta della Disney con sopra Chewbecca", 70
			);
	}
	
	public static void vittoriaSulGoblin(TextArea textAreaConsole) {
		Object[][] introMessagesWithDelays = {
				{"Non so come... ", 900},
					{"Ma hai sconfitto il Goblin!  \n", 500},
					{"Ora potrai narrarlo nelle tue gesta ed essere ricordato come Il Babajaga dei Goblin.  \n", 70}
		};
        handleTypewriterSequence(introMessagesWithDelays, laGrottaOscuraStory::ricercaChiave,textAreaConsole);	  

	}
	public static void ricercaChiave(TextArea textAreaConsole) {
		typewriterSequencer.typeSequence(
			    "Uno strano istinto ti assale... vuoi squartare il Goblin per l'affronto subito? o cercare una via d'uscita? \n", 70,
			    "1. Squarta il Goblin canticchiando tra te e te...", 0,
			    "2. Cerca una via d'uscita.", 0
			);

	}
	
	public static void trovaLaChiaveNelGoblin(TextArea textAreaConsole) {
		typewriterSequencer.typeSequence(
			    "Trovi una chiave nel corpo del Goblin! \n", 70,
			    "Metti in tasca la chiave senza ripulirla... ", 500,
			    "Tanto... ", 1500,
			    "È tutto un casino...", 200
			);

	}
	
	public static void richiestaAperturaPortaTesoro1(TextArea textAreaConsole) {
		typewriterSequencer.typeSequence(
			    "Poco più avanti trovi una porta chiusa a chiave. La chiave trovata potrebbe aprirla. \n", 70,
			    "Vuoi usare la chiave per aprire la porta? \n", 70,
			    "1. Usa la chiave",
			    "2. Cerca un'altra via"
			);

	}
	
	public static void richiestaAperturaForziere1(TextArea textAreaConsole) {
		typewriterSequencer.typeSequence(
			    "Usi la chiave per aprire la porta...", 500,
			    "La porta si apre... e...", 2000,
			    "In fondo alla stanza si rivela esserci un antico forziere!", 500,
			    "Ti precipiti in preda all'avidità! \n", 500,
			    "Vuoi aprire il forziere? \n", 500,
			    "1. DANNAZIONE SI !!! Perché me lo devi chiedere?",
			    "2. No!!! Sono un assassino mica un ladro... per chi mi hai preso?"
			);

	}
	public static void mostroContenutoForziere(String[] contenutoForziere, TextArea textAreaConsole) {
		typewriterSequencer.typeSequence(
			    "Il forziere si apre con un cigolio sinistro...", 500,
			    "Ci sono " + contenutoForziere.length + " oggetti suo interno:", 500
			);


        for (String oggetto : contenutoForziere) {
        	typewriterSequencer.typeSequence( "- " + oggetto, 500);

        }

        typewriterSequencer.typeSequence(
        	    "Cosa vuoi raccogliere?", 70,
        	    "(inserisci i numeri separati da spazio):", 70
        	);

	}
	public static void fugaGoblinGameOver1(TextArea textAreaConsole) {
		typewriterSequencer.typeSequence(
			    "Il Goblin ti imprigiona nella sua grotta...", 500,
			    "Non puoi scappare!\n", 1000,
			    "Solo e desolato non ti rimane che restare in silenzio a contemplare la tua cella.", 100,
			    "Senti una voce in lontananza chiamare il tuo nome...", 1000,
			    "Chi sará mai? \n", 1500,
			    "Chiudi e riapri gli occhi e ti ritrovi tra i tuoi compagni che ti guardano attoniti.", 2000,
			    "Ti riferiscono che eri in preda a strane allucinazioni...\n", 1500,
			    "Finisci dal direttore che esige da te un test anti-droga.", 2000,
			    "Fiducioso vai a fare il test ed aspetti i risultati.\n", 2000
			);

    	String e= "";
    	int i= 2;
    	for (int c=0;c<5;c++) {
    		 String w =".";
    		 e = e + w;
    		 typewriterSequencer.typeSequence( "Aspetti.."+e+"\n" , i*1000);
        	i++;
    	}
    	typewriterSequencer.typeSequence(
    		    "Ecco i risultati !\n", 2000,
    		    "Sei positivo al test ant-droga !\n", 2000,
    		    "La scuola ha deciso di espellerti !\n", 1000
    		);

	}
	
	public static void ilGoblinTiAcciuffa(TextArea textAreaConsole) {
		typewriterSequencer.typeSequence(
			    "Decidi di fuggire! \n", 1000,
			    ".... \n", 500,
			    "Ma il Goblin é piú veloce di te! \n", 1000,
			    "Il Goblin riesce ad acciuffarti per la maglietta! \n", 100
			);

	}
	public static void fuggiDalGoblinConSuccesso(TextArea textAreaConsole) {
		typewriterSequencer.typeSequence(
			    "Il Goblin perde l'equilibrio!", 1000,
			    "Sbatte con violenza contro una rastrelliera...", 2000,
			    "Con un fare buffo una pesante ascia molto ma molto ...", 2000,
			    "E DICO MOLTO ! MOOOOOLTO AFFILATA ! ...", 500,
			    "gli cade sul collo e lo decapita! ...", 2000,
			    "sollevato scoppi a ridere a crepapelle! ...", 500
			);

	}
	public static void fugaDalGoblinGameOver2(TextArea textAreaConsole) {
		typewriterSequencer.typeSequence(
			    "Decidi di fuggire, ma inciampi, batti la testa e...", 2000,
			    "ti ritrovi in classe con i tuoi compagni...", 1000,
			    "Menomale !... pensi tra te e te... era solo un sogno !", 500,
			    "Il professore ti chiama ! ... Sei interrogato !", 500
			);

	}
	
	public static void lanciaIDadi(TextArea textAreaConsole) {
		typewriterSequencer.typeSequence(
			    "\n Lancia i dadi per l'attacco !\n", 500
			);
	}
	
	




}
