package UnitTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Main.Bishop;
import Main.Game;
import Main.MoveCoordinate;

class BishopTest {

	@Test
	void correctMovementTest() throws Exception {
		Game game = new Game();	
		char player = 'b';
		int startPoint = 8;
		game.setNewPieceAt(startPoint,3,new Bishop(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("C8-A6",game);
		//game.print.print();
		assertTrue(game.board[startPoint][3].getPiece().canMove(mc,true),"bishop only can move diagonally");
	}
	@Test
	void falseMovementTest1() throws Exception {
		Game game = new Game();	
		char player = 'b';
		int startPoint = 8;
		game.setNewPieceAt(startPoint,3,new Bishop(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("C8-C6",game);
		assertFalse(game.board[startPoint][3].getPiece().canMove(mc,true),"Bishop cant moving straight");
	}
	@Test
	void falseMovementTest2() throws Exception {
		Game game = new Game();	
		char player = 'b';
		int startPoint = 8;
		game.setNewPieceAt(startPoint,3,new Bishop(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("C8-B6",game);
		assertFalse(game.board[startPoint][3].getPiece().canMove(mc,true),"bishop only can move diagonally");
	}
	
	@Test
	void falseMovementTest3() throws Exception {
		Game game = new Game();	
		game.setNewPieceAt(8,3,new Bishop('b',game.board));
		game.setNewPieceAt(7,2,new Bishop('b',game.board));
		MoveCoordinate mc = new MoveCoordinate("C8-A6",game);
		//game.print.print();
		assertFalse(game.board[8][3].getPiece().canMove(mc,true),"piece can't jump over piece");
	}
	
}
