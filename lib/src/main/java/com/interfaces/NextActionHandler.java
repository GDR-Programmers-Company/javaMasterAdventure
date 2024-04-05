package com.interfaces;

import javafx.scene.control.TextArea;

@FunctionalInterface
public interface NextActionHandler {
    void handleNextAction(TextArea textAreaConsole);
}