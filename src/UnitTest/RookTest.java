package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chessEntities.*;
import chess_games.Game;
import chess_games.MoveCoordinate;

class RookTest {

	@Test
	void correctMovementTest1() throws Exception {
		Game game = new Game();	
		char player = 'b';
		int file = 8;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Rook(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-D1",game);
		assertTrue(game.board[file][rank].getPiece().canMove(mc,true),"Rook only can move straight");
	}
	@Test
	void correctMovementTest2() throws Exception {
		Game game = new Game();	
		char player = 'b';
		int file = 8;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Rook(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-H8",game);
		assertTrue(game.board[file][rank].getPiece().canMove(mc,true),"Rook only can move straight");
	}
	@Test
	void falseMovementTest1() throws Exception {
		Game game = new Game();	
		char player = 'b';
		int file = 8;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Rook(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-A5",game);
		assertFalse(game.board[file][rank].getPiece().canMove(mc,true),"Rook only can move straight");
	}
	@Test
	void falseMovementTest2() throws Exception {
		Game game = new Game();	
		char player = 'b';
		int file = 8;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Rook(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-E7",game);
		//game.print.print();
		assertFalse(game.board[file][rank].getPiece().canMove(mc,true),"Rook only can move straight");
	}
	
	@Test
	void falseMovementTest3() throws Exception {
		Game game = new Game();	
		char player = 'b';
		int file = 8;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Rook(player,game.board));
		game.setNewPieceAt(file,rank+1,new Rook(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-H8",game);
		assertFalse(game.board[file][rank].getPiece().canMove(mc,true),"Rook can't jump over piece");
	}
	
	@Test
	void correctMovementTest22() throws Exception {
		Game game = new Game();	
		char player = 'b';
		game.setNewPieceAt(7,1,new Rook(player,game.board));
		game.setNewPieceAt(7,8,new King('w',game.board));
		MoveCoordinate mc = new MoveCoordinate("A7-H7",game);
		//game.print.print();
		assertTrue(game.board[7][1].getPiece().canMove(mc,true),"Rook only can move straight");
	}
}
