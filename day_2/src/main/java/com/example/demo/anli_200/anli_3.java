package com.example.demo.anli_200;

import java.util.Scanner;

/**
 * FileName:anli_3
 * Author: kaishen
 * Date: 2020/11/4 2:14
 * Description:分配员工
 */
public class anli_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入新员工的姓名");
        String name = scanner.nextLine();
        System.out.println("请输入新员工应聘的编程语言");
        String language = scanner.nextLine();
        switch (language.hashCode()){
            case 3254818:                               //Java的哈希码
            case 2301506:                               //Java的哈希码
            case 2269730:                               //Java的哈希码
                System.out.println("员工"+name+"被分配到Java开发部门");
                break;
            case 3104:
            case 2112:
                System.out.println("员工"+name+"被分配到c#开发部门");
                break;
            default:
                System.out.println("本公司不需要"+language+"语言的程序开发人员");
        }
    }
}
