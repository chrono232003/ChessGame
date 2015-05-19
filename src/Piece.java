
public class Piece {
	
	int currentPositionX;
	int currentPositionY;

	public void create(int x, int y) {
		this.currentPositionX = x;
		this.currentPositionY = y;
	}
	
	
	public void move(int x, int y) {
		if (((currentPositionX + x < 7)|| currentPositionX <= 0) && ((currentPositionY + y < 7) || currentPositionY <= 0)) {
			currentPositionX = currentPositionX + x;
	        currentPositionY = currentPositionY + y;
        } else {
            System.out.println("This is an invalid move, please select another move");
        }
    }
	
	public void moveCheck() {

		int pieceX = currentPositionX + 1;
		int pieceY = currentPositionY;
		int countUpX = 0;
		int countUpY = 1;
		
		while(Board.values[pieceX][pieceY] == "X" && pieceX < 8) {
			countUpX = countUpX + 1;
			pieceX = pieceX + 1;
		}
		System.out.println("The count of X axis moves is " + countUpX);
	}
	
}