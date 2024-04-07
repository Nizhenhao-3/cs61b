public class LinkedListDeque <T> implements Deque<T>{
    public class Node{
        public Node prev;
        public T item;
        public Node next;
        public Node(Node x,T y,Node z){
            prev=x;
            item=y;
            next=z;
        }
    }
    private Node sentinel;
    private int size;
    //创建空链表
    public LinkedListDeque(){
        sentinel = new Node(null,null,null);
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
        size=0;

    }
    //创建带一个值的链表
    public LinkedListDeque(T x){
        sentinel=new Node(null,null,null);
        sentinel.next=new Node(sentinel,x,sentinel);
        sentinel.prev=sentinel.next;
        size+=1;
    }
    @Override
    public void addFirst(T item){
        sentinel.next=new Node(sentinel,item,sentinel.next);
        sentinel.next.next.prev=sentinel.next;

        size+=1;

    }
    @Override
    public void addLast(T item){
        sentinel.prev.next=new Node(sentinel.prev,item,sentinel);
        sentinel.prev=sentinel.prev.next;
        size+=1;

    }
    @Override
    public boolean isEmpty(){
        if (sentinel.next==sentinel) {
            return true;
        }
        return false;

    }
    @Override
    public int size(){
        return size;

    }

    @Override

    public void printDeque(){
        Node current=sentinel.next;
        while (current!=sentinel){
            System.out.println(current.item);
            current=current.next;
        }
    }
    @Override

    public T removeFirst(){
        if (isEmpty()){

            return null;
        }
        T item=sentinel.next.item;
        sentinel.next.next.prev=sentinel;
        sentinel.next=sentinel.next.next;
        size-=1;
        return item;

    }
    @Override

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        T item=sentinel.prev.item;
        sentinel.prev.prev.next=sentinel;
        sentinel.prev=sentinel.prev.prev;
        size--;
        return item;
    }
    @Override

    public T get(int index){
        if (isEmpty() || index >=size){
            return null;
        }
        Node current=sentinel;
        for (int i=0;i<=index;i++){
            current=current.next;


        }
        return current.item;
    }
    public T getRecursice(int index,Node current){
        if (isEmpty() || index >=size){
            return null;
        }

        if (index==0){
            return current.next.item;
        }
        return getRecursice(index-=1,current.next);

    }
//    public static void main(String[] args){
//        LinkedListDeque<Integer> a=new  LinkedListDeque();
//        a.addFirst(1);
//        a.printDeque();
//    }


}
