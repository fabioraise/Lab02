package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	AlienDictionary dic = new AlienDictionary();
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	String contenuto = txtWord.getText();
    	if(contenuto.contains(" ")) {
    		String alienWord = contenuto.substring(0, contenuto.indexOf(" "));
    		String translation = contenuto.substring(contenuto.indexOf(" ")+1, contenuto.length());
    		dic.addWord(alienWord, translation);
    	}
    	else {
    		txtResult.clear();
    		if(dic.translateWord(contenuto) != null)
    			txtResult.appendText(dic.translateWord(contenuto));
    		else
    			txtResult.appendText(String.format("La parola '%s' non è presente nel dizionario\n", contenuto));
    	}
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	dic.clearDictionary();
    }
    
}
