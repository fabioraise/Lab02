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
	
	public List<WordEnhanced> translateWordWildcard(String alienWord) {
		alienWord = alienWord.replaceAll("\\?", ".").toLowerCase();
		List<WordEnhanced> foundAlienWords = new ArrayList<WordEnhanced>(); 
		
		int matchNumber = 0;
		
		// utilizzo le regex
		for(WordEnhanced we : dizionario) {
			if(we.matches(alienWord)) {
				foundAlienWords.add(we);
				++matchNumber;
			}
		}
		
		if(matchNumber != 0)
			return foundAlienWords;
		else
			return null;
	}
	
	public void clearDictionary() {
		dizionario.clear();
	}

}
