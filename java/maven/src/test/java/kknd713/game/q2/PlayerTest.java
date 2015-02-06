package kknd713.game.q2;

import java.io.PrintStream;

import kknd713.game.q2.entity.Player;
import kknd713.game.q2.util.FightUtils;
import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InOrder;

public class PlayerTest {
	@Test
	public void testAttack(){

		PrintStream out = mock(PrintStream.class);
		
		Player p1 = new Player("张三", 3, 10);
		Player p2 = new Player("李四", 4, 10);
		
		new FightUtils(out).fight(p1, p2);
		
		InOrder order = inOrder(out);
		
		order.verify(out).printf("%s攻击了%s,造成了%d点伤害,%s剩余生命:%d", 
				"张三","李四",3,"李四",7);
		order.verify(out).printf("%s攻击了%s,造成了%d点伤害,%s剩余生命:%d", 
				"李四","张三",4,"张三",6);
		
		order.verify(out).printf("%s攻击了%s,造成了%d点伤害,%s剩余生命:%d", 
				"张三","李四",3,"李四",4);
		order.verify(out).printf("%s攻击了%s,造成了%d点伤害,%s剩余生命:%d", 
				"李四","张三",4,"张三",2);
		
		order.verify(out).printf("%s攻击了%s,造成了%d点伤害,%s剩余生命:%d", 
				"张三","李四",3,"李四",1);
		order.verify(out).printf("%s攻击了%s,造成了%d点伤害,%s剩余生命:%d", 
				"李四","张三",4,"张三",0);
		order.verify(out).println("张三被打败了!");
		
		order.verify(out,never()).printf("%s攻击了%s,造成了%d点伤害,%s剩余生命:%d", 
				"张三","李四",3,"李四",0);
		order.verify(out,never()).println("李四被打败了!");
		order.verify(out,never()).println("张三被打败了!");
		
		/*
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
		*/
	}
}
