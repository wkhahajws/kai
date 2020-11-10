package com.example.demo.anli_200;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * FileName:anli_30
 * Author: kaishen
 * Date: 2020/11/4 1:43
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public class anli_30 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(350,180);
    }
}

class FillGradientPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;  //获取2D对象
        Rectangle2D.Float rect = new Rectangle2D.Float(20, 20, 280, 140);//创建矩形对象
        GradientPaint paint = new GradientPaint(20, 20, Color.BLUE, 100, 80, Color.RED, true);
        g2.setPaint(paint);
        g2.fill(rect);
    }
}
