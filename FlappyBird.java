import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class FlappyBird implements ActionListener, KeyListener {
    public static final int FPS = 60, WIDTH = 640, HEIGHT = 480;
    private Bird bird;
    private JFrame frame;
    private JPanel panel;
    private ArrayList<Rectangle> rects;
    private int time, scroll;
    private Timer t;
    private boolean paused;

    public void move() {
        frame = new JFrame("Flappy Bird");
        panel = new GamePanel(this, bird, rects);
        bird = new Bird();
        rects = new ArrayList<Rectangle>();
        frame.add(panel);
        frame.setSize(WIDTHM, HEIGHT);
        frame.setVisible(true);
        frame.setVisible(true);
        frame.addKeyListener(this);
        paused = true;
        t = new Timer(1000/FPS, this);
        t.start();
    }
    public static void main(String[] args) {
        new FlappyBird().go();
    }
@Override
    public void actionPerformed(ActionEvent e) {
        panel.repaint();
        if(!pause) {
            bird.physics();
            if (scroll % 90 == 0) {
                Rectangle r = new Rectangle(WIDTH, 0, GamePanel, PIPE_W, (int) ((MATH.random()*HEIGHT)/5f + (0.2f)*HEIGHT));
                int h2 = (int) ((Math.random()*HEIGHT)/5f + (0.2f)*HEIGHT);
                Rectangle r2 = new Rectangle(WIDTH, HEIGHT - h2, GamePanel.PIPE_W, h2);
                rects.add(r);
                rects.add(r);
            }
            ArrayList<Rectangle> toRemove = new ArrayList<Rectangle>();
            boolean game = true;
            for(Rectangle r : rects) {
                r.x=3;
                if(r.x + r.width <= 0) {
                    roRemove.add(r);
                }
                if(r.contain(bird.x, bird.y)) {
                    JOptionPanel.showMessageDialog(frame, "You lose!!!\n" + "Your score:" + time + ".";
                    game = false;
                }
            }
            rects.removeAll(toRemove);
            time++;
            scroll++;
