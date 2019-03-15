
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Cinema cinema1=new Cinema();
		
		cinema1.addMovie("Movie1",2);                  //Add movies
		cinema1.addMovie("Movie2",3);
		cinema1.addMovie("Movie3",1);
		cinema1.addMovie("movie4",2);
		               
		cinema1.addRoom(1, 1,1);                     //Add rooms
		cinema1.addRoom(2, 10,10);
		cinema1.addRoom(1, 20,10);
		cinema1.addRoom(3, 10,30);
		
//		System.out.println(cinema1.getMovielist());    //Test Movielist
//		System.out.println(cinema1.getRoomlist());     //Test Roomlist
		
		cinema1.addScreening("Movie1", 1, 1);          //Add movieSceenings
		cinema1.addScreening("Movie2", 4, 2);
		cinema1.addScreening("Movie3", 8, 3);
		cinema1.addScreening("Movie2", 5, 3);
		cinema1.addScreening("Movie3", 4, 1);
		
		System.out.println(cinema1.getMovieScreeningGraph());
		
		System.out.println("your ticketId is: "+ cinema1.buyTicket("Movie1", 1,1));       //Test butTicket and seatMap
		System.out.println("your ticketId is: "+ cinema1.buyTicket("Movie1", 1,1));
		System.out.println("your ticketId is: "+ cinema1.buyTicket("Movie2", 4,2));
		System.out.println("your ticketId is: "+ cinema1.buyTicket("Movie2", 2,4,1,1));   //buyTicket with row and column
		System.out.println("your ticketId is: "+ cinema1.buyTicket("Movie2", 2,4,5,2));
		System.out.println("your ticketId is: "+ cinema1.buyTicket("Movie2", 2,4,6,7));
		System.out.println("your ticketId is: "+ cinema1.buyTicket("Movie2", 2,4,2,2));
		
//		System.out.println("the seatMap of room2:");        //Test seatMap of room2
//		cinema1.printScreening("Movie2", 2, 4);
		
		System.out.println("your ticketId is: "+ cinema1.buyTicket("Movie3", 8,3)+"\n");
		cinema1.getTicketInformation(1);
		
		cinema1.cancelTicket(2);
		
//		System.out.println("SoldTicketCount= "+cinema1.getSoldTicketCount()+"\n");      //Test the total sold tickets number of the cinema
		
		System.out.println("\n");   
		cinema1.getOnWaitingList("Movie1", 1, 1,"A");
		cinema1.getOnWaitingList("Movie1", 1, 1,"B");
		cinema1.getOnWaitingList("Movie1", 1, 1,"C");
		cinema1.getOnWaitingList("Movie2", 4, 2,"D");
		cinema1.getOnWaitingList("Movie2", 4, 2,"E");
		
//		System.out.println("The WaitingList of <movie: Movie1 ;screeningTime: 1 ;room: 1> :");     //Test waitingList
//		cinema1.printWaitingList("Movie1", 1, 1);
		
		System.out.println("All Today Screenings are:");
		cinema1.printAllScreenings();
		
		System.out.println("\n");          
		
//		cinema1.getFreePopcorn(1);      //Test one ticket only can buy popcorn once 
//		cinema1.getFreePopcorn(1);
		
		
		
		
		
		
		
	}

}
