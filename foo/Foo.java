package foo;

//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;




public class Foo {
	
//	private List<String> list;
//	private ListNode<Integer> head;
//	
//	public Foo() {
//		list = new LinkedList<>();
//		head = null;
//	}
//	
//	/*
//	 * foo.Add(value): insert the "value" string if it's not already in
//	 */
//	public void add ( String value ) {
//		// if ( object doesn't contain the value add it )
//		if ( !contains( value ) ) {
//			list.add( value );
//			
//			if ( list.size() == 1 ) {
//				head = new ListNode( list.get(0) );
//			}
//			
//		}
//	}
//	
//	/*
//	 * foo.Remove(value): remove the "value" string
//	 */
//	public void remove ( String value ) {
//		
//		if ( head.data == value ) {
//			head = head.next;
//		} else {
//		
//			ListNode curr = head;
//			ListNode pre = null;
//		
//			while ( curr.data != value ) {
//				pre = curr;
//				curr = curr.next;
//			}
//		
//			pre.next = curr.next;
//			
//	}
//	
//	/*
//	 * foo.Contains(value): return True if the "value" string is in, otherwise return False
//	 */
//	public boolean contains ( String value ) {
//		
//		for ( int i = 0; i < list.size(); i++ ) {
//			if ( value.equals( list.get(i) ) ) {
//				return true;
//			}
//		}
//		
//		return false;
//	}
//	
//	/*
//	 * foo.Iterator(): return an iterator "it" used to loop chronologically over the strings
//	 */
//	public Iterator<String> iterator () {
//		
//		return new LinkedListIterator();
//	}
//	
//	
//	private class LinkedListIterator implements Iterator<String> {
//		
//		private ListNode curr;
//		private ListNode preOne;
//		private ListNode preTwo;
//		
//		public LinkedListIterator () {
//			curr = head;
//			preOne = null;
//			preTwo = null;
//		}
//		
//
//		@Override
//		public boolean hasNext() {
//			return curr != null;
//		}
//
//		/*
//		 * it.Next(): advance the iterator to the next chronological position and indicate whether the iteration has finished
//		 */
//		@Override
//		public String next() {
//			
//			String result = (String) curr.data;
//			preTwo = preOne;
//			preOne = curr; 
//			curr = curr.next;
//			
//			return result;
//		}
//		
//		
//		/*
//		 * it.Value(): return the value string at the current iterator's position
//		 */
//		public String value() {
//			
//			return (String) curr.data;
//		}
//		
//	}
	
}

