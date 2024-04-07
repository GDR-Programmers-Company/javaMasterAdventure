package javaMasterAdventure;

import com.asciiArt.asciiArt;
import com.dungenons.*;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;



public class Main extends Application { 


    public static void main(String[] args) {
        launch(args);

    	//asciiArt.stampaTitolo();
    	//laGrottaOscura.esegui();
    }
    
    // Metodo start richiamato quando l'applicazione JavaFX viene avviata
    
    @Override
    public void start(Stage primaryStage) {

    	try {
    	   // Creazione del contenitore radice per la scena
						
            
            Parent root = FXMLLoader.load(getClass().getResource("/com/scene/homeMenu.fxml"));
            
            Scene scene = new Scene(root);
            Image icon = new Image("assets/icon.png");
            primaryStage.getIcons().add(icon);
            primaryStage.setHeight(768);
            primaryStage.setWidth(1366);
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(false);

            // Configurazione della finestra
            primaryStage.setScene(scene);
            primaryStage.setTitle("JavaMasterAdventure Console");
            primaryStage.show();


    	}
    	catch(Exception e) {
    	    e.printStackTrace();
    	}

        

    }


}
