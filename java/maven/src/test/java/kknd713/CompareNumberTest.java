package kknd713;

import org.junit.Test;
import static junit.framework.Assert.*;

public class CompareNumberTest {
	
	@Test
	public void doAssert1(){
		CompareNumber comp = new CompareNumber();
		String ret = comp.compare("1234", "5678");
		assertEquals(ret, "0A0B");
	}
	
	@Test
	public void doAssert2(){
		CompareNumber comp = new CompareNumber();
		String ret = comp.compare("1234", "5167");
		assertEquals(ret, "0A1B");
	}
	
	@Test
	public void doAssert3(){
		CompareNumber comp = new CompareNumber();
		String ret = comp.compare("1234", "4356");
		assertEquals(ret, "0A2B");
	}
	
	@Test
	public void doAssert4(){
		CompareNumber comp = new CompareNumber();
		String ret = comp.compare("1234", "4326");
		assertEquals(ret, "0A3B");
	}
	
	@Test
	public void doAssert5(){
		CompareNumber comp = new CompareNumber();
		String ret = comp.compare("1234", "4321");
		assertEquals(ret, "0A4B");
	}
	
	
	@Test
	public void doAssert6(){
		CompareNumber comp = new CompareNumber();
		String ret = comp.compare("1234", "1567");
		assertEquals(ret, "1A0B");
	}
	
	@Test
	public void doAssert7(){
		CompareNumber comp = new CompareNumber();
		String ret = comp.compare("1234", "1456");
		assertEquals(ret, "1A1B");
	}
	
	@Test
	public void doAssert8(){
		CompareNumber comp = new CompareNumber();
		String ret = comp.compare("1234", "1325");
		assertEquals(ret, "1A2B");
	}
	
	@Test
	public void doAssert9(){
		CompareNumber comp = new CompareNumber();
		String ret = comp.compare("1234", "1423");
		assertEquals(ret, "1A3B");
	}
	
	@Test
	public void doAssert10(){
		CompareNumber comp = new CompareNumber();
		String ret = comp.compare("1234", "1256");
		assertEquals(ret, "2A0B");
	}
	
	@Test
	public void doAssert11(){
		CompareNumber comp = new CompareNumber();
		String ret = comp.compare("1234", "1245");
		assertEquals(ret, "2A1B");
	}
	
	@Test
	public void doAssert12(){
		CompareNumber comp = new CompareNumber();
		String ret = comp.compare("1234", "1432");//1223?
		assertEquals(ret, "2A2B");
	}
	
	@Test
	public void doAssert13(){
		CompareNumber comp = new CompareNumber();
		String ret = comp.compare("1234", "1235");
		assertEquals(ret, "3A0B");
	}
	
	
	@Test
	public void doAssert14(){
		CompareNumber comp = new CompareNumber();
		String ret = comp.compare("1234", "1234");
		assertEquals(ret, "4A0B");
	}
	
	
}
