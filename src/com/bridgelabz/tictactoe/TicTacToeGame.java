package com.bridgelabz.tictactoe;

public class TicTacToeGame {
	public  void createBoard() {
		char[] board = new char[10];
      String emptyBoard=board.toString();
		for(int i=0;i<10;i++) {
			board[i]=' ';
		}
	}

	public static void main(String[] args) {
		TicTacToeGame tictactoe=new TicTacToeGame();
		tictactoe.createBoard();
	}

}
