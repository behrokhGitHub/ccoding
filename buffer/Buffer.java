package buffer;

import java.util.Collections;
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
	
	// adding this to keep track of occupied indices in the buffer: 
	private PriorityQueue<Integer> trackPositions;
	
	// actual number of characters inside the buffer
	private Integer numOfChars;
	
	// private Integer size;
	
	
	public Buffer() {
		buffer = new HashMap<>();
		map = new HashMap<>();
		
		// this priority queue keeps track of indices in reverse order ( max heap )
		trackPositions = new PriorityQueue<Integer>(Collections.reverseOrder());
		numOfChars = 0;
		
		// size = 0;
	}
	
	
	public void set ( Integer position, Character c ) {
		
		// if buffer does not contain position, simply add it to both buffer and map.
		if ( !buffer.containsKey(position) ) {
		
			buffer.put(position, c);
			
			trackPositions.add(position);
			numOfChars++;
			
			this.updateMap(c, position);
			
			//size++;
			
		} else {
			
			Character curr = buffer.get(position);
			
			// removing from map
			PriorityQueue<Integer> temp = map.get(curr);
			temp.remove(position);
			
			if ( temp.size() != 0 ) {
				map.put(curr, temp);
			} else {
				// removing character from map if its PriorityQueue size is zero.
				map.remove(curr);
			}
			
			// removing from buffer
			buffer.remove(position, curr);	
			
			// updating buffer and map with (position, c).
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
			
			// removing character from map if its PriorityQueue size is zero.
			if ( map.get(curr).size() == 0 ) {
				map.remove(curr);
			}
			
		}
		
		trackPositions.remove(position);
		numOfChars--;
		buffer.remove(position);
		
		// size--;
		
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
	
	
	public String print () {
		
		String output = "";
		
		for ( int i = 0; i <= maxIndex(); i++ ) {
			
			if ( buffer.get(i) != null ) {
				output += buffer.get(i);
			} 
		
		}
		return output;
	}
	
	
	public HashMap<Integer, Character> returnBuffer () {
		return buffer;
	}

	
	public int bufferSize() {
		return numOfChars;
	}
	
	
	public int maxIndex() {
		return trackPositions.peek();
	}
	
	
	public PriorityQueue<Integer> CurrPositions() {	
		return trackPositions;	
	}
	
	
	public Character get ( Integer position ) {
		return buffer.get(position);
	}
	
	
	public HashMap<Character, PriorityQueue<Integer>> returnMap() {	
		return map;	
	}
	
}


