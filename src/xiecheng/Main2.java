package xiecheng;

/**
 * Created by ololo on 2019/9/4.
 */

import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class Main2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        char[] exprToChar=expr.toCharArray();

        Stack<Integer> stack=new Stack<>();

        int count =0;
        int length=exprToChar.length;
        char[] result=new char[length];
        int[] num=new int[length];
        for(int i=0;i<length;i++){
            char c=exprToChar[i];
            if(c=='('){
                stack.push(i);
            }else if(c==')'){
                num[i]=stack.peek();
                num[stack.peek()]=i;
                stack.pop();
            }
        }
         int f=1;
        int r=0;
        for(int i=0;i<length;){
            if(exprToChar[i]=='('||exprToChar[i]==')'){
                i=num[i];
                f=-f;
            }else {
                result[r++]=exprToChar[i];
            }
            i+=f;
        }

        return  String.valueOf(result);
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
