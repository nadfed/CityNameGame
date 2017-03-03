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
                CityDaoImpl.cityList.get(i).setUsed();    // ��������� ����������� �������� ������
                 break;
            } 
        } 
        
        return answer;*/
    	int beginIndexCity = 0, endIndexCity = 1;
        String answer; 
        char  tempChar = quest.toUpperCase().charAt(quest.length() -1);
        
        // ���� ��������� ������ "�" ��� "�", ����� �������������
        if((tempChar == '�')||(tempChar =='�')){
             tempChar = quest.toUpperCase().charAt(quest.length() - 2);
        } // end if
        if(tempChar =='�'){
        	tempChar = '�';	
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
                CityDaoImpl.cityList.get(i).setUsed();    // ��������� ����������� �������� ������
                return answer;
            } //  end if
        } // end for
        
        answer = "End: ��� �������� �������, �� �������� �����, �������������"; 
        return answer;
    }
    
    
    public static boolean getTrueCity(String questGr) {
        int beginIndexCity = 0, endIndexCity = 1;
        boolean answer = false;
        final char  tempChar;
        
        questGr = questGr.toUpperCase();   
        tempChar = questGr.charAt(0);   // ������ ����� �������� ������
        questGr = questGr.replace('�', '�');
        questGr = questGr.replace('�', '�');
        
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
                // ����� ���� ����� �� ���������� � ����
                 break;
            } 
        } 
        
      if(!answer) {
          System.out.println("������ ������ ��� � ������ (������ ����� �� �����������), ���� �� ��� ����������� �����");  
         }        
        
        return answer;
    } 
}
