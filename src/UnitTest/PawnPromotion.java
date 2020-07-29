package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Main.Game;
import Main.MoveCoordinate;
import Main.Pawn;
import Main.Player;

class PawnPromotion {

	@Test
	void correctMovementTest() throws Exception {
		Game game = new Game();	
		Player playerP = new Player('b');
		char player = playerP.getColor();
		int startPoint = 2;
		game.setNewPieceAt(startPoint,3,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("C2-C1Q",game);
		//game.print.print();
		assertTrue(game.move.movingPiece(playerP,mc,true),"pawn promotion only happen when the pawn reach the eight rank");
	}
	
	@Test
	void correctMovementTest2() throws Exception {
		Game game = new Game();	
		Player playerP = new Player('w');
		char player = playerP.getColor();
		int startPoint = 7;
		game.setNewPieceAt(startPoint,3,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("C7-C8Q",game);
		//game.print.print();
		assertTrue(game.move.movingPiece(playerP,mc,true),"pawn promotion only happen when the pawn reach the eight rank");
	}
	
	@Test
	void correctMovementTest3() throws Exception {
		Game game = new Game();	
		Player playerP = new Player('w');
		char player = playerP.getColor();
		int startPoint = 7;
		game.setNewPieceAt(startPoint,3,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("C7-C8R",game);
		//game.print.print();
		assertTrue(game.move.movingPiece(playerP,mc,true),"pawn promotion only happen when the pawn reach the eight rank");
	}
	
	@Test
	void correctMovementTest4() throws Exception {
		Game game = new Game();	
		Player playerP = new Player('w');
		char player = playerP.getColor();
		int startPoint = 7;
		game.setNewPieceAt(startPoint,3,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("C7-C8B",game);
		//game.print.print();
		assertTrue(game.move.movingPiece(playerP,mc,true),"pawn promotion only happen when the pawn reach the eight rank");
	}
	
	@Test
	void correctMovementTest5() throws Exception {
		Game game = new Game();	
		Player playerP = new Player('w');
		char player = playerP.getColor();
		int startPoint = 7;
		game.setNewPieceAt(startPoint,3,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("C7-C8N",game);
		//game.print.print();
		assertTrue(game.move.movingPiece(playerP,mc,true),"pawn promotion only happen when the pawn reach the eight rank");
	}
	
	@Test
	void FalseMovementTest() throws Exception {
		Game game = new Game();	
		Player playerP = new Player('w');
		char player = playerP.getColor();
		int startPoint = 6;
		game.setNewPieceAt(startPoint,3,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("C6-C7Q",game);
		//game.print.print();
		assertFalse(game.move.movingPiece(playerP,mc,true),"can't use pawn promotion input if the move is not pawn promorion");
	}
	

}
