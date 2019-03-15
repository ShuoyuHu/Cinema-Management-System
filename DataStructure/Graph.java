
public class Graph {
	public class Node implements Comparable {
		private Comparable info;
		private Vector edges;
		
		public Node(Comparable label) {
			info = label;
			edges = new Vector(100); 
			}
		
		public void addEdge(Edge e) {
			edges.addLast(e);
			}
		
		public Vector getEdges() {
			return edges;
		}
		
		public Comparable getSmallestNode() {    //find the smallest weight of this node
			if(edges != null) {
				Edge smallest = (Edge)edges.get(0);
				for(int i = 1; i < edges.size(); i++) {
					if(((Edge)edges.get(i)).weight.compareTo(smallest.weight) == -1){
						smallest = (Edge)edges.get(i);
					}
				}
				return smallest.toNode.info;
			}
			else return -1;
		}

		 
		public int compareTo(Object o) {
			Node n = (Node)o;
			return info.compareTo(n.getLabel());
			}
		
		public Comparable getLabel() {
			return info; 
			}
		
		public String toString() {
			return "Movie:" + info.toString() + ",  Next:" + edges.toString();   //Labels and Edges to string separately
		}
	}
	
	private class Edge implements Comparable {
		private Node toNode;
		public Comparable weight;
		public Edge(Node to,Comparable w) {
			toNode = to;
			weight = w;
		}
		
		public Comparable getWeight() {
			return weight;
		}
		public int compareTo(Object o) {
			Edge n= (Edge)o;
			return n.toNode.compareTo(toNode);
		}
		
		public String toString() {
			return toNode.info.toString() + weight.toString()+" ; ";
		}
	}
			
	private Vector nodes;
	
	public Graph() {
		nodes = new Vector(100); 
		}
	
	public void addNode(Comparable label) {
		nodes.addLast(new Node(label)); 
		}
	
	public Node getNode(int i) {
		return (Node)nodes.get(i);
	}
	

	
	public Node getSmallestEdge(Node n) {        //find the smallest weight edge of node n, used to find the marathonTicket path
		Edge smallest = ((Edge)n.getEdges().get(0));
		for(int i = 1;i <  n.getEdges().size();i++) {
			int index = 0;
			Edge temp = ((Edge)n.getEdges().get(i));
			if(temp.weight.compareTo(smallest.weight) == -1) {
				smallest = temp;
			}
		}
		return smallest.toNode;
	}
	
	public Node findNode(Comparable nodeLabel) {
		return (Node) (nodes.contains2(new Node(nodeLabel)));
	}
	
	public Comparable findLabel(Comparable nodelabel) {
		return findNode(nodelabel).getLabel();
	}
	
	public int size() {
		return nodes.size();
	}
	
	public void addEdge(Comparable nodeLabel1, Comparable nodeLabel2,Comparable weight){
		Node n1 = findNode(nodeLabel1);
		Node n2 = findNode(nodeLabel2); 
		n1.addEdge(new Edge(n2,weight));
	}
	
	public Vector getNodes() {
		Vector allNodes = new Vector(100);
		for(int i =0;i < nodes.size();i++) {
			allNodes.addLast(((Node)nodes.get(i)).getLabel());
		}
		return allNodes;
	}
	
	public Node findPath(Comparable nodeLabel1, Comparable nodeLabel2){
		Node startState = findNode(nodeLabel1);
		Node endState = findNode(nodeLabel2);
		Stacks toDoList = new Stacks(); 
		Queue pathList = new Queue(100);
		toDoList.push(startState); 
		
		while(!toDoList.empty()){
			Node current = (Node)toDoList.pop(); 
			if (current == endState) {
				for(int i =0;i<pathList.size();i++) {
					System.out.print(((Node)pathList.pop()).getLabel());
				}
			}
				
			else{
				for (int i=0; i<current.edges.size(); i++) {
					Edge e = (Edge)current.edges.get(i);
					toDoList.push(e.toNode);
					pathList.push(e.toNode);
					}
			}
		}
	   return null; 
	}
	
	
	public String toString() {
		return  nodes.toString();
	}
	
}
