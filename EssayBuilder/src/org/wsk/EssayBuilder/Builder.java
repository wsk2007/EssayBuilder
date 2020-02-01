package org.wsk.EssayBuilder;

import java.security.SecureRandom;
import java.util.ArrayList;
@author(value = "wsk")
public class Builder {
	SecureRandom sr = new SecureRandom();
	ArrayList<String> famous;
	ArrayList<String> bosh;
	ArrayList<String> before;
	ArrayList<String> after;
	public Builder(ArrayList<String> famous,ArrayList<String> bosh,ArrayList<String> before,ArrayList<String> after) {
		this.famous = famous;
		this.bosh = bosh;
		this.before = before;
		this.after = after;
		
	}
	
	public String buildRandom(String theme, int length) {
		StringBuilder sb = new StringBuilder();
		int num;
		sb.append("    ");
		while(sb.length() < length) {
			num = sr.nextInt(100);
			if(num < 5) {
				sb.append("\r\n");
				sb.append("    ");
			}
			if(num < 30) {
				sb.append(randomChoice(famous).replace("a", randomChoice(before)).replace("b", randomChoice(after)));
						
				num = sr.nextInt(100);
				if(num < 50) {
					sb.append("\r\n");
					sb.append("    ");
				}
			
				
			}
			if(num < 100) {
				sb.append(randomChoice(bosh).replaceAll("x", theme));
				
			}
		}
		return sb.toString();
	}
	
	public <T> T randomChoice(ArrayList<T> data) {
		return data.get(sr.nextInt(data.size()));
	}

}
