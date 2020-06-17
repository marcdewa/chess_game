package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chessEntities.*;
import chess_games.BoardPrinter;
import chess_games.Games;
import chess_games.MoveCoordinate;
import chess_games.Player;

class PawnTest {

	
	@Test
	void correctMovementTest1() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int file = 7;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Pawn(player,game.board));
		game.setNewPieceAt(file-1,rank+1,new Pawn('w',game.board));
		MoveCoordinate mc = new MoveCoordinate("D7-E6",game);
		assertTrue(game.board[file][rank].getPiece().canMove(mc,true),"Pawn can move +- 1 rank if there is a piece to eat");
	}
	@Test
	void correctMovementTest2() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int file = 7;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D7-D5",game);
		assertTrue(game.board[file][rank].getPiece().canMove(mc,true),"Pawn can move 2 step if its their first turn");
	}
	
	@Test
	void correctMovementTest3() throws Exception {
		Games game = new Games();	
		BoardPrinter print = new BoardPrinter(game);
		Player playerP = new Player('b');
		char player = playerP.getColor();
		int file = 7;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Pawn(player,game.board));
		game.setNewPieceAt(file-1,rank,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D7-D5",game);
		print.print();
		assertFalse(game.move.movingPiece(playerP, mc,true),"Pawn can't jump over pieces with +2 move file");
		
	}
	
	@Test
	void correctMovementTest4() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int file = 7;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D7-D6",game);
		game.move.movingPiece(new Player('b'), mc,true);
		MoveCoordinate mc1 = new MoveCoordinate("D6-D5",game);
		assertTrue(game.board[file-1][rank].getPiece().canMove(mc1,true),"Pawn only can +1 file move if not the pawn first turn");
	}
	
	@Test
	void FalseMovementTest1() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int file = 7;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D7-D6",game);
		game.move.movingPiece(new Player('b'), mc,true);
		MoveCoordinate mc1 = new MoveCoordinate("D6-D4",game);
		assertFalse(game.board[file-1][rank].getPiece().canMove(mc1,true),"False +2 file move for pawn if not the pawn first turn");
	}
	
	@Test
	void falseMovementTest2() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int file = 7;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Pawn(player,game.board));
		game.setNewPieceAt(file-1,rank,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D7-D8",game);
		//game.print.print();
		assertFalse(game.move.movingPiece(new Player(player), mc,true),"Pawn can't move backwards");
	}
	//En passant
	//Pawn Promotion

}
