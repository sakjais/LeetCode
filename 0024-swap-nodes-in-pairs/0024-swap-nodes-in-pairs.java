/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) 
    {
        ListNode dummy=new ListNode(-1);
        ListNode point=dummy;
        dummy.next=head;
        while(point.next!=null && point.next.next!=null)
        {
            ListNode node1=point.next;
            ListNode node2=point.next.next;
            node1.next=node2.next;
            node2.next=node1;
            point.next=node2;
            point=node1;
        }
        return dummy.next;
    }
}