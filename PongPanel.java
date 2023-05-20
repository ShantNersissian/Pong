import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PongPanel extends JPanel {
    public Ball ball;
    public Paddle paddle1;
    public Paddle paddle2;

    public PongPanel() {
        ball = new Ball(635, 300, 3, 3, 3, Color.WHITE, 10);
        paddle1 = new Paddle(15, 60, 0, 300, 4, Color.WHITE);
        paddle2 = new Paddle(15, 60, 1265, 300, 4, Color.WHITE);
    }

    public void paintComponent(Graphics g) {
        ball.paint(g);
        paddle1.paint(g);
        paddle2.paint(g);
    }
}