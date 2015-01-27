package com.noesis.app.emailCollection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.noesis.app.Utils;

public class EmailCollector {
	
	public EmailCollector() {
		
	}
	
	public static void main(String args[]){
		EmailCollector ec = new EmailCollector();
		ec.collectPDF();
		//ec.collectHTML();
		//ec.jsonLinkSearch();
		//ec.collectTxt();
		
	}
	
	public void collectTxt(){
		String longStr;
		try {
			longStr = Utils.readTxtFile("web.txt");
			//System.out.println("longStr=\n" + longStr);
			List<String> emailList = Utils.pullEmailAddressesFromString(longStr);
			
			System.out.println("EMAILS: \n");
			for (String email : emailList){
				if(!isCanadian(email))
					System.out.println(email);
			}
			System.out.println("\nTxt file done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void collectPDF(){
		try {
			String pdfFile = "http://www.wrcog.cog.ca.us/uploads/media_items/hero-commercial-contractors.original.pdf";
			String pdfContent = Utils.pullPDFTextFromURL(pdfFile);
			//System.out.println("pdf = " + pdfContent);  //Sanity check
			List<String> emailList = Utils.pullEmailAddressesFromString(pdfContent);
			
			System.out.println("EMAILS: \n");
			for (String email : emailList){
				if(!isCanadian(email))
					System.out.println(email);
			}
			System.out.println("\nPDF done");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void collectHTML(){
		try{
			String url = "http://www.wasatchsolar.com/contractors.html";
			String htmlContent = Utils.readFromURL(url);
			System.out.println("web = " + htmlContent);  //Sanity check
			List<String> emailList = Utils.pullEmailAddressesFromString(htmlContent);
			
			System.out.println("EMAILS: \n");
			for (String email : emailList){
				if (!isCanadian(email))
					System.out.println(email.toLowerCase());
			}
			System.out.println("\nHTML done");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void jsonLinkSearch(){
		List<String> emailList = new ArrayList<String>();
		System.out.println("EMAILS: \n");
		
		String jsonFile = "kimonoData.json";
		List<String> links = Utils.jsonLinkExtractor(jsonFile);
		
	
		for (String url : links){
			try{
			//System.out.println(url);
			String htmlContent = Utils.readFromURL(url);
			System.out.println(Utils.pullUrlFromUrlString(htmlContent));
			//System.out.println(htmlContent);
			List<String> emails = Utils.pullEmailAddressesFromString(htmlContent);
			for (String email : emails){
				if (!emailList.contains(email) && !isCanadian(email))
					emailList.add(email);
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		//second iteration to remove duplicates
//		for (String email : emailList){
//			System.out.println(email);
//		}
		System.out.println("\nJSON done");
	}
	
	public boolean isCanadian(String email){
		if(email.endsWith(".ca")){
			return true;
		}
		return false;
	}

}
