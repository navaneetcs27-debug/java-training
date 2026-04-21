class Solution {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node node) {
        Node current = node;
        Node last = null;

        while (current != null) {
            Node next = current.next;

            // if child exists → flatten it
            if (current.child != null) {
                Node childLast = dfs(current.child);

                // connect current with child
                current.next = current.child;
                current.child.prev = current;

                // connect child's last with next
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                current.child = null;
                last = childLast;
            } else {
                last = current;
            }

            current = next;
        }

        return last;
    }
}