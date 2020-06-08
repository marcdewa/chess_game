package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chessEntities.*;
import chess_games.Games;
import chess_games.MoveCoordinate;

class PawnTest {

	@Test
	void sscorrectMovementTest1() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int file = 7;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Pawn(player,game.board));
		game.setNewPieceAt(file-2,rank,new Pawn('w',game.board));
		MoveCoordinate mc = new MoveCoordinate("D7-D5",game);
		game.print.print();
		assertTrue(game.board[file][rank].getPiece().canMove(mc),"Pawn can move +- 1 rank if there is a piece to eat");
	}
	
	@Test
	void correctMovementTest1() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int file = 7;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Pawn(player,game.board));
		game.setNewPieceAt(file-1,rank+1,new Pawn('w',game.board));
		MoveCoordinate mc = new MoveCoordinate("D7-E6",game);
		assertTrue(game.board[file][rank].getPiece().canMove(mc),"Pawn can move +- 1 rank if there is a piece to eat");
	}
	@Test
	void correctMovementTest2() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int file = 7;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D7-D5",game);
		assertTrue(game.board[file][rank].getPiece().canMove(mc),"Pawn can move 2 step if its their first turn");
	}
	
	@Test
	void correctMovementTest3() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int file = 7;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D7-D6",game);
		game.move.movingPiece('b', mc);
		MoveCoordinate mc1 = new MoveCoordinate("D6-D5",game);
		assertTrue(game.board[file-1][rank].getPiece().canMove(mc1),"Pawn only can +1 file move if not the pawn first turn");
	}
	
	@Test
	void FalseMovementTest1() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int file = 7;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D7-D6",game);
		game.move.movingPiece('b', mc);
		MoveCoordinate mc1 = new MoveCoordinate("D6-D4",game);
		assertFalse(game.board[file-1][rank].getPiece().canMove(mc1),"False +2 file move for pawn if not the pawn first turn");
	}
	//En passant
	//Pawn Promotion

}
