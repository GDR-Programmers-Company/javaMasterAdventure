package com.objects;

public abstract class Oggetto implements interfacciaOggetto {
    private String nome;

    public Oggetto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int getPotenza() {
        return 0; // Imposta la potenza a 0 per impostazione predefinita
    }

    @Override
    public int getDifesa() {
        return 0; // Imposta la difesa a 0 per impostazione predefinita
    }

    @Override
    public int getRipristinoSalute() {
        return 0; // Imposta i punti salute a 0 per impostazione predefinita
    }
    @Override
    public String getDescrizione() {
        return ""; // Imposta i punti salute a 0 per impostazione predefinita
    }
    @Override
    public String getEffetto() {
        return ""; // Imposta i punti salute a 0 per impostazione predefinita
    }
    public abstract void usa();
}
