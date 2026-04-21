class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy; // last confirmed unique node

        while (head != null) {

            // check if duplicate exists
            if (head.next != null && head.val == head.next.val) {

                // skip all nodes with same value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

                prev.next = head.next; // remove duplicates
            } 
            else {
                prev = prev.next; // move normally
            }

            head = head.next;
        }

        return dummy.next;
    }
}