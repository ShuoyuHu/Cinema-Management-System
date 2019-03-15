
public class Cinema implements ICinema {
	private Vector movies;
	private Vector rooms;
	private Graph movieScreeningGraph;
	private Dictionary ticketList;
	private int waitNumber=0;
	private int cancelCount=0;
	private int ticketCount=0;

	
	public Cinema(){
		movies=new Vector(10);
		rooms=new Vector(10);
		movieScreeningGraph=new Graph();
		ticketList=new Dictionary();
		
	}
	
	//add new movie if the movieTitle have not been added in the movieList
	public void addMovie(String movieTitle,int length){
		if(!movies.contains(movieTitle)) {
			Movie movie=new Movie(movieTitle,length);
			movies.addLast(movie);
		}
		
		
	}
	
	
	public Object getMovielist(){
		return movies;
	}
	
	//add new room if the roomNumber have not been added
	public void addRoom(int number, int rows, int seatsPerRow){
		if(!rooms.contains(number)) {
			Room room=new Room(number,rows,seatsPerRow);
			rooms.addLast((Comparable)room);
		}
		
	}
	
	public Object getRoomlist(){
		return rooms;
	}
	 
	//to find the required MovieScreening, return MovieScreening type
	public MovieScreening getMovieScreening(String movieTitle,int screeningTime, int roomNumber){
		return (MovieScreening)movieScreeningGraph.findLabel(new MovieScreening(new Movie(movieTitle,0),screeningTime,new Room(roomNumber,0, 0)));
	
	}
	
	//find the required Movie with specific movieTitle
	private Movie getMovie(String movieTitle){
		Movie movie = null;
		for (int i = 1; i <= movies.size(); i++){
			if (((Movie)movies.get(i - 1)).getTitle().equals(movieTitle)){
				movie = (Movie) movies.get(i - 1);
				break;
			}
		}
		return movie;
	}
	
	//find the required Room with specific roomNumber
	private Room getRoom(int roomNumber){
		Room room = null;
		for(int i = 1;i <= rooms.size();i++){
			if(((Room)rooms.get(i - 1)).getRoomNumber()==roomNumber){
				room = (Room) rooms.get(i - 1);
				break;
			}
		}
		return room;
	
	}
	
	//add new movieScreening to the movieScreeningGraph when the movie and the playing room exist
	//consider the movieScreening as the label of a node
	public void addScreening(String movieTitle, int screeningTime, int roomNumber){
		Movie movie = this.getMovie(movieTitle);
		Room room =this.getRoom(roomNumber); 
		if(movie!= null && room!= null) {      
			MovieScreening ns =new MovieScreening(movie,screeningTime,room);
			movieScreeningGraph.addNode(ns);
			Vector tempVector = movieScreeningGraph.getNodes(); //the return value are just the labels of all nodes
			for(int i =0;i < tempVector.size();i++) {          //consider the new screening as a new node,and add this node to the whole graph
				MovieScreening temp = (MovieScreening)tempVector.get(i);   //traverse the graph, if the screeningTime of new screening is later 
				if(screeningTime >= temp.getEndTime()) {                  //than the node[i], then create an new edge from node[i] to the new one
					movieScreeningGraph.addEdge(temp, ns, 0);            
				}
				if(screeningTime + temp.getMovie().getLength() < temp.getScreeningTime()) {   //otherwise create an edge from the new one to node[i]
					movieScreeningGraph.addEdge(ns,temp, 0);
				}
			}
		}
		
	}
	
	
	public Graph getMovieScreeningGraph(){
		return movieScreeningGraph;
	}
		
	//buy a ticket randomly
	public int buyTicket(String movieTitle, int screeningTime,int roomNumber){
		MovieScreening movieScreening = this.getMovieScreening(movieTitle, screeningTime,roomNumber);
		if(movieScreening != null&&movieScreening.getRestNumber() != 0){      //can buy a ticket when the movieScreening exists and the room still has empty seats
			for(int i = 0;i < movieScreening.getSeat().getRow();i++) {        
				for(int j = 0;j < movieScreening.getSeat().getSeatsPerRow();j++) {
					if(movieScreening.getSeat().getState(i, j)) {          //just find a seat is empty (the state of the seat is true)
						ticketCount++;                                    //buy a ticket with this seat, and set this seat is occupied
						Ticket newTicket = new Ticket(movieScreening,ticketCount);
						ticketList.add(ticketCount, newTicket);
						movieScreening.addSoldNumber();
						movieScreening.getSeat().seatSold(i, j);
						return ticketCount;
					}
				}
			}	
		 return -1;
		}	
		return -1;
	}
	
	//buy a ticket with specific row and column
	public int buyTicket(String movieTitle,int room, int screeningTime, int row, int seat) {
		MovieScreening movieScreening = this.getMovieScreening(movieTitle, screeningTime, room);
		if(movieScreening != null&&movieScreening.getRestNumber() != 0) {
			if(movieScreening.getSeat().getState(row-1, seat-1)) {      //check whether this seat is already occupied, if not,buy it 
				ticketCount++;
				Ticket newTicket = new Ticket(movieScreening,ticketCount);
				ticketList.add(ticketCount, newTicket);
				movieScreening.addSoldNumber();
				movieScreening.getSeat().seatSold(row-1, seat-1);
				return ticketCount;
			}
			else return -1;
		}
	   return -1;
	}
	
	//print the mapSeat of a movieScreening
	public void printScreening(String movieTitle, int room, int screeningTime) {
		MovieScreening movieScreening = this.getMovieScreening(movieTitle, screeningTime, room);
		movieScreening.getSeat().printSeatMap();
	}
	
	/*assume the start of this graph is the first element, from this node, find the smallest weight edge of it
	 and add this node to a queue(if the Queue doesn't have this movie yet),then let this node be the start and 
	 do again until reach a leaf node(the vector edges of a leaf node is null),then stop */
	public void getScreeningsForMarathonTicket() {
		Comparable startNode = movieScreeningGraph.getNode(0).getLabel();
		Queue marathonTicket = new Queue(100);
		marathonTicket.push(startNode);
		while(movieScreeningGraph.findNode(startNode).getEdges() != null) {
			if(!marathonTicket.equals(((MovieScreening)startNode).getMovie().getTitle())) {
				Comparable temp = movieScreeningGraph.findNode(startNode).getSmallestNode();
				startNode = temp;
				marathonTicket.push(temp);
			}
		}
		for(int i =0;i < marathonTicket.size();i++) {
			System.out.println(marathonTicket.pop().toString());
		}
			
	}
	
	//cancel a ticket
	public void cancelTicket(int ticketId){
		ticketList.remove(ticketId);
		cancelCount++;
					
	}
	
	//find the ticket with specific ticketId
	public Ticket getTicket(int ticketId) {
		return (Ticket)ticketList.find(ticketId);
	}
	
	public void getTicketInformation(int ticketId) {
		Ticket t = (Ticket)ticketList.find(ticketId);
		System.out.println(t.toString());
	}
	
	//buy a popcorn
	public void getFreePopcorn(int ticketID) {
		Ticket ticket = this.getTicket(ticketID);
		if(ticket.getPopcornFlag()==1) {    //check the popcorn flag of this ticket
			ticket.freePopcorn();
			System.out.println("You can get a free popcorn!");
		}
		else {
			System.out.println("Sorry,you can't get a free popcorn!");
		}
	}
	
	
	public void getOnWaitingList(String movieTitle, int screeningTime,int roomNumber,String customerName){
		MovieScreening moviescreening = this.getMovieScreening(movieTitle, screeningTime, roomNumber);
		if(moviescreening.getRestNumber()!=0) return;   //if the room still has empty seats, do not need to wait
		else moviescreening.addWaitinglist(customerName);   //otherwise add the customerName to the waitingList
		
	}
	
	public int getSoldTicketCount(){
		return ticketCount-cancelCount;
		
	}
	
	public void printAllScreenings(){
		for(int i=0;i<movieScreeningGraph.size();i++){
			System.out.println(((MovieScreening)movieScreeningGraph.getNode(i).getLabel()).toString());
		}
		
	}
	
	//print the waitingList of a specific movieScreening
	public void printWaitingList(String movieTitle, int screeningTime, int roomNumber){
		MovieScreening moviescreening = this.getMovieScreening(movieTitle, screeningTime, roomNumber);
	    System.out.println(moviescreening.getWaitingList());
		
	}
		
		
}	


