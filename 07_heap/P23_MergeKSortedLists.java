import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class LNode {
    int val;
    LNode next;
    public LNode() {}
    public LNode(int val) {this.val = val;}
    public LNode(int val, LNode next) {this.val = val; this.next = next;}
}


public class P23_MergeKSortedLists {

    public static LNode mergeKLists(List<LNode> lists) {
        // for (LNode node: lists) {
        //     printLinkedList(node);
        // }
        // return new LNode();

        if (lists == null || lists.isEmpty()) return null;

        PriorityQueue<LNode> minHeap = new PriorityQueue<>(new Comparator<LNode>() {
            @Override
            public int compare(LNode a, LNode b) {
                return a.val - b.val;
            }
        });

        for (LNode node: lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        // minHeap.addAll(lists);

        LNode dNode = new LNode(); // dummy node
        LNode dHead = dNode;

        while (!minHeap.isEmpty()) {
            dHead.next = minHeap.poll();
            dHead = dHead.next;

            if (dHead.next != null) {
                minHeap.add(dHead.next);
            }
        }

        return dNode.next;
    }

    public static LNode constructLinkedList(int[] nums) {
        LNode dNode = new LNode();
        LNode dHead = dNode;
        for (int num: nums) {
            dHead.next = new LNode(num);
            dHead = dHead.next;
        }
        return dNode.next;
    }

    public static LNode[] constructKLinkedLists(int[][] list) {
        LNode[] nodeList = new LNode[list.length];
        for (int i = 0; i < list.length; i++) {
            nodeList[i] = constructLinkedList(list[i]);
        }
        return nodeList;
    }

    public static void printLinkedList(LNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][][] probs = {
            {{1,4,5},{1,3,4},{2,6}},
            {},
            {{}}
        };
        for (int[][] prob: probs) {
            LNode resNode = mergeKLists(new ArrayList<>(Arrays.asList(constructKLinkedLists(prob))));
            printLinkedList(resNode);
        }

        // int[] x = {1, 2, 3};
        // List<Integer> l = new ArrayList(Arrays.asList(x));

        // int[][] l = {{}};
        // System.out.println(l.length);
    }
}
