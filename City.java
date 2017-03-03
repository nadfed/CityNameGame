package domain;

public class City {
	private final String title;
    private  char asLinkDw = '@';
    private boolean used = false;
    
    public City(String titl){
        
        title = titl.toUpperCase();
        asLinkDw = title.toUpperCase().charAt(title.length() - 1);   
        
        // если последний символ "Ь" или "Ы", берем предпоследний
        if((asLinkDw == 'Ь')||(asLinkDw =='Ы')){
             asLinkDw = title.toUpperCase().charAt(title.length() - 2);
        } 
        
    } 
 
    public char getFirstCharTitle() {
        return title.charAt(0);
    }  
    
    public String getTitle() {
        return title;
    }  
    
    public boolean getUsed(){
        return used;
    } 
    
    public void setUsed(){
         used = true;
    } 
   
     void resetUsed(){
         if(used)
            used = false;
    } 
} 
