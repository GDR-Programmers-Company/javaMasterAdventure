package com.combatSystem;
import com.warriors.*;
import com.creatures.*;
import java.util.Scanner;
import com.effect.*;
import com.dungenons.*;
import com.dungeons.storyteller.laGrottaOscuraStory;

public class combatSystem {
	public static boolean combat(Guerriero eroe, Crerature creature) {
		boolean esitoBattaglia = false;
		
		// Combattimento
    	do {
    	    eroe.attacca(creature);
    	    if (creature.getPuntiVita() > 0) {
    	    	creature.attacca(eroe);
    	    }
    	} while (eroe.getPuntiVita() > 0 && creature.getPuntiVita() > 0);
    	
    	if (eroe.getPuntiVita() > creature.getPuntiVita()) {
    		esitoBattaglia = true;
    	}
		
		return esitoBattaglia;
		
	}

}
