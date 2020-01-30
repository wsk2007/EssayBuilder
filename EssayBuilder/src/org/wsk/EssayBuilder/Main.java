package org.wsk.EssayBuilder;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Download d = new Download();
		
		
			try {
			d.saveToFile("https://raw.githubusercontent.com/wsk2007/NonsenseForEssayBuilder/master/data.json", "data.json");
			
		}
			
			// TODO 自动生成的 catch 块
			catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		Json j = new Json();
		String[] s = {"famous" , "bosh" , "after" , "before"};
		ArrayList<ArrayList<String>> al = j.getdata("data.json", s);
		Builder b = new Builder(al.get(0),al.get(1),al.get(3),al.get(2));
		System.out.println(b.Build("好好学习", 5000));
		
		}


	

}
