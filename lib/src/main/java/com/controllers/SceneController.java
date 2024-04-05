package com.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.asciiArt.asciiArt;
import com.dungenons.laGrottaOscura;
import com.dungeons.storyteller.laGrottaOscuraStory;
import com.effect.TypewriterEffect;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SceneController implements Initializable {

    @FXML
    private TextArea gameConsole;
    @FXML
    private TextField playerInput;
    @FXML
    private Button sendInput;
    @FXML
    private Button lanciaDadi;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	System.out.println("metodo inizializzato");
    	
    	
    	if (gameConsole != null) {
    	    // Creiamo un'istanza di laGrottaOscura
            laGrottaOscura gioco = new laGrottaOscura();
            // Chiamiamo il metodo esegui sull'istanza gioco
            gioco.esegui(gameConsole, playerInput, sendInput,lanciaDadi);    	} else {
    	}

    }

    public void gameOptions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/scene/homeMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Metodo per iniziare il gioco
    public void startGame() {
    	//laGrottaOscura.esegui(); // Avvia l'introduzione del gioco
    }

  
}
