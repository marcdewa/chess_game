package chess_games;

import chessEntities.*;


public class games {
	Position[][] board ;

	
	public games() {
		board = new Position[10][10];
		defaultPieceLocation('b');
		defaultPieceLocation('w');
	}
	
	
	public void defaultPieceLocation(char player) {
		int Side = (player=='b')? 8 : 1 ; 
		int bw = (player=='b')? -1 : 1;

		setNewPieceAt(Side,1,new Rook(player));
		setNewPieceAt(Side,8,new Rook(player));
		
		setNewPieceAt(Side,2,new Knight(player));
		setNewPieceAt(Side,7,new Knight(player));
		
		setNewPieceAt(Side,3,new Bishop(player));
		setNewPieceAt(Side,6,new Bishop(player));
	
		setNewPieceAt(Side,4,new Queen(player));
	
		setNewPieceAt(Side,5,new King(player));

		for(int i=1; i<9;i++) {
			setNewPieceAt(Side+bw,i,new Pawn(player));
		}

	}
	
	public void setNewPieceAt(int file,int rank,Pieces piece) {
		board[file][rank] = new Position(new PiecesLocation(file,rank),piece);
	}
	
	
	
	public void coordinateMove(String loc) {
		PiecesLocation locTo;
		PiecesLocation locFrom;
		
		locFrom = coordinateConverterToInteger(loc,0,2);
		locTo = coordinateConverterToInteger(loc,3,5);
		
		
		movingPieceToANewSpot(locTo, locFrom);
	}
	
	public PiecesLocation coordinateConverterToInteger(String Loc,int start , int end) {
		String Position;
		Position = Loc.substring(start,end);
		
		return new PiecesLocation(Position.charAt(0),Position.charAt(1));
	}
	
	
	private void movingPieceToANewSpot(PiecesLocation locTo, PiecesLocation locFrom) {
		
		if(validMoveCheck(locFrom,locTo,board) && isEnemyPiece(locTo, locFrom)) {
			movePiece(locTo, locFrom);
		}else System.out.println("Invalid Move");
	}


	private boolean isEnemyPiece(PiecesLocation locTo, PiecesLocation locFrom) {
		try {
			return board[locTo.getFile()][locTo.getRank()].getPiece().getPlayer() != board[locFrom.getFile()][locFrom.getRank()].getPiece().getPlayer();
		} catch (Exception e) {
			return true;
		}
	}

	private void movePiece(PiecesLocation locTo, PiecesLocation locFrom) {
		board[locTo.getFile()][locTo.getRank()]= board[locFrom.getFile()][locFrom.getRank()];
		board[locTo.getFile()][locTo.getRank()].setLoc(locTo);
		board[locFrom.getFile()][locFrom.getRank()] = null;
	}

	private boolean validMoveCheck(PiecesLocation locFrom,PiecesLocation locTo,Position[][] board) {
		return board[locFrom.getFile()][locFrom.getRank()].getPiece().canMove(locFrom,locTo,board);
	}


	public void print() {
		
			for(int i = 8 ; i > 0 ; i--) {
			
				for(int j = 1 ; j < 9 ; j++) {
					
					if(board[i][j] != null) {
					System.out.print(" "+board[i][j].getPiece().getPieceName()+" ");
					}else blackOrWhiteBoardColor(i, j);
					
				}
				System.out.println(" "+(i)+" ");
			}
			System.out.println(" A  B  C  D  E  F  G  H");
	}

	private void blackOrWhiteBoardColor(int i, int j) {
		if(isEven(i)) {
			if(isEven(j)) {
				System.out.print(" + ");
			}
			else System.out.print(" - ");
		}
		else {
				if(isEven(j)) {
					System.out.print(" - ");
				}
				else System.out.print(" + ");
			
		}
	}

	private boolean isEven(int i) {
		return i%2==0;
	}

}
