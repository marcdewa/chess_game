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
	
	
	
	public boolean coordinateMove(String loc,char player) {
		PiecesLocation locTo;
		PiecesLocation locFrom;
		
		locFrom = coordinateConverterToInteger(loc,0,2);
		locTo = coordinateConverterToInteger(loc,3,5);
		
		return movingPieceToANewSpot(locTo, locFrom,player);
	}
	
	public PiecesLocation coordinateConverterToInteger(String Loc,int start , int end) {
		String Position;
		Position = Loc.substring(start,end);
		
		return new PiecesLocation(Position.charAt(1),Position.charAt(0));
	}
	
	
	private boolean movingPieceToANewSpot(PiecesLocation locTo, PiecesLocation locFrom,char player) {
		Position[][] oldBoard = cloning(board);
		
		if(validMoveCheck(locFrom,locTo,board) && isEnemyPiece(locTo, locFrom) && board[locFrom.getFile()][locFrom.getRank()].getPiece().getPlayer() == player) {
				movePiece(locTo, locFrom);
				if(isInCheck(player)) {
					System.out.println("Invalid Move : Your king is in check");
					board = oldBoard.clone();
					return false;
				}else return true;
		}else { 
			System.out.println("Invalid Move");
			return false;
		}
	}

	private Position[][] cloning(Position[][] Board) {
		Position[][] oldBoard = new Position[10][10];
		for(int i = 8 ; i > 0 ; i--) {
			for(int j = 1 ; j < 9 ; j++) {
				oldBoard[i][j] = board[i][j];

			}
		
		}
		return oldBoard;
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
		
		if((board[locFrom.getFile()][locFrom.getRank()].getPiece().canMove(locFrom,locTo,board))) {
			return true;
		}
		return false;
	}


	public void print(Position[][] board) {
		
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
	
	public boolean isInCheck(char player){
        PiecesLocation kingPos = kingPosition(player);
        int file = kingPos.getFile();
        int rank = kingPos.getRank();
       // System.out.println(board[kingPos.getFile()][kingPos.getRank()].getPiece().getPieceName());
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] != null){
                    if(board[i][j].getPiece().canMove(new PiecesLocation(i,j), new PiecesLocation(file,rank),board) && 
                    		board[i][j].getPiece().getPlayer() != player){
                        //System.out.println(board[i][j].getPiece().getPieceName()+" "+board[file][rank].getPiece().getPieceName());
                    	return true;
                    }
                }
            }
        }

        return false;
    }
	
	public PiecesLocation kingPosition(char player) {
		int file = 0;
		int rank = 0;
		
		for(int i = 8 ; i > 0 ; i--) {
			
			for(int j = 1 ; j < 9 ; j++) {
				
				if(board[i][j] != null && isKing(i, j) && board[i][j].getPiece().getPlayer() == player) {
					file=i;
					rank=j;
					break;
				}
				
			}

		}
		
		return new PiecesLocation(file,rank);
	}


	private boolean isKing(int i, int j) {
		return board[i][j].getPiece().getPieceName()=='K'|| board[i][j].getPiece().getPieceName()=='k';
	}

}
