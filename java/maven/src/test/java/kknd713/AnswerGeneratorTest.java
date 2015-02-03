package kknd713;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class AnswerGeneratorTest {
	@Test
	public void doTest() {
		AnswerGenerator ag = new AnswerGenerator();
		
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < 1000; i++) {
			set.add(ag.generate());
		}
		System.out.println(set.size());
	}
}
