package jdexame;

/**
 * Created by ololo on 2019/8/24.
 * 输入中有多组测试数据。每组测试数据的第一行为两个整数n和m（1=＜n, m=＜1000），
 * 分别表示价签的数量以及小B的购买清单中所列的物品数。第二行为空格分隔的n个正整数，
 * 表示货架上各类物品的价格，每个数的大小不超过100000。随后的m行为购买清单中物品的名称，
 * 所有物品名称为非空的不超过32个拉丁字母构成的字符串，保证清单中不同的物品种类数不超过n，
 * 且商店有小B想要购买的所有物品。
 *样例输入
 5 3
 4 2 1 10 5
 apple
 orange
 mango
 6 5
 3 5 1 6 8 1
 peach
 grapefruit
 banana
 orange
 orange
 *
 * 输出
 对每组测试数据，在单独的行中输出两个数a和b，表示购买清单上所有的物品可能需要的最小和最大费用。
 7 19
 11 30
 */
import java.util.*;

public class CaiGou
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            ArrayList<Integer> price = new ArrayList<>();
            int goodsNum = 0, buyNum = 0;
            HashMap<String, Integer> buyList = new HashMap<>();
            goodsNum = sc.nextInt();
            buyNum = sc.nextInt();
            for (int i = 0; i < goodsNum; i++)
            {
                price.add(sc.nextInt());
            }
            for (int i = 0; i < buyNum; i++)
            {
                String good = sc.next();
                if (buyList.containsKey(good))
                {
                    int count = buyList.get(good);
                    buyList.put(good, ++count);
                }
                else
                    buyList.put(good, 1);
            }
            int maxValue = 0;
            int minValue = 0;
            Collection collection = buyList.values();
            ArrayList<Integer> list = new ArrayList<>(collection);
            Collections.sort(list);
            Collections.sort(price);
            for (int i = 0; i < list.size(); i++)
            {
                minValue += list.get(list.size() - i - 1) * price.get(i);
                maxValue += list.get(list.size() - i - 1) * price.get(price.size() - i - 1);
            }
            System.out.printf(minValue + " " + maxValue + "\n");
        }
    }

}