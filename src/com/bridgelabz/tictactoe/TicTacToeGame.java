package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	String user="x";
	String computer;
	char[] board = new char[10];
	public  void createBoard() {
		
		
      
		for(int i=0;i<10;i++) {
			board[i]='*';
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
	public void printBoard() {
		System.out.println("Tic Tac Toe Board");
		System.out.println(board[0]+"-----"+board[1]+"-----"+board[2]+"-----");
		System.out.println(board[4]+"-----"+board[5]+"-----"+board[6]+"-----");
		System.out.println(board[7]+"-----"+board[8]+"-----"+board[9]+"-----");
	}
	public static void main(String[] args) {
		TicTacToeGame tictactoe=new TicTacToeGame();
		tictactoe.createBoard();
		tictactoe.allowPlayer();
		tictactoe.printBoard();
	}

}
