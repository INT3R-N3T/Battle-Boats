import java.util.Scanner;
public class BoardTD {
    public static void main(String [] args)
    {
        System.out.println("-------Welcome to Battle Boats-------");

        Scanner cheese = new Scanner(System.in);
        Board obj1 = new Board();
        Board obj2 = new Board("Enemy Ships");
        int turnCount = 1;

        
        System.out.println("Place your ships ");

        int shipType = 1;
        String ship = "How was this printed :) ";
        int longness = 0;
        String pos1;
        String pos2;

        while (true) {
            
            switch (shipType) {

                case 1:
                longness = 5; ship = "Aircraft Carrior";
    
                case 2:
                longness = 4; ship = "Battle Ship";
    
                case 3:
                longness = 3; ship = "Cruser";
    
                case 4:
                longness = 3; ship = "Submarine";
    
                case 5:
                longness = 2; ship = "Destroyer";
    
            }


            System.out.println("Please select a start tile for your " + ship + " (" + longness + " spaces): ");

            pos1 = cheese.next();
            pos2 = cheese.next();

            if (obj1.setShips(pos1, pos2, shipType) == 1)
            {
                shipType += 1;

                    if (shipType == 6){
                        obj1.print();
                        break;
                    }

            }
            else{
                System.out.print("Invalid Ship Placement, try again: ");
            }
        }


        System.out.println("Are you playing first? (y/n): ");
        if (cheese.next().toUpperCase().equals("Y")){
            turnCount = 0;
        }
        while ((obj1.getHC() <= 17) && (obj2.getHC() <= 17))
        {  
            if (turnCount %2 == 0)
            {
                System.out.println("Guess co-ordinates (ex. A4): ");
                String cords = cheese.next();

                System.out.println("Hit or miss? (h/m): ");
                String hoM = cheese.next();
                obj2.guess(obj1.translate(cords), hoM);
            }
            else
            {
                System.out.println("What did they guess? (ex. A4): ");
                obj1.incGuess(obj1.translate(cheese.next()));
            }
            turnCount ++;
        }

            



    }  
}
