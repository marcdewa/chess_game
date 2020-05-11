package Main;

import java.util.Scanner;
import chessEntities.*;
import chess_games.BoardPrinter;
import chess_games.Games;

public class Main {
	Scanner scan = new Scanner(System.in);
	Games game = new Games();
	BoardPrinter print = new BoardPrinter(game);
	
	int flag ;
	public Main() {
		while (true) {
			algebraicOrCoordinate();
			try {
				flag = scan.nextInt();
			} catch (Exception e) {
				flag = 0;
			}scan.nextLine();
			switch (flag) {
			case 1:
				print.print();
				break;
			case 2:
				game.startGame();
			default:
				break;
			}
		}
	}
	

	private void algebraicOrCoordinate() {
		System.out.println("1. Algebraic");
		System.out.println("2. Coordinate");
		System.out.println("Choose move notation [1-2]: ");

	}
	
	
	public static void main(String[] args) {
		new Main();

	}


}