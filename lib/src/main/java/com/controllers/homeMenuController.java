package com.controllers;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.asciiArt.asciiArt;
import com.dungenons.laGrottaOscura;
import com.effect.TypewriterEffect;

public class homeMenuController implements Initializable {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
    
    @FXML
    private MediaView mediaView;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    @FXML
    private ImageView newGame;
    @FXML
    private ImageView loadGame;
    @FXML
    private ImageView saveGame;
    @FXML
    private ImageView quitGame;

    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Carica il video di sfondo
        file = new File("src/main/java/assets/video/backgroundFullhd.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        
        // Imposta le immagini originali per i pulsanti
        newGame.setImage(new Image("assets/images.menu/newGameOff.png"));
        loadGame.setImage(new Image("assets/images.menu/loadGameOff.png"));
        saveGame.setImage(new Image("assets/images.menu/saveGameOff.png"));
        quitGame.setImage(new Image("assets/images.menu/quitGameOff.png"));

        // Aggiunge i gestori degli eventi del mouse per ciascun pulsante
        setMouseOverHandler(newGame, "assets/images.menu/newGameOn.png");
        setMouseOverHandler(loadGame, "assets/images.menu/loadGameOn.png");
        setMouseOverHandler(saveGame, "assets/images.menu/saveGameOn.png");
        setMouseOverHandler(quitGame, "assets/images.menu/quitGameOn.png");

        // Imposta il volume del video a 0 per evitare rumori
        mediaPlayer.setVolume(0);

        // Avvia il video automaticamente
        mediaPlayer.setAutoPlay(true);

        // Imposta il ciclo di riproduzione infinito per il video di sfondo
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        handleNewGameClick();
        
        System.out.println("Game Menu initialized");
    }

    private void setMouseOverHandler(ImageView imageView, String hoverImageName) {
        // Gestore dell'evento mouseEntered
        imageView.setOnMouseEntered(event -> {
            // Effetto di dissolvenza in uscita
            fadeOutImage(imageView, () -> {
                // Cambia l'immagine con quella passata come parametro
                imageView.setImage(new Image(hoverImageName));
                // Effetto di dissolvenza in entrata
                fadeInImage(imageView);
            });
            // Imposta il cursore a forma di mano quando il mouse entra nell'immagine
            imageView.getParent().setCursor(Cursor.HAND);
        });

        // Gestore dell'evento mouseExited
        imageView.setOnMouseExited(event -> {
            // Effetto di dissolvenza in uscita
            fadeOutImage(imageView, () -> {
                // Ripristina l'immagine originale
                imageView.setImage(new Image("assets/images.menu/" + imageView.getId() + "Off.png"));
                // Effetto di dissolvenza in entrata
                fadeInImage(imageView);
            });
            // Ripristina il cursore predefinito quando il mouse esce dall'immagine
            imageView.getParent().setCursor(Cursor.DEFAULT);
        });
    }

    private void fadeInImage(ImageView imageView) {
        // Effetto di dissolvenza in entrata
        FadeTransition fadeIn = new FadeTransition(Duration.millis(200), imageView);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.setCycleCount(1);
        fadeIn.setAutoReverse(false);
        fadeIn.play();
    }

    private void fadeOutImage(ImageView imageView, Runnable onFinish) {
        // Effetto di dissolvenza in uscita
        FadeTransition fadeOut = new FadeTransition(Duration.millis(200), imageView);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setCycleCount(1);
        fadeOut.setAutoReverse(false);
        fadeOut.setOnFinished(event -> {
            // Esegui il codice quando l'effetto di dissolvenza è completo
            onFinish.run();
            // Effetto di dissolvenza in entrata
            fadeInImage(imageView);
        });
        fadeOut.play();
    }
    
	public void newGame(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/scene/newGame.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    	
	}
	
	@FXML
	private void handleNewGameClick() {
	    // Chiamata al metodo newGame quando si clicca sull'immagine "New Game"
	    newGame.setOnMouseClicked(event -> {
	        try {
	            newGame(event);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    });
	}


}
