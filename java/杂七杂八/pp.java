package 杂七杂八;

public class pp {
    public static void main(String[] args) throws Exception {

        ArrayList_ arrayList_ = new ArrayList_();
        arrayList_.add(1,1);
        arrayList_.add(2,2);
        arrayList_.list();
    }

    static class ArrayList_ {
        public Node head;

        public ArrayList_() {
            head=new Node(-1,-1);
        }

        public void add(int id, int value) {
            Node cur = head;
            while (cur != null) {
                if (cur.next == null) {
                    break;
                } else {
                    cur = cur.next;
                }
            }

            cur.next = new Node(id, value);
        }

        public void list() {
            Node cur = head;
            while (cur != null) {
                if (cur.next != null) {
                    System.out.println(cur.next);
                    cur = cur.next;
                } else {
                    break;
                }
            }

        }
    }

}

class Node {
    public int id;
    public int value;
    public Node next;

    public Node(int id, int value) {
        this.id = id;
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString() {
        return "杂七杂八.Node{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
