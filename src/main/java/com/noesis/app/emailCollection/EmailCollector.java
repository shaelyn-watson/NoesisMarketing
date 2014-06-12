package com.noesis.app.emailCollection;

import java.util.List;

import com.noesis.app.Utils;

public class EmailCollector {
	
	public EmailCollector() {
		
	}
	
	public static void main(String args[]){
		EmailCollector ec = new EmailCollector();
		ec.collect();
		
	}
	
	public void collect(){
		try {
			String pdfContent = Utils.pullPDFTextFromURL("http://www.kcpl.com/~/media/Files/Save%20Energy%20and%20Money/Missourirenewableresourcedirectory.pdf");
			//System.out.println("pdf = " + pdfContent);
			List<String> emailList = Utils.pullEmailAddressesFromString(pdfContent);
			System.out.println("EMAILS: \n");
			for (String email : emailList){
				System.out.println(email);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
