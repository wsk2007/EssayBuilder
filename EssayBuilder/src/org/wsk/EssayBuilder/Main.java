package org.wsk.EssayBuilder;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class Main {

	public static void main(String[] args) {
		Download d = new Download();
		try {
			d.saveToFile("https://raw.githubusercontent.com/wsk2007/NonsenseForEssayBuilder/master/data.json", "C:\\AppData\\Roaming\\EssayBuilder\\data.json");
		}
			
			// TODO 自动生成的 catch 块
			catch(Exception e) {
			e.printStackTrace();
		}


	

}
}