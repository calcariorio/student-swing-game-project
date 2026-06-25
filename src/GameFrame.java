import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private Player currentPlayer;
    private playerService playerService;
    private GameLogic gameLogic;
    private JButton[] buttons;
    private JLabel lblStatus;

    public GameFrame(Player player) {
        this.currentPlayer = player;
        this.playerService = new playerService();
        this.gameLogic = new GameLogic();

        setTitle("Tic-Tac-Toe Arena");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        lblStatus = new JLabel("Your turn (X)", SwingConstants.CENTER);
        lblStatus.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblStatus, BorderLayout.NORTH);

        JPanel pnlBoard = new JPanel(new GridLayout(3, 3, 5, 5));
        buttons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            final int index = i;
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 40));
            buttons[i].addActionListener(e -> handlePlayerMove(index));
            pnlBoard.add(buttons[i]);
        }
        add(pnlBoard, BorderLayout.CENTER);
    }

    private void handlePlayerMove(int index) {
        if (gameLogic.makeMove(index, 'X')) {
            buttons[index].setText("X");
            buttons[index].setForeground(Color.BLUE); // Pewarnaan X menjadi Biru

            if (gameLogic.checkWinner('X')) {
                finishGame("WIN");
                return;
            }
            if (gameLogic.isDraw()) {
                finishGame("DRAW");
                return;
            }

            lblStatus.setText("Computer thinking...");
            int botIndex = gameLogic.computerMove();
            if (botIndex != -1) {
                gameLogic.makeMove(botIndex, 'O');
                buttons[botIndex].setText("O");
                buttons[botIndex].setForeground(Color.RED); // Pewarnaan O menjadi Merah

                if (gameLogic.checkWinner('O')) {
                    finishGame("LOSE");
                    return;
                }
                if (gameLogic.isDraw()) {
                    finishGame("DRAW");
                    return;
                }
            }
            lblStatus.setText("Your turn (X)");
        }
    }

    private void finishGame(String result) {
        playerService.updateStatistics(currentPlayer, result);
        JOptionPane.showMessageDialog(this, "Game Over! Result: " + result);
        MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
        menuFrame.setVisible(true);
        this.dispose();
    }
}