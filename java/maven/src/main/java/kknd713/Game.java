package kknd713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private PrintStream out;
	private BufferedReader in;
	private AnswerGenerator answerGenerator;
	private CompareNumber compareNumber;
	
	
	public PrintStream getOut() {
		return out;
	}

	public void setOut(PrintStream out) {
		this.out = out;
	}

	public BufferedReader getIn() {
		return in;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

	public AnswerGenerator getAnswerGenerator() {
		return answerGenerator;
	}

	public void setAnswerGenerator(AnswerGenerator answerGenerator) {
		this.answerGenerator = answerGenerator;
	}

	public CompareNumber getCompareNumber() {
		return compareNumber;
	}

	public void setCompareNumber(CompareNumber compareNumber) {
		this.compareNumber = compareNumber;
	}

	public Game(PrintStream out, BufferedReader in, AnswerGenerator answerGenerator, CompareNumber compareNumber) {
		this.out = out;
		this.in = in;
		this.answerGenerator = answerGenerator;
		this.compareNumber = compareNumber;
	}

	public void start() throws IOException{
		String answer = answerGenerator.generate();
		out.println("Welcome!");
		for (int i = 6; i > 0; i--) {
			out.printf("\nplease input your number(%d):",i);
			String input = in.readLine();
			String result = compareNumber.compare(answer, input);
			if ("4A0B".equals(result)) {
				out.println("\nCongratulations!");
				//out.println("\nCongratulations!" + result);
				return;
			}
			out.println(result);
		}
		out.println("Game Over!");
		//out.println("Game Over!Answer:" + answer);
		
	}
	
//	public static void main(String[] args) {
//		new Game().start();
//	}
}
