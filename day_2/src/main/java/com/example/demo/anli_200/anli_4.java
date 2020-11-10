package com.example.demo.anli_200;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * FileName:anli_4
 * Author: kaishen
 * Date: 2020/11/4 15:43
 * Description:
 */
public class anli_4 {
    public static void main(String[] args) {
        try {
            PrintStream out = System.out;           //保存原输出流
            PrintStream ps = new PrintStream("K:/log.txt");     //创建文件输出流
            System.setOut(ps);                      //设置新的输出流
            int age = 18;
            System.out.println("年龄变量定义成功,初始值为18");
            String sex = "女";
            System.out.println("性别变量定义成功,初始值为女");
            System.setOut(out);                     //恢复原有输出流
            System.out.println("程序运行完毕,请查看日志文件");

            ps = new PrintStream("K:/err.txt");
            System.setErr(ps);                       //标准的错误输出流
            System.err.println("error:"+"程序发生了错误");
            System.err.println("警告:"+"警告你第一次");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
