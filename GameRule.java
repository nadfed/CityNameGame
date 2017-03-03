package Service;
import domain.IndexCity;
import java.io.IOException;
import java.util.ArrayList;

import dao.CityDaoImpl;
import domain.City;
public class GameRule {
	public static CityDaoImpl dao= new CityDaoImpl();
	
    public static String getAnswer(String quest) {
       /* int beginIndexCity = 0, endIndexCity = 1;
        String answer = "F";
        final char  tempChar = quest.toUpperCase().charAt(quest.length() -1);
        
        for(IndexCity indG: CityDaoImpl.catalog) {
            if(indG.getwordLetter() == tempChar) {
                beginIndexCity = indG.getBeginIndex();
                endIndexCity = indG.getEndIndex();
                break;
            } 
        } 
        
        for(int i = beginIndexCity; i < endIndexCity +1; i++) {
            if(!CityDaoImpl.cityList.get(i).getUsed()) {
                answer = CityDaoImpl.cityList.get(i).getTitle();
                CityDaoImpl.cityList.get(i).setUsed();    // компьютер использовал название города
                 break;
            } 
        } 
        
        return answer;*/
    	int beginIndexCity = 0, endIndexCity = 1;
        String answer; 
        char  tempChar = quest.toUpperCase().charAt(quest.length() -1);
        
        // если последний символ "Ь" или "Ы", берем предпоследний
        if((tempChar == 'Ь')||(tempChar =='Ы')){
             tempChar = quest.toUpperCase().charAt(quest.length() - 2);
        } // end if
        if(tempChar =='Й'){
        	tempChar = 'И';	
        }
        
        for(IndexCity indG: CityDaoImpl.catalog) {
            if(indG.getwordLetter() == tempChar) {
                beginIndexCity = indG.getBeginIndex();
                endIndexCity = indG.getEndIndex();
                break;
            } // end if
        } // end for
        
        for(int i = beginIndexCity; i < endIndexCity +1; i++) {
            if(!CityDaoImpl.cityList.get(i).getUsed()) {
                answer = CityDaoImpl.cityList.get(i).getTitle();
                CityDaoImpl.cityList.get(i).setUsed();    // компьютер использовал название города
                return answer;
            } //  end if
        } // end for
        
        answer = "End: все названия городов, на заданную букву, использованны"; 
        return answer;
    }
    
    
    public static boolean getTrueCity(String questGr) {
        int beginIndexCity = 0, endIndexCity = 1;
        boolean answer = false;
        final char  tempChar;
        
        questGr = questGr.toUpperCase();   
        tempChar = questGr.charAt(0);   // первая буква названия города
        questGr = questGr.replace('й', 'и');
        questGr = questGr.replace('ё', 'е');
        
        for(IndexCity indG: CityDaoImpl.catalog) {
            if(indG.getwordLetter() == tempChar) {
                beginIndexCity = indG.getBeginIndex();
                endIndexCity = indG.getEndIndex();
                break;
            } 
        } 
        
        for(int i = beginIndexCity; i < endIndexCity +1; i++) {
            if((!CityDaoImpl.cityList.get(i).getUsed()) && (CityDaoImpl.cityList.get(i).getTitle().compareTo(questGr) == 0)) {
                answer = true;
                CityDaoImpl.cityList.get(i).setUsed();
                // далее этот город не учавствует в игре
                 break;
            } 
        } 
        
      if(!answer) {
          System.out.println("Такого города нет в России (города крыма не учитываются), либо он уже использован ранее");  
         }        
        
        return answer;
    } 
}
