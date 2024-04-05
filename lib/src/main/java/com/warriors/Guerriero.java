package com.warriors;
import com.creatures.Crerature;
import com.heroes.*;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea; // Assicurati di importare la classe TextArea corretta

// Classe Guerriero - Ereditarietà e Polimorfismo
public class Guerriero extends Personaggio {
    // Costruttore
    public Guerriero(String nome, int puntiVita, TextArea textAreaGlobale, Button sendButton) {
        super(nome, "Guerriero", puntiVita, textAreaGlobale, sendButton);
    }

}
