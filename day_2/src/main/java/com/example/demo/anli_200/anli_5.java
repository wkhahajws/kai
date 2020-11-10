package com.example.demo.anli_200;

import javax.swing.*;
import java.awt.*;

/**
 * FileName:anli_5
 * Author: kaishen
 * Date: 2020/11/4 16:00
 * Description:
 */
public class anli_5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("用动态数组保存学生姓名");
        frame.setSize(500 , 500);
        frame.getContentPane().setBackground(Color.gray);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton jButton1 = new JButton("添加学生");
        JButton jButton2 = new JButton("删除学生");
        frame.add(jButton1);
        frame.add(jButton2);

    }
}
