public class ArrayDeque <T> implements Deque<T>{
    private T[] items;
    private int size;
    private int nextfrist;
    private int nextlast;
    private double R=0.25;
    //计算下一个first,实现循环利用
    private int compute_nextfirst(int nextfirst){
        if (nextfirst==0){
            nextfirst=items.length-1;
            return nextfirst;
        }
        else {
            nextfirst-=1;
            return nextfirst;
        }

    }
    //计算下一个Last
    private int compute_nextLast(int nextlast){
        if (nextlast==items.length-1){
            nextlast=0;
            return nextlast;
        }
        else {
            nextlast+=1;
            return nextlast;
        }

    }
    //在数组满的时候，扩大数组
    private void resize(int capacity){
        T[] a=(T[]) new Object[capacity];
        int first=(nextfrist+1)%items.length;
        int last= nextlast==0?items.length-1:nextlast-1;
        if (first<last){
            System.arraycopy(items,first,a,0,size);
        }
        else {
            System.arraycopy(items,first,a,0,items.length-first);
            System.arraycopy(items,0,a,items.length-first,size-items.length+first);

        }
        items=a;
        nextfrist=items.length-1;
        nextlast=size;

    }

    //初始化双端队列
    public ArrayDeque(){
        //数组大小为8
        items=(T[]) new Object[8];
        nextfrist=0;
        nextlast=1;
        size=0;
    }
    @Override
    public void addFirst(T item){
        if (size>=items.length){
            resize(size*2);

        }

        items[nextfrist]=item;
        size+=1;
        nextfrist=compute_nextfirst(nextfrist);

    }
    @Override
    public void addLast(T item){
        if (size>= items.length){
            resize(size*2);

        }

        items[nextlast]=item;
        size+=1;
        nextlast=compute_nextLast(nextlast);


    }
    @Override
    public boolean isEmpty(){
        if (size==0){
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
        for (int i=(nextfrist+1)%items.length;i!=nextlast-1;i=(i+1)%items.length){
            System.out.println(items[i]+" ");
        }
        System.out.println(items[nextlast-1]);

    }
    @Override
    public T removeFirst(){
        //在利用率低于0.25时，缩小数组
        if (isEmpty()){
            return null;
        }
        int first=(nextfrist+1)%items.length;
        T x=items[first];
        items[first]=null;
        nextfrist=first;
        size-=1;
        if (items.length>=16 && size<items.length/4){
            resize(items.length/2);

        }
        return x;


    }
    @Override
    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        //在利用率低于0.25时，缩小数组
        int last= nextlast==0?items.length-1:nextlast-1;
        T x=items[last];
        items[last]=null;
        nextlast=last;
        size-=1;
        if (items.length>=16&&size<items.length/4){
            resize(items.length/2);
        }
        return x;

    }
    @Override
    public T get(int index){
        if (isEmpty() || index>=size){
            return null;
        }

        return items[(nextfrist+1+index)%items.length];


    }
//    public static void main(String[] args){
//        ArrayDeque<Integer> a= new ArrayDeque<>();
//        a.addFirst(1);
//        a.addLast(2);
//        a.addFirst(0);
//        a.addLast(3);
//        a.addLast(4);
//        a.addLast(5);
//        a.addLast(6);
//        a.addLast(7);
//        a.addLast(8);
////        a.removeFirst();
////        a.removeLast();
////        a.removeLast();
////        a.removeLast();
////        a.removeLast();
////        a.removeLast();
//        System.out.println(8);
//
//
//        a.printDeque();
//
//
//    }



}
