package com.kush.studyplan.seventyfive.linkedlist;

import java.util.ArrayList;
import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
public class LinkedListProblem {
	 public static void main(String[] args) {
	        // Create a linked list: 1 -> 4 -> 3 -> 2
	        ListNode node4 = new ListNode(2);
	        ListNode node3 = new ListNode(3);
	        node3.next = node4;
	        ListNode node2 = new ListNode(4);
	        node2.next = node3;
	        ListNode node1 = new ListNode(1);
	        node1.next = node2;
	    }
	
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow=head,fast=head,prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
     if(prev == null) return null;
     //System.out.println("prev "+prev.val+" slow:"+slow.val);
     prev.next=slow.next;
     
     return head;        
    }

	/*
	 * Given the head of a singly linked list, group all the nodes with odd indices
	 * together followed by the nodes with even indices, and return the reordered list.
	 * 
	 * The first node is considered odd, and the second node is even, and so
	 * on. 
	 * 
	 * Note that the relative order inside both the even and odd groups should
	 * remain as it was in the input. You must solve the problem in O(1) extra space
	 * complexity and O(n) time complexity.
	 */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
    
    
    public ListNode reverseList(ListNode head) {
        ListNode curr=head,prev=null,next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
      }
    
    /*
    Twin Nodes: In this problem, for a linked list of size n, the "twin" 
    of the ith node (0-indexed) is the node at position (n-1-i) in the linked list. 
   This twinning only applies for nodes where i ranges from 0 to (n / 2) - 1.
   
   For example, given the linked list: 1 -> 4 -> 3 -> 2, the twin sum calculation would be:

   Node 1 (value 4) is the twin of Node 2 (value 3). Twin sum = 4 + 3 = 7.
   Node 4 (value 2) is the twin of Node 0 (value 1). Twin sum = 2 + 1 = 3.
   */
    
    public int pairSum(ListNode head) {
        List<Integer> list=new ArrayList<>();
        getDataInList(head,list);
        int n=list.size()-1; //(n - 1)
        int maxSum=0;
        for(int i=0;i<list.size() / 2 ; i++){
            maxSum=Math.max(maxSum,list.get(i) + list.get(n- i));
        }
         return maxSum;
     }
     private void getDataInList(ListNode head,List<Integer> list){
         while(head!=null){
             list.add(head.val);
             head=head.next;
         }
     }
   
    
}