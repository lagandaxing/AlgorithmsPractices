import java.util.Scanner;

/**
 * Created by ololo on 2019/9/3.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number=in.nextInt();
        if(number<0){
            return;
        }
        int count=0;
        while (number!=0){
            count++;
            number=(number-1)&number;
        }
        System.out.println(count);


    }

}
