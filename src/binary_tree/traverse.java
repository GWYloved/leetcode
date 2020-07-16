package binary_tree;

import normal_struct.TreeNode;

import java.util.LinkedList;

public class traverse {
    public static void preOrderTraverse(TreeNode node){
        if (node == null)
            return;
        System.out.println(node.val);
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
        /**
         * 中序
         *         preOrderTraverse(node.left);
         *         System.out.println(node.val);
         *         preOrderTraverse(node.right);
         * 后序同理
         */

    }

    public static void preOrderTraverseWithOutRecursion(TreeNode node){
        if (node == null)
            return;
        TreeNode current;
        LinkedList<TreeNode> container = new LinkedList<>();
        container.addFirst(node);
        /**
         * 宽度优先搜索
         */
        while (!container.isEmpty()){
            current = container.removeFirst();
            System.out.println(current.val);
            if (current.right != null)
                container.addFirst(current.right);
            if (current.left != null)
                container.addFirst(current.left);
        }
    }
}
