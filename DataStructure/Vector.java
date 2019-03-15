
public class Vector {
	private Comparable data[];
	private int count;

	public Vector(int capacity) {
		data = new Comparable[capacity];
		count = 0;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public Comparable get(int index) {
		return data[index];
	}

	public void set(int index, Comparable obj) {
		data[index] = obj;
	}

	public boolean contains(Comparable obj) {
		for (int i = 0; i < count; i++) {
			if (data[i] == obj)
				return true;
		}
		return false;
	}

	public Comparable contains2(Comparable obj) {
		for(int i = 0;i < count;i++) {
			if(data[i].compareTo(obj) == 0)
				return data[i];
		}
		return null;
	}
	public void addFirst(Comparable item) {
		// add your code
		for (int i = count - 1; i >= 0; i--) {
			data[i + 1] = data[i];
		}
		count += 1;
		data[0] = item;
	}

	public void addLast(Comparable o) {
		if (data.length <= count) {
			extendCapacity();
		}
		data[count] = o;
		count++;
	}

	/*
	 * public boolean binarySearch(Object key) { int start = 0; int end = count - 1;
	 * while(start <= end) { int middle = (start + end + 1) / 2; if(key <
	 * data[middle]) end = middle -1; else if(key > data[middle]) start = middle +
	 * 1; else return true; } return false; }
	 */

	public Object getFirst() {
		// add your code
		return data[0];
	}

	//
	public Object getLast() {
		// add your code
		return data[count - 1];
	}

	public void removeLast() {
		// add your code
		count -= 1;
	}
	
	public void remove(int k) {
		for(int i = k;i<count;i++) {
			data[i] = data[i+1];
		}
	}

	public void remove(Object o){
		for(int i = 0;i < count;i++){
			if(data[i] == o){
				data[i] = null;
			}
		}
	}
	public void removeFirst() {
		// add your code
		for (int i = 0; i < count - 1; i++) {
			data[i] = data[i + 1];
		}
		count -= 1;
	}

	public void reverse() {
		// add your code
		for (int i = 0; i <= (count - 1) / 2; i++) {
			Comparable datatemp = data[i];
			data[i] = data[count - i - 1];
			data[count - i - 1] = datatemp;
		}
	}

	public Vector doubleVector() {
		Vector VectorDouble = new Vector((2 * count));
		for (int i = 0; i < count; i++) {
			VectorDouble.addLast(data[i]);
			VectorDouble.addLast(data[i]);
		}
		return VectorDouble;
	}

	public Vector interleave(Vector v2) {
		Vector InterleaveVector = new Vector(count + v2.size());
		if (count < v2.size()) {
			for (int i = 0; i < count; i++) {
				InterleaveVector.addLast(data[i]);
				InterleaveVector.addLast(v2.get(i));
			}
			for (int j = count; j < v2.size(); j++) {
				InterleaveVector.addLast(v2.get(j));
			}
		} else {
			for (int i = 0; i < v2.size(); i++) {
				InterleaveVector.addLast(data[i]);
				InterleaveVector.addLast(v2.get(i));
			}
			for (int j = v2.size(); j < count; j++) {
				InterleaveVector.addLast(data[j]);
			}
		}
		return InterleaveVector;
	}

	private void extendCapacity() {
		Comparable[] data2 = new Comparable[count * 2 - 1];
		for (int i = 0; i < count; i++) {
			data2[i] = data[i];
		}
		data = data2;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < count; i++) {
			s += this.get(i).toString();
			s += "\n";
		}
		return s;
	}



}
