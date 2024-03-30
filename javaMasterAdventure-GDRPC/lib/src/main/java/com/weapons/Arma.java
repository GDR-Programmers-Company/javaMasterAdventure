package com.weapons; // Definisce il package in cui si trova la classe Arma

import com.objects.Oggetto;

//Definizione della classe Arma che estende la classe astratta Oggetto
public class Arma extends Oggetto {
	
	 // Campi dati della classe Armi
	 private int potenza; // potenza di attacco
	 
 // Costruttore della classe Arma
 public Arma(String nome, int potenza) {
     super(nome); // Chiama il costruttore della classe base (Oggetto)
     this.potenza = potenza;
 }
 
 // Metodo getter per ottenere la difesa dell'armatura
 public int getPotenza() {
     return potenza;
 }
@Override
public void usa() {
	// TODO Auto-generated method stub
	
}



 // Non è necessario sovrascrivere i metodi getNome() e getPotenza() poiché sono già definiti nella classe Oggetto
}