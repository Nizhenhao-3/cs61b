public class LinkedListDeque <something>{
    public class Node{
        public Node prev;
        public something item;
        public Node next;
        public Node(Node x,something y,Node z){
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
    public LinkedListDeque(something x){
        sentinel=new Node(null,null,null);
        sentinel.next=new Node(sentinel,x,sentinel);
        sentinel.prev=sentinel.next;
        size+=1;
    }
    public void addFirst(something item){
        sentinel.next=new Node(sentinel,item,sentinel.next);
        sentinel.next.next.prev=sentinel.next;

        size+=1;

    }
    public void addLast(something item){
        sentinel.prev.next=new Node(sentinel.prev,item,sentinel);
        sentinel.prev=sentinel.prev.next;
        size+=1;

    }
    public boolean isEmpty(){
        if (sentinel.next==sentinel) {
            return true;
        }
        return false;

    }
    public int size(){
        return size;

    }
    public void printDeque(){
        Node current=sentinel.next;
        while (current!=sentinel){
            System.out.println(current.item);
            current=current.next;
        }
    }
    public something removeFirst(){
        if (isEmpty()){

            return null;
        }
        something item=sentinel.next.item;
        sentinel.next.next.prev=sentinel;
        sentinel.next=sentinel.next.next;
        size-=1;
        return item;

    }
    public something removeLast(){
        if (isEmpty()){
            return null;
        }
        something item=sentinel.prev.item;
        sentinel.prev.prev.next=sentinel;
        sentinel.prev=sentinel.prev.prev;
        size--;
        return item;
    }
    public something get(int index){
        if (isEmpty() || index >=size){
            return null;
        }
        Node current=sentinel;
        for (int i=0;i<=index;i++){
            current=current.next;


        }
        return current.item;
    }
    public something getRecursice(int index,Node current){
        if (isEmpty() || index >=size){
            return null;
        }

        if (index==0){
            return current.next.item;
        }
        return getRecursice(index-=1,current.next);

    }


}
