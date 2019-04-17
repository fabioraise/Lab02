package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private List<Word> dizionario;
	
	public AlienDictionary() {
		dizionario = new LinkedList<Word>();
	}
	
	public void addWord(String alienWord, String translation) {
		alienWord = alienWord.toLowerCase();
		translation = translation.toLowerCase();
		for(Word w : dizionario) {
			if(w.getAlienWord().equals(alienWord)) {
				w.setTranslation(translation);
				return;
			}
		}
		Word w = new Word(alienWord, translation);
		dizionario.add(w);
	}
	
	public String translateWord(String alienWord) {
		alienWord = alienWord.toLowerCase();
		for(Word w : dizionario) {
			if(w.getAlienWord().equals(alienWord))
				return w.getTranslation();
		}
		
		return null;
	}
	
	
	public void clearDictionary() {
		dizionario.clear();
	}

}
