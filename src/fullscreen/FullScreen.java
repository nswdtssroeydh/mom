package fullscreen;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
 
import javax.swing.JFrame;
 
 
public class FullScreen extends JFrame implements KeyListener {
    private boolean flag = false;
    //开始时左上角的位置,开始时的高度，宽度
    private Point start = new Point(300,150);
    private int width = 600;
    private int height = 400;
     
     
    public FullScreen() {
        this.addKeyListener(this);
         
        this.setLocation(start);
        this.setSize(width, height);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
    public static void main(String[] args) {
        new FullScreen();
    }
 
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            max();
        }
         
        //最大化时按esc键退出
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE && flag) {
            normal();
        }
    }
 
    public void keyReleased(KeyEvent e) {}
 
    public void keyTyped(KeyEvent e) {}
 
    /**
     * 最大化
     */
    private void max() {
        flag = true;
        this.setLocation(0, 0);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.repaint();
    }
     
    /**
     * 退出全屏
     */
    private void normal() {
        flag = false;
        this.setLocation(start);
        this.setSize(width, height);
        this.repaint();
    }
}
