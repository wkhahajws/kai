package com.example.demo.until;

import java.util.ArrayList;

/**
 * FileName:ball
 * Author: kaishen
 * Date: 2020/10/22 22:45
 * Description:双色球算啥篮球
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public class ball {
    public static void main(String[] args) {

        ArrayList<Integer> list = sha(9);
        System.out.println();
        System.out.println(list);

        list = sha(9,8,list);
        System.out.println(list);

        list = sha2(9,8,list);
        System.out.println(list);
    }

    /**
     * 第一次 筛选
     * @param param1  上期号码
     * @return
     */
    public static ArrayList<Integer> sha(int param1){
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> aaaaa = new ArrayList<Integer>();
        for (int i = 1; i <= 16 ; i++) {
            list.add(i);
            aaaaa.add(i);
        }
        int a = (19 - param1) % 10;
        System.out.print("杀尾值："+a);
        int b = (21 - param1) % 10;
        System.out.print(","+b);

        int d = param1*2%10;
        System.out.print(","+d);
        int e = param1%10*4%10;
        System.out.print(","+e);
        int f;
        if(param1 > 14){
            f = (param1 - 7) % 10;
        }else{
            f = (param1 + 7) % 10;
        }
        System.out.print(","+f);
        int g = (param1+2) % 10;
        System.out.print(","+g);
        int h = (param1+6) % 10;
        System.out.print(","+h);


        for (int i = 0; i < aaaaa.size(); i++) {
            int p = aaaaa.get(i);
            if(a == p % 10){
                list.remove((Object)p);
            }
            if(b == p % 10){
                list.remove((Object)p);
            }
            if(param1 <= 15){
                int c = (15 - param1) % 10;
                if(c == p % 10){
                    System.out.print(","+c);
                    list.remove((Object)p);
                }
            }
            if(d == (p % 10)){
                list.remove((Object)p);
            }
            if(e == p % 10){
                list.remove((Object)p);
            }
            if(f == p % 10){
                list.remove((Object)p);
            }
            if(g == p % 10){
                list.remove((Object)p);
            }
            if(h == p % 10){
                list.remove((Object)p);
            }
        }
        return list;
    }

    /**
     * 第二次删选
     * @param param1 上期号码
     * @param param2 上上期号码
     * @param list
     * @return
     */
    public static ArrayList<Integer> sha(int param1,int param2,ArrayList<Integer> list){
        int a = (param1 % 10 + param2 % 10)%10;
        int b = ((param1 / 10) % 10 + param2 % 10)%10;
        int c = (param1 % 10 + (param2 / 10) % 10)%10;
        System.out.println("第二次杀尾值:"+a+","+b+","+c);
        ArrayList<Integer> aaaaa = new ArrayList<>(list);
        for (int i = 0; i < aaaaa.size(); i++) {
            int p = aaaaa.get(i);
            if(a == p%10){
                list.remove((Object)p);
            }
            if(b == p%10){
                list.remove((Object)p);
            }
            if(c == p%10){
                list.remove((Object)p);
            }
        }
        return list;
    }

    /**
     * 第三次筛选
     * @param param1 上期数
     * @param param2 上上上期数
     * @param list
     * @return
     */
    public static ArrayList<Integer> sha2(int param1,int param2,ArrayList<Integer> list){
        int a = (param1 % 10 + param2 % 10)%10;
        System.out.println("第三次杀尾值:"+a);
        ArrayList<Integer> aaaaa = new ArrayList<>(list);
        for (int i = 0; i < aaaaa.size(); i++) {
            int p = aaaaa.get(i);
            if(a == p%10){
                list.remove((Object)p);
            }
        }
        return list;
    }
}
