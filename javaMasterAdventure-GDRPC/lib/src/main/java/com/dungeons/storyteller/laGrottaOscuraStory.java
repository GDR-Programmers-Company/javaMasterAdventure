package com.dungeons.storyteller;

import com.effect.typewriterEffect;

public class laGrottaOscuraStory {
	
	public static void intro() {
		typewriterEffect.type("Sei in una tranquilla giornata di primavera e ti stai rercando al corso java ", 70);
	    typewriterEffect.type("Fiducioso di apprendere nuove nozioni sulla programmazione. \n", 500);
	    typewriterEffect.type("Arrivi nell'aula saluti i tuoi compagni di corso e firmi il registro delle presenze. \n", 500);
	    typewriterEffect.type("L'insegnante comincia a spiegare la lezione, ma l'argomento che sta spiegando ti ipnotizza... \n", 1000);
	    typewriterEffect.type("Improvvisamente, ti trovi solo in una buia e fredda grotta, con in mano la matita che stavi masticando... \n", 500);
	    typewriterEffect.type("Un brivido corre lungo la tua schiena!", 500);
	    typewriterEffect.type("Di fronte a te un Goblin con denti aguzzi si avvicina minaccioso ! \n", 500);
	}
	
	public static void scontroColGoblin() {
		typewriterEffect.type("Cosa vuoi fare? \n", 500);
	    typewriterEffect.type("1. Preso da molto ottimismo e ispirato da Jhon Wick attacchi il Goblin con una matita !", 1000);
	    typewriterEffect.type("2. Fuggi perché il Goblin indossa una maglietta della disney con sopra Chewbecca", 70);
	}
	
	public static void vittoriaSulGoblin() {
		 typewriterEffect.type("Non so come... ", 900);
         typewriterEffect.type("Ma hai sconfitto il Goblin!  \n", 500);
         typewriterEffect.type("Ora potrai narrarlo nelle tue gesta ed essere ricordato come Il Babajaga dei Goblin.  \n", 70);
	}
	public static void ricercaChiave() {
        typewriterEffect.type("Uno strano istinto ti assale... vuoi squartare il Goblin per l'affronto subito? o cercare una via d'uscita? \n", 70);
        System.out.println("1. Squarta il Goblin canticchiando tra te e te...");
        System.out.println("2. Cerca una via d'uscita.");
	}
	
	public static void trovaLaChiaveNelGoblin() {
	       typewriterEffect.type("Trovi una chiave nel corpo del Goblin! \n", 70);
           typewriterEffect.type("Metti in tasca la chiave senza ripulirla... ", 500);
           typewriterEffect.type("Tanto... ", 1500);
           typewriterEffect.type("É tutto un casino...", 200);
	}
	
	public static void richiestaAperturaPortaTesoro1() {
        typewriterEffect.type("Poco piú avanti trovi una porta chiusa a chiave. La chiave trovata potrebbe aprirla. \n", 70);
        typewriterEffect.type("Vuoi usare la chiave per aprire la porta? \n", 70);

        System.out.println("1. Usa la chiave");
        System.out.println("2. Cerca un'altra via");
	}
	
	public static void richiestaAperturaForziere1() {
    	typewriterEffect.type("Usi la chiave per aprire la porta...", 500);
    	typewriterEffect.type("La porta si apre... e...", 2000);
    	typewriterEffect.type("In fondo alla stanza si rivela esserci un antico forziere!", 500);
    	typewriterEffect.type("Ti precipiti in preda all'aviditá! \n", 500);
    	typewriterEffect.type("Vuoi aprire il forzie? \n", 500);
    	typewriterEffect.type("1.DANNAZIONE SI !!! Perché me lo devi chiedere?", 500);
    	typewriterEffect.type("2.No!!! Sono un assassino mica un ladro... per chi mi hai preso?", 500);
	}
	public static void mostroContenutoForziere(String[] contenutoForziere) {
		typewriterEffect.type("Il forziere si apre con un cigolio sinistro...", 500);
		typewriterEffect.type("Ci sono "+contenutoForziere.length+" oggetti suo interno:", 500);

        for (String oggetto : contenutoForziere) {
        	typewriterEffect.type("- " + oggetto, 500);

        }

        System.out.println("Cosa vuoi raccogliere?");
        System.out.println("(inserisci i numeri separati da spazio):");
	}
	public static void fugaGoblinGameOver1() {
    	typewriterEffect.type("Il Goblin ti imprigiona nella sua grotta..." , 500);
    	typewriterEffect.type("Non puoi scappare!\n" , 1000);
    	typewriterEffect.type("Solo e desolato non ti rimane che restare in silenzio a contemplare la tua cella." , 100);
    	typewriterEffect.type("Senti una voce in lontananza chiamare il tuo nome..." , 1000);
    	typewriterEffect.type("Chi sará mai? \n" , 1500);
    	typewriterEffect.type("Chiudi e riapri gli occhi e ti ritrovi tra i tuoi compagni che ti guardano attoniti." , 2000);
    	typewriterEffect.type("Ti riferiscono che eri in preda a strane allucinazioni...\n" , 1500);
    	typewriterEffect.type("Finisci dal direttore che esige da te un test anti-droga." , 2000);
    	typewriterEffect.type("Fiducioso vai a fare il test ed aspetti i risultati.\n" , 2000);
    	String e= "";
    	int i= 2;
    	for (int c=0;c<5;c++) {
    		 String w =".";
    		 e = e + w;
        	typewriterEffect.type("Aspetti.."+e+"\n" , i*1000);
        	i++;
    	}
    	typewriterEffect.type("Ecco i risultati !\n" , 2000);
    	typewriterEffect.type("Sei positivo al test ant-droga !\n" , 2000);
    	typewriterEffect.type("La scuola ha deciso di espellerti !\n" , 1000);
	}
	
	public static void ilGoblinTiAcciuffa() {
		typewriterEffect.type("Decidi di fuggire! \n" , 1000);
    	typewriterEffect.type(".... \n" , 500);
    	typewriterEffect.type("Ma il Goblin é piú veloce di te! \n" , 1000);
    	typewriterEffect.type("Il Goblin riesce ad acciuffarti per la maglietta! \n" , 100);
	}
	public static void fuggiDalGoblinConSuccesso() {
		typewriterEffect.type("Il Goblin perde l'equilibrio!" , 1000);
		typewriterEffect.type("Sbatte con violenza contro una rastrelliera..." , 2000);
		typewriterEffect.type("Con un fare buffo una pesante ascia molto ma molto ..." , 2000);
		typewriterEffect.type("E DICO MOLTO ! MOOOOOLTO AFFILATA ! ..." , 500);
		typewriterEffect.type("gli cade sul collo e lo decapita! ..." , 2000);
		typewriterEffect.type("sollevato scoppi a ridere a crepapelle! ..." , 500);
	}
	public static void fugaDalGoblinGameOver2() {
    	typewriterEffect.type("Decidi di fuggire, ma inciampi, batti la testa e... \n" , 2000);
    	typewriterEffect.type("ti ritrovi in classe con i tuoi compagni... \n" , 1000);
    	typewriterEffect.type("Menomale !... pensi tra te e te... era solo un sogno ! \n" , 500);
    	typewriterEffect.type("Il professore ti chiama ! ... Sei interrogato ! \n" , 500);
	}


}
