package kknd713;

import java.util.ArrayList;
import java.util.List;

public class CompareNumber {
	public String compare(String answer, String input){
		int countA = 0;
		int countB = 0;
		for (int i = 0; i < input.length(); i++) {
			String target = input.charAt(i) + "";
			if (answer.contains(target)) {
				countB ++;
			}
			
			if (answer.charAt(i) == input.charAt(i)) {
				countA ++;
				countB --;
			}
		}
		return countA + "A" + countB + "B";
	}
	
}
