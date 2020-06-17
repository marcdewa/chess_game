package chess_games;

public class MoveCoordinate {
	
	private Location locFrom;
	private Location locTo;
	private char promotedPiece ;
	
	public MoveCoordinate(String input,Game game) throws Exception {
		Location locFrom;
		Location locTo;
		if(isPromotedInputValid(input)) {
			locFrom = coordinateToInteger(input,0,2);
			locTo = coordinateToInteger(input,3,5);
			promotedPiece= input.charAt(5);
		}
		else if(input.length()==5) {
			locFrom = coordinateToInteger(input,0,2);
			locTo = coordinateToInteger(input,3,5);
		}else {
			throw new Exception ("invalid coordinate");
		}
		
		if(inputValidation(locTo, locFrom,game)) {
			throw new Exception ("invalid coordinate");
		}
		
		this.locFrom = locFrom;
		this.locTo = locTo;
	}
	
	public MoveCoordinate(Location locFrom, Location locTo) {
		this.locFrom = locFrom;
		this.locTo = locTo;
	}
	
	
	public MoveCoordinate(int x ,int y , int i ,int j,Game game) throws Exception {
		Location locFrom = new Location(x,y);
		Location locTo = new Location(i,j);
		
		this.locFrom = locFrom;
		this.locTo = locTo;
	}
	
	
	private boolean isPromotedInputValid(String input) {
		return input.length()==6 && (input.charAt(5)=='Q'||input.charAt(5)=='R'||input.charAt(5)=='B'||input.charAt(5)=='N');
	}
	


	private boolean inputValidation(Location locTo, Location locFrom,Game game) {
		if(locFrom.getFile()==locTo.getFile() && locFrom.getRank()==locTo.getRank()) {
			return true;
		}
		
		if(game.board[locFrom.getFile()][locFrom.getRank()]==null) 
			return true;
		
		if(locFrom ==null || locTo ==null) 
			return true;
		
		return false;
	}
	
	public Location coordinateToInteger(String locInput,int start , int end) {
		String Position;
		Position = locInput.substring(start,end);
		
		try {
			Location loc = new Location(Position);
			return loc;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public Location getLocFrom() {
		return locFrom;
	}

	public Location getLocTo() {
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

	public char getPromotedPiece() {
		return promotedPiece;
	}

	public void setPromotedPiece(char promotedPiece) {
		this.promotedPiece = promotedPiece;
	}
	

	
	
}
