package offer;

/**
 * Created by ololo on 2019/5/7.
 */
import java.util.Arrays;
public class Solution {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7};
        int[] sub=Arrays.copyOfRange(array,1,4);
        for(int i=0;i<sub.length;i++){
            System.out.println(sub[i]);
        }



    }


}