package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	String turn1="x";
	String turn2;
	public  void createBoard() {
		
		char[] board = new char[10];
      
		for(int i=0;i<10;i++) {
			board[i]=' ';
		}
	}

	public void allowPlayer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the letter X or O");
		String letter=sc.next();
		
		if(turn1.equals(letter)) {
			turn2="o";
		}else {
			turn2="x";
		}
		System.out.println(turn1);
		System.out.println(turn2);
	
	}
	public static void main(String[] args) {
		TicTacToeGame tictactoe=new TicTacToeGame();
		tictactoe.createBoard();
		tictactoe.allowPlayer();
	}

}
