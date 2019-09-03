package sorting;

/**
 * Created by ololo on 2019/8/9.
 *
 */
public class ShellSort {
    /**
     * 希尔排序
     *
     */
    public static void  shellSort(int[] array){
        if(array.length<=1 || array==null){
            return;
        }
        int h=array.length/2; //增量
        while (h>0){
            for(int i=h;i<array.length;i++){
                //后边的数字小于前边的数字 ，将其插入到前边
                if(array[i-h]>array[i]){
                    int temp=array[i];
                    int j=i;
                    while(j>(h-1)&&array[j-h]>temp){
                        array[j]=array[j-h];//右移
                        j=j-h;
                    }
                    array[j]=temp;
                }
            }
            h=h/2;
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
        shellSort(a);
        System.out.printf("after  sort:");
        printIntArray(a);
    }

}

