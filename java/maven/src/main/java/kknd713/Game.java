package kknd713;

import java.util.Scanner;

public class Game {
	public void start(){
		CompareNumber cn = new CompareNumber();
		AnswerGenerator ag = new AnswerGenerator();
		Scanner in = new Scanner(System.in);
		//���ɴ�
		String answer = ag.generate();
		System.out.println("Welcome:" + answer);
		for (int i = 6; i > 0; i--) {
			System.out.printf("\nplease input your number(%d):",i);
			String input = in.nextLine();
			//�Ƚ�
			String result = cn.compare(answer, input);
			//�ж�ʤ��
			if ("4A0B".equals(result)) {
				System.out.println("\nCongratulations!" + result);
				return;
			}
			System.out.println(result);
		}

		System.out.println("Game Over!Answer:" + answer);
	}
	
	public static void main(String[] args) {
		new Game().start();
	}
}
