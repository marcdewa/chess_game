package chess_games;

public class MoveCoordinate {

	private PiecesLocation locFrom;
	private PiecesLocation locTo;
	
	public MoveCoordinate(String input,Games game) throws Exception {
		PiecesLocation locFrom = coordinateToInteger(input,0,2);
		PiecesLocation locTo = coordinateToInteger(input,3,5);
		
		if(inputValidation(locTo, locFrom,game)) {
			throw new Exception ("invalid coordinate");
		}
		
		this.locFrom = locFrom;
		this.locTo = locTo;
	}
	
	public MoveCoordinate(PiecesLocation locFrom, PiecesLocation locTo) {
		this.locFrom = locFrom;
		this.locTo = locTo;
	}
	
	private boolean inputValidation(PiecesLocation locTo, PiecesLocation locFrom,Games game) {
		if(game.board[locFrom.getFile()][locFrom.getRank()]==null) 
			return true;
		
		if(locFrom ==null || locTo ==null) 
			return true;
		
		return false;
	}
	
	public PiecesLocation coordinateToInteger(String locInput,int start , int end) {
		String Position;
		Position = locInput.substring(start,end);
		
		try {
			PiecesLocation loc = new PiecesLocation(Position);
			return loc;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public PiecesLocation getLocFrom() {
		return locFrom;
	}

	public PiecesLocation getLocTo() {
		return locTo;
	}

	public int getLocToFile() {
		return this.locTo.getFile();
	}
	
	public int getLocFromFile() {
		return this.locFrom.getFile();
	}
	
	public int getLocToRank() {
		return this.locTo.getRank();
	}
	
	public int getLocFromRank() {
		return this.locFrom.getRank();
	}
	
}
