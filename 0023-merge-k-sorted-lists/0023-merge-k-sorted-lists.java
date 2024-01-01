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
class Solution 
{
    public ListNode mergeKLists(ListNode[] lists) 
    {
        ListNode head=new ListNode(0);
        ListNode head2=head;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(ListNode list:lists)
        {
            ListNode temp=list;
            while(temp!=null)
            {
                pq.add(temp.val);
                temp=temp.next;
            }
            
        }
        while(!pq.isEmpty())
        {
            int x=pq.poll();
            ListNode newnode=new ListNode(x);
            head.next=newnode;
            head=newnode;
        }
        return head2.next;
    }
}
