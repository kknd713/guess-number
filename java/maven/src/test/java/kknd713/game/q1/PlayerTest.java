package kknd713.game.q1;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.PrintStream;

import kknd713.game.q1.entity.Player;
import kknd713.game.q1.util.FightUtils;

import org.junit.Test;

public class PlayerTest {
	@Test
	public void testAttack(){
		PrintStream out = mock(PrintStream.class);
		Player p1 = new Player("Jack", 10, 100);
		Player p2 = new Player("Rose", 10, 100);
		
		new FightUtils(out).fight(p1, p2);
		
		verify(out).println("Rose被打败了!");
		
	}
}
