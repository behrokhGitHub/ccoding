package buffer;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * Implement a buffer data structure "Buffer" that allows setting a character at a given position 
 * (indexes from 0 and up) in the buffer, and finding the lowest position of a given character.  
 * As before, design the interfaces and analyze each method's big-O.  
 * After this is done, also add support for deleting a character from a position:
 * buf.Set(position, character)
 * buf.Find(character)
 * additional work: buf.Delete(position)
 */

public class Buffer {
	
	private HashMap<Integer, Character> buffer;
	private HashMap<Character, PriorityQueue<Integer>> map;
	private Integer size;
	
	
	public Buffer() {
		buffer = new HashMap<>();
		map = new HashMap<>();
		size = 0;
	}
	
	
	public void set ( Integer position, Character c ) {
		
		if ( !buffer.containsKey(position) ) {
		
			buffer.put(position, c);
			this.updateMap(c, position);
			size++;
			
		} else {
			
			Character curr = buffer.get(position);
			PriorityQueue<Integer> temp = map.get(curr);
			temp.remove(position);
			map.put(curr, temp);
			buffer.remove(position, curr);
			buffer.put(position, c);
			this.updateMap(c, position);
			
		}
		
	}
	
	
	public Integer find ( Character c ) {
		
		if ( !map.containsKey(c) ) {
			return null;
		} else {
			return map.get(c).peek();
		}
		
	}
	
	
	public void delete ( Integer position ) {
		
		Character curr = buffer.get(position);
		
		if ( curr != null ) {
			
			map.get(curr).remove(position);
			
		}
		
		buffer.remove(position);
		
		size--;
	}


	public HashMap<Integer, Character> returnBuffer () {
		return buffer;
	}

	
	public int size() {
		return size;
	}
	
	
	public Character get ( Integer position ) {
		
		return buffer.get(position);
	}
	
	
	public HashMap<Character, PriorityQueue<Integer>> returnMap() {
		return map;
	}
	
	
	private void updateMap ( Character c, Integer position ) {
		
		if ( !map.containsKey(c) ) {
			
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			pq.offer(position);
			map.put(c, pq);
				
		} else {
			
			map.get(c).offer(position);			
		}
		
	}
		
}


