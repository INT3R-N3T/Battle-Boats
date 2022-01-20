import java.util.ArrayList;

public class Board {

    String[][] board;
    public int hitCount;
    private String player;

    // Constructors
    public Board() {
        // initialise instance variables
        board = new String[10][10];
        hitCount = 0;
        player = "Your Ships";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = "_";
            }
        }
    }

    public Board(String gPlayer) {
        hitCount = 0;
        board = new String[10][10];
        player = gPlayer;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = "_";
            }
        }
    }

    // Methods
    public void print() {
        String alphabet = "ABCDEFGHIJ";
        System.out.print("      " + player);
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(alphabet.substring(i, i + 1));
            for (int j = 0; j < board[0].length; j++) {
                System.out.print("|");
                System.out.print(board[i][j]);
            }
            System.out.println("|");
        }
        System.out.print(" ");
        for (int i = 0; i < board.length; i++) {
            System.out.print(" ");
            System.out.print(i + 1);
        }
        System.out.println();
    }

    // Translate
    public int[] translate(String gCord) {

        String alphabet = "ABCDEFGHIJ";
        int[] outputArr = new int[2];
        for (int i = 0; i < alphabet.length(); i++) {
            if (gCord.substring(0, 1).toUpperCase().equals(alphabet.substring(i, i + 1))) {
                outputArr[0] = i;
            }
        }
        outputArr[1] = Integer.parseInt(gCord.substring(1, 2)) - 1;
        if (gCord.length() == 3) {
            outputArr[1] = 9;
        }
        return outputArr;
    }

    // Set ships method

    public int setShips(ArrayList<String> pos, String gSymbol) {

        for (int i = 0; i < pos.size(); i++) {

            if (this.board[Integer.parseInt(pos.get(i).substring(0, 1))][Integer
                    .parseInt(pos.get(i).substring(1, 2))] != "_") {

                return -1;

            }

            this.board[Integer.parseInt(pos.get(i).substring(0, 1))][Integer
                    .parseInt(pos.get(i).substring(1, 2))] = gSymbol;

        }

        return 1;

    }

    // Input method for managing board of your guesses returns nothing
    // Must get sanitized inputs (0,4)
    // result is a hit or miss
    public void guess(int[] gCords, String hoM) {
        String output;
        if (hoM.toUpperCase().equals("H")) {
            output = "X";
            this.hitCount += 1;
        } else {
            output = "O";
        }
        this.board[gCords[0]][gCords[1]] = output;
    }

    // Checks whether enemy hit a ship and marks accordingly.
    // Returns a hit or miss (True or false)
    public boolean incGuess(int[] gCords) {
        if (board[gCords[0]][gCords[1]].equals("_")) {
            this.board[gCords[0]][gCords[1]] = "O";
            return false;
        }

        else if (board[gCords[0]][gCords[1]].equals("X") | (board[gCords[0]][gCords[1]].equals("O"))) {
            return false;
        }

        else {
            this.board[gCords[0]][gCords[1]] = "X";
            this.hitCount += 1;
            return true;
        }

    }

}
