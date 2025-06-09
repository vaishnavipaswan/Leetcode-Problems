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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> s=new Stack<>();
        ListNode n1=head;
        ListNode n2=head;
        while(n2!=null && n2.next!=null){
            n1=n1.next;
            n2=n2.next.next;
        }
        ListNode mid=n1;
            while(n1!=null){
            s.push(n1.val);
            n1=n1.next;
        }
        ListNode curr=head;
        while(curr!=mid){
            if(s.peek()!=curr.val) return false;
            s.pop();
            curr=curr.next;
        }
        return true;
    }
}