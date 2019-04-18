package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {
	
	private String alienWord;
	private List<String> translations;
	
	
	public WordEnhanced(String alienWord, List<String> translations) {
		this.alienWord = alienWord;
		this.translations = translations;
	}
	
	


	public List<String> getTranslations() {
		return translations;
	}




	public void setTranslations(List<String> translations) {
		this.translations = translations;
	}




	public String getAlienWord() {
		return alienWord;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	
	
}