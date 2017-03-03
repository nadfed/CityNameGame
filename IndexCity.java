package domain;

public class IndexCity {
	private final char wordLetter;
    private final int beginIndex;
    private int endIndex;
    
    public IndexCity(char wordLetterCity, int beginIndexCity) {
        wordLetter = wordLetterCity;
        beginIndex = beginIndexCity;
       
    } 
    
    public char getwordLetter() { 
        return wordLetter;
    }      
    public int getBeginIndex() { 
        return beginIndex;
    }  
    
    public int getEndIndex() { 
        return endIndex;
    }  
    
    public void setEndIndex(int endIndexCity) { 
         endIndex = endIndexCity;
    } 
}
