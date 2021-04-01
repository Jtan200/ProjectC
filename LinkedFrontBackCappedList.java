import java.util.StringJoiner;

public class LinkedFrontBackCappedList<T> implements FrontBackCappedListInterface<T> {

	private Node head, tail;
    int maximumSize; 
    int size;
    
   // YOUR CLASS HERE!
    
    //constructor
	public LinkedFrontBackCappedList(int maximumSize) {
		this.maximumSize = maximumSize;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isFull() {
		if(size == maximumSize) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	public void clear() {
		head = null;
		tail = head;
	}
	
	public T getEntry(int givenPosition) {
		int position = 0;
		Node current = head;
		
		while(current!=null && position!=givenPosition) {
			current = current.next;
			position++;
		}
		
		//return current.data;
		return null;
	}
	
	public boolean contains(T anEntry) {
		Node current = head;
		
		while(current!=null) {
			if(current!=null && current.data.equals(anEntry)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	public int indexOf(T anEntry) {
		int position = 0;
		Node current = head;
		
		while(current!=null) {
			if(current.data.equals(anEntry)) {
				return position;
			}
			current = current.next;
			position++;
		} 
		
		return -1; //if not found
	}
	
	public int lastIndexOf(T anEntry) {
		Node current = tail;
		int position = 0;
		
		while(current!=null) {
			if(current.data.equals(anEntry)) {
				return position;
			}
			current = current.next;
			position++;
		}
		
		return -1; //if not found
	}
	
	public boolean addFront(T newEntry) {
		if(!isFull()) {
			Node newNode = new Node(newEntry);
			head = newNode;
			size++;
			if(size == 1) { //tail also has to be the head if singleton list
				tail = head;
			}
			return true;
		}
		return false;
	}
	
	public boolean addBack(T newEntry) {
		/*
		if(!isFull()) {
			Node newNode = new Node(newEntry);
			newNode.next = tail;
			tail = newNode;
			size++;
			return true;
		}
		*/
		return false;
	}
	
	public T removeFront() {
		T removed = null;
		
		if(head!=null) {
			removed = head.data;
			head = head.next;
			size--;
		}
		return removed;
	}

	public T removeBack() {
		T removed = null;
		/*
		if(tail!=null) {
			removed = tail.data;
			tail = null;
			size--;
		}
		*/
		return removed;
	}
	
	//how to display things properly?
	public String toString() {
		String string = "";
		
		/* 
		Node current = head;
		while(current!=null) {
			System.out.println(current.data);
			current = current.next;
		}
        */
		
		if(size==0) {
			string = "[]" + "  " + "size=" + size + "    " + "capacity:" + maximumSize;
		} else if(head!=null) {
			string = "[" + "]" + "  " + "size=" + size + " " + "capacity=" + maximumSize + "     " 
					+ "head=" + head.data + " " + "tail=" + tail.data;
		}
		
		return string;
	}

	public class Node {
		public T data; 
		public Node next; 

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		}

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}

		private T getData() {
			return data;
		}

		private void setData(T newData) {
			data = newData;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} 
	}

	public int compareTo(LinkedFrontBackCappedList<T> listB) {
		// TODO Auto-generated method stub
		return 0;
	} 
}
