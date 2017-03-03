package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import Service.GameRule;
import dao.CityDaoImpl;

public class Main {
	
	
	public static void main(String[] args)  throws IOException {
		GameRule rule = new GameRule();
		CityDaoImpl dao= new CityDaoImpl();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dao.fillcityList("resources/cities_RF.txt"); 
       dao.fillIndexCatalog();
        
        System.out.print("Ваш первый ход! \nМожно использовать названия городов России \n");
        String ss = br.readLine();
       
                
        while(rule.getTrueCity(ss)) {
            System.out.println(rule.getAnswer(ss));
            System.out.println("Ваш город?");
           ss = br.readLine();
        } // end while     
    } // end main
    

}
