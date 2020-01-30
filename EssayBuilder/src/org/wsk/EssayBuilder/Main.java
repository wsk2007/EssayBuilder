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
		
		for(ArrayList<String> a : al) {
			System.out.println("-------------------------");
			for(String str : a) {
				System.out.println(str);
			}
		}


	

}
}