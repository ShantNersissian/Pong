import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Pong extends JFrame {
    private static final int WIDTH = 950;
    private static final int HEIGHT = 600;
    private static final int PADDLE_WIDTH = 10;
    private static final int PADDLE_HEIGHT = 100;
    private static final int BALL_SIZE = 20;
    private static final int FPS = 240;
    private static final int DELAY = 1000 / FPS;

    private JPanel gamePanel;
    private Timer timer;
    private int paddleY;
    private int ballX, ballY;
    private int ballXSpeed, ballYSpeed;
    
    public Pong() {
        initGame();
        initComponents();
        addListeners();
    }

    private void initGame() {
        paddleY = HEIGHT / 2 - PADDLE_HEIGHT / 2;
        ballX = WIDTH / 2 - BALL_SIZE / 2;
        ballY = HEIGHT / 2 - BALL_SIZE / 2;
        ballXSpeed = 10;
        ballYSpeed = -10;
    }

    private void initComponents() {
        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGame(g);
            }
        };
        gamePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        gamePanel.setBackground(Color.BLACK);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setTitle("Breakout");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void addListeners() {
        gamePanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                paddleY = e.getY() - PADDLE_HEIGHT / 2;
            }
        });
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGame();
                gamePanel.repaint();
            }
        });
        timer.start();
    }
    private void drawGame(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(WIDTH - PADDLE_WIDTH - 10, paddleY, PADDLE_WIDTH, PADDLE_HEIGHT);

        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
    }

    private void updateGame() {
        ballX += ballXSpeed;
        ballY += ballYSpeed;

        if (ballY <= 0 || ballY + BALL_SIZE >= HEIGHT) {
            ballYSpeed = -ballYSpeed;
        }

        if (ballX <= 0) {
            ballXSpeed = -ballXSpeed;
        }

        if (ballX + BALL_SIZE >= WIDTH) {
            ballX = HEIGHT / 2 - BALL_SIZE / 2;
            ballY = WIDTH / 2 - BALL_SIZE / 2;
            paddleY = HEIGHT / 2 - PADDLE_HEIGHT / 2;
            }

        if (ballX + BALL_SIZE >= WIDTH - PADDLE_WIDTH - 10 && ballY + BALL_SIZE >= paddleY && ballY <= paddleY + PADDLE_HEIGHT) {
            ballXSpeed = -ballXSpeed;
        }
    }  
}