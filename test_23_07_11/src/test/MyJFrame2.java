package test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * {@code @Author} 19667
 * {@code @create} 2023/7/13 18:17
 */
public class MyJFrame2 extends JFrame implements KeyListener {
    public MyJFrame2(){
        //设置界面的宽高
        this.setSize(603, 680);
        //设置界面的标题
        this.setTitle("拼图游戏V1.0");
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认化居中放置
        this.setLayout(null);
        //KeyListener
        this.addKeyListener(this);
        //置顶
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("KeyPressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("KeyReleased");
    }
}
