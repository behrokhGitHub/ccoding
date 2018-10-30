package buffer;

public class BufferTest {

	public static void main ( String[] args ) {
				
		Buffer buf = new Buffer();
		
		buf.set( 0, 'c');		
		buf.set(1, 'b');
		
		System.out.println("buffer current size: "+ buf.size());
		System.out.println("current Map: " + buf.returnMap());
		System.out.println("current Buffer: "+ buf.returnBuffer());	
		System.out.println("should return c: " + buf.get(0));
		System.out.println("should return 1: " + buf.find('b'));
		
		System.out.println();
		
		buf.set(2, 'e');
		buf.set(3, 'b');		
		buf.set(4, 'c');		
		buf.set(0, 'x');
		
		System.out.println("buffer current size: " + buf.size());
		System.out.println("current Map: " + buf.returnMap());
		System.out.println("current Buffer: "+ buf.returnBuffer());	
		System.out.println("should return x: " + buf.get(0));
		
		System.out.println();
		
		System.out.println(buf.find('c'));
		System.out.println(buf.find('b'));
		System.out.println(buf.find('e'));
		System.out.println(buf.find('x'));
		buf.set(0, 'b');

		System.out.println("buffer current size: " + buf.size());
		System.out.println("current Map: " + buf.returnMap());
		System.out.println("current Buffer: "+ buf.returnBuffer());	
		System.out.println("should return b: " + buf.get(0));
		
		System.out.println();
		
		System.out.println("Deleting: ");
		buf.delete(0);
		System.out.println("buffer current size: " + buf.size());
		System.out.println("current Map: " + buf.returnMap());
		System.out.println("current Buffer: "+ buf.returnBuffer());	
		System.out.println("should return b: " + buf.get(0));
				
		System.out.println();
		
		buf.set(0, 'c');
		System.out.println("buffer current size: " + buf.size());
		System.out.println("current Map: " + buf.returnMap());
		System.out.println("current Buffer: "+ buf.returnBuffer());	
		System.out.println("should return x: " + buf.get(0));

		System.out.println();
		
		buf.set(6, 'c');
		System.out.println("buffer current size: " + buf.size());
		System.out.println("current Map: " + buf.returnMap());
		System.out.println("current Buffer: "+ buf.returnBuffer());	
		System.out.println("should return x: " + buf.get(0));
		
		System.out.println("should return 0: " + buf.find('c'));
		System.out.println("should return 1: " + buf.find('b'));
		
		System.out.println();
		
		buf.set(2, 'b');
		System.out.println("current Map: " + buf.returnMap());
		System.out.println("current Buffer: "+ buf.returnBuffer());	
		System.out.println(buf.find('b'));
		
		System.out.println();
		
		buf.set(1, 'c');
		System.out.println("current Map: " + buf.returnMap());
		System.out.println("current Buffer: "+ buf.returnBuffer());	
		System.out.println(buf.find('b'));
		
		buf.delete(0);
		System.out.println("current Map: " + buf.returnMap());
		System.out.println("current Buffer: "+ buf.returnBuffer());	
		System.out.println(buf.find('c'));
	}
}

