package com.enemy;
import com.effect.typewriterEffect;
import com.heroes.*;
import java.util.Scanner;
import java.util.Random;

//Classe Nemico
public class Nemico {
 private String nome;
 private int puntiVita;

 // Costruttore
 public Nemico(String nome, int puntiVita) {
     this.nome = nome;
     this.puntiVita = puntiVita;
 }

 // Metodo per attaccare un personaggio
 public void attacca(Personaggio personaggio) {
     Scanner scanner = new Scanner(System.in);
     Random random = new Random();

     // Lancio del dado
     typewriterEffect.type("Premi Invio per lanciare il dado per l'attacco del nemico...", 500);

     scanner.nextLine();
     int dado = random.nextInt(20) + 1; // Simula il lancio di un dado da 1 a 20
     typewriterEffect.type("Il nemico ha lanciato il dado e ottenuto: " + dado, 500);

     // Implementazione dell'attacco
     typewriterEffect.type(nome + " attacca " + personaggio.getNome() + "...", 500);

     if (dado >= 10) {
         int danno = random.nextInt(10) + 1; // Danno casuale da 1 a 10
         
         typewriterEffect.type("Colpito! " + personaggio.getNome() + " subisce " + danno + " danni!", 500);
         personaggio.subisciDanno(danno);

     } else {
         typewriterEffect.type("Mancato!", 500);

     }
 }

 // Metodo per subire danni
 public void subisciDanno(int danno) {
     puntiVita -= danno;
     if (puntiVita <= 0) {
    	 typewriterEffect.type(nome + " è stato sconfitto!", 500);
        
     }
 }

 // Getter per il nome del nemico
 public String getNome() {
     return nome;
 }
 
 public int getPuntiVita() {
     return puntiVita;
 }
 
}
