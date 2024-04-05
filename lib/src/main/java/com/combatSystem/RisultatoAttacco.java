package com.combatSystem;

public class RisultatoAttacco {
    private Object[] messaggi;
    private boolean successo;

    public RisultatoAttacco(Object[] messaggi, boolean successo) {
        this.messaggi = messaggi;
        this.successo = successo;
    }

    public Object[] getMessaggi() {
        return messaggi;
    }

    public boolean esito() {
        return successo;
    }
}

