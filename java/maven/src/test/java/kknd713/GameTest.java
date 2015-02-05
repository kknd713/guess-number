package kknd713;

import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

public class GameTest {
	private PrintStream out;
	private Game game;
	private AnswerGenerator answerGenerator;
	private CompareNumber compareNumber;
	private BufferedReader in;

	@Before
	public void init() throws IOException {
		out = mock(PrintStream.class);
		answerGenerator = mock(AnswerGenerator.class);
		in = mock(BufferedReader.class);
		compareNumber = new CompareNumber();
		game = new Game(out,in,answerGenerator,compareNumber);
		
		given(answerGenerator.generate()).willReturn("1234");
		given(in.readLine()).willReturn("4321");
	}
	
	@Test
	public void testWelcome(){
		verify(out,never()).println("Welcome!");
		try {
			game.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		verify(out).println("Welcome!");
	}
	
	@Test
	public void testSecondLineInputNumber(){
		try {
			game.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		InOrder order= inOrder(out);
		order.verify(out).println("Welcome!");
		order.verify(out).printf("\nplease input your number(%d):",6);
	}
	
	@Test
	public void testPrintResultWhenAnswerIsWrong() throws IOException{
		game.start();
		InOrder order = inOrder(out);
		order.verify(out).println("Welcome!");
		order.verify(out).printf("\nplease input your number(%d):",6);
		order.verify(out).println("0A4B");
	}
	
	@Test
	public void testReduceChangeWhenAnswerIsWrong() throws IOException{
		game.start();
		InOrder order = inOrder(out);
		order.verify(out).println("Welcome!");
		order.verify(out).printf("\nplease input your number(%d):",6);
		order.verify(out).println("0A4B");
		order.verify(out).printf("\nplease input your number(%d):",5);
	}
	
	
	@Test
	public void testLostWhenNoChange() throws IOException{
		game.start();
		InOrder order = inOrder(out);
		order.verify(out).println("Welcome!");
		order.verify(out).printf("\nplease input your number(%d):",6);
		order.verify(out).println("0A4B");
		order.verify(out).printf("\nplease input your number(%d):",5);
		order.verify(out).println("0A4B");
		order.verify(out).printf("\nplease input your number(%d):",4);
		order.verify(out).println("0A4B");
		order.verify(out).printf("\nplease input your number(%d):",3);
		order.verify(out).println("0A4B");
		order.verify(out).printf("\nplease input your number(%d):",2);
		order.verify(out).println("0A4B");
		order.verify(out).printf("\nplease input your number(%d):",1);
		order.verify(out).println("Game Over!");
		order.verify(out,never()).println("0A4B");
	}
	
	
	@Test
	public void testResultWhenAnswerIsRightFirst() throws IOException{
		given(in.readLine()).willReturn("1234");
		game.start();
		InOrder order = inOrder(out);
		order.verify(out).println("Welcome!");
		order.verify(out).printf("\nplease input your number(%d):",6);
		order.verify(out).println("\nCongratulations!");
		order.verify(out,never()).println("4A0B");
		order.verify(out,never()).printf("\nplease input your number(%d):",5);
	}
	
	@Test
	public void testResultWhenAnswerIsRight() throws IOException{
		given(in.readLine()).willReturn("4321","1234");
		game.start();
		InOrder order = inOrder(out);
		order.verify(out).println("Welcome!");
		order.verify(out).printf("\nplease input your number(%d):",6);
		order.verify(out).println("0A4B");
		order.verify(out).printf("\nplease input your number(%d):",5);
		order.verify(out).println("\nCongratulations!");
		order.verify(out,never()).println("4A0B");
		order.verify(out,never()).printf("\nplease input your number(%d):",5);
	
	}
	
}
