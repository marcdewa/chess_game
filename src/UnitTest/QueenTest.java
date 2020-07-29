package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Main.Game;
import Main.MoveCoordinate;
import Main.Queen;

class QueenTest {

	@Test
	void correctMovementTest1() throws Exception {
		Game game = new Game();	
		char player = 'b';
		game.setNewPieceAt(8,4,new Queen(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-A8",game);
		assertTrue(game.board[8][4].getPiece().canMove(mc,true),"Queen can go straight and diagonally");
	}
	
	@Test
	void correctMovementTest2() throws Exception {
		Game game = new Game();	
		char player = 'b';
		game.setNewPieceAt(8,4,new Queen(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-A5",game);
		assertTrue(game.board[8][4].getPiece().canMove(mc,true),"Queen can go straight and diagonally");
	}
	@Test
	void correctMovementTest3() throws Exception {
		Game game = new Game();	
		char player = 'b';
		game.setNewPieceAt(8,4,new Queen(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-D1",game);
		assertTrue(game.board[8][4].getPiece().canMove(mc,true),"Queen can go straight and diagonally");
	}
	@Test
	void correctMovementTest4() throws Exception {
		Game game = new Game();	
		char player = 'b';
		game.setNewPieceAt(8,4,new Queen(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-H4",game);
		assertTrue(game.board[8][4].getPiece().canMove(mc,true),"Queen can go straight and diagonally");
	}
	
	@Test
	void correctMovementTest5() throws Exception {
		Game game = new Game();	
		char player = 'b';
		game.setNewPieceAt(8,4,new Queen(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-H8",game);
		assertTrue(game.board[8][4].getPiece().canMove(mc,true),"Queen can go straight and diagonally");
	}
	
	@Test
	void falseMovementTest1() throws Exception {
		Game game = new Game();	
		char player = 'b';
		game.setNewPieceAt(8,4,new Queen(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-B7",game);
		assertFalse(game.board[8][4].getPiece().canMove(mc,true),"Queen only can go straight and diagonally");
	}
	
	@Test
	void falseMovementTest2() throws Exception {
		Game game = new Game();	
		char player = 'b';
		game.setNewPieceAt(8,4,new Queen(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-C6",game);
		assertFalse(game.board[8][4].getPiece().canMove(mc,true),"Queen only can go straight and diagonally");
	}
	
	@Test
	void falseMovementTest3() throws Exception {
		Game game = new Game();	
		char player = 'b';
		game.setNewPieceAt(8,4,new Queen(player,game.board));
		game.setNewPieceAt(8,5,new Queen(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-H8",game);
		assertFalse(game.board[8][4].getPiece().canMove(mc,true),"Queen can't jump over piece");
	}
	
	
	
}
