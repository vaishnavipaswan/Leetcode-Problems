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
    public int getDecimalValue(ListNode head) {
        ListNode temp=head;
        StringBuilder s=new StringBuilder();
        while(temp!=null){
            s.append(temp.val);
            temp=temp.next;
        }
        String str=s.toString();
        int res=Integer.parseInt(str,2);
        return res;
    }
}