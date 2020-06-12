package UnitTest;
import chess_games.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import chessEntities.King;
import chessEntities.Rook;


class KingTest {

	@Test
	void correctMovementTest() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int startPoint = 8;
		game.setNewPieceAt(startPoint,5,new King(player,game.board));
		game.setNewPieceAt(8,8,new Rook(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("E8-G8",game);
		//game.print.print();
		assertTrue(game.move.movingPiece(player,mc,true),"Castling king side");
	}
	
	@Test
	void correctMovementTest1() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int startPoint = 8;
		game.setNewPieceAt(startPoint,5,new King(player,game.board));
		game.setNewPieceAt(8,1,new Rook(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("E8-C8",game);
		//game.print.print();
		assertTrue(game.move.movingPiece(player,mc,true),"Castling Queen side");
	}
	
	@Test
	void falseMovementTest() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int startPoint = 8;
		MoveCoordinate mc;
		game.setNewPieceAt(startPoint,5,new King(player,game.board));
		mc = new MoveCoordinate("E8-E7",game);
		game.move.movingPiece(player, mc,true);
		mc = new MoveCoordinate("E7-E8",game);
		game.move.movingPiece(player, mc,true);
		game.setNewPieceAt(8,1,new Rook(player,game.board));
		mc = new MoveCoordinate("E8-C8",game);
		//game.print.print();
		assertFalse(game.move.movingPiece(player,mc,true),"Castling fail if either rook or king already move");
	}
	
	@Test
	void falseMovementTest1() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int startPoint = 8;
		game.setNewPieceAt(startPoint,4,new King(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("D8-A6",game);
		//game.print.print();
		assertFalse(game.board[startPoint][4].getPiece().canMove(mc,true),"king only can move 1 away in every angle");
	}
	
	@Test
	void falseMovementTest2() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int startPoint = 8;
		MoveCoordinate mc;
		game.setNewPieceAt(startPoint,5,new King(player,game.board));
		game.setNewPieceAt(8,1,new Rook(player,game.board));
		mc = new MoveCoordinate("A8-A7",game);
		game.move.movingPiece(player, mc,true);
		mc = new MoveCoordinate("A7-A8",game);
		game.move.movingPiece(player, mc,true);
		mc = new MoveCoordinate("E8-C8",game);
		//game.print.print();
		assertFalse(game.move.movingPiece(player,mc,true),"Castling fail if either rook or king already move");
	}
	
	@Test
	void falseMovementTest3() throws Exception {
		Games game = new Games();	
		char player = 'b';
		int startPoint = 8;
		MoveCoordinate mc;
		game.setNewPieceAt(startPoint,5,new King(player,game.board));
		mc = new MoveCoordinate("E8-E7",game);
		game.move.movingPiece(player, mc,true);
		mc = new MoveCoordinate("E7-E8",game);
		game.move.movingPiece(player, mc,true);
		game.setNewPieceAt(8,1,new Rook(player,game.board));
		mc = new MoveCoordinate("A8-A7",game);
		game.move.movingPiece(player, mc,true);
		mc = new MoveCoordinate("A7-A8",game);
		game.move.movingPiece(player, mc,true);
		mc = new MoveCoordinate("E8-C8",game);
		//game.print.print();
		assertFalse(game.move.movingPiece(player,mc,true),"Castling fail if both rook and king already move");
	}
	
}
