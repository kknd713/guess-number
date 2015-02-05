package kknd713.game.q1;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.PrintStream;

import kknd713.game.q1.entity.Player;

import org.junit.Test;

public class PlayerTest {
	@Test
	public void testAttack(){
		PrintStream out = mock(PrintStream.class);
		Player p1 = new Player("Jack", 10, 100, out);
		Player p2 = new Player("Rose", 10, 100, out);
		
		while(true){
			p1.attack(p2);
			if (p2.getHp() == 0) {
				verify(out).println(p2.getName()+"被打败了!");
				break;
			}
		}
	}
}
