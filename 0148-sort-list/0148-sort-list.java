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
    public ListNode sortList(ListNode head) {
        if(head==null) return null;
        List<Integer> res=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null) {
            res.add(temp.val);
            temp=temp.next;
        }
        Collections.sort(res);
        ListNode t=new ListNode(res.get(0));
        head=t;
        ListNode p=head;
        for(int i=1;i<res.size();i++){
            ListNode n=new ListNode(res.get(i));
            p.next=n;
            p=p.next;
        }
        return head;
    }
}