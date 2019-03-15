
public class Queue {
private Vector data;
	
	public Queue(int capacity){
		data=new Vector(capacity);
	}
	
	public void push(Comparable o){
		data.addLast(o);
	}
	
	public Object pop(){
		Object temp=data.getFirst();
		data.removeFirst();
		return temp;
	}
	
	public Object top(){
		return data.getFirst();
	}
	
	public int size(){
		return data.size();
	}
	
	public boolean empty(){
		return data.isEmpty();
	}
	
	
	public String toString(){
		return data.toString()+"\n";
	}

}
