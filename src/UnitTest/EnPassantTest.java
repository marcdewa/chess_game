package UnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chessEntities.*;
import chess_games.Games;
import chess_games.MoveCoordinate;

class EnPassantTest {

	@Test
	void correctMovementTest() throws Exception {
		Games game = new Games();	
		char player = 'b';
		MoveCoordinate mc;
		game.setNewPieceAt(4,2,new Pawn(player,game.board));
		game.setNewPieceAt(2,1,new Pawn('w',game.board));
		mc = new MoveCoordinate("A2-A4",game);
		game.move.movingPiece('w', mc,true);
		mc = new MoveCoordinate("B4-A3",game);
		//game.print.print();
		assertTrue(game.move.movingPiece(player,mc,true),"Black side enpassant");
	}
	
	@Test
	void correctMovementTest1() throws Exception {
		Games game = new Games();	
		char player = 'b';
		MoveCoordinate mc;
		game.setNewPieceAt(7,7,new Pawn(player,game.board));
		game.setNewPieceAt(5,6,new Pawn('w',game.board));
		mc = new MoveCoordinate("G7-G5",game);
		game.move.movingPiece('b', mc,true);
		mc = new MoveCoordinate("F5-G6",game);
		//game.print.print();
		assertTrue(game.move.movingPiece('w',mc,true),"enpassant");
	}
	
//	@Test
//	void correctMovementTest2() throws Exception {
//		Games game = new Games();	
//		char player = 'b';
//		int startPoint = 2;
//		MoveCoordinate mc;
//		game.setNewPieceAt(4,2,new Pawn(player,game.board));
//		game.setNewPieceAt(5,4,new Rook(player,game.board));
//		game.setNewPieceAt(2,1,new Pawn('w',game.board));
//		//game.print.print();
//		game.coordinateMove("A2-A4",'w');
//		//System.out.println(game.lastMoved.getPieceName());
//		//game.print.print();
//		game.coordinateMove("D5-H5",'b');
//		game.print.print();
//		//System.out.println(game.lastMoved.getPieceName());
//		//game.print.print();
//		assertFalse(game.coordinateMove("B4-A3",'b'),"the capture can only be made on the move immediately after the enemy pawn makes the double-step move");
//	}	

}
