package com.combatSystem;
import com.warriors.*;

import javafx.scene.control.TextArea;

import com.creatures.*;
import com.effect.*;
import com.heroes.Personaggio;

public class CombatSystem {
    private static TypewriterSequencer typewriterSequencer;


    public static String combat(Personaggio personaggio, Personaggio nemico, TextArea textAreaConsole) {
        String esitoBattaglia = "nd";
        Object[] messaggiNemico = null;
        Object[] messaggiEroe = null;
        Object[] messaggioTiraIDadi = null;
        Object[][] arrayMessaggi;
        Object[] concatenazioneArrayMessaggi;
        int delayBetweenAttacks = 500;

        TypewriterSequencer typewriterSequencer = new TypewriterSequencer(textAreaConsole);

        if (nemico.getPuntiVita() > 0 && personaggio.getPuntiVita() > 0) {
            RisultatoAttacco risultatoPersonaggio = personaggio.attacca(nemico);
            messaggiEroe = risultatoPersonaggio.getMessaggi();
            disableAttacks(nemico);

            try {
                Thread.sleep(delayBetweenAttacks);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            RisultatoAttacco risultatoNemico = nemico.attacca(personaggio);
            disableAttacks(personaggio);

            // Controllo se il personaggio o il nemico ha perso la battaglia
            if (nemico.getPuntiVita() <= 0) {
                esitoBattaglia = "vinto";
                messaggiNemico = new Object[]{"Vittoria !", 70};
                messaggioTiraIDadi = new Object[]{"", 70};
            } else if (personaggio.getPuntiVita() <= 0) {
                esitoBattaglia = "perso";
                messaggiNemico = new Object[]{"Hai perso lo scontro !", 70};
                messaggioTiraIDadi = new Object[]{"", 70};
            } else {
                // Se nessuno ha perso, il combattimento continua
                esitoBattaglia = "nd";
                messaggiNemico = risultatoNemico.getMessaggi();
                messaggioTiraIDadi = new Object[]{"Lancia i dadi per attaccare di nuovo ! \n", 70};
            }
        }

        // Inizializzo messaggiEroe se non è stato inizializzato prima
        if (messaggiEroe == null) {
            messaggiEroe = new Object[]{"", 70};
        }

        // Creo l'array dei messaggi concatenati
        arrayMessaggi = new Object[][]{messaggiEroe, messaggiNemico, messaggioTiraIDadi};
        concatenazioneArrayMessaggi = concatenateArrays(arrayMessaggi);

        // Stampo il numero totale di elementi nell'array
        System.out.println("totale elementi=" + concatenazioneArrayMessaggi.length);

        // Inviare i messaggi al typewriterSequencer
        typewriterSequencer.typeSequence(concatenazioneArrayMessaggi);

        // Abilito gli attacchi dopo un ritardo
        enableAttacksAfterDelay(personaggio, nemico, delayBetweenAttacks);

        // Inserire callback prima di restituire l'esito della battaglia per gestire le chiamate successive
        return esitoBattaglia;
    }


    private static Object[] concatenateArrays(Object[][] arrays) {
        int totalLength = 0;
        for (Object[] array : arrays) {
            totalLength += array.length;
        }

        Object[] concatenatedArray = new Object[totalLength];

        int index = 0;
        for (Object[] array : arrays) {
            for (Object element : array) {
                concatenatedArray[index++] = element;
            }
        }

        return concatenatedArray;
    }


	    private static void disableAttacks(Personaggio personaggio) {
	        personaggio.setAttacchiDisabilitati(true);
	    }

	    private static void enableAttacksAfterDelay(Personaggio personaggio, Personaggio nemico, int delay) {
	        Thread thread = new Thread(() -> {
	            try {
	                Thread.sleep(delay); // Attendere per il periodo di ritardo
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	            // Riabilita gli attacchi di entrambi i personaggi dopo il ritardo
	            personaggio.setAttacchiDisabilitati(false);
	            nemico.setAttacchiDisabilitati(false);
	        });
	        thread.start();
	    }
}
