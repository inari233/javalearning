package com.AVL;

public class node {
    public node left;
    public node right;
    public int value;

    public node(int value) {
        this.value = value;
    }

    /**
     * 一共要考虑三种情况
     * （1）删除的结点是叶子节点
     * （2）删除的结点有一个子节点
     * （2）删除的结点有两个子节点
     *
     * @param value 要删除的值
     */
    public void delete(int value) {
        node target = this.search(value);
        if (target == null) {
            return;
        }
        node parent = this.parent(value);
        if (parent == null) {
            target = null;
            return;
        }
        //处理是叶子节点的方法
        if (target.left == null && target.right == null) {
            if (target == parent.left) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (target.right != null && target.left != null) {//两个结点都不为空的情况
            //思路，从该结点的右子树找点最小的结点，把该结点的值赋给target，然后把它置空
            //反过来也可以实现
            node find = findMin(target.right);
            int t = find.value;
            delete(t);
            target.value = t;

        } else {//只有一个结点不为空的情况
            if (target.right != null) {
                if (target == parent.left) {
                    parent.left = target.right;
                } else {
                    parent.right = target.right;
                }
            } else {
                if (target == parent.left) {
                    parent.left = target.left;
                } else {
                    parent.right = target.left;
                }
            }
        }
    }

    public node findMin(node node) {
        if (node == null) {
            throw new RuntimeException();
        }

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    public void add(node node) {
        if (node == null) {
            return;
        }

        if (node.value > this.value) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        } else {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }

        }

        if (this.leftHeight() - this.rightHeight() > 1){
            if(this.left.rightHeight() - this.left.leftHeight() > 1){
                this.left.leftRotate();
            }
            rightHeight();
        }
        if (this.rightHeight() - this.leftHeight() > 1){
            if(this.right.leftHeight() - this.right.rightHeight() > 1){
                this.right.rightRotate();
            }
            leftRotate();;
        }

    }


    public void rightRotate(){
        node newNode = new node(this.value);
        //创建新节点，存放当前结点的值
        newNode.left = this.left;
        //新节点的右 节点指向当前结点的右节点的左节点
        newNode.right = this.right.left;
        //把当前结点的右节点的值赋给当前结点
        this.value = this.right.value;
        //当前结点的左节点指向当前结点的右节点的右节点
        this.right = this.right.right;
        //当前结点的左节点指向新节点
        this.left = newNode;
    }

    public void leftRotate(){
        node newNode = new node(this.value);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = newNode;
    }

    public node search(int value) {
        if (value == this.value) {
            return this;
        }
        if (value > this.value) {
            if (this.right != null) {
                return this.right.search(value);
            } else {
                return null;
            }
        } else {
            if (this.left != null) {
                return this.left.search(value);
            } else {
                return null;
            }
        }
    }

    public node parent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        }
        if (value > this.value) {
            if (this.right != null) {
                return this.right.parent(value);
            } else {
                System.out.println("没有该结点");
                return null;
            }
        } else {
            if (this.left != null) {
                return this.left.parent(value);
            } else {
                System.out.println("没有该节点");
                return null;
            }
        }
    }

    public int leftHeight() {
        if (this.left == null) {
            return 0;
        } else {
            return this.left.height();
        }
    }

    public int rightHeight() {
        if (this.right == null) {
            return 0;
        } else {
            return this.right.height();
        }
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }


    @Override
    public String toString() {
        return "node{" +
                "value=" + value +
                '}';
    }
}
