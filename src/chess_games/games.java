package chess_games;

import chessEntities.*;


public class Games {
	Position[][] board ;
	Move move;
	
	public Games() {
		board = new Position[10][10];
		move = new Move(board);
		defaultPieceLocation('b');
		defaultPieceLocation('w');
	}
	
	
	public void defaultPieceLocation(char player) {
		int startPoint = isBlack(player)? 8 : 1 ; 
		int forwardMovement = isBlack(player)? -1 : 1;

		setNewPieceAt(startPoint,1,new Rook(player));
		setNewPieceAt(startPoint,8,new Rook(player));
		
		setNewPieceAt(startPoint,2,new Knight(player));
		setNewPieceAt(startPoint,7,new Knight(player));
		
		setNewPieceAt(startPoint,3,new Bishop(player));
		setNewPieceAt(startPoint,6,new Bishop(player));
	
		setNewPieceAt(startPoint,4,new Queen(player));
	
		setNewPieceAt(startPoint,5,new King(player));

		for(int i=1; i<9;i++) {
			setNewPieceAt(startPoint+forwardMovement,i,new Pawn(player));
		}

	}


	private boolean isBlack(char player) {
		return player=='b';
	}
	
	public void setNewPieceAt(int file,int rank,Pieces piece) {
		board[file][rank] = new Position(new PiecesLocation(file,rank),piece);
	}
	
	
	

	public boolean coordinateMove(String input,char player)  {
		if(input.length() != 5) {
			System.out.println("invalid coordinate");
			return false;
		}
		
		try {
			MoveCoordinate movLoc = new MoveCoordinate(input,this);
			return move.movingPieceToANewSpot(movLoc,player);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

}
