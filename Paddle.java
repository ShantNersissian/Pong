import java.awt.*;

public class Paddle {
    int w, h, x, y, speed;
    Color color;

    public Paddle(int w, int h, int x, int y, int speed, Color color) {
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = color;
    }

    public void paint(Graphics g) {
        g.setColor(color.WHITE);
        g.fillRect(x, y, w, h);
    }
}