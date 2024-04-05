package com.effect;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

public class TypewriterEffect {
    private static TypewriterEffect instance;
    private TextArea textAreaConsole;

    private TypewriterEffect() {
        // Costruttore privato per impedire l'istanziazione esterna
    }

    public static TypewriterEffect getInstance() {
        if (instance == null) {
            instance = new TypewriterEffect();
        }
        return instance;
    }

    public void setTextArea(TextArea textArea) {
        this.textAreaConsole = textArea;
    }

    public void type(String message, int delayBetweenLines) {
        if (textAreaConsole == null) {
            System.err.println("TextArea is null. Cannot write message.");
            return;
        }

        Timeline timeline = new Timeline();
        for (int i = 0; i < message.length(); i++) {
            final int index = i; // Variabile locale finale per catturare il valore corretto di index
            KeyFrame keyFrame = new KeyFrame(Duration.millis(40 * i), event -> {
                textAreaConsole.appendText(String.valueOf(message.charAt(index)));
            });
            timeline.getKeyFrames().add(keyFrame);
        }

        // Aggiungiamo un ritardo fisso di 500 millisecondi tra le righe
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(40 * message.length() + delayBetweenLines), event -> {
            textAreaConsole.appendText("\n");
        }));
        timeline.play();
    }
}
