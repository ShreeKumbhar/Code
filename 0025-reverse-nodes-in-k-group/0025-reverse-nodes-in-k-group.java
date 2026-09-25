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

    public static ListNode reverse(ListNode head,int times){

        ListNode prev = null;
        ListNode curr = head;

        while(times-- > 0){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        
        int size = k;
        if(head == null ) return head;

        ListNode left = head;
        ListNode res = null;
        ListNode prevleft = null;

        while(true){

            ListNode right = left;
            for(int i=0; i<size-1; i++){
                if(right == null){
                    break;
                }
                right = right.next;
            }

            if (right != null) {

                ListNode nextleft = right.next;

                reverse(left, size);
                if (prevleft != null) {
                    prevleft.next = right;
                }
                if (res == null) {
                    res = right;
                }
                prevleft = left;
                left = nextleft;
            }
            else{
                if(prevleft!=null){
                    prevleft.next=left;
                    if(res==null){
                        res = left;
                    }
                }
                break;
            }

        } 

        return res;

    }
}