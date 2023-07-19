package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * {@code @Author} 19667
 * {@code @create} 2023/7/11 20:11
 */
public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //记录数据的二维数组
    int[][] data = new int[4][4];
    //创建random函数
    Random random = new Random();
    //胜利数据数组
    int[][] win = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    //更换图片的控制变量
    int change = 0;
    //记录0的位置
    int x = 0;
    int y = 0;
    //记录地址
    String path = "image\\animal\\animal1\\";
    //记录步数
    int steps = 0;
    //创建JMenuItem
    JMenuItem replayJavaMenuItem = new JMenuItem("重新游戏");
    //JMenuItem reLogInJavaMenuItem = new JMenuItem("重新登录");
    JMenuItem closeJavaMenuItem = new JMenuItem("关闭游戏");
    JMenuItem accountJavaMenuItem = new JMenuItem("作者微信");
    JMenuItem girl = new JMenuItem("美女");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem sport = new JMenuItem("运动");

    //空参构造方法
    public GameJFrame() {
        //初始化界面
        initialJavaFrame();
        //初始化菜单栏
        initialJavaMenuBar();
        //初始化乱序二维数组
        initialArr();
        //插入图片
        initialPicture();
        //显示界面
        this.setVisible(true);

    }

    //初始化乱序二维数组
    private void initialArr() {

        //初始化一维顺序数组
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        x = 0;
        y = 0;
        //将一维数组添加到二维数组data中
        for (int i = 0; i < arr.length; i++) {
            data[i / 4][i % 4] = arr[i];
        }
        for (int i = 0; i < 1000; i++) {
            int nextInt = random.nextInt(4);
            switch (nextInt){
                case 0: {
                    System.out.println("向左移动");
                    if (y == 3) {
                        continue;
                    }
                    data[x][y] = data[x][y + 1];
                    data[x][y + 1] = 0;
                    y = y + 1;
                }
                case 1: {
                    if (x == 3) {
                        continue;
                    }
                    data[x][y] = data[x + 1][y];
                    data[x + 1][y] = 0;
                    x = x + 1;
                }
                case 2: {
                    if (y == 0) {
                        continue;
                    }
                    data[x][y] = data[x][y - 1];
                    data[x][y - 1] = 0;
                    y = y - 1;
                }
                case 3: {
                    if (x == 0) {
                        continue;
                    }
                    data[x][y] = data[x - 1][y];
                    data[x - 1][y] = 0;
                    x = x - 1;
                }
            }
        }
    }

    //插入图片
    private void initialPicture() {
        //清空之前的图片
        this.getContentPane().removeAll();
        //加入计步器
        JLabel step = new JLabel("步数：" + steps);
        step.setBounds(50, 30, 100, 20);
        this.getContentPane().add(step);
        //判断是否胜利并添加图片
        if (victory()) {
            JLabel vic = new JLabel(new ImageIcon("image\\win.png"));
            vic.setBounds(203, 283, 197, 73);
            this.getContentPane().add(vic);
        }
        //定义计数器 用于插入图片
        for (int i = 0; i < 4; i++) {
            //利用双层循环添加图片
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                //以文件地址创建ImageIcon并放入jLabel1
                JLabel jLabel = new JLabel(new ImageIcon(path + num + ".jpg"));
                //设置图片的位置大小
                jLabel.setBounds(j * 105 + 83, i * 105 + 134, 105, 105);
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //将jLabel添加到默认容器中
                this.getContentPane().add(jLabel);
            }
        }
        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("image\\background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);
        this.getContentPane().repaint();
    }

    //初始化菜单栏
    private void initialJavaMenuBar() {
        //创建JMenuBar
        JMenuBar jMenuBar = new JMenuBar();
        //创建JMenu
        JMenu functionJavaMenu = new JMenu("功能");
        JMenu aboutJavaMenu = new JMenu("关于我们");
        JMenu changeImage = new JMenu("更换图片");
        //把美女，动物，运动添加到更换图片当中
        changeImage.add(girl);
        changeImage.add(animal);
        changeImage.add(sport);
        //绑定事件
        girl.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);
        //将JMenuItem添加到JMenu中
        functionJavaMenu.add(changeImage);
        functionJavaMenu.add(replayJavaMenuItem);
        //functionJavaMenu.add(reLogInJavaMenuItem);
        functionJavaMenu.add(closeJavaMenuItem);
        aboutJavaMenu.add(accountJavaMenuItem);
        //将JMenu添加到JMenuBar中
        jMenuBar.add(functionJavaMenu);
        jMenuBar.add(aboutJavaMenu);
        //给JMnuItem添加ActionListener
        replayJavaMenuItem.addActionListener(this);
        //reLogInJavaMenuItem.addActionListener(this);
        closeJavaMenuItem.addActionListener(this);
        accountJavaMenuItem.addActionListener(this);
        //将JMenuBar添加到MainJFrame中
        this.setJMenuBar(jMenuBar);
    }

    //初始化界面
    private void initialJavaFrame() {
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
        //置顶
        this.setAlwaysOnTop(true);
        //添加KeyListener
        this.addKeyListener(this);
        //刷新
    }

    //判断胜利
    private boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //判断是否胜利
        if (victory()) {
            return;
        }
        int eKeyCode = e.getKeyCode();
        if (eKeyCode == 65) {
            //清空图片
            this.getContentPane().removeAll();
            //加入计步器
            JLabel step = new JLabel("步数：" + steps);
            step.setBounds(50, 30, 100, 20);
            this.getContentPane().add(step);
            //添加原来的图片
            JLabel jLabel = new JLabel(new ImageIcon(path + "all.jpg"));
            jLabel.setBounds(83, 134, 420, 420);
            this.getContentPane().add(jLabel);
            //添加背景图片
            JLabel background = new JLabel(new ImageIcon("image\\background.png"));
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //判断是否胜利
        if (victory()) {
            return;
        }
        //获取键盘输入代码
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);

        //向左移动
        if (keyCode == 37) {
            System.out.println("向左移动");
            if (y == 3) {
                return;
            }
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y = y + 1;
            //步数加一
            steps++;
            initialPicture();

            //向上移动
        } else if (keyCode == 38) {
            System.out.println("向上移动");
            if (x == 3) {
                return;
            }
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x = x + 1;
            //步数加一
            steps++;
            initialPicture();

            //向右移动
        } else if (keyCode == 39) {
            System.out.println("向右移动");
            if (y == 0) {
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y = y - 1;
            //步数加一
            steps++;
            initialPicture();

            //向下移动
        } else if (keyCode == 40) {
            System.out.println("向下移动");
            if (x == 0) {
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x = x - 1;
            //步数加一
            steps++;
            initialPicture();
        } else if (keyCode == 65) {
            initialPicture();
        } else if (keyCode == 87) {
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            initialPicture();
            x = 3;
            y = 3;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object eSource = e.getSource();
        if (eSource == replayJavaMenuItem) {
            System.out.println("重新游戏");
            //计步器清零
            steps = 0;
            //重新打乱二维数组
            initialArr();
            //重新加载图片
            initialPicture();
        } /*else if (eSource == reLogInJavaMenuItem) {
            System.out.println("重新登录");
            //关闭当前界面
            this.setVisible(false);
            //打开登录界面
        }*/ else if (eSource == closeJavaMenuItem) {
            System.out.println("关闭游戏");
            //直接关闭虚拟机
            System.exit(0);
        } else if (eSource == accountJavaMenuItem) {
            System.out.println("关于我们");
            //创建一个弹窗对象
            JDialog jDialog = new JDialog();
            //创建JLabel
            JLabel label = new JLabel(new ImageIcon("image\\about.jpg", "加我"));
            //设置位置和宽高
            label.setBounds(0, 0, 480, 638);
            //把图片添加到弹框中
            jDialog.add(label);
            //设置弹框的大小
            jDialog.setSize(567, 725);
            //置顶并居中
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            //设置无法操作其他界面
            jDialog.setModal(true);
            //显示弹框
            jDialog.setVisible(true);
        } else if (eSource == girl) {
            System.out.println("girl");
            path = "image\\girl\\girl" + ((++change % 11) + 1) + "\\";
            initialArr();
            steps = 0;
            initialPicture();
        } else if (eSource == animal) {
            path = "image\\animal\\animal" + ((++change % 7) + 1) + "\\";
            initialArr();
            steps = 0;
            initialPicture();
            System.out.println("animal");
        } else if (eSource == sport) {
            System.out.println("sport");
            path = "image\\sport\\sport" + ((++change % 9) + 1) + "\\";
            initialArr();
            steps = 0;
            initialPicture();
        }
    }
}
