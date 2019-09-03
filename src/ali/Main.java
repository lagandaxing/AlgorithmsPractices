package ali;

/**
 * Created by ololo on 2019/8/30.
 */
/*
阿里巴巴在线考试 中文English 正在拍摄  剩余时间: 00:54:09 李晓星 | 退出
        2/2
        1 问答题
        小滕是淘宝产品经理，刚参加完脑力竞赛回来，解题余味未尽，恰逢双十一，老大让她设计优惠券发放规则。于是就设计了下面的规则：

        随机给定一个二维的字符板，用户需要找出只包含指定字符的最长字符串长度，字符串生成的原则如下: 起始位置任意,可以向上,下,左,右四个方向移动,寻找相邻的字符,如果该字符是指定字符,则继续按上述规则移动,否则则终止算法。备注:一个字符仅能被使用一次,即下一次移动无法回到前一次的位置.

        例如：

        Board = [

        "ABCEDF",

        "CBDAAB",

        "DCBABE"

        ]

        指定字符为 [‘A’,’B’].

        假设起始位置为Board[0,0],则生成的字符串为:ABB

        假设起始位置为Board [1,3],则生成的字符串有:AAB,AABAB,取最长的字符串长度为5.

        符合条件的图示:



        不符合条件的图示:



        下图中Board[2,3]字符(黄色单元格)被使用了两次





        遍历各个起始位置,发现最长的字符串长度为5.

        只有当用户输入可以拼接的字符串的最长长度(上例中为5)时，优惠券才会自动发放。为了验证用户输入的结果是否正确，请你帮小滕写一个自动验证的算法。

        已输入字数: 3740 / 10000   运行
        编译器版本: Java 1.8.0_66
        请使用标准输入输出(System.in, System.out)；已禁用图形、文件、网络、系统相关的操作，如java.lang.Process , javax.swing.JFrame , Runtime.getRuntime；不要自定义包名称，否则会报错，即不要添加package answer之类的语句；您可以写很多个类，但是必须有一个类名为Main，并且为public属性，并且Main为唯一的public class，Main类的里面必须包含一个名字为'main'的静态方法（函数），这个方法是程序的入口
        时间限制: 3S (C/C++以外的语言为: 5 S)   内存限制: 128M (C/C++以外的语言为: 640 M)
        输入:
        字符串数组棋盘，例如：[
        "ABCEDF",
        "CBDAAB",
        "DCBABE"
        ]
        指定字符为 [‘A’,’B’]
        第一行,输入棋盘信息,每一行以逗号分隔
        第二行,输入指定字符,多个以逗号分隔
        输出:
        符合条件的最长字符个数
        输入范例:
        ABCEDF,CBDAAB,DCBABE
        A,B
        输出范例:
        5
        编程说明 ▲
*/
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.LinkedList;
        import java.util.List;
        import java.util.Scanner;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int getMaxLength(String[] board, String[] chars) {


        return  0;



    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] board = split(in.nextLine().trim(), ",");
        String[] chars = split(in.nextLine().trim(), ",");
        int maxLength = getMaxLength(board, chars);
        for(int i=0;i<board.length;i++){
            System.out.println(board[i]);
        }

        System.out.println(maxLength);
    }

    private static String[] splitWorker(String str, String separatorChars, int max, boolean preserveAllTokens) {
        // Performance tuned for 2.0 (JDK1.4)
        // Direct code is quicker than StringTokenizer.
        // Also, StringTokenizer uses isSpace() not isWhitespace()

        if (str == null) {
            return null;
        }
        int len = str.length();
        if (len == 0) {
            return new String[0];
        }
        List list = new ArrayList();
        int sizePlus1 = 1;
        int i = 0, start = 0;
        boolean match = false;
        boolean lastMatch = false;
        if (separatorChars == null) {
            // Null separator means use whitespace
            while (i < len) {
                if (Character.isWhitespace(str.charAt(i))) {
                    if (match || preserveAllTokens) {
                        lastMatch = true;
                        if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        } else if (separatorChars.length() == 1) {
            // Optimise 1 character case
            char sep = separatorChars.charAt(0);
            while (i < len) {
                if (str.charAt(i) == sep) {
                    if (match || preserveAllTokens) {
                        lastMatch = true;
                        if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        } else {
            // standard case
            while (i < len) {
                if (separatorChars.indexOf(str.charAt(i)) >= 0) {
                    if (match || preserveAllTokens) {
                        lastMatch = true;
                        if (sizePlus1++ == max) {
                            i = len;
                            lastMatch = false;
                        }
                        list.add(str.substring(start, i));
                        match = false;
                    }
                    start = ++i;
                    continue;
                }
                lastMatch = false;
                match = true;
                i++;
            }
        }
        if (match || (preserveAllTokens && lastMatch)) {
            list.add(str.substring(start, i));
        }
        return (String[])list.toArray(new String[list.size()]);
    }

    public static String[] split(String str, String separatorChars) {
        return splitWorker(str, separatorChars, -1, false);
    }
}