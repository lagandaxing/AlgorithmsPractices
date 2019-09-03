package sorting;

/**
 * 简单选择排序
 * Created by ololo on 2019/8/9.
 */
public class SelectionSort {
    public static void sort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int k=i;
            for(int j=i+1;j<array.length-1;j++){
                if(array[j]<array[k]){
                    k=j;
                }
            }
            if(k!=i){
                int temp=array[i];
                array[i]=array[k];
                array[k]=temp;
            }
        }

    }

    public static void printIntArray(int[] key){
        for (int i=0; i<key.length; i++)
            System.out.printf("%d ", key[i]);
        System.out.printf("\n");
    }


    public static void main(String[] args) {
        int i;
        int[] a = {20,40,30,10,60,50};

        System.out.printf("before sort:");
        printIntArray(a);
        sort(a);
        System.out.printf("after  sort:");
        printIntArray(a);
    }


}
