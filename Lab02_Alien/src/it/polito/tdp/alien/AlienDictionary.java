package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private List<WordEnhanced> dizionario;
	
	public AlienDictionary() {
		dizionario = new LinkedList<WordEnhanced>();
	}
	
	public void addWord(String alienWord, List<String> translations) {
		alienWord = alienWord.toLowerCase();
		for(String s : translations)
			s = s.toLowerCase();
		for(WordEnhanced we : dizionario) {
			if(we.getAlienWord().equals(alienWord)) {
				we.setTranslations(translations);
				return;
			}
		}
		WordEnhanced we = new WordEnhanced(alienWord, translations);
		dizionario.add(we);
	}
	
	public List<String> translateWord(String alienWord) {
		alienWord = alienWord.toLowerCase();
		for(WordEnhanced we : dizionario) {
			if(we.getAlienWord().equals(alienWord))
				return we.getTranslations();
		}
		
		return null;
	}
	
	
	public void clearDictionary() {
		dizionario.clear();
	}

}
