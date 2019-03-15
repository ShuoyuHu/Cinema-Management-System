
public class MovieScreening implements Comparable {
	private Movie movie;
	private int screeningTime;
	private Room room;
	private Seat seat;
	private int soldNumber=0;
	private Queue waitingList;
	//private int endTime=0;


	public MovieScreening(Movie movie, int screeningTime, Room room) {
		
		// TODO Auto-generated constructor stub
		this.movie=movie;
		this.screeningTime=screeningTime;
		this.room=room;
		seat=new Seat(room.getRoomRow(),room.getRoomSeatsPerRow());
		waitingList=new Queue(100);
	}
	
	public int compareTo (Object o){
		MovieScreening ms = (MovieScreening)o;
		if(movie.compareTo(ms.movie)==0 && room.compareTo(ms.room) == 0 
				&& screeningTime == ms.screeningTime) {
			 return 0;
		}
		else return -1;
				
				
	}
	

	public void setScreeningTime(int screeningTime) {
		this.screeningTime = screeningTime;
	}

	public void setMovie(Movie movie) {
		this.movie= movie;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Movie getMovie() {
		return movie;
	}
	
	public int getScreeningTime() {
		return screeningTime;
	}
	
	public int getEndTime() {
		return screeningTime + movie.getLength();
	}

	public Room getRoom() {
		return room;
	}

	public Seat getSeat() {
		return seat;
	}
	
	public int getSoldNumber(){
		return soldNumber;
	}
	
	public int getRestNumber(){
		return (room.getRoomSize()-soldNumber);
	}
	
	public void addSoldNumber(){
		soldNumber++;
	}
	
	public void addWaitinglist(String name){
		waitingList.push(name);
		
	}
	
	public Queue getWaitingList(){
		return waitingList;
	}

	public String toString() {
		String s = "Movie: " + movie.getTitle() +" "+ " screeningTime: "+ screeningTime + " Room Number: "
				+ room.getRoomNumber();
		return s;
	}


}
