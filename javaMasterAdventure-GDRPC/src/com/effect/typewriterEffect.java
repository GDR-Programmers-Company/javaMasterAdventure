package com.effect;

public class typewriterEffect {
	  public static void type(String message, int delayAfter) {
	        try {
	            for (int i = 0; i < message.length(); i++) {
	                System.out.print(message.charAt(i));
	                // Aggiungi un ritardo di 100 millisecondi tra ogni carattere
	                Thread.sleep(40);
	            }
	            System.out.println(); // Aggiungi una riga vuota alla fine
	            // Aggiungi un ulteriore ritardo specificato dopo aver scritto l'intera frase
	            Thread.sleep(delayAfter);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

}
