
public class Seat {
	private int row;
	private int seatsPerRow;
	private boolean[][] state;
	
	public Seat(int row,int seatsPerRow) {
		this.row = row;
		this.seatsPerRow = seatsPerRow;
		state=new boolean[row][seatsPerRow];
		for(int i=0;i<row;i++) {
			for(int j=0;j<seatsPerRow;j++) {
				state[i][j] = true;
			}
		}
	}
	
	public int getRow() {
		return row;
	}
	
	public int getSeatsPerRow() {
		return seatsPerRow;
	}
	
	public boolean getState(int row,int seatsPerRow) {
		return state[row][seatsPerRow];
	}
	
	public void seatSold(int row,int seatsPerRow) {     // If this ticket is bought,set its state 'false'
		state[row][seatsPerRow] = false;
	}

	public void printSeatMap() {                      //print the states line by line
		for(int i = 0;i < row;i++) {
			for(int j =0; j <seatsPerRow;j++) {
				System.out.print(state[i][j]+" ");
			}
			System.out.println("\n");
		}
	}
	public String toString() {
		return "";
	}


}
