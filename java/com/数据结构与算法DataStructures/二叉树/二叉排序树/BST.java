package com.数据结构与算法DataStructures.二叉树.二叉排序树;

import java.util.Arrays;
import java.util.Objects;

public class BST {
    public static void main(String[] args) {
//        int[] arr = new int[7];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 8 + 1);
//        }

//        int[] arr = {7, 3, 10, 12, 5, 1, 9, 0, 2, 4, 6};
        int[] arr = {7, 3, 10, 1, 2, 5, 9, 12};
//        int[] arr = {10,1};
        System.out.println("原数组");
        System.out.println(Arrays.toString(arr));
        tree head = new tree(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            add(head, arr[i]);
        }
        System.out.println("list");
        list(head);

        tree del = del(head, 10);
        System.out.println("删除后");
        list(del);
    }

    public static void add(tree head, int arr) {
        if (head == null) {
            return;
        }
        if (arr >= head.val) {
            if (head.right == null)
                head.right = new tree(arr);
            else
                add(head.right, arr);
        } else {
            if (head.left == null)
                head.left = new tree(arr);
            else
                add(head.left, arr);
        }
    }

    //中序遍历 按序输出
    public static void list(tree root) {
        if (root != null) {
            root.list(root);
        } else {
            System.out.println("kong");
        }
    }

    public static tree del(tree head, int val) {
        if (head.left == null && head.right == null) {
            System.out.println("只有一个结点");
            return null;
        } else {
            return head.del(head, val);
        }
    }
}

class tree {
    public int val;
    public tree left;
    public tree right;

    public tree checkTree;

    public tree(int val) {
        this.val = val;
    }

    public tree search(tree head, int index) {
        if (index == head.val) {
            return head;
        } else if (index < head.val) {

            if (head.left == null) {
                checkTree = null;
            } else {
                checkTree = head.left.search(head.left, index);
            }
        } else {
            if (head.right == null) {
                checkTree = null;
            } else {
                checkTree = head.right.search(right, index);
            }
        }
        return checkTree;
    }

    public tree searchParent(tree head, int index) {
        if ((head.left != null && head.left.val == index)
                || (head.right != null && head.right.val == index)) {
            return head;
        } else {
            if (index < head.val && head.left != null) {
                return head.left.searchParent(head.left, index);
            } else if (index >= head.val && head.right != null) {
                return head.right.searchParent(head.right, index);
            } else {
                //没有父结点
                return null;
            }
        }
    }

    /**
     * @param head  head
     * @param index index
     *              只是删除叶子结点
     */
    public tree del(tree head, int index) {

        tree search = search(head, index);

        if (search == null) {
            System.out.println("找不到要删除的结点");
            return null;
        }
        //一个二叉树只有一个结点的情况

        tree parent = searchParent(head, index);

        if (parent == null) {
            System.out.println("找不到父结点");

            if(head.left!=null){
                if (head.right==null){
                    head=head.left;
                }
                else {
                    tree min = findMin(head.right);
                    tree temp=head.left;
                    head=head.right;

                    if (temp.val<min.val){
                        min.left=temp;
                    }else {
                        min.right=temp;
                    }
                }
                return head;
            }
            else {
                if (head.right==null){
                    return null;
                }else {
                    head=head.right;
                    return head;
                }
            }



        } else {
            //删除叶子结点
            if (search.left == null && search.right == null) {

                if (parent.left != null && parent.left.val == index) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.val == index) {
                    parent.right = null;
                }
            }

            //删除只有一颗子树的结点

            if (search.left == null && search.right != null) {
                if (parent.left != null && parent.left.val == index) {
                    parent.left = search.right;
                } else if (parent.right != null && parent.right.val == index) {
                    parent.right = search.right;
                }
            } else if (search.left != null && search.right == null) {
                if (parent.left != null && parent.left.val == index) {
                    parent.left = search.left;
                } else if (parent.right != null && parent.right.val == index) {
                    parent.right = search.left;
                }
            }

            //删除有两个子树的结点
            if (search.left != null && search.right != null) {
                //要找到右子树的 最小结点
                tree min = findMin(search.right);

                min.left = search.left;
               if (parent.left == search) {
                    parent.left = search.right;
                } else if (parent.right == search) {
                    parent.right = search.right;
                }

            }
        }
        return head;
    }

    public tree findMin(tree node) {
        if (node.left == null && node.right == null) {
            System.out.println("findMin");
            System.out.println(node);
            return node;
        }

        return findMin(Objects.requireNonNullElseGet(node.left, () -> node.right));
    }

    public void list(tree root) {
        if (root.left != null) {
            list(root.left);
        }
        System.out.println(root);
        if (root.right != null) {
            list(root.right);
        }
    }

    @Override
    public String toString() {
        return "tree[" + "val=" + val + ']';
    }
}
