package kknd713;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnswerGenerator {
	private int getRand(int min, int max){
		return (int)(Math.random() * (max - min + 1) + min);
	}
	
	private int[] getRand(int min, int max, int count){
		int[] arr = new int[count];
		int currIndex = 0;
		boolean isRepeated;
		while(true){
			isRepeated = false;
			int num = getRand(min,max);
			for (int i = 0; i < currIndex; i++) {
				if (arr[i] == num) {
					isRepeated = true;
					break;
				}
			}
			if (!isRepeated) {
				arr[currIndex++] = num;
			}
			if (currIndex >= count) {
				break;
			}
		}
		return arr;
	}
	
	public String generate(){
		//String str = Arrays.toString(getRand(0,9,4));
		//return str.replaceAll(",", "").replaceAll("\\[", "").replaceAll("\\]", "");
	
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		Collections.shuffle(list);
		
		String str = "";
		for (int i = 0; i < 4; i++) {
			str = str.concat(list.get(i) + "");
		}
		return str;
	}
	
	public static void main(String[] args) {
		System.out.println(new AnswerGenerator().generate());;
	}
}
