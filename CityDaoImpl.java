package dao;

import domain.IndexCity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import domain.City;

public class CityDaoImpl {
	 public  static ArrayList<City> cityList = new ArrayList<>();  
	    public static ArrayList<IndexCity> catalog = new ArrayList<>();   
	  
	    public static  void fillcityList(String fileName) {
	        String S = null;
	        
	         try(BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
	            while ((S = reader.readLine()) != null) {
	                cityList.add(new City(S));
	            }  
	        }  
	        catch (IOException e) {
	            System.out.println(e);
	        } 
	      // return cityList;
	    } 
	    

	    public  static void fillIndexCatalog() {
	        char tempWordLetter = '@';  // UTF-8, ANSI Windows. 'Ь' -> начальный индекс 'А'
	        int i = 0;
	        int j = 0;
	        for(City gg: cityList){
	            if(gg.getFirstCharTitle() != tempWordLetter) {
	                i = cityList.indexOf(gg);                                
	                catalog.add( new IndexCity(gg.getFirstCharTitle(), i));;  
	                tempWordLetter = gg.getFirstCharTitle();
	                j++;
	            } 
	         } 
	        
	       for(i=0; i < catalog.size() -2; i++) {
	    	   catalog.get(i).setEndIndex(catalog.get(i + 1).getBeginIndex() - 1);                
	       } 
	       catalog.get(catalog.size() - 1).setEndIndex(cityList.size() - 1);        
	    } 
	      
	    
}
