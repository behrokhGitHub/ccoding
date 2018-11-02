package buffer;

public class BufferTest {

	public static void main ( String[] args ) {
				
		/*
		 * Testing :
		 * 
		 * 	if the buffer has "foo" at position 0,1,2 and "bar" at position 10,11,12 and nothing else, it would print 4 lines in total:
		 * 		- foobar (the compact string)
		 * 		- 0, foo (i.e. "foo" at position 0)
		 * 		- 3, null x 7 (i.e. 7 nulls at position 3)
		 * 		- 10, "bar"
		 * 
		 */
		 
		Buffer buf = new Buffer();
		
		buf.set(0, 'f');
		buf.set(1, 'o');		
		buf.set(2, 'o');
		
		buf.set(10, 'b');
		buf.set(11, 'a');		
		buf.set(12, 'r');
		
		System.out.println("buffer current size: "+ buf.bufferSize());
		System.out.println("current Map: " + buf.returnMap());
		System.out.println("current Buffer: "+ buf.returnBuffer());
		System.out.println("current positions: "+ buf.CurrPositions());
		
		String output = buf.print();
		System.out.println("the output is: " + output );
		
//		buf.set( 0, 'c');		
//		buf.set(1, 'b');
//		
//		System.out.println("buffer current size: "+ buf.bufferSize());
//		System.out.println("current Map: " + buf.returnMap());
//		System.out.println("current Buffer: "+ buf.returnBuffer());	
//		System.out.println("should return c: " + buf.get(0));
//		System.out.println("should return 1: " + buf.find('b'));
//		
//		System.out.println();
//		
//		buf.set(2, 'e');
//		buf.set(3, 'b');		
//		buf.set(4, 'c');		
//		buf.set(0, 'x');
//		
//		System.out.println("buffer current size: " + buf.bufferSize());
//		System.out.println("current Map: " + buf.returnMap());
//		System.out.println("current Buffer: "+ buf.returnBuffer());	
//		System.out.println("should return x: " + buf.get(0));
//		String output = buf.print();
//		System.out.println("the output is: " + output );
//		
//		System.out.println();
		
//		System.out.println(buf.find('c'));
//		System.out.println(buf.find('b'));
//		System.out.println(buf.find('e'));
//		System.out.println(buf.find('x'));
//		buf.set(0, 'b');
//
//		System.out.println("buffer current size: " + buf.bufferSize());
//		System.out.println("current Map: " + buf.returnMap());
//		System.out.println("current Buffer: "+ buf.returnBuffer());	
//		System.out.println("should return b: " + buf.get(0));
//		output = buf.print();
//		System.out.println("the output is: " + output );
//		
//		System.out.println();
//		
//		System.out.println("Deleting: ");
//		buf.delete(0);
//		System.out.println("buffer current size: " + buf.bufferSize());
//		System.out.println("current Map: " + buf.returnMap());
//		System.out.println("current Buffer: "+ buf.returnBuffer());	
//		System.out.println("current positions: "+ buf.CurrPositions());	
//		System.out.println("should return null: " + buf.get(0));
//		output = buf.print();
//		System.out.println("the output is: " + output );
//		
//		System.out.println();
//		
//		buf.set(0, 'c');
//		System.out.println("buffer current size: " + buf.bufferSize());
//		System.out.println("current Map: " + buf.returnMap());
//		System.out.println("current Buffer: "+ buf.returnBuffer());	
//		System.out.println("current positions: "+ buf.CurrPositions());	
//		System.out.println("should return c: " + buf.get(0));
//		output = buf.print();
//		System.out.println("the output is: " + output );
//
//		System.out.println();
//		
//		buf.set(6, 'c');
//		System.out.println("buffer current size: " + buf.bufferSize());
//		System.out.println("current Map: " + buf.returnMap());
//		System.out.println("current Buffer: "+ buf.returnBuffer());	
//		System.out.println("current positions: "+ buf.CurrPositions());	
//		System.out.println("should return c: " + buf.get(0));
//		
//		System.out.println("should return 0: " + buf.find('c'));
//		System.out.println("should return 1: " + buf.find('b'));
//		output = buf.print();
//		System.out.println("the output is: " + output );
//		
//		System.out.println();
//		
//		buf.set(2, 'b');
//		System.out.println("current Map: " + buf.returnMap());
//		System.out.println("current Buffer: "+ buf.returnBuffer());	
//		System.out.println(buf.find('b'));
//		
//		System.out.println();
//		
//		buf.set(1, 'c');
//		System.out.println("current Map: " + buf.returnMap());
//		System.out.println("current Buffer: "+ buf.returnBuffer());	
//		System.out.println(buf.find('b'));
//		
//		buf.delete(0);
//		System.out.println("current Map: " + buf.returnMap());
//		System.out.println("current Buffer: "+ buf.returnBuffer());	
//		System.out.println(buf.find('c'));
//		
//		output = buf.print();
//		System.out.println("the output is: " + output );
		
	
	}
}

