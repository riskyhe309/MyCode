/**
 * Created by Risky on 2015/1/29.
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {

        if(head == null)
            return null;

        int length = 1;
        ListNode q = head;
        while(q.next != null){
            length++;
            q = q.next;
        }

        TreeNode root = transform(head, q,length);

        return root;
    }

    TreeNode transform(ListNode head, ListNode tail, int length){

        //ListNode mid = findMid(head,length);
        if(length < 1)
            return null;

        if(length == 1)
            return new TreeNode(head.val);

        int midIndex = length/2;
        ListNode mid = head;
        ListNode preTail = null;
        ListNode nextHead = null;

        while(midIndex > 0){

            preTail = mid;
            mid = mid.next;
            midIndex--;
        }

        nextHead = mid.next;

        TreeNode root = new TreeNode(mid.val);

        root.left = transform(head, preTail, length/2);
        root.right = transform(nextHead, tail, (length + 1)/2 - 1);

        return root;

    }
}