package com.数据结构与算法DataStructures.链表;

public class L {
    public static void main(String[] args) {
        Hero hero = new Hero(1, "林欢喜", "戏法王子");
        Hero hero2 = new Hero(21, "赵云", "赵子龙");
        Hero hero3 = new Hero(6, "马云", "马首富");
        Hero hero4 = new Hero(77, "任正非", "华为一哥");
        Hero hero6 = new Hero(3, "赵本山", "本山大叔");
        Hero hero5 = new Hero(28, "澎湖湾", "她的家");
        Hero hero7 = new Hero(47, "乔布斯", "乔不死");
        Hero hero8 = new Hero(70, "爱因斯坦", "学术王者");
        HeroList heroList = new HeroList();
        HeroList heroList1 = new HeroList();

        //第一组
        heroList.addHero(hero4);
        heroList.addHero(hero2);
        heroList.addHero(hero);
        heroList.addHero(hero3);
        //第二组
        heroList1.addHero(hero5);
        heroList1.addHero(hero6);
        heroList1.addHero(hero7);
        heroList1.addHero(hero8);

        Hero nextHero1 = heroList1.getHeadHero().nextHero;
        Hero nextHero = heroList.getHeadHero().nextHero;
        //这道题的难点是要断开要添加的节点后面的节点，而不是抛掉
        //如果不做处理直接把另一个链表的节点添加进去，会引导致无法正确读取到后续节点


        HeroList heroList2 = new HeroList();


        Hero middle = new Hero();
        middle = null;
        Hero middle1 = new Hero();
        middle1 = null;
        while (nextHero != null && nextHero1 != null) {
            //把要添加的节点后续的节点放在一个新的对象里面，之后要用；
            //为要放在新对象里而不是直接用nextHero呢？因为在讲nextHero放入链表时，链表的放入
            //方法改变了nextHero的内部的指针，无法通过改变后的nextHero读取到另一个链表的节点
            //因此要把后续的节点保存在另一个对象中，即middle中，后续可以从middle中读取到另一个
            //链表后续的节点
            middle = nextHero.nextHero;
            middle1 = nextHero1.nextHero;
            heroList2.addHero(nextHero);
            heroList2.addHero(nextHero1);
            nextHero = middle;
            nextHero1 = middle1;

        }
        heroList2.listHero();
    }
}

class HeroList {
    private Hero headHero = new Hero(0, "", "");

    public void listHero() {
        Hero temp = headHero;
        while (true) {
            if (headHero.nextHero == null) {
                System.out.println("空list");
                break;
            }
            if (temp.nextHero == null) {
                break;
            }
            temp = temp.nextHero;
            System.out.println(temp);
        }
    }

    public void addHero(Hero hero) {
        Hero temp = headHero;
        boolean flag = false;
        while (true) {
            if (temp.nextHero == null) {
                //说明链表到头了
                break;
            }
            if (temp.nextHero.getId() > hero.getId()) {
                flag = true;
                break;
            }
            temp = temp.nextHero;
        }
        if (flag) {
            //进入代表是插入

            //拆开指针，放入数据
            hero.nextHero = temp.nextHero;
            temp.nextHero = hero;

        } else {
            //进入代表链表是尾部添加
            temp.nextHero = hero;
        }

    }

    public Hero getHeadHero() {
        return headHero;
    }

}

class Hero {
    private Integer id;
    private String name;
    private String nickName;
    public Hero nextHero;

    public Hero() {
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public Hero(Integer id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
