package kknd713.game.q2;

import java.io.PrintStream;

import kknd713.game.q2.entity.Player;
import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class PlayerTest {
	@Test
	public void testAttack(){

		PrintStream out = mock(PrintStream.class);
		
		Player p1 = new Player("Jack", 8, 100, out);
		Player p2 = new Player("Rose", 10, 100, out);
		
		while(true){
			p1.attack(p2);
			if (p2.getHp() == 0) {
				verify(out).println(p2.getName()+"被打败了!");
				break;
			}else {
				verify(out).printf("%s攻击了%s,造成了%d点伤害,%s剩余生命:%d",
						p1.getName(),p2.getName(),p1.getAp(),p2.getName(),p2.getHp());
			}
			
			p2.attack(p1);
			if (p1.getHp() == 0) {
				verify(out).println(p1.getName()+"被打败了!");
				break;
			}else {
				verify(out).printf("%s攻击了%s,造成了%d点伤害,%s剩余生命:%d",
						p2.getName(),p1.getName(),p2.getAp(),p1.getName(),p1.getHp());
			}
		}
	}
}
