import javax.swing.*;
import java.awt.*;

public class StatisticsFrame extends JFrame {
    public StatisticsFrame(Player player) {
        setTitle("My Statistics");
        setSize(250, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        add(new JLabel(" Player: " + player.getUsername(), SwingConstants.CENTER));
        add(new JLabel(" Wins: " + player.getWins(), SwingConstants.CENTER));
        add(new JLabel(" Losses: " + player.getLosses(), SwingConstants.CENTER));
        add(new JLabel(" Draws: " + player.getDraws(), SwingConstants.CENTER));
        add(new JLabel(" Total Score: " + player.getScore(), SwingConstants.CENTER));
    }
}
