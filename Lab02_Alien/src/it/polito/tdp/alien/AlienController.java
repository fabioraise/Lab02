package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.*;
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
    		
    		// memorizzo la parola aliena
    		String alienWord = contenuto.substring(0, contenuto.indexOf(" "));
    		contenuto = contenuto.substring(contenuto.indexOf(" ")+1, contenuto.length());
    		
    		// memorizzo in una lista tutte le possibili traduzioni fintanto che ci sono spazi nella stringa
    		List<String> translations = new ArrayList<String>();
    		while(contenuto.contains(" ")) {
    			translations.add(contenuto.substring(0, contenuto.indexOf(" ")));
    			contenuto = contenuto.substring(contenuto.indexOf(" ")+1, contenuto.length());
    		}
    		// aggiungo l'ultima parola la cui stringa è rimasta senza spazi
    		translations.add(contenuto.substring(0, contenuto.length()));
    		
    		// inserisco la parola nel dizionario
    		dic.addWord(alienWord, translations);
    		
    	}
    	else {
    		txtResult.clear();
    		if(contenuto .contains("?")) {
    			List<WordEnhanced> paroleAliene = dic.translateWordWildcard(contenuto);
    			if(paroleAliene != null) {
    				for(WordEnhanced we : paroleAliene) {
    					List<String> traduzioni = dic.translateWord(we.getAlienWord());
    	    			for(String w : traduzioni)
    	    				txtResult.appendText(w+"\n");
    				}
    			}
    		}
    		else if(dic.translateWord(contenuto) != null) {
    			List<String> traduzioni = dic.translateWord(contenuto);
    			for(String w : traduzioni)
    				txtResult.appendText(w+"\n");
    		}
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
