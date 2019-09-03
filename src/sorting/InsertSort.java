package sorting;

/**
 * Created by ololo on 2019/8/9.
 */
public class InsertSort {
    /*
         * 直接插入排序
         *
         * 参数说明：
         *     a -- 待排序的数组
         *     n -- 数组的长度
         */
    public static void insertSort(int[] key) {
        for(int i=1;i<key.length;i++){
            int temp=key[i],j;
            for(j=i-1;j>=0&&temp<key[j];j--){
                key[j+1]=key[j];
            }
            key[j+1]=temp;
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

        insertSort(a);

        System.out.printf("after  sort:");
        printIntArray(a);
    }

}
