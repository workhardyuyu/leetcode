import java.util.HashMap;

public class LRUCache {
    class Node{
        int key;
        int value;
        Node pre=null;
        Node next=null;
		public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    
    HashMap<Integer, Node> hm=new HashMap<Integer,Node>();
    int capacity=0; int count=0;
    Node head=null; Node tail=null;
    public LRUCache(int capacity) {
        this.capacity=Math.max(1,capacity);
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node temp=hm.get(key);
            temp.pre.next=temp.next;
            temp.next.pre=temp.pre;
            temp.pre=null;
            temp.next=head;
            head.pre=temp;
            head=temp;
            return temp.value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(count<capacity){
            count++;
            if(head==null){
                head=new Node(key,value);
                tail=head;
                hm.put(key,head);
                return;
            }else{
                Node temp=new Node(key,value);
                temp.next=head;
                head.pre=temp;
                head=temp;
                hm.put(key,temp);
                return;
            }
        }else{
            hm.remove(tail.value);
            
            if(capacity==1){
                head=new Node(key,value);
                tail=head;
                hm.put(key,head);
                return;
            }
            tail=tail.pre;
            tail.next=null;
            Node temp=new Node(key,value);
            temp.next=head;
            head.pre=temp;
            head=temp;
            hm.put(key,temp);
            return;
        }
    }
}