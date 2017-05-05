//Insert a value into sorted array

public ListNode insert(int val, ListNode head){
	id(head == null){
		return new ListNode(val);
	}
	ListNode dummy = new ListNode(0);
	ListNode newNode = new ListNode(val);
	dummy.next = head;
	ListNode cur = head;
	ListNode pre = dummy;
	while(cur != null && cur.val < val){
		pre = cur;
		cur = cur.next;
	}
	pre.next = newNode;
	newNode.next = cur;
	return dummy.next;
}


//merge two sorted lists

public class Solution {
  public ListNode merge(ListNode one, ListNode two) {
    if(one == null && two == null){
      return one;
    }
    if(one == null){
      return two;
    }
    if(two == null){
      return one;
    }
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while(one != null && two != null){
      if(one.value < two.value){
        cur.next = one;
        cur = cur.next;
        one = one.next;
      }else{
        cur.next = two;
        cur = cur.next;
        two = two.next;
      }
    }
    if(one != null){
      cur.next = one;
    }
    if(two != null){
      cur.next = two;
    }
    return dummy.next;
  }
}

    