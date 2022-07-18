public class P206_ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode listNode) {this.val = val; this.next = listNode;}
    }

    public static ListNode reverse(ListNode node) {
        ListNode dHead = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = dHead;
            dHead = node;
            node = next;
        }
        return dHead;
    }

    public static ListNode generateLinkedList(int[] nums) {
        ListNode dNode = new ListNode();
        ListNode dHead = dNode;
        for (int num: nums) {
            dHead.next = new ListNode(num);
            dHead = dHead.next;
        }
        return dNode.next;
    }

    public static void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] probs = {
            {1,2,3,4,5},
            {1,2},
            {}
        };
        for (int[] prob: probs) {
            // printLinkedList(generateLinkedList(prob));
            printLinkedList(reverse(generateLinkedList(prob)));
        }
    }
}
