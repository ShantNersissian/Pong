import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyListener;

public class PongPanel extends JPanel implements KeyListener {
    public Ball ball;
    public Paddle paddle1;
    public Paddle paddle2;

    JFrame frame;
    JLabel label;
    Action upAction;
    Action downAction;

    public PongPanel() {
        ball = new Ball(635, 300, 3, 3, 3, Color.WHITE, 10);
        paddle1 = new Paddle(15, 60, 0, 300, 4, Color.WHITE);
        paddle2 = new Paddle(15, 60, 1265, 300, 4, Color.WHITE);

        upAction = new UpAction();
        downAction = new DownAction();

        label.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
        label.getActionMap().put("upAction", upAction);

        label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        label.getActionMap().put("downAction", downAction);
    }

    public void paintComponent(Graphics g) {
        ball.paint(g);
        paddle1.paint(g);
        paddle2.paint(g);
    }

    public class UpAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvents e) {
            label.setLocation(label.getX(), label.getY() - 10);
        }
    }

    public class DownAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvents e) {
            label.setLocation(label.getX(), label.getY() - 10);
        }
    }
}