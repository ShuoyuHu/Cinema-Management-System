

public class Room implements Comparable{
	private int roomNumber;
	private int row;
	private int seatsPerRow;
	

	
	public Room(int roomNumber,int row,int seatsPerRow){
		this.roomNumber = roomNumber;
		this.row = row; 
		this.seatsPerRow = seatsPerRow;
	}
	
	public int compareTo ( Object o){
		Room r = (Room)o;
		return (( Comparable ) roomNumber ). compareTo (r.roomNumber );
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public int getRoomRow() {
		return row;
	}
	
	public int getRoomSeatsPerRow() {
		return seatsPerRow;
	}

	
	public int getRoomSize() {
		return row*seatsPerRow;
	}
		
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	
	
	public String toString() {
		String s = "Room number: " + roomNumber;
		return s;
	}
	


}
