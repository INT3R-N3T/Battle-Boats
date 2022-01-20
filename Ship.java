import java.util.ArrayList;

public class Ship {

    public int longness;
    public String name;
    public ArrayList<String> position = new ArrayList<String>();
    public int boomSectionCounter = 0;
    public String letter;
    public int activated = 0;
    public int hitcount = 0;

    public Ship(int gShip) {

        switch (gShip) {

            case 1:
                longness = 5;
                letter = "A";
                name = "Aircraft Carrior";
                break; // Can you tell that dom wrote this part "Carrior"

            case 2:
                longness = 4;
                letter = "B";
                name = "Battle Ship";
                break;

            case 3:
                longness = 3;
                letter = "C";
                name = "Cruser";
                break;

            case 4:
                longness = 3;
                letter = "S";
                name = "Submarine";
                break;

            case 5:
                longness = 2;
                letter = "D";
                name = "Destroyer";
                break;

        }
    }

    public int calculateLocation(int[] gBow, int[] gStern) {
        // Take in input through translate

        int[] head = gBow;
        int[] tail = gStern;

        // pick the left up as the start
        // pick the right down as the end

        int[] start = new int[2];
        int[] end = new int[2];

        if (head[0] == tail[0]) {
            if (head[1] < tail[1]) {

                start[0] = head[0];
                start[1] = head[1];
                end[0] = tail[0];
                end[1] = tail[1];
            } else {

                start[0] = tail[0];
                start[1] = tail[1];
                end[0] = head[0];
                end[1] = head[1];
            }

        }

        else if (head[0] < tail[0]) {

            start[0] = head[0];
            start[1] = head[1];
            end[0] = tail[0];
            end[1] = tail[1];
        }

        else {

            start[0] = tail[0];
            start[1] = tail[1];
            end[0] = head[0];
            end[1] = head[1];
        }

        if (start[0] == end[0]) {

            if ((end[1] - start[1] + 1) != longness) {
                return -1;
            }

            int temp = start[1];
            int temp2 = end[1];
            for (int z = temp; z < temp2 + 1; z++) {

                position.add(String.valueOf(start[0]) + String.valueOf(z));

            }

            activated = 1;
            // this means there was a proper execution of this code.
            return 1;

        }

        if (start[1] == end[1]) {

            if ((end[0] - start[0] + 1) != longness) {
                return -1;
            }

            int temp = start[0];
            int temp2 = end[0];
            for (int z = temp; z < temp2 + 1; z++) {

                position.add(String.valueOf(z) + String.valueOf(start[1]));

            }

            activated = 1;
            // this means there was a proper execution of this code.
            return 1;

        }

        else {

            return -1;
        }

    }
}
