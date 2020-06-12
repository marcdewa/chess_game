package chess_games;

import java.util.Scanner;

import chessEntities.*;


public class Games {
	public Board[][] board ;
	public Move move;
	public BoardPrinter print;
	Scanner scan ;
	
	public Games() {
		print = new BoardPrinter(this);
		scan = new Scanner(System.in);
		board = new Board[10][10];
		move = new Move(board);
	}
	
	public void startGame() {
		defaultPieceLocation('b');
		defaultPieceLocation('w');
		while(true) {
			Turn('w');
			Turn('b');
		}
	}
	
	public void defaultPieceLocation(char player) {
		int startPoint = isBlack(player)? 8 : 1 ; 
		int forwardMovement = isBlack(player)? -1 : 1;

		setNewPieceAt(startPoint,1,new Rook(player,board));
		setNewPieceAt(startPoint,8,new Rook(player,board));
		
		setNewPieceAt(startPoint,2,new Knight(player,board));
		setNewPieceAt(startPoint,7,new Knight(player,board));
		
		setNewPieceAt(startPoint,3,new Bishop(player,board));
		setNewPieceAt(startPoint,6,new Bishop(player,board));
	
		setNewPieceAt(startPoint,4,new Queen(player,board));
	
		setNewPieceAt(startPoint,5,new King(player,board));

		for(int i=1; i<9;i++) {
			setNewPieceAt(startPoint+forwardMovement,i,new Pawn(player,board));
		}

	}


	private boolean isBlack(char player) {
		return player=='b';
	}
	
	public void setNewPieceAt(int file,int rank,Pieces piece) {
		board[file][rank] = new Board(new PiecesLocation(file,rank),piece);
	}
	
	private void Turn(char player) {
		
		print.clear();
		
		String input = null;
		String color = (player == 'b') ? "black" : "white"; 
		
		print.print();
		isCheckmateOrStalemate(player);
		
		System.out.println(color+" move: ");
		
		input = scan.nextLine();
		if(!coordinateMove(input,player)) {
			System.out.println("Invalid Move");
			Turn(player);
		}
		
	}
	
	private boolean coordinateMove(String input,char player)  {		
		try {
			MoveCoordinate movLoc = new MoveCoordinate(input,this);
			return move.movingPiece(player,movLoc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	

	private void isCheckmateOrStalemate(char player) {
		String colorOpp = (player == 'b') ? "white" : "black";
		boolean noAnyLegalMove = !anyLegalMoveCheck(player);
		
		if(isCheckmate(player,noAnyLegalMove)) {
			System.out.println(colorOpp +" Win!");
			System.exit(0);
		}
		if(isStalemate(player, noAnyLegalMove)) {
			System.out.println("Draw");
			System.exit(0);
		};
	}


	public boolean isCheckmate(char player,boolean noAnyLegalMove) {
		return noAnyLegalMove && move.isPlayerInCheck(player);
	}


	public boolean isStalemate(char player, boolean noAnyLegalMove) {
		return noAnyLegalMove && !move.isPlayerInCheck(player);
	}
	

	
    private boolean anyLegalMoveCheck(char color){
    	Board[][] oldBoard = move.cloning(board);
    	
        for(int x = 1; x<board.length-1; x++){
            for(int y = 1; y<board[0].length-1; y++){
                for(int w = 1; w<board.length-1; w++){
                    for(int z = 1; z<board[0].length-1; z++){
                        try{
                            if(board[y][x] != null){
                            	MoveCoordinate mc = new MoveCoordinate(y,x,z,w,this);
                                if(board[y][x].getPiece().getPlayer()==color){
                                	if(board[z][w]==null) {
                                        if(move.movingPiece(color,mc) && !move.isPlayerInCheck(color)) {
                                     
                                        	move.reverseMove(oldBoard);
                                                return true;
                                        }
                                        move.reverseMove(oldBoard);
                                	}else if(board[z][w].getPiece().getPlayer()!=color) {
                                        if(move.movingPiece(color,mc) && !move.isPlayerInCheck(color)) {

                                        	move.reverseMove(oldBoard);
                                            return true;
                                        }
                                        move.reverseMove(oldBoard);
                                	}
                                }
                            }
                            move.reverseMove(oldBoard);
                        } catch(Exception e){
                        	move.reverseMove(oldBoard);
                        }
                    }
                }
            }
        }
        move.reverseMove(oldBoard);
        return false;
    }

}
