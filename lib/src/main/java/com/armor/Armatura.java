package com.armor;

import com.objects.Oggetto;

//Definizione della classe Armatura che estende la classe astratta Oggetto
public class Armatura extends Oggetto {
 
 // Campi dati della classe Armatura
 private int difesa; // Difesa dell'armatura
 
 // Costruttore della classe Armatura
 public Armatura(String nome, int difesa) {
     super(nome); // Chiama il costruttore della classe base (Oggetto) con una potenza di 0
     this.difesa = difesa; // Inizializza la difesa dell'armatura
 }

 // Metodo getter per ottenere la difesa dell'armatura
 public int getDifesa() {
     return difesa;
 }

@Override
public void usa() {
	// TODO Auto-generated method stub
	
}

 // Non è necessario sovrascrivere il metodo getPotenza() poiché è già definito nella classe Oggetto
}
