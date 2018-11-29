package Cache;

public class LRUCacheTest {
	
	public static void main ( String[] args ) {
		
		LRUCache cache = new LRUCache( 5 );

		cache.put( "1", "12") ;
		System.out.println( cache.memoryUsedSoFar() );
		cache.put("2", "21");
		System.out.println( cache.memoryUsedSoFar() );
		System.out.println( cache.get("1") );    
		cache.put("3", "100");
		System.out.println( cache.memoryUsedSoFar() );
		System.out.println( cache.get("2") );
		System.out.println( cache.get("3") );    
		System.out.println( cache.memoryUsedSoFar() );
	}

}
