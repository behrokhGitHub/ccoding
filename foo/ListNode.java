package foo;

public class ListNode<T> {
	public ListNode<T> next;
	public Integer data;
	
	public ListNode() {
		this.next = null;
	}
	
	public ListNode(Integer val) {
		this.data = val;
	} 
}

