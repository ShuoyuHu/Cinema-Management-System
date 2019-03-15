public class Dictionary  {
	
	public class DictionaryPair implements Comparable{
		private Comparable key ;
		private Object value ;
		public DictionaryPair ( Comparable someKey ,Object someValue ){
			this.key=someKey;
			this.value=someValue;
		}
		public Object getKey (){
			return key;
	    }
		public Object getValue(){
			return value;
		}
	
		public void setKey ( Comparable newKey ){
			key = newKey;
		}
	
		public void setValue ( Object newValue ){
			value = newValue;
		}
		
		public int compareTo(Object o) {
			DictionaryPair d =(DictionaryPair)o;
			return key.compareTo(d.getKey());
		}
	
	}
	
	private Vector data ;
	public Dictionary (){
		data = new Vector(100);
	}
	
	public void add(Comparable key , Object value ){
		DictionaryPair d = new DictionaryPair(key,value);
		data.addLast(d);
	}
	
	public void remove(Comparable key) {
		data.remove(findPosition(key));
	}
	
	public int size() {
		return data.size();
	}
	
	public int findPosition (Comparable key){
		for(int i =0;i<data.size();i++){
			if(((DictionaryPair)data.get(i)).getKey().equals(key)){
				return i;
			}
		}
		return -1;
	}
	public Object find(Comparable key){
		for(int i =0;i<data.size();i++){
			if(((DictionaryPair)data.get(i)).getKey().equals(key)){
				return ((DictionaryPair)data.get(i)).getValue();
			}
		}
		return null;
	}
	

}
