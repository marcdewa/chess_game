package Main;

import java.util.Scanner;
import chess_games.BoardPrinter;
import chess_games.Game;

/* Maaf ko , saya baru sadar diakhir project kalok saya terbalik menggunakan 
 * maksud file dan rank , disini saya menggunakan 
 * 
 * File sebagai Row
 * Rank sebagai Column
 * 
 * Mohon dimengerti ya ko hehehe saya masih sangat awam dicatur soalnya,
 * dan sudah terlalu sulit untuk mengubah semuanya , karena
 * saya sadar pas semua function udah hampir jadi
 * Terima kasih ko.
 * */

public class Main {
	Scanner scan = new Scanner(System.in);
	Game game = new Game();
	BoardPrinter print = new BoardPrinter(game.board);
	
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
