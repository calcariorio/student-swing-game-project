import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class playerService {

    public Player login(String username, String password) {
        String sql = "SELECT * FROM players WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Player(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getInt("wins"),
                            rs.getInt("losses"),
                            rs.getInt("draws"),
                            rs.getInt("score")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("Login error: " + e.getMessage());
        }
        return null;
    }

    public void updateStatistics(Player player, String result) {
        int additionalScore = 0;
        String sql = "";

        if (result.equalsIgnoreCase("WIN")) {
            additionalScore = 10;
            sql = "UPDATE players SET wins = wins + 1, score = score + ? WHERE id = ?";
        } else if (result.equalsIgnoreCase("LOSE")) {
            additionalScore = 0;
            sql = "UPDATE players SET losses = losses + 1, score = score + ? WHERE id = ?";
        } else if (result.equalsIgnoreCase("DRAW")) {
            additionalScore = 3;
            sql = "UPDATE players SET draws = draws + 1, score = score + ? WHERE id = ?";
        }

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, additionalScore);
            stmt.setInt(2, player.getId());
            stmt.executeUpdate();

            // SINKRONISASI INSTAN: Mengubah data object Player (P kapital) di memori runtime
            if (result.equalsIgnoreCase("WIN")) {
                player.setWins(player.getWins() + 1);
                player.setScore(player.getScore() + 10);
            } else if (result.equalsIgnoreCase("LOSE")) {
                player.setLosses(player.getLosses() + 1);
            } else if (result.equalsIgnoreCase("DRAW")) {
                player.setDraws(player.getDraws() + 1);
                player.setScore(player.getScore() + 3);
            }

        } catch (Exception e) {
            System.out.println("Update statistics error: " + e.getMessage());
        }
    }

    public ArrayList<Player> getTopFives() {
        ArrayList<Player> list = new ArrayList<>();
        String sql = "SELECT * FROM players ORDER BY score DESC, wins DESC LIMIT 5";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new Player(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getInt("wins"),
                        rs.getInt("losses"),
                        rs.getInt("draws"),
                        rs.getInt("score")
                ));
            }
        } catch (Exception e) {
            System.out.println("Leaderboard error: " + e.getMessage());
        }
        return list;
    }
}