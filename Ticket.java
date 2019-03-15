
public class Ticket {
	private MovieScreening movieScreening;
	private int ticketId;
	private int popcornflag=1;

	public Ticket(MovieScreening movieScreening,int ticketId) {
		this.movieScreening = movieScreening;
		this.ticketId = ticketId;
	}

	public MovieScreening getTicketscreening() {
		return movieScreening;
	}

	public int getTicketId(){
		return ticketId;
	}
	
	public void freePopcorn() {    //if this ticket had been used to buy popcorn, set the flag = -1
		popcornflag = -1;
	}
	
	public int getPopcornFlag() {
		return popcornflag;
	}
	
	
	public String toString() {
		String s = "Ticket infomation: \n"
				+ movieScreening.getMovie() + "\n" + "Time of the Screening: "
				+ movieScreening.getScreeningTime() + "-" + movieScreening.getEndTime() + "\n" 
				+ movieScreening.getRoom() + "\n"
				+ "TicketId:"
				+ ticketId;
		return s;
	}


}
