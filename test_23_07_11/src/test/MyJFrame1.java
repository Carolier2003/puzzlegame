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
public class MyJFrame1 extends JFrame implements MouseListener , KeyListener {
    public MyJFrame1(){
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
        //设置按钮
        JButton jButton = new JButton("点我呀");
        jButton.setBounds(0,0,100,100);
        jButton.addMouseListener(this);
        this.getContentPane().add(jButton);
        //KeyListener
        this.addKeyListener(this);
        //置顶
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("坤击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按住不放");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("放手");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("我又跳进来了");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("我又跳出来了");
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
