package org.wsk.EssayBuilder;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Json {
	public ArrayList<ArrayList<String>> getdata(String path, String[] key) {
		File f = new File(path);
		String str = readFile(f);
		JSONObject jo = JSONObject.fromObject(str);
		ArrayList<ArrayList<String>>  al = new ArrayList<ArrayList<String>>();
		for(int k = 0; k < key.length ; k++) {
			al.add(new ArrayList<String>());
		}



		
		ArrayList<String> a;
		JSONArray ja;
		int j = 0;
		Iterator<String> it;

		for(ArrayList<String> a1 : al) {
			
			ja = jo.getJSONArray(key[j]);
			String str1;
			int p = 0;
			try {
				for(;;) {
					str1 = ja.getString(p);
					a1.add(str1);
					p++;
				
			    }
			}catch(Exception e) {
				
			}
			
			j++;
			
		}
		
		return al;

	}	
	public String readFile(File f) {
		StringBuilder sb = new StringBuilder();
		try {

                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("data.json"),"UTF-8"));

              String s = null;

             

               while((s = reader.readLine()) != null){

               sb.append(s);

               }

		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		return sb.toString();
	}

}
