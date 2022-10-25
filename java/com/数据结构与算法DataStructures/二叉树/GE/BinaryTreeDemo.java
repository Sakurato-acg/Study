package com.数据结构与算法DataStructures.二叉树.GE;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //
        Tree tree = new Tree();
        HeroNode no0 = new HeroNode(0, "no0");
        HeroNode no1 = new HeroNode(1, "no1");
        HeroNode no2 = new HeroNode(2, "no2");
        HeroNode no3 = new HeroNode(3, "no3");
        HeroNode no4 = new HeroNode(4, "no4");
        HeroNode no5 = new HeroNode(5, "no5");
        HeroNode no6 = new HeroNode(6, "no6");
        HeroNode no7 = new HeroNode(7, "no7");
        no0.setLeft(no1);
        no0.setRight(no2);
        no1.setLeft(no3);
        no1.setRight(no4);
        no2.setLeft(no5);
        no2.setRight(no6);
//        no3.setLeft(no7);

//        no1.setLeft(no2);
//        no1.setRight(no3);
//        no3.setRight(no4);
//        no3.setLeft(no5);

        tree.setRoot(no0);

        System.out.println("深度");
        tree.maxDepth();
//        tree.del(8);

        System.out.println("---------前序遍历---------");
        tree.pre();

        System.out.println("---------中序遍历---------");
        tree.mid();

        System.out.println("---------后序遍历---------");
        tree.pos();

        System.out.println("---------LIST---------");
        tree.list();


        System.out.println("---------前序查找---------");
        HeroNode pro = tree.preSearch(15);
        try {
            System.out.println(pro.toString());
        } catch (Exception e) {
            System.out.println("找不到");
        }
        System.out.println("---------中序查找---------");
        HeroNode mid = tree.midSearch(15);
        try {
            System.out.println(mid.toString());
        } catch (Exception e) {
            System.out.println("找不到");
        }
        System.out.println("---------后序查找---------");
        HeroNode pos = tree.posSearch(15);
        try {
            System.out.println(pos.toString());
        } catch (Exception e) {
            System.out.println("找不到");
        }
    }
}

class Tree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void maxDepth() {
        if (this.root != null) {
            int i = this.root.maxD();
            System.out.println(i);
        } else {
            System.out.println("kong");
        }
    }

    public void pre() {
        if (this.root != null) {
            this.root.preOder();
        } else {
            System.out.println("kong");
        }
    }

    public HeroNode preSearch(int no) {
        if (root != null) {
            return root.preSearch(no);
        } else {
            return null;
        }
    }

    public void mid() {
        if (this.root != null) {
            this.root.midOder();
        } else {
            System.out.println("kong");
        }
    }

    public HeroNode midSearch(int no) {
        if (root != null) {
            return root.midSearch(no);
        } else {
            return null;
        }
    }

    public void pos() {
        if (this.root != null) {
            this.root.posOder();
        } else {
            System.out.println("kong");
        }
    }

    public HeroNode posSearch(int no) {
        if (root != null) {
            return root.posSearch(no);
        } else {
            return null;
        }
    }

    public void list() {
        if (this.root != null) {
            System.out.println(root.toString());
            this.root.list();
        } else {
            System.out.println("kong");
        }
    }

    public void del(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.del(no);
            }
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    public boolean tt = true;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int maxD() {
        return maxD(this);
    }

    public int maxD(HeroNode x) {
        if (x == null) {
            return 0;
        }
        int max = 0;
        int maxL = 0;//左子树深度
        int maxR = 0;
        if (x.left != null) {
            maxL = maxD(x.left);
        }
        if (x.right != null) {
            maxR = maxD(x.right);
        }
        max = maxL > maxR ? maxL + 1 : maxR + 1;
        return max;
    }

    public void list() {
        if (this.left == null) {
            // System.out.println("左为空");
        } else {
            System.out.println(this.left);
        }
        if (this.right == null) {
            //  System.out.println("右为空");
        } else {
            System.out.println(this.right);
        }
        if (this.left == null || this.right == null) {
            return;
        } else if (this.left.left != null || this.left.right != null) {
            this.left.list();
        }

        if (this.right.left != null || this.right.right != null) {
            this.right.list();
        } else {
            return;
        }
    }

    //前序遍历
    public void preOder() {
        System.out.println(this);
        //左
        if (this.left != null) {
            this.left.preOder();
        }
        //右
        if (this.right != null) {
            this.right.preOder();
        }
    }

    public HeroNode preSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode res = null;

        if (this.left != null) {
            res = this.left.preSearch(no);
            //return this.left.preSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.right != null) {
            res = this.right.preSearch(no);
            //return this.right.preSearch(no);
        }
        return res;
    }

    //左 中 右
    public HeroNode midSearch(int no) {
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.midSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.no == no) {
            return this;
        }

        if (this.right != null) {
            res = this.right.midSearch(no);
        }
        return res;
//        HeroNode res = null;
//        if (this.left.no == no) {
//            return this.left;
//        }
//
//
//        if (this.left.left!=null){
//            res=this.left.midSearch(no);
//        }
//       if (res!=null){
//           return res;
//       }
//        if (this.left.right!=null){
//            res=this.right.midSearch(no);
//        }
//        if (res!=null){
//            return res;
//        }
//        if (this.no == no) {
//            return this;
//        }
//
//        if (this.right.no==no){
//            return this.right;
//        }
//
//        if (this.right.left!=null){
//            res=this.right.midSearch(no);
//        }
//        if (res!=null){
//            return res;
//        }
//        if (this.right.right!=null){
//            res=this.right.midSearch(no);
//        }
//        return res;
    }

    public void midOder() {
        if (this.left != null) {
            this.left.midOder();
        }
        System.out.println(this);

        if (this.right != null) {
            this.right.midOder();
        }
    }

    public void posOder() {
        if (this.left != null) {
            this.left.posOder();
        }
        if (this.right != null) {
            this.right.posOder();
        }
        System.out.println(this);
    }

    public HeroNode posSearch(int no) {
        HeroNode res = null;
        if (this.left != null) {
            res = this.left.midSearch(no);
        }
        if (res != null) {
            return res;
        }

        if (this.right != null) {
            res = this.right.midSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.no == no) {
            return this;
        }
        return res;
//        HeroNode res = null;
//        if (this.left.no == no) {
//            return this.left;
//        }
//
//        if (this.left.left!=null){
//            res=this.left.midSearch(no);
//        }
//        if (res!=null){
//            return res;
//        }
//        if (this.left.right!=null){
//            res=this.right.midSearch(no);
//        }
//        if (res!=null){
//            return res;
//        }
//
//
//        if (this.right.no==no){
//            return this.right;
//        }
//
//        if (this.right.left!=null){
//            res=this.right.midSearch(no);
//        }
//        if (res!=null){
//            return res;
//        }
//        if (this.right.right!=null){
//            res=this.right.midSearch(no);
//        }
//        if (this.no == no) {
//            return this;
//        }
//
//        return res;
    }

    public void del(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.del(no);
        }
        if (this.right != null) {
            this.right.del(no);
        }
    }
}
