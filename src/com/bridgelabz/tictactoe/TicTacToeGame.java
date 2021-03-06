package com.bridgelabz.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

	char symbol = 'x';
	char[] board = new char[10];
	char letter;
	Scanner sc = new Scanner(System.in);

	public void createBoard() {
		for (int i = 0; i < board.length; i++) {
			board[i] = '*';
		}
	}

	public char symbol() {
		System.out.println("Enter the letter X or O");
		letter = sc.next().charAt(0);
		return letter;
	}

	public void allowPlayer(char userSelect) {

		if (symbol == userSelect) {
			userSelect = 'x';
		} else {
			userSelect = 'o';
		}

	}

	public void movePlayer(char userSelect) {
		System.out.println("make a move between 1 to 9 :");
		int move = sc.nextInt();

		if (!(move > 0 && move <= 9)) {
			System.out.println("you have enter wrong number");
		}
		if (isFree(move)) {
			assignPosition(move, userSelect);
		}
		
		computerMove();

	}

	public void computerMove() {
		System.out.println("computer turn");
		char computerSelect = symbol();
		System.out.println("make a move between 1 to 9 :");
		int move = sc.nextInt();

		if (!(move > 0 && move <= 9)) {
			System.out.println("you have enter wrong number");
		}
		if (isFree(move)) {
			assignPosition(move, computerSelect);
		}
		
	}

	void assignPosition(int move, char userSelect) {
		if (checkWinner()) {
			System.out.println("win");
		} else {
			for (int i = 0; i < board.length; i++) {
				if (board[0] == '*') {
					board[0] = userSelect;
					return;
				} else if (board[2] == '*') {
					board[1] = userSelect;
					return;
				} else if (board[6] == '*') {
					board[6] = userSelect;
					return;
				} else if (board[8] == '*') {
					board[8] = userSelect;
					return;
				} else if (board[4] == '*') {
					board[4] = userSelect;
					return;
				} else {
					board[move] = userSelect;
				}
			}
		}

		printBoard();
	}

	public boolean isFree(int index) {
		if (board[index] == '*') {
			return true;
		} else {
			return false;
		}
	}

	public boolean toss() {

		Random random = new Random();
		int toss = random.nextInt(2);
		if (toss == 1) {
			System.out.println("user Win toss");
			return true;
		} else {
			System.out.println("computer Win toss");
			return false;
		}
	}

	public boolean checkWinner() {
		for (int i = 0; i < 8; i++) {

			if (board[0] == 'x' && board[1] == 'x' && board[2] == 'x'
					|| board[0] == 'o' && board[1] == 'o' && board[2] == 'o') {
				return true;
			} else if (board[3] == 'x' && board[4] == 'x' && board[5] == 'x'
					|| board[3] == 'o' && board[4] == 'o' && board[5] == 'o') {
				return true;
			} else if (board[6] == 'x' && board[7] == 'x' && board[8] == 'x'
					|| board[6] == 'o' && board[7] == 'o' && board[8] == 'o') {
				return true;

			} else if (board[0] == 'x' && board[3] == 'x' && board[6] == 'x'
					|| board[0] == 'o' && board[3] == 'o' && board[6] == 'o') {
				return true;
			} else if (board[1] == 'x' && board[4] == 'x' && board[7] == 'x'
					|| board[1] == 'o' && board[4] == 'o' && board[7] == 'o') {
				return true;
			} else if (board[2] == 'x' && board[5] == 'x' && board[8] == 'x'
					|| board[2] == 'o' && board[5] == 'o' && board[8] == 'o') {
				return true;
			} else if (board[0] == 'x' && board[4] == 'x' && board[8] == 'x'
					|| board[0] == 'o' && board[4] == 'o' && board[8] == 'o') {
				return true;
			} else if (board[2] == 'x' && board[4] == 'x' && board[6] == 'x'
					|| board[2] == 'o' && board[4] == 'o' && board[6] == 'o') {
				return true;
			}

		}
		return false;
	}

	public int checkOpponentWin(char userSelect) {
		for (int i = 0; i < board.length; i++) {
			if (checkwin(userSelect)) {
				return i;

			} else {
				board[i] = userSelect;
			}
		}
		return 0;
	}

	public boolean checkwin(char userSelect) {
		for (int i = 0; i < board.length; i++) {
			if (board[i] == '*') {
				board[i] = userSelect;

				if (checkWinner()) {
					movePlayer(userSelect);
					return true;
				}
			}
		}
		return false;
	}

	public void printBoard() {
		System.out.println("Tic Tac Toe Board");
		System.out.println(board[0] + "-----" + board[1] + "-----" + board[2]);
		System.out.println(board[4] + "-----" + board[5] + "-----" + board[6]);
		System.out.println(board[7] + "-----" + board[8] + "-----" + board[9]);
	}

	public static void main(String[] args) {
		TicTacToeGame tictactoe = new TicTacToeGame();
		
		String currentTurn="user";
		tictactoe.createBoard();
		tictactoe.printBoard();

//		char userSelect = tictactoe.symbol();
//		tictactoe.allowPlayer(userSelect);
		char userSelect = ' ';
		while (!tictactoe.checkWinner()) {
			if (tictactoe.toss()) {
				userSelect = tictactoe.symbol();
				tictactoe.allowPlayer(userSelect);
				tictactoe.movePlayer(userSelect);
				tictactoe.printBoard();
			} else {
				tictactoe.computerMove();
				tictactoe.printBoard();
				tictactoe.checkWinner();
			}
			System.out.println();
			if(tictactoe.checkWinner()==true) {
				System.out.println("The winner is: "+currentTurn);
			}
			tictactoe.checkwin(userSelect);
			System.out.println("want to play another game enter 1.Yes or 2.no");
		    Scanner sc=new Scanner(System.in);
		    String input=sc.next();
		if(input=="yes") {
			while (!tictactoe.checkWinner()) {
				if (tictactoe.toss()) {
					userSelect = tictactoe.symbol();
					tictactoe.allowPlayer(userSelect);
					tictactoe.movePlayer(userSelect);
					tictactoe.printBoard();
				} else {
					tictactoe.computerMove();
					tictactoe.printBoard();
					tictactoe.checkWinner();
				}
		}
			
		}else {
			System.out.println("exit");
		}
		
	}
	}

}
