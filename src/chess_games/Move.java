package chess_games;

import chessEntities.King;

public class Move {
	Board[][] board;
	MoveCoordinate movLoc;
	
	public Move(Board[][] board) {
		this.board = board;
	}
	
	public boolean movingPiece(char player,MoveCoordinate movLoc) {
		this.movLoc = movLoc;
		Board[][] oldBoard = cloning(board);
		
		
		if(isMoveValid(player)) {
			if(isMoveCastling(movLoc.getLocFrom())) {
				castlingMove();
				return true;
			}
			performMove();
			
			if(isPlayerInCheck(player)) {
				reverseMove(oldBoard);
				return false;
			}
			return true;
			
		}
		else return false;
		
	}

	public Board[][] cloning(Board[][] Board) {
		Board[][] oldBoard = new Board[10][10];
		for(int i = 8 ; i > 0 ; i--) {
			for(int j = 1 ; j < 9 ; j++) {
				oldBoard[i][j] = Board[i][j];

			}
		
		}
		return oldBoard;
	}
	
	public void reverseMove(Board[][] Board) {
		for(int i = 8 ; i > 0 ; i--) {
			for(int j = 1 ; j < 9 ; j++) {
				board[i][j] = Board[i][j];
			}
		}
	}
	
	private boolean isMoveValid(char player) {
		if(!isEnemyPiece()) 
			return false;
		
		if(!(board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getPlayer() == player)) 
			return false;
		
		if(!(board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].canMove(movLoc))) 
			return false;
		
		return true;
	}
	
	private boolean isEnemyPiece() {
		try {
			return board[movLoc.getLocToFile()][movLoc.getLocToRank()].getPlayer() != board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getPlayer();
		} catch (Exception e) {
			return true;
		}
	}

	private boolean isMoveCastling(PiecesLocation locFrom) {
		return isKing(locFrom.getFile(),locFrom.getRank()) && ((King) (board[locFrom.getFile()][locFrom.getRank()].getPiece())).isCastling();
	}
	
	private void castlingMove() {
		performMove();
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

	private void performMove() {
		
		board[movLoc.getLocFromFile()][movLoc.getLocFromRank()].getPiece().setHasMoved(true);
		board[movLoc.getLocToFile()][movLoc.getLocToRank()]= board[movLoc.getLocFromFile()][movLoc.getLocFromRank()];
		board[movLoc.getLocFromFile()][movLoc.getLocFromRank()] = null;
	}
	

	public boolean isPlayerInCheck(char player){
        PiecesLocation kingPos = kingPosition(player);
        int file = kingPos.getFile();
        int rank = kingPos.getRank();
        for(int i = 1; i<board.length; i++){
            for(int j = 1; j<board[0].length; j++){
                if(board[i][j] != null){
                    if(board[i][j].canMove(new MoveCoordinate(new PiecesLocation(i,j), new PiecesLocation(file,rank))) && 
                    		board[i][j].getPlayer() != player){
                    	return true;
                    }
                }
            }
        }
        return false;
    }
	
	private PiecesLocation kingPosition(char player) {
		int file = 0;
		int rank = 0;
		
		for(int i = 8 ; i > 0 ; i--) {
			
			for(int j = 1 ; j < 9 ; j++) {
				
				if(board[i][j] != null && isKing(i, j) && board[i][j].getPlayer() == player) {
					file=i;
					rank=j;
					break;
				}
				
			}

		}
		
		return new PiecesLocation(file,rank);
	}
	private boolean isKing(int i, int j) {
		return board[i][j].getPiece().isKing(i, j)|| board[i][j].getPiece().isKing(i, j);
	}
}
