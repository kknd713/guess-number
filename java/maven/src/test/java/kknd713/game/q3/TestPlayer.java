package kknd713.game.q3;

import static org.mockito.Mockito.*;

import java.io.PrintStream;

import kknd713.game.q3.entity.Player;
import kknd713.game.q3.entity.Warrior;
import kknd713.game.q3.entity.equip.Armor;
import kknd713.game.q3.entity.equip.Weapon;
import kknd713.game.q3.util.FightUtils;

import org.junit.Test;
import org.mockito.InOrder;

/**
 * 
	要有职业分为： 普通人和战士。
	攻击要输出职业+名字
	被攻击时也输出
	战士可以装备武器，武器有名字。所以要输出用武器攻击了对方。
	武器有额外的攻击力。
	战士和普通人可以互相攻击。
	战士可以装备防具
	普通人不可以装备防具或武器
	战士受到的伤害是对方的攻击力减去防御力.
	第二问的单行输出需求被废弃。
 * @author root
 *
 */
public class TestPlayer {
	
	/**
	 * 攻击要输出职业+名字
	 */
	@Test
	public void print_job_and_name_when_attack(){
		PrintStream out = mock(PrintStream.class);
		
		Weapon weapon = new Weapon(5, "青龙偃月刀");
		Armor armor = new Armor(2,"轻甲");
		
		Player p1 = new Player("张三",3,10);
		Warrior p2 = new Warrior("李四", 4, 10, weapon, armor);
		
		new FightUtils(out).fight(p1, p2);
		
		InOrder order = inOrder(out);
		
		order.verify(out).printf("%s%s%s攻击了%s%s,%s受到了%d点伤害,%s剩余生命:%d",
				"普通人","张三","","战士","李四","李四",1,"李四",9);
		order.verify(out).printf("%s%s%s攻击了%s%s,%s受到了%d点伤害,%s剩余生命:%d",
				"战士","李四","用青龙偃月刀","普通人","张三","张三",9,"张三",1);

		order.verify(out).printf("%s%s%s攻击了%s%s,%s受到了%d点伤害,%s剩余生命:%d",
				"普通人","张三","","战士","李四","李四",1,"李四",8);
		order.verify(out).printf("%s%s%s攻击了%s%s,%s受到了%d点伤害,%s剩余生命:%d",
				"战士","李四","用青龙偃月刀","普通人","张三","张三",9,"张三",0);

		order.verify(out).println("张三被打败了!");
		
		order.verify(out,never()).printf("%s%s%s攻击了%s%s,%s受到了%d点伤害,%s剩余生命:%d",
				"普通人","张三","","战士","李四","李四",1,"李四",7);
	}
}	
