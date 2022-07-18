import java.util.ArrayList;
import java.util.List;

public class P226_InvertBinaryTree {
    static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {};
            TreeNode(int val) {this.val = val;}
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }

        public static List<List<Integer>> levelPrint(TreeNode node) { 
            List<List<Integer>> res = new ArrayList<>();
            dfs(node, res, 0);
            return res;
        }
        
        public static void dfs(TreeNode node, List<List<Integer>> levels, int parent) {
            if (node == null) {
                return;
            }
            if (levels.size() == parent) {
                levels.add(new ArrayList<>());
            }
            levels.get(parent).add(node.val);

            dfs(node.left, levels, parent+1);
            dfs(node.right, levels, parent+1);
        }
    }

    public static void invert(TreeNode node) { // use dfs and swap left with right
        if (node == null) {return;}

        TreeNode tempnode = node.left;
        node.left = node.right;
        node.right = tempnode;

        invert(node.left);
        invert(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(TreeNode.levelPrint(root));
        
        invert(root);
        System.out.println(TreeNode.levelPrint(root));
    }
}
