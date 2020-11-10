package com.example.demo.anli_200;

import java.util.Scanner;

/**
 * FileName:anli_1
 * Author: kaishen
 * Date: 2020/11/4 1:59
 * Description:判断是否为润年
 */
public class anli_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个年份");
        long year = scanner.nextLong();
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            System.out.println(year + "是润年");
        }else{
            System.out.println(year + "不是润年");
        }
    }
}
