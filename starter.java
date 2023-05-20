import java.awt.*;
import javax.swing.*;

public class starter {
    public static void main(String[] args) {
        Pong pong = new Pong();
        PongPanel panel = new PongPanel();
        pong.getContentPane().add(panel);
    }
}