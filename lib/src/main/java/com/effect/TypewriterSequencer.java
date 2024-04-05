package com.effect;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.TextArea;
import javafx.util.Duration;
import java.util.function.Consumer;

public class TypewriterSequencer {
    private static final int DEFAULT_TYPING_SPEED = 40; // Velocità predefinita di battitura (in millisecondi per carattere)

    private TextArea textAreaConsole;
    private Timeline timeline;
    private int currentIndex;
    private Object[] messagesAndDelays;
    private Consumer<Void> onFinishCallback;

    public TypewriterSequencer(TextArea textArea) {
        this.textAreaConsole = textArea;
        this.timeline = new Timeline();
        this.timeline.setOnFinished(event -> nextMessage());
    }

    public void typeSequence(Object... messagesAndDelays) {
        if (messagesAndDelays.length % 2 != 0) {
            throw new IllegalArgumentException("Il numero di messaggi e ritardi deve essere pari, invece ne ho ricevuti:" + messagesAndDelays.length);
        }

        this.messagesAndDelays = messagesAndDelays;
        this.currentIndex = 0;
        nextMessage();
    }

    private void nextMessage() {
        if (currentIndex >= messagesAndDelays.length) {
            if (onFinishCallback != null) {
                onFinishCallback.accept(null);
            }
            return; // Nessun messaggio rimasto
        }

        String message = (String) messagesAndDelays[currentIndex];
        int delay = (int) messagesAndDelays[currentIndex + 1];

        currentIndex += 2;

        // Aggiungi una nuova riga solo se il TextArea non è vuoto
        if (!textAreaConsole.getText().isEmpty()) {
            textAreaConsole.appendText("\n");
        }

        // Inizia la scrittura del messaggio corrente
        writeMessage(message, delay);
    }

    private void writeMessage(String message, int delay) {
        Timeline messageTimeline = new Timeline();

        for (int i = 0; i < message.length(); i++) {
            final int index = i;
            KeyFrame keyFrame = new KeyFrame(Duration.millis(delay + DEFAULT_TYPING_SPEED * index), event -> {
                textAreaConsole.appendText(String.valueOf(message.charAt(index)));
            });
            messageTimeline.getKeyFrames().add(keyFrame);
        }

        messageTimeline.getKeyFrames().add(new KeyFrame(Duration.millis(delay + DEFAULT_TYPING_SPEED * message.length()), event -> {
            // Passa al prossimo messaggio quando il messaggio corrente è completamente scritto
            nextMessage();
        }));

        messageTimeline.play();
    }

    public void setTextArea(TextArea textArea) {
        this.textAreaConsole = textArea;
    }

    public void setOnFinished(Consumer<Void> onFinishCallback) {
        this.onFinishCallback = onFinishCallback;
    }

}

