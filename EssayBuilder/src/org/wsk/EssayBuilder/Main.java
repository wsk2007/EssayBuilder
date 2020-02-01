package org.wsk.EssayBuilder;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
@author(value = "wsk")
public class Main {
	private static Logger log = Logger.getLogger("org.wsk.EssayBuilder.Main");

	public static void main(String[] args) {
		Download d = new Download();
		
		
			try {
			d.saveToFile("https://raw.githubusercontent.com/wsk2007/NonsenseForEssayBuilder/master/data.json", "data.json");
			
		}
			
			
			catch(Exception e) {
				log.log(Level.WARNING, e.getMessage());
			
		}
		
		
		Json j = new Json();
		String[] s = {"famous" , "bosh" , "after" , "before"};
		ArrayList<ArrayList<String>> al = j.getdata("data.json", s);
		Builder b = new Builder(al.get(0),al.get(1),al.get(3),al.get(2));
		System.out.println(b.buildRandom("ºÃºÃÑ§Ï°", 5000));
		
		}


	

}
