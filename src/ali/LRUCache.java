package ali;

/**
 * Created by ololo on 2019/8/28.
 */
import java.util.HashMap;
public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();

    Node head = null;
    Node end = null;

    public LRUCache(int capacity){
        this.capacity = capacity;
    }


    public int get(int key){
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            addHead(n);
            return n.value;

        }

        return -1;
    }

    public void put(int key, int value){
        Node p = new Node(key,value);
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            addHead(n);
        }else
        addHead(p);
        if(map.size() >= this.capacity){
            map.remove(end.key);
            remove(end);
        }
        map.put(key, p);

}


    public void remove(Node n){
        if(n.pre != null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }
        if(n.next != null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }

    }


    public void addHead(Node n){
        n.next = head;
        n.pre = null;
        if(head != null){
            head.pre = n;

        }

        head = n;
        if(end == null){
            end = head;
        }

    }

    @Override
    public String toString() {
        return "LRUCache [capacity=" + capacity + ", map=" + map + ", head="+ head + ", end=" + end + "]";

        /*StringBuilder sb = new StringBuilder();
        Node n=head;
        sb.append("LRUCache [capacity=" + capacity );
        while (n!=null){
            sb.append(" ,（").append(String.format("%s:%s",n.key,n.value)).append("） ");
            n=n.next;
        }
        sb.append(",head=("+head.key+":"+head.value+")");
        sb.append(",end =("+end.key+":"+end.value+")");
        sb.append("]");

        return sb.toString();*/

    }

class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
    @Override
    public String toString() {

        return  "("+key+":"+value+")";
    }
}
}
