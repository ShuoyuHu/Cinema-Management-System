
public class Movie implements Comparable{
	private String title;
	private int length;

	public Movie(String title, int length) {
		this.title = title;
		this.length = length;
	}
	public int compareTo ( Object o){
		Movie m = (Movie)o;
		return (( Comparable ) title ). compareTo (m.title );
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
	public void setTitle(String title){
		this.title=title;
	}
	
	public void setLength(int length){
		this.length=length;
	}
	
	public String toString() {
		String s = "Title: " + title + ", Length: " + length;
		return s;
	}


}
