package ali;

/**
 * Created by ololo on 2019/8/28.
 */
public class Test {
    public static void main(String[] args) {
        LRUCache cache=new  LRUCache(-1);
       // int n=cache.get(1);
       // System.out.println(n);

        /*cache.put(1,10);
        System.out.println(cache);*/

       /* cache.put(1,10);
        System.out.println(cache);*/

       //测边界值
        for(int i=0;i<15;i++){
            cache.put(i,i);
        }
        System.out.println(cache);
        /*int i=cache.get(9);
        System.out.println(i);
        cache.put(9,19);
        i=cache.get(9);
        System.out.println(i);*/

    }
}
