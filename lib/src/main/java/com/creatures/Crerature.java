package com.creatures;
import com.heroes.Personaggio;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
//Classe Goblin - Ereditarietà e Polimorfismo
public class Crerature extends Personaggio {
 // Costruttore
 public Crerature(String nome, String classe, int puntiVita, TextArea textAreaConsole , Button sendButton) {
     super(nome, classe, puntiVita, textAreaConsole, sendButton);
 }


 
}