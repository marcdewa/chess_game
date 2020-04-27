package chess_games;

import chessEntities.King;

public class Move {
	Position[][] board;
	MoveCoordinate movLoc;
	
	public Move(Position[][] board) {
		this.board = board;
	}
	
	
	
	public boolean movingPiece(char player,MoveCoordinate movLoc) {
		this.movLoc = movLoc;
		Position[][] oldBoard = cloning(board);
		if(isMoveValid(player)) {
			if(isMoveCastling(movLoc.getLocFrom())) {
				castlingMove();
				return true;
			}
			movePiece();
			if(isInCheck(player)) {
				System.out.println("Invalid Move : Your king is in check");
				reverseMove(oldBoard);
				return false;
			}
			return true;
			
		}else { 
			System.out.println("Invalid move");
			return false;
		}
	}
	private Position[][] cloning(Position[][] Board) {
		Position[][] oldBoard = new Position[10][10];
		for(int i = 8 ; i > 0 ; i--) {
			for(int j = 1 ; j < 9 ; j++) {
				oldBoard[i][j] = Board[i][j];

			}
		
		}
		return oldBoard;
	}
	
	private void reverseMove(Position[][] Board) {
		for(int i = 8 ; i > 0 ; i--) {
			for(int j = 1 ; j < 9 ; j++) {
				board[i][j] = Board[i][j];

			}
		
		}
	}
	
	private boolean isMoveValid(char player) {
		if(!isEnemyPiece()) 
			return false;
		
		if(!(board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getPiece().getPlayer() == player)) 
			return false;
		
		if(!(board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getPiece().canMove(movLoc))) 
			return false;
		
		return true;
	}
	
	private boolean isEnemyPiece() {
		try {
			return board[movLoc.getLocToFile()][movLoc.getLocToRank()].getPiece().getPlayer() != board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getPiece().getPlayer();
		} catch (Exception e) {
			return true;
		}
	}

	private boolean isMoveCastling(PiecesLocation locFrom) {
		return isKing(locFrom.getFile(),locFrom.getRank()) && ((King) (board[locFrom.getFile()][locFrom.getRank()].getPiece())).isCastling();
	}
	
	private void castlingMove() {
		movePiece();
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

	private void movePiece() {
		board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getPiece().setHasMoved(true);
		board[movLoc.getLocToFile()][movLoc.getLocToRank()]= board[movLoc.getLocFromFile()][movLoc.getLocFromRank()];
		board[movLoc.getLocFromFile()][movLoc.getLocFromRank()] = null;
	}



	public boolean isInCheck(char player){
        PiecesLocation kingPos = kingPosition(player);
        int file = kingPos.getFile();
        int rank = kingPos.getRank();
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] != null){
                    if(board[i][j].getPiece().canMove(new MoveCoordinate(new PiecesLocation(i,j), new PiecesLocation(file,rank))) && 
                    		board[i][j].getPiece().getPlayer() != player){
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


	public boolean isKing(int i, int j) {
		return board[i][j].getPiece().isKing(i, j)|| board[i][j].getPiece().isKing(i, j);
	}
	
}
