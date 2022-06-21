package com.Threadedbinarytree;

public class ThreadedBinaryTree {
    public static void main(String[] args) {
        tree tree = new tree();
        node node1 = new node(1);
        node node2 = new node(2);
        node node3 = new node(3);
        node node4 = new node(4);
        node node5 = new node(5);
        node node6 = new node(6);
        node node7 = new node(7);
        node node8 = new node(8);

        tree.head = node1;
        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node2.left = node4;
        //node3.left = node6;
        //node5.left = node4;
        //node6.left = node7;
        //node7.left = node8;
        tree.postThread(tree.head);
        System.out.println();

    }
}

class node {
    public int no;
    public node left;
    public node right;
    //当这个数为2时，即该节点是用来补充前驱后继关系的
    public int node_left_type = 0;//默认为一，即左节点就是左子树的引用，右节点就是右子树的引用
    public int node_right_type = 0;

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
    public node pre = null;

    public tree() {
        head = new node(-1);
    }



    public void postThread(node node){
        if(node == null){
            return;
        }
        postThread(node.left);
        postThread(node.right);
        if (node.left == null) {
            node.left = pre;
            node.node_left_type = 1;
        }

        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.node_right_type = 1;
        }
        pre = node;

    }

    public void list_infixThread() {
        list_infixThread(head);
    }


    public void preThread(node node) {
        if (node == null) {
            return;
        }


        if (node.left == null) {
            node.left = pre;
            node.node_left_type = 1;
        }

        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.node_right_type = 1;
        }
        pre = node;
        if (node.node_left_type == 0) {
            preThread(node.left);
        }
        if (node.node_right_type == 0) {
            preThread(node.right);
        }

    }

    public void list_preThread(node node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.print(node.no + " ");

            if (node.node_right_type == 1) {
                node = node.right;
            } else if (node.node_left_type == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

    }

    public void list_infixThread(node node) {
        if (node == null) {
            return;
        }

        while (node != null) {
            while (node.node_left_type == 0) {
                node = node.left;
            }

            System.out.print(node.no + " ");

            while (node.node_right_type == 1) {
                node = node.right;
                System.out.print(node.no + " ");
            }
            node = node.right;
        }
    }


    public void infix_thread() {
        infix_thread(head);
    }

    /**
     * 用中序遍历的方式完成二叉树的线索化
     *
     * @param node 用于线索化的树的头节点
     */
    public void infix_thread(node node) {
        if (node == null) {
            return;
        }
        //先对左节点进行线索化
        infix_thread(node.left);
        //再对本结点进行线索化

        //先处理本节点的前驱，即右节点
        if (node.left == null) {
            //右节点指向前驱
            node.left = pre;
            //将节点类型设为前驱后继型
            node.node_left_type = 1;
        }
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.node_right_type = 1;
        }
        pre = node;
        //最后对右节点进行线索化
        infix_thread(node.right);
    }

    /*
    前序遍历，按照先遍历当前节点，再左节点，然后右节点
     */
    public void preOrder(node node) {
        if (node == null) {
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
