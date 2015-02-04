package kknd713;

import static junit.framework.Assert.assertEquals;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.*;

import org.junit.Test;


public class AnswerGeneratorTest {
	
	@Test
	/**
	 * 测试不连续的三次调用允许出现重复的
	 */
	public void isRepeat(){
		Random rand = mock(Random.class);
		given(rand.nextInt(10))
			.willReturn(1,2,3,4)
			.willReturn(2,3,4,5)
			.willReturn(3,4,5,6)
			.willReturn(1,2,3,4);
		
		AnswerGenerator ag = new AnswerGenerator(rand);
		List<String> set = new ArrayList<String>();
		set.add(ag.generate());
		set.add(ag.generate());
		set.add(ag.generate());
		set.add(ag.generate());
		assertThat(set.size()).isEqualTo(4);
	}
	
	@Test
	/**
	 * 测试连续3次调用不允许重复
	 */
	public void isRepeat3Times(){
		Random rand = mock(Random.class);
		given(rand.nextInt(10))
			.willReturn(1,2,3,4)
			.willReturn(1,2,3,4)
			.willReturn(2,3,4,5)
			.willReturn(3,4,5,6);
		
		AnswerGenerator ag = new AnswerGenerator(rand);
		Set<String> set = new HashSet<String>();
		set.add(ag.generate());
		set.add(ag.generate());
		set.add(ag.generate());
		assertThat(set.size()).isEqualTo(3);
	}
	
	@Test
	public void isNumber() {
		AnswerGenerator ag = new AnswerGenerator(new Random());
		String str = ag.generate();
		boolean isNumber = true;
		try {
			Integer.parseInt(str);
		} catch (Exception e) {
			isNumber = false;
		}
		assertEquals(isNumber, true);
	}
	
	@Test
	public void isFourDig() {
		AnswerGenerator ag = new AnswerGenerator(new Random());
		String str = ag.generate();
		assertThat(str.length()).isEqualTo(4);
	}
	
	
}


//函数式编程

//dsl
