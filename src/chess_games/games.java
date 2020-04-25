package chess_games;

import chessEntities.*;


public class Games {
	Position[][] board ;

	
	public Games() {
		board = new Position[10][10];
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
			return movingPieceToANewSpot(movLoc,player);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	
	
	private boolean movingPieceToANewSpot(MoveCoordinate movLoc,char player) {
		Position[][] oldBoard = cloning(board);
		if(isMoveValid(movLoc,player)) {
			if(isMoveCastling(movLoc.getLocFrom())) {
				castlingMove(movLoc);
				return true;
			}else {
				movePiece(movLoc);
				if(isInCheck(player)) {
					System.out.println("Invalid Move : Your king is in check");
					board = oldBoard.clone();
					return false;
				}
				return true;
			}
		}else { 
			System.out.println("Invalid Move "+"\""+board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getPiece().getPieceName()+"\" piece");
			return false;
		}
	}


	private boolean isMoveCastling(PiecesLocation locFrom) {
		return isKing(locFrom.getFile(),locFrom.getRank()) && ((King) (board[locFrom.getFile()][locFrom.getRank()].getPiece())).isCastling();
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

	private boolean isEnemyPiece(MoveCoordinate movLoc) {
		try {
			return board[movLoc.getLocToFile()][movLoc.getLocToRank()].getPiece().getPlayer() != board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getPiece().getPlayer();
		} catch (Exception e) {
			return true;
		}
	}
	
	private void castlingMove(MoveCoordinate movLoc) {
		movePiece(movLoc);
		if(movLoc.getLocToRank()-movLoc.getLocFromRank()==2) {
			board[movLoc.getLocToFile()][movLoc.getLocToRank()+1].getPiece().setHasMoved(true);
			board[movLoc.getLocToFile()][movLoc.getLocToRank()-1]= board[movLoc.getLocToFile()][movLoc.getLocToRank()+1];
			board[movLoc.getLocToFile()][movLoc.getLocToRank()+1] = null;
		}else {
			board[movLoc.getLocToFile()][movLoc.getLocToRank()-2].getPiece().setHasMoved(true);
			board[movLoc.getLocToFile()][movLoc.getLocToRank()+1]= board[movLoc.getLocToFile()][movLoc.getLocToRank()-2];
			board[movLoc.getLocToFile()][movLoc.getLocToRank()-2] = null;
		}
		
	}

	private void movePiece(MoveCoordinate movLoc) {
		board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getPiece().setHasMoved(true);
		board[movLoc.getLocToFile()][movLoc.getLocToRank()]= board[movLoc.getLocFromFile()][movLoc.getLocFromRank()];
		board[movLoc.getLocFromFile()][movLoc.getLocFromRank()] = null;
	}

	private boolean isMoveValid(MoveCoordinate movLoc,char player) {
		if(!isEnemyPiece(movLoc)) 
			return false;
		
		if(!(board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getPiece().getPlayer() == player)) 
			return false;
		
		if(!(board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getPiece().canMove(movLoc.getLocFrom(),movLoc.getLocTo(),board))) 
			return false;
		
		return true;
	}


//	public void print(Position[][] board) {
//		
//			for(int i = 8 ; i > 0 ; i--) {
//			
//				for(int j = 1 ; j < 9 ; j++) {
//					
//					if(board[i][j] != null) {
//					System.out.print(" "+board[i][j].getPiece().getPieceName()+" ");
//					}else blackOrWhiteBoardColor(i, j);
//					
//				}
//				System.out.println(" "+(i)+" ");
//			}
//			System.out.println(" A  B  C  D  E  F  G  H");
//	}
	
//	public void print() {
//		
//		for(int i = 8 ; i > 0 ; i--) {
//		
//			for(int j = 1 ; j < 9 ; j++) {
//				
//				if(board[i][j] != null) {
//				System.out.print(" "+board[i][j].getPiece().getPieceName()+" ");
//				}else blackOrWhiteBoardColor(i, j);
//				
//			}
//			System.out.println(" "+(i)+" ");
//		}
//		System.out.println(" A  B  C  D  E  F  G  H");
//}
//
//	private void blackOrWhiteBoardColor(int i, int j) {
//		if(isEven(i)) {
//			if(isEven(j)) {
//				System.out.print(" + ");
//			}
//			else System.out.print(" - ");
//		}
//		else {
//				if(isEven(j)) {
//					System.out.print(" - ");
//				}
//				else System.out.print(" + ");
//			
//		}
//	}
//
//	private boolean isEven(int i) {
//		return i%2==0;
//	}
	
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
