package com.interfaces;

import javafx.scene.control.TextArea;

@FunctionalInterface
public
interface ActionWithTextArea {
    void performAction(TextArea textAreaConsole);
}

