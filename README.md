# JavaMasterAdventure

## Descrizione
JavaMasterAdventure è un'applicazione Java che simula un gioco di avventura testuale. Esplora mondi fantastici, affronta mostri spaventosi e risolvi enigmi intriganti in questo emozionante viaggio attraverso la programmazione Java!

## Requisiti
- Java Development Kit (JDK) 17 o versione successiva installato sul tuo sistema.
- Un ambiente di sviluppo integrato (IDE) come Eclipse o IntelliJ IDEA, se si desidera modificare o estendere il codice sorgente.
- Amore per i GDR e D&D
- Voglia di programmare e contribuire al progetto (quella non guasta mai!)

## Utilizzo
1. Clona il repository JavaMasterAdventure sul tuo computer: 
git clone https://github.com/GDR-Programmers-Company/javaMasterAdventure.git

2. Importa il progetto nel tuo IDE preferito.

3. Esegui l'applicazione eseguendo la classe principale `Main.java`.

4. Segui le istruzioni a schermo per giocare all'avventura!

## <span style="color:red">Struttura del Codice</span>
### <span style="color:red">Un lista utile di metodi implementati</span>

### <span style="color:blue">Eroe</span> (Personaggio)
- <span style="color:green">`Personaggio(nome, classe, puntiVita)`</span>: Crea un nuovo personaggio.
- <span style="color:green">`attacca(Nemico nemico)`</span>: Attacca un nemico.
- <span style="color:green">`dannoArma()`</span>: Infligge un danno all'avversario in base all'arma in uso.

### <span style="color:orange">Chest</span> (Forziere)
- <span style="color:green">`Chest(Oggetto[] oggetti)`</span>: Inizializza la chest.
- <span style="color:green">`visualizzaContenuto()`</span>: Visualizza il contenuto del forziere.
- <span style="color:green">`raccogliOggetti(indiciOggetti, InventarioPersonaggio )`</span>: Raccoglie gli oggetti dal forziere.
- <span style="color:green">`verificaIndici(indici)`</span>: Verifica se gli indici degli oggetti corrispondono a quelli scelti dall'utente.

### <span style="color:orange">Inventario</span> (Inventario)
- <span style="color:green">`InventarioPersonaggio(dimensioneMassima)`</span>:Inizializza l'inventario del personaggio.
- <span style="color:green">`aggiungiOggetto(Oggetto)`</span>: Aggiunge un oggetto all'inventario

### <span style="color:orange">Combat System</span> (Sistema di combattimento)
- <span style="color:green">`combat(Guerriero eroe, Crerature creature)`</span>: Inizializza il combattimento tra l'eroe e la creatura.

### <span style="color:orange">Dungeon</span> (Livelli creati)
- <span style="color:green">`laGrottaOscura()`</span>: Inizializza il dungeon La Grotta Oscura.

# Implementazioni sviluppate e da sviluppare 
## _(potrebbero variare in corso d'opera)_
### <span style="color:orange">Giocatore</span>
  - [ ] Camminata / ricerca del percorso
  - [ ] Menu contestuale / Azioni
  - [ ] Salute e statistiche
  - [x] Inventario (in fase evolutiva)
  - [ ] Abbigliamento del personaggio
  - [ ] La tua prima missione
### <span style="color:orange">Interfaccia Utente</span>
  - [ ] Scheda Inventario
  - [ ] Scheda Missioni
  - [ ] Box di chat (per giocatori e azioni)
  - [ ] Scheda Abbigliamento del personaggio
  - [ ] Aspetto generale e sensazione
### <span style="color:orange">NPC</span> (personaggi non giocanti)
  - [ ] Commercio (Negozi)
  - [ ] Interazione dialoghi
  - [ ] Movimento
  - [ ] Banca
### <span style="color:orange">Creature e Mostri</span>
  - [x] Sistema di combattimento (in fase evolutiva)
  - [ ] Saccheggio
  - [ ] Apparizione
### <span style="color:orange">Network</span>
  - [ ] I giocatori si vedono reciprocamente
  - [ ] Personaggi non giocanti
  - [ ] Mostri
  - [ ] Scambio tra giocatori
  - [ ] Oggetti
### <span style="color:orange">Mondo</span>
  - [ ] Sistema di respawn
  - [ ] Giocatore contro giocatore
  - [ ] Abilità di raccolta risorse
  - [ ] Estrazione mineraria
  - [ ] Fabbro 
  - [ ] Pesca
  - [ ] Cucina

### *Il progetto é alle sue fasi embrionali, quindi in costante evoluzione, assicurati di mantenere aggiornata la tua copia costantemente !*