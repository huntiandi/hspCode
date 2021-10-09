package com.games;

import javax.swing.*;
import java.awt.*;

/**
 * @ProjectName: work
 * @author: ZhangBiBo
 * @description: 瞎玩玩，这东西早淘汰了
 * @data: 2021/9/15 20:52
 */
public class GamesTest extends JFrame {
    public MyPanel mp = null;
    public static void main(String[] args) {
        new GamesTest();
    }

    public GamesTest(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
class MyPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(10,10,100,100);
    }
}