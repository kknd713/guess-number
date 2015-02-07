package kknd713.game.q4.entity.effect.impl;

import kknd713.game.q4.entity.Sprite;
import kknd713.game.q4.entity.debuff.Debuff;
import kknd713.game.q4.entity.effect.Effect;

/***
 * 带debuff的效果
 * @author root
 *
 */
public class DebuffEffect extends Effect{
	
	public DebuffEffect(Debuff debuff) {
		super(debuff, 0.25);
	}

	public int handle(Sprite self, Sprite other) {
		return 0;
	}

}
