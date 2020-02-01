package org.wsk.EssayBuilder;

import java.io.BufferedReader;


import java.io.FileInputStream;


import java.util.logging.*;

import java.io.InputStreamReader;
import java.util.ArrayList;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@author(value = "wsk")
public class Json {
	private Logger log = Logger.getLogger(this.getClass().getName());
	public ArrayList<ArrayList<String>> getdata(String path, String[] key) {
		JSONObject jo = null;
		String str = readFile(path);
		try {
			jo = JSONObject.fromObject(str);
		}catch(Exception e) {
			log.log(Level.SEVERE, e.toString());
			
		}
		
		ArrayList<ArrayList<String>>  al = new ArrayList<ArrayList<String>>();
		for(int k = 0; k < key.length ; k++) {
			al.add(new ArrayList<String>());
		}



		
		
		JSONArray ja;
		int j = 0;
		

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
	public String readFile(String path) {
		StringBuilder sb = new StringBuilder();
		try {

                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));

              String s = null;

             

               while((s = reader.readLine()) != null){

               sb.append(s);

               }

		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			log.log(Level.SEVERE, e.toString());
			
			
		}
		
		
		return sb.toString();
	}

}
