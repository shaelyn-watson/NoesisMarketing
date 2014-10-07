package com.formValidation.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	List<String> urlList = new ArrayList<String>();
    	urlList.add("https://www.noesisenergy.com/site/content/energy-efficient-lighting-explained-0?");
    	urlList.add("https://www.noesisenergy.com/site/content/energy-project-finance-cheat-sheet");
    	
    	
    	List<String> fieldList = new ArrayList<String>();
    	
    	for(String url : urlList){
    	 Document doc = Jsoup.connect(url).get();
         Elements inputs = doc.select("input");
         System.out.println("\n========\nForm url: " + url + "\n");
         
         for(Element input : inputs) {
        	 System.out.println(input.attr("name"));
             System.out.println(input.attr("ng-init"));
             
             fieldList.add(input.attr("name"));
             fieldList.add(input.attr("ng-init"));
             

             
         }
         
    	
         /*  How many fields are on the form?  */
         
    	
    	/*  Does the form include the Google Analytics fields?  */
         boolean analyticsQ = false;
         if(fieldList.contains("GASourceLatest__c") && fieldList.contains("GAMediumLatest__c") && fieldList.contains("GACampaignLatest__c")){
        	 analyticsQ = true;
         }
         System.out.println("\nDoes the form include the Google Analytics fields? " + analyticsQ);
    	
    	
    	/*  What is the value of the hidden 'source' field?  */
         
    	
    	/*  Is there an 'opt in' question on the form? What is the text of the opt in question?  */
         boolean optInQ = false;
         if(fieldList.contains("Landing_Page_Opt_In__c")){
        	 optInQ = true;
         }
         System.out.println("\nIs there an 'opt in' question on the form? " + optInQ);
         
         Elements otros = doc.select("p");
         for (Element p : otros){
        	 System.out.println(p.select("p[style=color:#FFFFFF]"));
         }
         
         
        // end loop over urls 
    	}
    	System.out.println( "\n======Form validation complete" );
    }
}
