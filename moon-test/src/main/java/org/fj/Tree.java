package org.fj;

/**
 * 二叉树
 *
 * @author spike
 */
public class Tree {

    public static class Node {
        int value;
        Node left;
        Node right;
    }

    private Node root;

    public Node find(int value) {
        Node current = root;

        while (current.value != value) {
            if (current.value < value) {
                current = current.right;
            } else {
                current = current.left;
            }

            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int value) {
        Node newNode = new Node();
        newNode.value = value;

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;

                if (value < current.value) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }

        }
    }

    public void walk() {
        preorder(root);
        inorder(root);
        postorder(root);
    }


    //前序遍历
    public void preorder(Node node) {
        if (node == null)
            return;

        System.out.println("node--->" + node.value);
        preorder(node.left);
        preorder(node.right);
    }

    //中序遍历
    public void inorder(Node node) {
        if (node == null)
            return;

        preorder(node.left);
        System.out.println("node--->" + node.value);
        preorder(node.right);
    }

    //后序遍历
    public void postorder(Node node) {
        if (node == null)
            return;

        preorder(node.left);
        preorder(node.right);
        System.out.println("node--->" + node.value);
    }

    public Node findMax() {
        Node currnet = root;
        Node parent = currnet;

        while (currnet != null) {
            parent = currnet;
            currnet = currnet.right;
        }
        return parent;
    }

    public Node findMin() {
        Node currnet = root;
        Node parent = currnet;

        while (currnet != null) {
            parent = currnet;
            currnet = currnet.left;
        }
        return currnet;
    }


    public boolean delete(int value) {
        //1.找到要删除的节点，要操作 删除节点的 父节点，将父节点的left/right置为null
        Node current = root;
        //要删除的节点是否父节点的左节点
        boolean isLeft = true;
        Node parent = current;

        while (current.value != value) {
            parent = current;
            if (value < current.value) {
                current = current.left;
                isLeft = true;
            } else if (value > current.value) {
                current = current.right;
                isLeft = false;
            }
            if (current == null) {
                return false;//未找到
            }
        }
        //2. 删除
        if (current.left == null && current.right == null) {
            //2.1 没有子节点
            if (root == current) {
                root = null;
            }
            if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            current = null;

            return true;
        } else {
            if (current.left == null) {
                //2.2 有一个right子节点
                if (root == current) {
                    root = current.right;
                } else {
                    if (isLeft) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }

            } else if (current.right == null) {
                //2.2 有一个left子节点
                if (root == current) {
                    root = current.left;
                } else {
                    if (isLeft) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } else {
                //2.3 有两个子节点
            }
        }
        return true;
    }
}
