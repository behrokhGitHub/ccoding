package Cache;

import java.util.HashMap;

public class LRUCache {
	
	private int memUsed;
	private int maxSize;
	
	private HashMap < String, Record > map;
	private ListElement lruOrderStart;
	private ListElement lruOrderEnd;
	
	/*
	 * Given that memory is not infinite, it takes a parameter in the constructor 
	 * that puts a limit on the amount of memory the cache can hold.
	 */
	public LRUCache ( int capacity ) {
		
		map = new HashMap<>();
		lruOrderStart = null;
		lruOrderEnd = null;
		
		maxSize = capacity;
		memUsed = 0;
		
	}
	
	/*
	 * So it must also keep track of the sum of memory used (for example the sum of the lengths of the values given to the Put)
	 * You may offer here to simplify the question and ask if the values can be limited to strings or arrays of bytes 
	 * (something simple enough to compute its size or length, in order to keep track of memory used)
	 * If not, maybe the interviewer is willing to assume the existence of a general purpose 
	 * sizeOfObject() function the candidate could use without having to dive into all the ways to compute the memory 
	 * usage of any generic object used in the value.
	 */
	public int sizeOfObject ( String key ) {
		return map.get(key).value.length();
	}
	
	public int memoryUsedSoFar () {
		return memUsed; 
		
	}
	
	/*
	 * Given all this, the last part of the design is what to do when a new Put() causes the total memory 
	 * used to exceed the limit.  At this point, the Put must first delete (remove) from the cache enough 
	 * entries to reduce memory usage by at least the size of the object about to be stored by the Put.  
	 * The requirement is for LRU (least recently used), so that means the objects must also be tracked 
	 * in reverse usage order.  To keep things fast, this can also be done O(1),so no use of sorting 
	 * (n.log(n)) or priority queues (log(n) per add or remove).
	 */
	public String get ( String key ) {
		
		if ( map.containsKey(key) ) {
			Record record = map.get(key);
		
			ListElement node = record.listEntry;
		
			// remove it from the list
			// insert it at end of the list
			if ( node != null ) {
			
			removeFromLinkedList(node);
			insertAtEndOfLinkedList(node);
			
			}
			return record.value;
		}
		
		return  null ;
	}
	
	
	// remove the node from current place
	private void removeFromLinkedList ( ListElement node ) {
		
		if ( node.pre != null ) {
			node.pre.next = node.next;
		}
		
		if ( node.next != null ) {
			node.next.pre = node.pre;
		}
		
		if ( node == lruOrderStart ) {
			lruOrderStart = node.next;
		}
		
		if ( node == lruOrderEnd ) {
			lruOrderEnd = node.pre;
		}
		
	}
	
	// insert at front of linked list
	private void insertAtEndOfLinkedList ( ListElement node ) {
	
		if ( lruOrderEnd == null ) {
			lruOrderStart = node;
			lruOrderEnd = node;
		} else {
			lruOrderEnd.next = node;
			node.pre = lruOrderEnd;
			lruOrderEnd = node;
		}			
	}
	
	public void put ( String key, String value ) {
		
		ListElement newNode = new ListElement(key);
		Record record = new Record ( value, newNode ); 
		
		if ( map.containsKey(key) ) {
			removeKey(key);
		}
		
		int currValueLength = value.length();
		
		while ( this.memUsed + currValueLength > this.maxSize ) {
				
				String lruOrderStartKey = this.lruOrderStart.key;
				
				int headValueLength = this.sizeOfObject(lruOrderStartKey);
				
				this.removeFromLinkedList(lruOrderStart);
				map.remove(lruOrderStartKey);
				
				this.memUsed -= headValueLength;
				System.out.println( "this.memUsed: " + this.memUsed );				
		}
		
		insertAtEndOfLinkedList( newNode );
		map.put( key, record);
		
		// updating memUsed
		this.memUsed += currValueLength;
		
	}

	public void removeKey ( String key ) {
		
		Record record = map.get(key);
		ListElement listEntry = record.listEntry;
		
		memUsed -= record.value.length();
				
		this.removeFromLinkedList(listEntry);
		
		map.remove(key);
		
	}

	class ListElement {
		
		public String key;
		public ListElement next;
		public ListElement pre;
		
		public ListElement ( String k ) {
			this.key = k;	
		}
	}

	class Record {
		
		public String value;
		public ListElement listEntry;
		
		public Record ( String val, ListElement listEntry ) {
			this.value = val;
			this.listEntry = listEntry;
			
		}
	}

}
