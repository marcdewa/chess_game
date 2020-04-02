package chess_games;

import java.util.Scanner;
import chessEntities.*;

public class Main {
	Scanner scan = new Scanner(System.in);
	games game = new games();
	int flag ;
	public Main() {
		while (true) {
			String coor;
			algebraicOrCoordinate();
			try {
				flag = scan.nextInt();
			} catch (Exception e) {
				flag = 0;
			}scan.nextLine();
			switch (flag) {
			case 1:
				game.print();
				break;
			case 2:
				while(true) {
					game.print();
					System.out.println("white move: ");
					coor = scan.nextLine();
					game.coordinateMove(coor);
				}
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
