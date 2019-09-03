package vipkid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * Created by ololo on 2019/9/3.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();
        String[] inputArrayStr = str.split(",");
        for(int i=0;i<inputArrayStr.length;i++){
            inputArrayStr[i]=inputArrayStr[i].trim();
            if(!isNumeric(inputArrayStr[i])){
                return;
            }
        }


        int count = 0;
        int size = inputArrayStr.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            //  System.out.println(inputArrayStr[i]);
            if (inputArrayStr[i].contains("-")) {
                list.add(inputArrayStr[i].substring(1, inputArrayStr[i].length()));

            }
        }

        for (String str1 : list) {
            for (int j = 0; j < size; j++) {
                if (str1.equals(inputArrayStr[j])) {
                    count++;
                }
            }

        }
        System.out.println(count);
    }

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("-?[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
}
