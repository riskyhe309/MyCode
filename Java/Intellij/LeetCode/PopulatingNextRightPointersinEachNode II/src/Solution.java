/**
 * Created by Risky on 2015/1/25.
 */
/**
 * Definition for binary tree with next pointer.*/


public class Solution {




    public void connect(TreeLinkNode root) {

        TreeLinkNode cur = root;

        while(cur != null){

            TreeLinkNode work = cur;

            while(work != null){

                if(work.left != null && work.right != null){
                    work.left.next = work.right;
                }

                TreeLinkNode linkLeft = work.next;
                linkLeft = findLeft(linkLeft);

                if(work.right != null)
                    work.right.next = linkLeft;
                else if(work.left != null)
                    work.left.next = linkLeft;

               /* if(work.next != null && work.right != null){
                        if(work.next.left !== null)
                            work.right.next = work.next.left;
                        else if(work.next.right == null)
                            work.right.next = work.next.right;
                    }
                    else if(work.next != null && work.left != null){

                        if(work.next.left !== null)
                            work.left.next = work.next.left;
                        else if(work.next.right == null)
                            work.left.next = work.next.right;
                    }
                    */

                work = work.next;

            }

            cur = findLeft(cur);
        }
    }


    TreeLinkNode findLeft(TreeLinkNode cur){
        if(cur == null)
            return cur ;

        if(cur.left != null){
            cur = cur.left;
            return cur ;
        }

        if(cur.right != null){
            cur = cur.right;
            return cur ;
        }

        return findLeft(cur.next);

    }
}