package Test;
import chess_games.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import chessEntities.*;
import chess_games.Games;
import chess_games.MoveCoordinate;

class KnightTest {

	@Test
	void correctMovementTest1() throws Exception {
		Games game = new Games("Test");	
		char player = 'b';
		game.setNewPieceAt(8,4,new Knight(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-C6",game);
		assertTrue(game.board[8][4].getPiece().canMove(mc),"Knight only have certain move");
	}
	
	@Test
	void correctMovementTest2() throws Exception {
		Games game = new Games("Test");	
		char player = 'b';
		game.setNewPieceAt(8,4,new Knight(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-B7",game);
		game.print.print();
		assertTrue(game.board[8][4].getPiece().canMove(mc),"Knight only have certain move");
	}
	
	@Test
	void correctMovementTest3() throws Exception {
		Games game = new Games("Test");	
		char player = 'b';
		game.setNewPieceAt(8,4,new Knight(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-F7",game);
		game.print.print();
		assertTrue(game.board[8][4].getPiece().canMove(mc),"Knight only have certain move");
	}
	
	
	@Test
	void correctMovementTest4() throws Exception {
		Games game = new Games("Test");	
		char player = 'b';
		game.setNewPieceAt(8,4,new Knight(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-E6",game);
		assertTrue(game.board[8][4].getPiece().canMove(mc),"Knight only have certain move");
	}
	
	@Test
	void correctMovementTest5() throws Exception {
		Games game = new Games("Test");	
		char player = 'b';
		game.setNewPieceAt(8,4,new Knight(player,game.board));
		game.setNewPieceAt(7,4,new Pawn(player,game.board));
		game.setNewPieceAt(7,3,new Pawn(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-C6",game);
		assertTrue(game.board[8][4].getPiece().canMove(mc),"Knight can jump over other pieces to move");
	}
	
	@Test
	void falseMovementTest1() throws Exception {
		Games game = new Games("Test");	
		char player = 'b';
		int file = 8;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Knight(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-D6",game);
		assertFalse(game.board[file][rank].getPiece().canMove(mc),"Knight cant moving straight");
	}
	
	@Test
	void falseMovementTest2() throws Exception {
		Games game = new Games("Test");	
		char player = 'b';
		int file = 8;
		int rank = 4;
		game.setNewPieceAt(file,rank,new Knight(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-B6",game);
		assertFalse(game.board[file][rank].getPiece().canMove(mc),"Knight cant moving diagonally");
	}

}
