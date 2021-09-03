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
		while (true) {
			if (!(move > 0 && move <= 9)) {
				System.out.println("you have enter wrong number");
			}
			if (isFree(move)) {
				assignPosition(move, userSelect);
			}
			computerMove();
		}

	}
public void computerMove() {
	System.out.println("computer turn");
	char computerSelect=symbol();
	System.out.println("make a move between 1 to 9 :");
	int move = sc.nextInt();
	while (true) {
		if (!(move > 0 && move <= 9)) {
			System.out.println("you have enter wrong number");
		}
		if (isFree(move)) {
			assignPosition(move, computerSelect);
		}

	}
}
	void assignPosition(int move, char userSelect) {
		board[move] = userSelect;
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

	public void printBoard() {
		System.out.println("Tic Tac Toe Board");
		System.out.println(board[0] + "-----" + board[1] + "-----" + board[2] );
		System.out.println(board[4] + "-----" + board[5] + "-----" + board[6] );
		System.out.println(board[7] + "-----" + board[8] + "-----" + board[9] );
	}

	public static void main(String[] args) {
		TicTacToeGame tictactoe = new TicTacToeGame();
		tictactoe.createBoard();
		tictactoe.printBoard();

//		char userSelect = tictactoe.symbol();
//		tictactoe.allowPlayer(userSelect);
		if (tictactoe.toss()) {
			char userSelect = tictactoe.symbol();
			tictactoe.allowPlayer(userSelect);
			tictactoe.movePlayer(userSelect);
		}else {
			tictactoe.computerMove();
		}

	}

}
