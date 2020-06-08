/**
 * An SLList is a list of integers,which hides the truth
 * of the nakedness within.
 */
public class SLList {
    /* InNode stands on SLList
    * IntNode never needs to look outwards */
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i,IntNode n){
            item = i;
            next = n;
        }
    }

    /* Note: PLEASE DO NOT MESS WITH first */
    private IntNode first;




    public SLList(int x) {
        /* 递归运用IntNode，生成节点 */
        first = new IntNode(x, null);

    }

    /**
     * Adds an item to the front of the list.
     * @param x
     */
    public void addFirst(int x){
        first = new IntNode(x,first);


    }

    /** Returns the first item in the list.
     * @return
     */
    public int getFirst(){
        return first.item;
    }

    /**
     * Adds an item to the end of the list
     * @param x
     * @return
     */
    public void addLast(int x){
        IntNode p = first;
        /* Move p until it reaches the end of the list.*/
        while (p.next != null){
            p = p.next;
        }
        p.next =new IntNode(x,null);
    }

    /**
     * Returns the size of the list that starts at IntNode p.
     * @param p
     * @return
     */
    private static int size(IntNode p){
        if(p.next==null){
            return 1;
        }
        return 1+size(p.next);

    }

    public int size(){
        return size(first);
    }
    public static void main(String[] args) {
        /*从尾节点开始链接*/
        SLList L =new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        System.out.println(L.size());
    }
}
