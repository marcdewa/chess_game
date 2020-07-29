package UnitTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Main.Game;
import Main.Knight;
import Main.MoveCoordinate;
import Main.Pawn;

class KnightTest {

	@Test
	void correctMovementTest1() throws Exception {
		Game game = new Game();	
		char player = 'b';
		game.setNewPieceAt(8,4,new Knight(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-C6",game);
		assertTrue(game.board[8][4].getPiece().canMove(mc,true),"Knight only have certain move");
	}
	
	@Test
	void correctMovementTest2() throws Exception {
		Game game = new Game();	
		char player = 'b';
		game.setNewPieceAt(8,4,new Knight(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-B7",game);
		assertTrue(game.board[8][4].getPiece().canMove(mc,true),"Knight only have certain move");
	}
	
	@Test
	void correctMovementTest3() throws Exception {
		Game game = new Game();	
		char player = 'b';
		game.setNewPieceAt(8,4,new Knight(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-F7",game);
		assertTrue(game.board[8][4].getPiece().canMove(mc,true),"Knight only have certain move");
	}
	
	
	@Test
	void correctMovementTest4() throws Exception {
		Game game = new Game();	
		char player = 'b';
		game.setNewPieceAt(8,4,new Knight(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-E6",game);
		assertTrue(game.board[8][4].getPiece().canMove(mc,true),"Knight only have certain move");
	}
	
	@Test
	void correctMovementTest5() throws Exception {
		Game game = new Game();	
		char player = 'b';
		game.setNewPieceAt(8,4,new Knight(player,game.board));
		game.setNewPieceAt(7,4,new Pawn(player,game.board));
		game.setNewPieceAt(7,3,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-C6",game);
		assertTrue(game.board[8][4].getPiece().canMove(mc,true),"Knight can jump over other pieces to move");
	}
	
	@Test
	void falseMovementTest1() throws Exception {
		Game game = new Game();	
		char player = 'b';
		int file = 8;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Knight(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-D6",game);
		assertFalse(game.board[file][rank].getPiece().canMove(mc,true),"Knight cant moving straight");
	}
	
	@Test
	void falseMovementTest2() throws Exception {
		Game game = new Game();	
		char player = 'b';
		int file = 8;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Knight(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-B6",game);
		assertFalse(game.board[file][rank].getPiece().canMove(mc,true),"Knight cant moving diagonally");
	}

}
