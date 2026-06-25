public class GameLogic {
    private char[] board;

    public GameLogic() {
        board = new char[9];
        resetBoard();
    }

    public void resetBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    public boolean makeMove(int index, char symbol) {
        if (index < 0 || index >= 9) {
            return false;
        }
        if (board[index] != ' ') {
            return false;
        }
        board[index] = symbol;
        return true;
    }

    public boolean checkWinner(char symbol) {
        int[][] patterns = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Baris
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Kolom
                {0, 4, 8}, {2, 4, 6}             // Diagonal
        };
        for (int i = 0; i < patterns.length; i++) {
            int a = patterns[i][0];
            int b = patterns[i][1];
            int c = patterns[i][2];
            if (board[a] == symbol && board[b] == symbol && board[c] == symbol) {
                return true;
            }
        }
        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == ' ') {
                return false;
            }
        }
        return true;
    }

    public int computerMove() {
        // AI Sederhana: Nyari slot kosong secara acak
        java.util.Random rand = new java.util.Random();
        int[] emptyCells = new int[9];
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i] == ' ') {
                emptyCells[count++] = i;
            }
        }
        if (count == 0) return -1;
        return emptyCells[rand.nextInt(count)];
    }

    public char[] getBoard() {
        return board;
    }
}
