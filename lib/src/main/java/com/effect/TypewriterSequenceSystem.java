package com.effect;

import javafx.scene.control.TextArea;

import java.util.function.Consumer;

import com.interfaces.NextActionHandler;

public class TypewriterSequenceSystem {
    private static TextArea textAreaConsole;
    private static TypewriterSequencer typewriterSequencer;
    private static boolean sequenzaCompletata = false;


	 // Metodo per gestire l'azione successiva
    public static void handleNextAction(NextActionHandler nextActionHandler) {
        // Esegui l'azione successiva specificata dal gestore delle azioni successive
        nextActionHandler.handleNextAction(textAreaConsole);
    }
	  
    public void handle(Object[][] messagesWithDelays, NextActionHandler nextActionHandler, TextArea textAreaConsole) {
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
  
}
