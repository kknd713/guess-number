package kknd713;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class AnswerGenerator {
	private LinkedList<String> container = new LinkedList<String>();
	private Random rand;
	public AnswerGenerator(Random rand){
		this.rand = rand;
	}
	
	public String generate(){
		if (container.size() == 3) {
			container.removeFirst();
		}
		String str = generateOnce();
		while (container.contains(str)) {
			str = generateOnce();
		}
		container.add(str);
		return str;
	}
	
	private String generateOnce(){
		StringBuilder sb = new StringBuilder();
		while(sb.length() < 4){
			int num = rand.nextInt(10);
			if (sb.indexOf(num + "") == -1) {
				sb.append(num);
			}
		}
		return sb.toString();
	}
	
	@Deprecated
	private String generateByCollections() {
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
	
}
