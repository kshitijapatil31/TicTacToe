package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	String user="x";
	String computer;
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
		
		if(user.equals(letter)) {
			user="x";
		}else {
			computer="o";
		}
		System.out.println(user);
		System.out.println(computer);
	
	}
	public static void main(String[] args) {
		TicTacToeGame tictactoe=new TicTacToeGame();
		tictactoe.createBoard();
		tictactoe.allowPlayer();
	}

}
