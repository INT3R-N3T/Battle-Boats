import java.util.Scanner;
import java.util.ArrayList;

public class BoardTD {
    public static void main(String[] args) {
        System.out.println("-------Welcome to Battle Boats-------");

        Scanner cheese = new Scanner(System.in);
        Board obj1 = new Board();
        Board obj2 = new Board("Enemy Ships");
        int turnCount = 1;

        System.out.println("Place your ships ");

        String pos1;
        String pos2;
        obj1.print();

        ArrayList<Ship> boats = new ArrayList<Ship>();

        Ship aC = new Ship(1);
        Ship bS = new Ship(2);
        Ship cS = new Ship(3);
        Ship sS = new Ship(4);
        Ship dS = new Ship(5);

        boats.add(aC);
        boats.add(bS);
        boats.add(cS);
        boats.add(sS);
        boats.add(dS);

        for (int i = 0; i < boats.size(); i++) {
            while (true) {

                System.out.println("Please select start tile for your " + boats.get(i).name + " ("
                        + boats.get(i).longness + " spaces): ");

                pos1 = cheese.next();
                System.out.println("Please select an end tile for your " + boats.get(i).name + " ("
                        + boats.get(i).longness + " spaces): ");

                pos2 = cheese.next();

                if (boats.get(i).calculateLocation(obj1.translate(pos1), obj1.translate(pos2)) == 1) {

                    // there was a majical for loop here, but devon killed it because it was
                    // POINTLESS and :(
                    // I killed it because it was emprty and your goldfish brain forgot what u were
                    // gona write
                    // just because a loop is empty inside doesnt mean it doesnt have a right to
                    // exist, im empty inside after coding this but im still here...
                    // Is everything okay at home??? AHAHHA WHAT HOME XD lmao
                    // :(
                    // * this is funny because dom got kicked out of his house at the young age of
                    // 17 and is now homeless
                    // P.S. the only thing poiontless is you're sharpness. you are not very sharp

                    /*
                     * DOM left the chat.
                     */

                    if (obj1.setShips(boats.get(i).position, boats.get(i).letter) == 1) {

                        obj1.print();
                        break;

                    } else {
                        System.out.println("Invalid Ship Placement, try again: ");
                    }

                } else {
                    System.out.println("Invalid Ship Placement, try again: ");
                }
            }

        }

        System.out.println("Are you playing first? (y/n): ");
        if (cheese.next().toUpperCase().equals("Y")) {
            turnCount = 0;
        }
        while ((obj1.hitCount <= 17) && (obj2.hitCount <= 17)) {
            if (turnCount % 2 == 0) {
                obj2.print();
                System.out.println("Guess co-ordinates (ex. A4): ");
                String cords = cheese.next();

                System.out.println("Hit or miss? (h/m): ");
                String hoM = cheese.next();
                obj2.guess(obj1.translate(cords), hoM);
                obj2.print();
            } else {
                System.out.println("What did they guess? (ex. A4): ");
                int[] incCords = obj1.translate(cheese.next());
                if (obj1.incGuess(incCords) == true) {

                    switch (obj1.board[incCords[0]][incCords[1]]) {

                        case "A":
                            aC.hitcount += 1;
                            break;

                        case "B":
                            bS.hitcount += 1;
                            break;

                        case "C":
                            cS.hitcount += 1;
                            break;

                        case "S":
                            sS.hitcount += 1;
                            break;

                        case "D":
                            dS.hitcount += 1;
                            break;
                    }

                    System.out.println("Hit!");
                } else {
                    System.out.println("Miss!");
                }
            }
            turnCount++;
            obj1.print();
            if ((obj1.hitCount <= 17) && (obj2.hitCount <= 17)) {
                break;
            }
        }
        System.out.println("GG WP GAME OVER!!!!");
    }
}
