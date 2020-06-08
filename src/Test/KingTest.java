package Test;
import chess_games.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import chessEntities.King;


class KingTest {

	@Test
	void correctMovementTest() throws Exception {
		Games game = new Games("Test");	
		char player = 'b';
		int startPoint = 8;
		game.setNewPieceAt(startPoint,4,new King(player,game.board));
		MoveCoordinate mc = new MoveCoordinate("C8-A6",game);
		assertTrue(game.board[startPoint][3].getPiece().canMove(mc),"bishop only can move diagonally");
	}

}
