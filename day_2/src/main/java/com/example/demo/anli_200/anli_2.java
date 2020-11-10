package com.example.demo.anli_200;

import java.util.Scanner;

/**
 * FileName:anli_2
 * Author: kaishen
 * Date: 2020/11/4 2:08
 * Description:从控制台接收输入的身份证号
 */
public class anli_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的身份证号");
        String str = scanner.nextLine();
        System.out.println("原来你的身份证号是"+str.length()+"位数字啊");
    }
}
