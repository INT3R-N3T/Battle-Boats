public class Board {
    
    private String [][] board;
    private int hitCount;
    private String player;
    
    //Constructors
    public Board()
    {
        // initialise instance variables
        board = new String [10][10];
        hitCount = 0;
        player = "Your Ships";
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board[0].length; j++){
                board[i][j] = "_";
            }
        }
    }
    public Board(String gPlayer)
    {
        hitCount = 0;
        board = new String [10][10];
        player = gPlayer;
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board[0].length; j++){
                board[i][j] = "_";
            }
        }
    }
    
    //Methods
    public void print(){
        String alphabet = "ABCDEFGHIJ";
        System.out.print("      " + player);
        System.out.println();
        for (int i = 0; i<board.length; i++){
            System.out.print(alphabet.substring(i,i+1));
            for (int j = 0; j<board[0].length; j++){
                System.out.print("|");
                System.out.print(board[i][j]);
            }
            System.out.println("|");
        }
        System.out.print(" ");
        for (int i = 0; i<board.length; i++){
            System.out.print(" ");
            System.out.print(i+1);
        }
        System.out.println();
    }

    //Translate
    public int[] translate(String gCord)
    {
        
        String alphabet = "ABCDEFGHIJ";
        int [] outputArr = new int [2];
        for (int i = 0; i<alphabet.length(); i++){
            if (gCord.substring(0,1).equals(alphabet.substring(i, i+1))){
                outputArr[0] = Integer.parseInt(alphabet.substring(i, i+1)) - 1;
            }
        }
        outputArr[1] = Integer.parseInt(gCord.substring(1,2));
        return outputArr;
    }

    //Set ships method

    public int setShips (String gBow, String gStern, int gShip)
    {
        //Take in input through translate

        int [] head = translate(gBow);
        int [] tail = translate(gStern);

        // set ship fill variable to correct ship type

        /*
            1: Aircraft Carrior (5 places)
            2: Battle Ship (4 places)
            3: Cruser (3 places)
            4: Submarine (3 places)
            5: Destroyer (2 places)

        */

        int shipLength = 0;
        String fillLetter = "N";

        switch (gShip) {

            case 1:
                fillLetter = "A"; shipLength = 5;

            case 2:
                fillLetter = "B"; shipLength = 4;

            case 3:
                fillLetter = "C"; shipLength = 3;

            case 4:
                fillLetter = "S"; shipLength = 3;

            case 5:
                fillLetter = "D"; shipLength = 2;

        }

        if (shipLength == 0 || fillLetter.equals("N")) {
            return -1;
        }

        //pick the left up as the start
        //pick the right down as the end

        int [] start;
        int [] end;


        if (head[0] == tail[0]){
            if (head[1] < tail[1]){
                start = head;
                end = tail;
            }
            else{
                start = tail;
                end = head;
            } 

        }

        else if (head[0] < tail[0]){
            start = head;
            end = tail;
        }

        else{
            start = tail;
            end = head;
        } 
        
        /* Get positions on the board
                
                if the "letter" is same

                    if high -low =! ship length
                        return -1

                    fill from low num to high num

                if the num is same 

                    if high(A side) -low (B side) =! ship length
                        return -1


                    fill from A side to J side

                else 

                    reject thing as an invalid output
                    return -1

        */

        
        if (start[0] == end[0]){

            if ((end[1] - start[1]) != shipLength ){
                return -1;
            }

            for (int i = start[1]; i == end[1]; i ++){

                this.board[start[0]][i] = fillLetter;
            }
        }

        else if (start[1] == end[1]){

            if ((end[0] - start[0]) != shipLength ){
                return -1;
            }

            for (int i = start[0]; i == end[0]; i ++){

                this.board[i][start[1]] = fillLetter;
            }
        }

        else {
            return -1;
        }



        // this means there was a proper execution of this code.
        return 1;

    }

    
    
    //Input method for managing board of your guesses returns nothing
    //Must get sanitized inputs (0,4) 
    //result is a hit or miss
    public void guess(int [] gCords, String hoM){
        String output;
        if (hoM.toUpperCase().equals("H")){
            output = "X";
            this.hitCount += 1;
        }
        else{
            output = "O";
        }
        board[gCords[0]][gCords[1]] = output;
    }
    
    //Checks whether enemy hit a ship and marks accordingly. 
    //Returns a hit or miss (True or false)
    public boolean incGuess(int [] gCords){
        if(board[gCords[0]][gCords[1]].equals("_"))
        //Whatever a ship is going to be reprenseted as
        {
            return false;
        }
        else
        {
            board[gCords[0]][gCords[1]] = "X";
            this.hitCount += 1;
            return true;
        }
        
    }

    //Getters n setters
    public int getHC()
    {
        return hitCount;
    }
}
