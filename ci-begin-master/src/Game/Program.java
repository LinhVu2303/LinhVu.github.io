package Game;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.util.Set;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow window = new GameWindow();
        window.setTitle("Game Touhou");
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GamePanel panel = new GamePanel();
        panel.setPreferredSize(new Dimension(Setting.GAME_WIDTH, Setting.GAME_HEIGHT));
        panel.setBackground(Color.CYAN);
        window.add(panel);
        window.pack();

        window.setVisible(true);

        panel.gameLoop();
    }
}
