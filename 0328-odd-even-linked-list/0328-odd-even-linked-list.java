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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode curr=head;
        ListNode n1=head;
        ListNode n2=head.next;
        ListNode n3=n2;
        ListNode temp=n2;
        while(n2!=null && n2.next!=null){
            n1.next=n2.next;
            n2.next=n2.next.next;
            n1=n1.next;
            n2=n2.next;
        }
        n1.next=n3;
        return head;
    }
}