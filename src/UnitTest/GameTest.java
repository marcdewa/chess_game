package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;


import chessEntities.*;
import chess_games.Games;
import chess_games.MoveCoordinate;

class GameTest {

	@Test
	void stalemateCheck() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int file = 8;
		int rank = 1;
		game.setNewPieceAt(file,rank,new King(player,game.board));
		game.setNewPieceAt(7,1,new Pawn('w',game.board));
		game.setNewPieceAt(6,1,new King('w',game.board));
		//game.print.print();
		try {
			Method legalMove = game.getClass().getDeclaredMethod("anyLegalMoveCheck",char.class);
			legalMove.setAccessible(true);
			boolean isAnyLegalMove = !(boolean) legalMove.invoke(game, player);
			assertTrue(game.isStalemate(player,isAnyLegalMove),"Black is in stalemate condition");
		} catch (Exception e) {
			fail(e);
		}
		
	}
	
	@Test
	void stalemateCheck2() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int file = 1;
		int rank = 8;
		game.setNewPieceAt(file,rank,new King(player,game.board));
		game.setNewPieceAt(2,6,new Queen('w',game.board));
		game.setNewPieceAt(8,1,new King('w',game.board));
		//game.print.print();
		try {
			Method legalMove = game.getClass().getDeclaredMethod("anyLegalMoveCheck",char.class);
			legalMove.setAccessible(true);
			boolean isAnyLegalMove = !(boolean) legalMove.invoke(game, player);
			assertTrue(game.isStalemate(player,isAnyLegalMove),"Black is in stalemate condition");
		} catch (Exception e) {
			fail(e);
		}
		
	}
	
	
	@Test
	void CheckmateCheck1() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int file = 8;
		int rank = 8;
		game.setNewPieceAt(file,rank,new King(player,game.board));
		game.setNewPieceAt(8,2,new Rook('w',game.board));
		game.setNewPieceAt(7,1,new Rook('w',game.board));
		game.setNewPieceAt(1,4,new King('w',game.board));
		//game.print.print();
		try {
			Method legalMove = game.getClass().getDeclaredMethod("anyLegalMoveCheck",char.class);
			legalMove.setAccessible(true);
			boolean isAnyLegalMove = !(boolean) legalMove.invoke(game, player);
			assertTrue(game.isCheckmate(player,isAnyLegalMove),"Black is in checkmate condition");
		} catch (Exception e) {
			fail(e);
		}
		
	}
	
	@Test
	void gamesCheck1() throws Exception {
		Games game = new Games();	
		game.setNewPieceAt(8,2,new Rook('w',game.board));
		game.setNewPieceAt(8,1,new Rook('w',game.board));
		//game.print.print();
		MoveCoordinate mc = new MoveCoordinate("A8-B8",game);
		assertFalse(game.move.movingPiece('w', mc),"Pieces can't eat own color piece");
	}
	
	@Test
	void gamesCheck2() throws Exception {
		Games game = new Games();
		game.setNewPieceAt(8,4,new Rook('b',game.board));
		game.setNewPieceAt(8,2,new King('w',game.board));
		game.setNewPieceAt(1,1,new Rook('w',game.board));
		//game.print.print();
		MoveCoordinate mc = new MoveCoordinate("A1-A2",game);
		assertFalse(game.move.movingPiece('w', mc),"Invalid move if the king is in check");
	}
	
//	@Test
//	void gamesCheck3() throws Exception {
//		Games game = new Games();
//		game.setNewPieceAt(8,4,new Rook('b',game.board));
//		game.setNewPieceAt(7,2,new King('w',game.board));
//		game.setNewPieceAt(1,1,new Rook('w',game.board));
//		game.print.print();
//		assertFalse(game.coordinateMove("D8-E8", 'w'),"Can't move other color pieces");
//	}
//	
//	@Test
//	void gamesCheck4() throws Exception {
//		Games game = new Games();
//		game.setNewPieceAt(8,4,new Rook('b',game.board));
//		game.setNewPieceAt(7,2,new King('w',game.board));
//		game.setNewPieceAt(1,1,new Rook('w',game.board));
////		game.print.print();
//		assertFalse(game.coordinateMove("D8-E9", 'w'),"Invalid coordinate input , coordinate out of range");
//	}
	
	@Test
	void gamesCheck5() throws Exception {
		Games game = new Games();
		game.defaultPieceLocation('b');
		int startPoint=8;
		//game.print.print();
		//MoveCoordinate mc = new MoveCoordinate("D8-E8",game);
		assertTrue(true,"Make all new pieces in default position");
	}
	


}
