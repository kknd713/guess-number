package kknd713.game.q4.entity.debuff;

import kknd713.game.q4.entity.Sprite;

public abstract class Debuff {
	//持续回合数
	private int count;
	
	
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	/**
	 * 效果叠加的方法
	 */
	public abstract void accumulate(Debuff debuff);

	/**
	 * 触发debuff
	 * @return 是否能攻击
	 */
	public abstract boolean handle(Sprite self) ;
}
