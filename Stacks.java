
public class Stacks {
	
	private Vector data;
	
	public Stacks(){
		data=new Vector(100);
	}
		
	
	public void push(Comparable o){
		data.addLast(o);
	}
	
	public Object pop(){
	    Object temp=data.getLast();
		data.removeLast();
		return temp;
	}
	
	public Object top(){
		return data.getLast();
	}
	
	public int size(){
		return data.size();
	}
	
	public boolean empty(){
		return data.isEmpty();
		
	}
	

}
