package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chessEntities.*;
import chess_games.Games;
import chess_games.MoveCoordinate;

class PawnPromotion {

	@Test
	void correctMovementTest() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int startPoint = 2;
		game.setNewPieceAt(startPoint,3,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("C2-C1Q",game);
		//game.print.print();
		assertTrue(game.move.movingPiece(player,mc),"pawn promotion only happen when the pawn reach the eight rank");
	}
	
	@Test
	void correctMovementTest2() throws Exception {
		Games game = new Games();	
		char player = 'w';
		int startPoint = 7;
		game.setNewPieceAt(startPoint,3,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("C7-C8Q",game);
		//game.print.print();
		assertTrue(game.move.movingPiece(player,mc),"pawn promotion only happen when the pawn reach the eight rank");
	}
	
	@Test
	void correctMovementTest3() throws Exception {
		Games game = new Games();	
		char player = 'w';
		int startPoint = 6;
		game.setNewPieceAt(startPoint,3,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("C6-C7Q",game);
		//game.print.print();
		assertFalse(game.move.movingPiece(player,mc),"can't use pawn promotion input if the move is not pawn promorion");
	}
	

}
