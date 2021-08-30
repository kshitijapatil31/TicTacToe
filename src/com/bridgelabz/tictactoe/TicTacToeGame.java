package com.bridgelabz.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	String user="x";
	String computer="o";
	char[] board = new char[10];
    char letter;
    Scanner sc=new Scanner(System.in);
	
	
	public  void createBoard() {
		for(int i=0;i<10;i++) {
			board[i]=(char) i;
		}
	}

	public void allowPlayer() {
		
		System.out.println("Enter the letter X or O");
		letter=sc.next().charAt(0);
		
		if(user.equals(letter)) {
			user="x";
		}else {
			computer="o";
		}
		System.out.println(user);
		System.out.println(computer);
	
	}
	
	
	public void movePlayer(String whoseturn) {
		System.out.println("make a move between 1 to 9 :");
		int move=sc.nextInt();
		while(true) {
		if(!(move>0&&move<=9)) {
			System.out.println("you have enter wrong number");
		}if(isFree(move)){
			assignPosition(move);
		}
	
		}
		
		
	}
	void assignPosition(int move){
		board[move]=letter;
	}
	
	public  boolean isFree(int index) {
		if(board[index]=='*') {
			return true;
		}else {
			return false;
		}
	}
	public void toss() {
		
		Random random=new Random();
		int toss=random.nextInt(2);
		if(toss==1) {
			System.out.println("user Win toss");
			movePlayer(user);
		}else {
			System.out.println("computer Win toss");
			movePlayer(computer);
		}
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
		tictactoe.printBoard();
		tictactoe.allowPlayer();
		tictactoe.toss();
	}

}
