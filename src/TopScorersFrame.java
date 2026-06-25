import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TopScorersFrame extends JFrame {
    private JTable table;
    private playerService playerService;

    public TopScorersFrame() {
        playerService = new playerService();
        setTitle("Top 5 Leaderboard");
        setSize(450, 200);
        setLocationRelativeTo(null);

        String[] columns = {"Username", "Wins", "Losses", "Draws", "Score"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        // Ambil data array list dari Service
        java.util.ArrayList<Player> topPlayers = playerService.getTopFives();
        for (Player p : topPlayers) {
            model.addRow(new Object[]{p.getUsername(), p.getWins(), p.getLosses(), p.getDraws(), p.getScore()});
        }

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}