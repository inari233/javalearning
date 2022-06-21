package com.binarytree;

public class BinaryTree {
    public static void main(String[] args) {
        tree tree = new tree();
        node node1 = new node(1);
        node node2 = new node(2);
        node node3 = new node(3);
        node node4 = new node(4);
        node node5 = new node(5);

        tree.head = node1;
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

//        tree.preOrder(tree.head);
//        System.out.println();
//        tree.infixOrder(tree.head);
//        System.out.println();
//        tree.postOrder(tree.head);

        node node = tree.postSearch(tree.head, 1);
        System.out.println(node == null ? "该节点不存在" : node);

    }
}


class node {
    public int no;
    public node left;
    public node right;

    public node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "node{" +
                "no=" + no +
                '}';
    }
}

class tree {
    public node head;

    public tree() {
        head = new node(-1);
    }

    /*
    前序遍历，按照先遍历当前节点，再左节点，然后右节点
     */
    public void preOrder(node node) {
        if (node == null) {
            System.out.println("该节点为空");
            return;
        }
        System.out.print(node.no + " ");
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    public void infixOrder(node node) {
        if (node == null) {
            System.out.println("该节点为空");
            return;
        }
        if (node.left != null) {
            infixOrder(node.left);
        }
        System.out.print(node.no + " ");
        if (node.right != null) {
            infixOrder(node.right);
        }
    }

    public void postOrder(node node) {
        if (node == null) {
            System.out.println("该节点为空");
            return;
        }
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        System.out.print(node.no + " ");
    }

    public node preSearch(node node, int no) {
        System.out.println("查找一次");
        node findNode = null;
        if (node == null) {
            System.out.println("该节点为空");
            return null;
        }
        if (node.no == no) {
            findNode = node;
            return findNode;
        }

        if (node.left != null) {
            findNode = preSearch(node.left, no);
        }
        if (node.right != null) {
            findNode = preSearch(node.right, no);
        }

        return findNode;
    }

    public node infixSearch(node node, int no) {
        System.out.println("查找一次");
        node findNode = null;
        if (node == null) {
            System.out.println("该节点为空");
            return null;
        }
        if (node.left != null) {
            findNode = infixSearch(node.left, no);
        }
        if (node.no == no) {
            findNode = node;
            return findNode;
        }
        if (node.right != null) {
            findNode = infixSearch(node.right, no);
        }
        return findNode;
    }

    public node postSearch(node node, int no) {
        System.out.println("查找一次");
        node findNode = null;
        if (node == null) {
            System.out.println("该节点为空");
            return null;
        }
        if (node.left != null) {
            findNode = postSearch(node.left, no);
        }

        if (node.right != null) {
            findNode = postSearch(node.right, no);
        }
        if (node.no == no) {
            findNode = node;
            return findNode;
        }
        return findNode;
    }

}
