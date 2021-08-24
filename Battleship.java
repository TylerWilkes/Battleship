import java.util.*;

class Main {

  public static final String red = "\u001B[31m";
  public static final String blue = "\u001B[34m";
  public static final String yellow = "\u001B[33m";
  public static final String white = "\u001B[37m";
  public static final String reset = "\u001B[0m";
  public static final String green = "\u001B[32m";
  public static final String cyan = "\u001B[36m";

  public static void delay(int ms) {
  if (true) { //set to false if you want to skip on all purposeful delays
    try {
      Thread.sleep(ms);
    }
    catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
    }
}
}

public static boolean ifYes(String in) {
  if (in.contains("yes") || in.contains("ye") || in.contains("yup") || in.contains("yea") || in.contains("ya") || in.contains("sure")) {
    return true;
  }
  return false;
}
public static boolean ifNo(String in) {
  if (in.contains("no") || in.contains("nope") || in.contains("not") || in.contains("na") || in.contains("nah") || in.contains("stop")) {
    return true;
  }
  return false;
}

public static String numToLetter(int num) {
  String toReturn = "";
  switch(num) {
    case 1:
      toReturn = "a";
      break;
    case 2:
      toReturn = "b";
      break;
    case 3:
      toReturn = "c";
      break;
    case 4:
      toReturn = "d";
      break;
    case 5:
      toReturn = "e";
      break;
    case 6:
      toReturn = "f";
      break;
    case 7:
      toReturn = "g";
      break;
    case 8:
      toReturn = "h";
      break;
    case 9:
      toReturn = "i";
      break;
    case 10:
      toReturn = "j";
      break;
    default:
    System.out.println("This number is not in bounds");
    break;
  }
  return toReturn;
}

public static String[][] inputPlayerShips() {

String[][] allCoordinates = {{"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a10"}, {"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b10"}, {"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10"}, {"d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10"}, {"e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "e10"}, {"f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "f10"}, {"g1", "g2", "g3", "g4", "g5", "g6", "g7", "g8", "g9", "g10"}, {"h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10"}, {"i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i10"}, {"j1", "j2", "j3", "j4", "j5", "j6", "j7", "j8", "j9", "j10"}};

String[][] playerShips = {{"",""}, {"","",""}, {"","",""}, {"","","",""}, {"","","","",""}};
    String[][] testPlayerShips = {{"",""}, {"","",""}, {"","",""}, {"","","",""}, {"","","","",""}};
    Scanner reader6 = new Scanner(System.in);
    int direction = 0;
    boolean ship1 = true;
    boolean ship2 = true;
    boolean ship3 = true;
    boolean ship4 = true;
    boolean ship5 = true;
    String first = "";
    String last = "";

          while (ship1) {
            ship1 = false;
            System.out.println("\nEnter the first and last coordinate for your destroyer (2 tiles long).");
            System.out.println("\nFirst coordinate:");
            first = reader6.nextLine();
            System.out.println("\nLast coordinate:");
            last = reader6.nextLine();

      for (int r = 0; r < allCoordinates.length; r++) { //check for real coordinates
        for (int c = 0; c < allCoordinates.length; c++) {
            if (allCoordinates[r][c].equals(first)) {
              r = 9;
              c = 9;
            }
            else if (r == 9 && c == 9 && !(first.equals(allCoordinates[r][c]))) {
              ship1 = true;
            }
          }
        }
        for (int r = 0; r < allCoordinates.length; r++) {
          for (int c = 0; c < allCoordinates.length; c++) {
            if (allCoordinates[r][c].equals(last)) {
              r = 9;
              c = 9;
            }
            else if (r == 9 && c == 9 && !(last.equals(allCoordinates[r][c]))) {
              ship1 = true;
            }
          }
        }
     if (ship1) {
       System.out.println("\nYou entered an invalid coordinate, try again."); delay(1000);
     }

          if (!ship1) {
            for (int r = 0; r < allCoordinates.length; r++) { //check if real ship
              for (int c = 0; c < allCoordinates[r].length; c++) {
                if (first.equals(allCoordinates[r][c])) {
                  if (!((r >= 1 && last.equals(allCoordinates[r-1][c])) || (r <= 8 && last.equals(allCoordinates[r+1][c])) || (c >= 1 && last.equals(allCoordinates[r][c-1])) || (c <= 8 && last.equals(allCoordinates[r][c+1])))) {
                    ship1 = true;
                    System.out.println("\nInvalid ship endpoint, try again."); delay(1000);
                  }
                }
              }
            }
          }

          }

          playerShips[0][0] = first;
          playerShips[0][1] = last;

          System.out.print(blue);
    System.out.println("\nYour ships:\n");
System.out.println("    1  2  3  4  5  6  7  8  9  10\n __|");
    for (int r = 0; r < allCoordinates.length; r++) {
      for (int c = 0; c < allCoordinates[r].length; c++) {
        if (c == 0) {
          System.out.print(allCoordinates[r][c].substring(0,1) + "   ");
        }

        for (int r2 = 0; r2 < playerShips.length; r2++) {
          for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
            if (allCoordinates[r][c].equals(playerShips[r2][c2])) {
              System.out.print(cyan + "[] " + blue);
              r2 = playerShips.length - 1;
              c2 = 999;
            }
            else if (r2 == playerShips.length - 1 && c2 == playerShips[r2].length - 1) {
              System.out.print(allCoordinates[r][c] + " ");
            }
          }
        }

        if (c == allCoordinates[r].length - 1) {
          System.out.println();
        }
      }
    }
    System.out.print(reset);

          while (ship2) {
            ship2 = false;
            System.out.println("\nEnter first and last coordinate for your cruiser (3 tiles long).");
            System.out.println("\nFirst coordinate:");
            first = reader6.nextLine();
            System.out.println("\nLast coordinate:");
            last = reader6.nextLine();

            for (int r = 0; r < allCoordinates.length; r++) { //check for real coordinates
        for (int c = 0; c < allCoordinates.length; c++) {
            if (allCoordinates[r][c].equals(first)) {
              r = 9;
              c = 9;
            }
            else if (r == 9 && c == 9 && !(first.equals(allCoordinates[r][c]))) {
              ship2 = true;
            }
          }
        }
        for (int r = 0; r < allCoordinates.length; r++) {
          for (int c = 0; c < allCoordinates.length; c++) {
            if (allCoordinates[r][c].equals(last)) {
              r = 9;
              c = 9;
            }
            else if (r == 9 && c == 9 && !(last.equals(allCoordinates[r][c]))) {
              ship2 = true;
            }
          }
        }
     if (ship2) {
       System.out.println("\nYou entered an invalid coordinate, try again."); delay(1000);
     }

          if (!ship2) {
            for (int r = 0; r < allCoordinates.length; r++) { //check if real ship
              for (int c = 0; c < allCoordinates[r].length; c++) {
                if (first.equals(allCoordinates[r][c])) {
                  if (!((r >= 2 && last.equals(allCoordinates[r-2][c])) || (r <= 7 && last.equals(allCoordinates[r+2][c])) || (c >= 2 && last.equals(allCoordinates[r][c-2])) || (c <= 7 && last.equals(allCoordinates[r][c+2])))) {
                    ship2 = true;
                    System.out.println("\nInvalid ship endpoint, try again."); delay(1000);
                  }
                }
              }
            }
          }

        if (!ship2) {
          for (int r = 0; r < allCoordinates.length; r++) {
            for (int c = 0; c < allCoordinates[r].length; c++) {
              if (first.equals(allCoordinates[r][c])) {
                if ((r >= 2 && last.equals(allCoordinates[r-2][c]))) {
                  direction = 0;
                }
                else if ((r <= 7 && last.equals(allCoordinates[r+2][c]))) {
                  direction = 1;
                }
                else if ((c >= 2 && last.equals(allCoordinates[r][c-2]))) {
                  direction = 2;
                }
                else if ((c <= 7 && last.equals(allCoordinates[r][c+2]))) {
                  direction = 3;
                }
              }
            }
          }

          testPlayerShips[1][0] = first;
          for (int r = 0; r < allCoordinates.length; r++) {
            for (int c = 0; c < allCoordinates[r].length; c++) {
              if (first.equals(allCoordinates[r][c])) {
                if (direction == 0) {
                  testPlayerShips[1][1] = allCoordinates[r-1][c];
                }
                if (direction == 1) {
                  testPlayerShips[1][1] = allCoordinates[r+1][c];
                }
                if (direction == 2) {
                  testPlayerShips[1][1] = allCoordinates[r][c-1];
                }
                if (direction == 3) {
                  testPlayerShips[1][1] = allCoordinates[r][c+1];
                }
              }
            }
          }
          testPlayerShips[1][2] = last;

            for (int c1 = 0; c1 < testPlayerShips[1].length; c1++) {
              for (int r2 = 0; r2 < playerShips.length; r2++) {
                for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
                  if (testPlayerShips[1][c1].equals(playerShips[r2][c2])) {
                    ship2 = true;
                  }
                }
              }
            }

            if (ship2) {
              System.out.println("\nOverlappping ships, try again."); delay(1000);
            }
          }
          }

          for (int c = 0; c < testPlayerShips[1].length; c++) {
            playerShips[1][c] = testPlayerShips[1][c];
          }

          System.out.print(blue);
    System.out.println("\nYour ships:\n");
System.out.println("    1  2  3  4  5  6  7  8  9  10\n __|");
    for (int r = 0; r < allCoordinates.length; r++) {
      for (int c = 0; c < allCoordinates[r].length; c++) {
        if (c == 0) {
          System.out.print(allCoordinates[r][c].substring(0,1) + "   ");
        }

        for (int r2 = 0; r2 < playerShips.length; r2++) {
          for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
            if (allCoordinates[r][c].equals(playerShips[r2][c2])) {
              System.out.print(cyan + "[] " + blue);
              r2 = playerShips.length - 1;
              c2 = 999;
            }
            else if (r2 == playerShips.length - 1 && c2 == playerShips[r2].length - 1) {
              System.out.print(allCoordinates[r][c] + " ");
            }
          }
        }

        if (c == allCoordinates[r].length - 1) {
          System.out.println();
        }
      }
    }
    System.out.print(reset);

          while (ship3) {
            ship3 = false;
            System.out.println("\nEnter first and last coordinate for your submarine (3 tiles long).");
            System.out.println("\nFirst coordinate:");
            first = reader6.nextLine();
            System.out.println("\nLast coordinate:");
            last = reader6.nextLine();

            for (int r = 0; r < allCoordinates.length; r++) { //check for real coordinates
        for (int c = 0; c < allCoordinates.length; c++) {
            if (allCoordinates[r][c].equals(first)) {
              r = 9;
              c = 9;
            }
            else if (r == 9 && c == 9 && !(first.equals(allCoordinates[r][c]))) {
              ship3 = true;
            }
          }
        }
        for (int r = 0; r < allCoordinates.length; r++) {
          for (int c = 0; c < allCoordinates.length; c++) {
            if (allCoordinates[r][c].equals(last)) {
              r = 9;
              c = 9;
            }
            else if (r == 9 && c == 9 && !(last.equals(allCoordinates[r][c]))) {
              ship3 = true;
            }
          }
        }
     if (ship3) {
       System.out.println("\nYou entered an invalid coordinate, try again."); delay(1000);
     }

          if (!ship3) {
            for (int r = 0; r < allCoordinates.length; r++) { //check if real ship
              for (int c = 0; c < allCoordinates[r].length; c++) {
                if (first.equals(allCoordinates[r][c])) {
                  if (!((r >= 2 && last.equals(allCoordinates[r-2][c])) || (r <= 7 && last.equals(allCoordinates[r+2][c])) || (c >= 2 && last.equals(allCoordinates[r][c-2])) || (c <= 7 && last.equals(allCoordinates[r][c+2])))) {
                    ship3 = true;
                    System.out.println("\nInvalid ship endpoint, try again."); delay(1000);
                  }
                }
              }
            }
          }

        if (!ship3) {
          for (int r = 0; r < allCoordinates.length; r++) {
            for (int c = 0; c < allCoordinates[r].length; c++) {
              if (first.equals(allCoordinates[r][c])) {
                if ((r >= 2 && last.equals(allCoordinates[r-2][c]))) {
                  direction = 0;
                }
                else if ((r <= 7 && last.equals(allCoordinates[r+2][c]))) {
                  direction = 1;
                }
                else if ((c >= 2 && last.equals(allCoordinates[r][c-2]))) {
                  direction = 2;
                }
                else if ((c <= 7 && last.equals(allCoordinates[r][c+2]))) {
                  direction = 3;
                }
              }
            }
          }

          testPlayerShips[2][0] = first;
          for (int r = 0; r < allCoordinates.length; r++) {
            for (int c = 0; c < allCoordinates[r].length; c++) {
              if (first.equals(allCoordinates[r][c])) {
                if (direction == 0) {
                  testPlayerShips[2][1] = allCoordinates[r-1][c];
                }
                if (direction == 1) {
                  testPlayerShips[2][1] = allCoordinates[r+1][c];
                }
                if (direction == 2) {
                  testPlayerShips[2][1] = allCoordinates[r][c-1];
                }
                if (direction == 3) {
                  testPlayerShips[2][1] = allCoordinates[r][c+1];
                }
              }
            }
          }
          testPlayerShips[2][2] = last;

            for (int c1 = 0; c1 < testPlayerShips[2].length; c1++) {
              for (int r2 = 0; r2 < playerShips.length; r2++) {
                for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
                  if (testPlayerShips[2][c1].equals(playerShips[r2][c2])) {
                    ship3 = true;
                  }
                }
              }
            }

            if (ship3) {
              System.out.println("\nOverlappping ships, try again."); delay(1000);
            }
          }

          }

          for (int c = 0; c < testPlayerShips[2].length; c++) {
            playerShips[2][c] = testPlayerShips[2][c];
          }

          System.out.print(blue);
    System.out.println("\nYour ships:\n");
System.out.println("    1  2  3  4  5  6  7  8  9  10\n __|");
    for (int r = 0; r < allCoordinates.length; r++) {
      for (int c = 0; c < allCoordinates[r].length; c++) {
        if (c == 0) {
          System.out.print(allCoordinates[r][c].substring(0,1) + "   ");
        }

        for (int r2 = 0; r2 < playerShips.length; r2++) {
          for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
            if (allCoordinates[r][c].equals(playerShips[r2][c2])) {
              System.out.print(cyan + "[] " + blue);
              r2 = playerShips.length - 1;
              c2 = 999;
            }
            else if (r2 == playerShips.length - 1 && c2 == playerShips[r2].length - 1) {
              System.out.print(allCoordinates[r][c] + " ");
            }
          }
        }

        if (c == allCoordinates[r].length - 1) {
          System.out.println();
        }
      }
    }
    System.out.print(reset);

          while (ship4) {
            ship4 = false;
            System.out.println("\nEnter first and last coordinate for your battleship (4 tiles long).");
            System.out.println("\nFirst coordinate:");
            first = reader6.nextLine();
            System.out.println("\nLast coordinate:");
            last = reader6.nextLine();

            for (int r = 0; r < allCoordinates.length; r++) { //check for real coordinates
        for (int c = 0; c < allCoordinates.length; c++) {
            if (allCoordinates[r][c].equals(first)) {
              r = 9;
              c = 9;
            }
            else if (r == 9 && c == 9 && !(first.equals(allCoordinates[r][c]))) {
              ship4 = true;
            }
          }
        }
        for (int r = 0; r < allCoordinates.length; r++) {
          for (int c = 0; c < allCoordinates.length; c++) {
            if (allCoordinates[r][c].equals(last)) {
              r = 9;
              c = 9;
            }
            else if (r == 9 && c == 9 && !(last.equals(allCoordinates[r][c]))) {
              ship4 = true;
            }
          }
        }
     if (ship4) {
       System.out.println("\nYou entered an invalid coordinate, try again."); delay(1000);
     }

          if (!ship4) {
            for (int r = 0; r < allCoordinates.length; r++) { //check if real ship
              for (int c = 0; c < allCoordinates[r].length; c++) {
                if (first.equals(allCoordinates[r][c])) {
                  if (!((r >= 3 && last.equals(allCoordinates[r-3][c])) || (r <= 6 && last.equals(allCoordinates[r+3][c])) || (c >= 3 && last.equals(allCoordinates[r][c-3])) || (c <= 6 && last.equals(allCoordinates[r][c+3])))) {
                    ship4 = true;
                    System.out.println("\nInvalid ship endpoint, try again."); delay(1000);
                  }
                }
              }
            }
          }

        if (!ship4) {
          for (int r = 0; r < allCoordinates.length; r++) {
            for (int c = 0; c < allCoordinates[r].length; c++) {
              if (first.equals(allCoordinates[r][c])) {
                if ((r >= 3 && last.equals(allCoordinates[r-3][c]))) {
                  direction = 0;
                }
                else if ((r <= 6 && last.equals(allCoordinates[r+3][c]))) {
                  direction = 1;
                }
                else if ((c >= 3 && last.equals(allCoordinates[r][c-3]))) {
                  direction = 2;
                }
                else if ((c <= 6 && last.equals(allCoordinates[r][c+3]))) {
                  direction = 3;
                }
              }
            }
          }

          testPlayerShips[3][0] = first;
          for (int r = 0; r < allCoordinates.length; r++) {
            for (int c = 0; c < allCoordinates[r].length; c++) {
              if (first.equals(allCoordinates[r][c])) {
                if (direction == 0) {
                  testPlayerShips[3][1] = allCoordinates[r-1][c];
                  testPlayerShips[3][2] = allCoordinates[r-2][c];
                }
                if (direction == 1) {
                  testPlayerShips[3][1] = allCoordinates[r+1][c];
                  testPlayerShips[3][2] = allCoordinates[r+2][c];
                }
                if (direction == 2) {
                  testPlayerShips[3][1] = allCoordinates[r][c-1];
                  testPlayerShips[3][2] = allCoordinates[r][c-2];
                }
                if (direction == 3) {
                  testPlayerShips[3][1] = allCoordinates[r][c+1];
                  testPlayerShips[3][2] = allCoordinates[r][c+2];
                }
              }
            }
          }
          testPlayerShips[3][3] = last;

            for (int c1 = 0; c1 < testPlayerShips[3].length; c1++) {
              for (int r2 = 0; r2 < playerShips.length; r2++) {
                for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
                  if (testPlayerShips[3][c1].equals(playerShips[r2][c2])) {
                    ship4 = true;
                  }
                }
              }
            }

            if (ship4) {
              System.out.println("\nOverlappping ships, try again."); delay(1000);
            }
          }

          }

          for (int c = 0; c < testPlayerShips[3].length; c++) {
            playerShips[3][c] = testPlayerShips[3][c];
          }

          System.out.print(blue);
    System.out.println("\nYour ships:\n");
System.out.println("    1  2  3  4  5  6  7  8  9  10\n __|");
    for (int r = 0; r < allCoordinates.length; r++) {
      for (int c = 0; c < allCoordinates[r].length; c++) {
        if (c == 0) {
          System.out.print(allCoordinates[r][c].substring(0,1) + "   ");
        }

        for (int r2 = 0; r2 < playerShips.length; r2++) {
          for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
            if (allCoordinates[r][c].equals(playerShips[r2][c2])) {
              System.out.print(cyan + "[] " + blue);
              r2 = playerShips.length - 1;
              c2 = 999;
            }
            else if (r2 == playerShips.length - 1 && c2 == playerShips[r2].length - 1) {
              System.out.print(allCoordinates[r][c] + " ");
            }
          }
        }

        if (c == allCoordinates[r].length - 1) {
          System.out.println();
        }
      }
    }
    System.out.print(reset);

          while (ship5) {
            ship5 = false;
            System.out.println("\nEnter first and last coordinate for your carrier (5 tiles long).");
            System.out.println("\nFirst coordinate:");
            first = reader6.nextLine();
            System.out.println("\nLast coordinate:");
            last = reader6.nextLine();

            for (int r = 0; r < allCoordinates.length; r++) { //check for real coordinates
        for (int c = 0; c < allCoordinates.length; c++) {
            if (allCoordinates[r][c].equals(first)) {
              r = 9;
              c = 9;
            }
            else if (r == 9 && c == 9 && !(first.equals(allCoordinates[r][c]))) {
              ship5 = true;
            }
          }
        }
        for (int r = 0; r < allCoordinates.length; r++) {
          for (int c = 0; c < allCoordinates.length; c++) {
            if (allCoordinates[r][c].equals(last)) {
              r = 9;
              c = 9;
            }
            else if (r == 9 && c == 9 && !(last.equals(allCoordinates[r][c]))) {
              ship5 = true;
            }
          }
        }
     if (ship5) {
       System.out.println("\nYou entered an invalid coordinate, try again."); delay(1000);
     }

          if (!ship5) {
            for (int r = 0; r < allCoordinates.length; r++) { //check if real ship
              for (int c = 0; c < allCoordinates[r].length; c++) {
                if (first.equals(allCoordinates[r][c])) {
                  if (!((r >= 4 && last.equals(allCoordinates[r-4][c])) || (r <= 5 && last.equals(allCoordinates[r+4][c])) || (c >= 4 && last.equals(allCoordinates[r][c-4])) || (c <= 5 && last.equals(allCoordinates[r][c+4])))) {
                    ship5 = true;
                    System.out.println("\nInvalid ship endpoint, try again."); delay(1000);
                  }
                }
              }
            }
          }

        if (!ship5) {
          for (int r = 0; r < allCoordinates.length; r++) {
            for (int c = 0; c < allCoordinates[r].length; c++) {
              if (first.equals(allCoordinates[r][c])) {
                if ((r >= 4 && last.equals(allCoordinates[r-4][c]))) {
                  direction = 0;
                }
                else if ((r <= 5 && last.equals(allCoordinates[r+4][c]))) {
                  direction = 1;
                }
                else if ((c >= 4 && last.equals(allCoordinates[r][c-4]))) {
                  direction = 2;
                }
                else if ((c <= 5 && last.equals(allCoordinates[r][c+4]))) {
                  direction = 3;
                }
              }
            }
          }

          testPlayerShips[4][0] = first;
          for (int r = 0; r < allCoordinates.length; r++) {
            for (int c = 0; c < allCoordinates[r].length; c++) {
              if (first.equals(allCoordinates[r][c])) {
                if (direction == 0) {
                  testPlayerShips[4][1] = allCoordinates[r-1][c];
                  testPlayerShips[4][2] = allCoordinates[r-2][c];
                  testPlayerShips[4][3] = allCoordinates[r-3][c];
                }
                if (direction == 1) {
                  testPlayerShips[4][1] = allCoordinates[r+1][c];
                  testPlayerShips[4][2] = allCoordinates[r+2][c];
                  testPlayerShips[4][3] = allCoordinates[r+3][c];
                }
                if (direction == 2) {
                  testPlayerShips[4][1] = allCoordinates[r][c-1];
                  testPlayerShips[4][2] = allCoordinates[r][c-2];
                  testPlayerShips[4][3] = allCoordinates[r][c-3];
                }
                if (direction == 3) {
                  testPlayerShips[4][1] = allCoordinates[r][c+1];
                  testPlayerShips[4][2] = allCoordinates[r][c+2];
                  testPlayerShips[4][3] = allCoordinates[r][c+3];
                }
              }
            }
          }
          testPlayerShips[4][4] = last;

            for (int c1 = 0; c1 < testPlayerShips[4].length; c1++) {
              for (int r2 = 0; r2 < playerShips.length; r2++) {
                for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
                  if (testPlayerShips[4][c1].equals(playerShips[r2][c2])) {
                    ship5 = true;
                  }
                }
              }
            }

            if (ship5) {
              System.out.println("\nOverlappping ships, try again."); delay(1000);
            }
          }

          }

          for (int c = 0; c < testPlayerShips[4].length; c++) {
            playerShips[4][c] = testPlayerShips[4][c];
          }

          return playerShips;
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public static void main(String[] args) {

    String[][] allCoordinates = {{"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a10"}, {"b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8", "b9", "b10"}, {"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10"}, {"d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10"}, {"e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "e10"}, {"f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "f10"}, {"g1", "g2", "g3", "g4", "g5", "g6", "g7", "g8", "g9", "g10"}, {"h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10"}, {"i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i10"}, {"j1", "j2", "j3", "j4", "j5", "j6", "j7", "j8", "j9", "j10"}};

//text out
    //System.out.println("\nGenerating ships...\n");

    String in = "";
    Scanner reader7 = new Scanner(System.in);

    System.out.println("\nWelcome to Battleship!"); delay(2000);
    System.out.println("\nDo you already know how to play Battleship?"); delay(3000);
    in = reader7.nextLine();
    in = in.toLowerCase();
    if (ifYes(in)) {
      System.out.println("\nLet's get started then."); delay(1000);
    }
    else {
      System.out.println("\nWell... there's a lot to cover, but it's not hard."); delay(3000);
      System.out.println("\nFirst thing, is that you don\'t have a childhood."); delay(3000);
      System.out.println("\nSecond thing, we\'ll be playing on a grid that looks like this:\n"); delay(2000);
      System.out.println("    " + blue + "1  2  3  4  5  6  7  8  9  10\n __|");
    for (int r = 0; r < allCoordinates.length; r++) {
      for (int c = 0; c < allCoordinates[r].length; c++) {
        if (c == 0) {
          System.out.print(allCoordinates[r][c].substring(0,1) + "   ");
        }
        System.out.print(allCoordinates[r][c] + " ");
        if (c == allCoordinates[r].length - 1) {
          System.out.println();
        }
      }
    }
    delay(8000);
      System.out.println(reset + "\nWe'll both have to place ships on to this grid."); delay(4000);
      System.out.println("\nThere are 5 total ships, a 2 tile ship, two 3 tile ships, a 4 tile ship and a 5 tile ship."); delay(6000);
      System.out.println("\nShips are not allowed to be placed on top of eachother."); delay(5000);
      System.out.println("\nAnd ships must be a set of tiles put adjecent (next) to eachother."); delay(5000);
      System.out.println("\nAn example of a valid set of coordinates for a ship would be, a1, a2, and a3."); delay(5000);
      System.out.println("\nYou could also place them like so: a1, b1, and c1 to make a vertically placed ship."); delay(6000);
      System.out.println("\nThe only restraint is that a ship cannot be diagonal."); delay(5000);
      System.out.println("\nAfter that we will take turns attempting to guess where eachother\'s ships are."); delay(6000);
      System.out.println("\nYou must hit every tile of a ship for it to be considered sunk."); delay(5000);
      System.out.println("\nThe goal of the game is to sink all of the enemy\'s ships."); delay(5000);
      System.out.println("\nI will let you know when a ship is sunk."); delay(5000);
      System.out.println("\nIn order to keep track of where you have guessed, I will use markers to show you your hits and misses."); delay(7000);
      System.out.println("\nA white coordinate represents a miss."); delay(4000);
      System.out.println("\nAnd a " + red + "red" + reset + " coordinate represents a hit."); delay(4000);
      System.out.println("\nIn single player mode after each of my guesses I'll also show you all the places I have hit and missed."); delay(6000);
      System.out.println("\nThe top of the grid will say \"Your ships:\" and will also show you where your ships are."); delay(7000);
      System.out.println("\nA \"" + cyan + "[]" + reset + "\" represents a tile with a ship."); delay(4000);
      System.out.println("\nA \"" + red + "[]" + reset + "\" represents a tile with a hit ship."); delay(4000);
      System.out.println("\nBest of luck to you!"); delay(3000);
    } //if doesn't know how to play


    boolean playAgain = true;
    boolean asbeccdreeftg = false;

    while (playAgain) {

    System.out.println("\nHow many players do you have (1 or 2)?");
    in = reader7.nextLine();

    while (!(in.equals("1") || in.equals("2"))) {
      System.out.println("\nInvalid number of players."); delay(1000);
      System.out.println("\nHow many players do you have (1 or 2)?");
      in = reader7.nextLine();
    }

        for (int i = 0; i <= 100; i++) {
      System.out.println();
    }

    if (in.equals("1")) {
      
    if (asbeccdreeftg) {
      System.out.println("\nNuclear support attempt: SUCCESSFUL"); delay(2000);
      System.out.println("\nReloading arsenal..."); delay(5000);
      System.out.println("\nArsenal reload: SUCCESSFUL"); delay(2000);
      System.out.println("\nCaptain, we have another war to fight..."); delay(4000);
      asbeccdreeftg = false;
    }


    String cpuRanLetter;
    asbeccdreeftg = false;
    boolean cpuTryHorShipAgain = true;
    boolean cpuTryVirShipAgain = true;
    int cpuShipNumCord;
    int cpuTryVirShipAgainCount = 0;
    int HorOrVir;
    int storeVirLetterNum;
    int cpuTryHorShipAgainCount = 0;

    //cpuShips generator start
    String[][] cpuShips = {{"", ""}, {"", "", ""}, {"", "", ""}, {"", "", "", ""}, {"", "", "", "", ""}};

    for (int r = 0; r < cpuShips.length; r++) {
      cpuTryHorShipAgain = true;
      cpuTryHorShipAgainCount = 0;
      cpuTryVirShipAgain = true;
      HorOrVir = (int) (Math.random() * 2 + 1);
      
        

      if (HorOrVir == 1) {
        while (cpuTryHorShipAgain) {
          cpuShipNumCord = (int) (Math.random() * (9 - (cpuShips[r].length)) + 1);
          cpuRanLetter = numToLetter((int) (Math.random() * 10 + 1));

          for (int c = 0; c < cpuShips[r].length; c++) {
        
        cpuTryHorShipAgain = true;
        cpuTryHorShipAgainCount = 0;
        

      

        switch (c) {
          case 0:
            cpuShips[r][c] = cpuRanLetter + cpuShipNumCord;
          break;
          case 1:
            cpuShips[r][c] = cpuRanLetter + (cpuShipNumCord + 1);
          break;
          case 2:
            cpuShips[r][c] = cpuRanLetter + (cpuShipNumCord + 2);
          break;
          case 3:
            cpuShips[r][c] = cpuRanLetter + (cpuShipNumCord + 3);
          break;
          case 4:
            cpuShips[r][c] = cpuRanLetter + (cpuShipNumCord + 4);
          break;
        }

        }
        
       for (int r2 = 0; r2 < cpuShips.length; r2++) {
          for (int c2 = 0; c2 < cpuShips[r2].length; c2++) {
              for (int c3 = 0; c3 < cpuShips[r].length; c3++) {
                if (cpuShips[r][c3].equals(cpuShips[r2][c2])) {
                  cpuTryHorShipAgainCount++;
                }
              }
          }
        }
        if (cpuTryHorShipAgainCount == cpuShips[r].length) {
          cpuTryHorShipAgain = false;
        }
        

      }
    }






    if (HorOrVir == 2) {
      while (cpuTryVirShipAgain) {
          cpuShipNumCord = (int) (Math.random() * 10 + 1);
          storeVirLetterNum = (int) (Math.random() * (9 - (cpuShips[r].length)) + 1);
        for (int c = 0; c < cpuShips[r].length; c++) {
        
        cpuTryVirShipAgain = true;
        cpuTryVirShipAgainCount = 0;
        
      

      

        switch (c) {
          case 0:
            cpuShips[r][c] = numToLetter(storeVirLetterNum) + cpuShipNumCord;
          break;
          case 1:
            cpuShips[r][c] = numToLetter(storeVirLetterNum + 1) + cpuShipNumCord;
          break;
          case 2:
            cpuShips[r][c] = numToLetter(storeVirLetterNum + 2) + cpuShipNumCord;
          break;
          case 3:
            cpuShips[r][c] = numToLetter(storeVirLetterNum + 3) + cpuShipNumCord;
          break;
          case 4:
            cpuShips[r][c] = numToLetter(storeVirLetterNum + 4) + cpuShipNumCord;
          break;
        }

        }
        
        for (int r2 = 0; r2 < cpuShips.length; r2++) {
          for (int c2 = 0; c2 < cpuShips[r2].length; c2++) {
              for (int c3 = 0; c3 < cpuShips[r].length; c3++) {
                if (cpuShips[r][c3].equals(cpuShips[r2][c2])) {
                  cpuTryVirShipAgainCount++;
                }
              }
          }
        }
        if (cpuTryVirShipAgainCount == cpuShips[r].length) {
          cpuTryVirShipAgain = false;
        }

      }
    }

  } // close cycle through ships for loop
    

//text out ship locations
    //for (int r = 0; r < cpuShips.length; r++) {
      //for (int c = 0; c < cpuShips[r].length; c++) {
        //System.out.print(cpuShips[r][c] + " ");
        //if (c == cpuShips[r].length - 1) {
          //System.out.println();
        //}
      //}
    //}

    for (int i = 0; i <= 100; i++) {
      System.out.println();
    }

System.out.println("\nI already placed my ships, it's your turn now."); delay(2000);
System.out.println("\nHere's the grid layout:\n");
System.out.println("    " + blue + "1  2  3  4  5  6  7  8  9  10\n __|");
    for (int r = 0; r < allCoordinates.length; r++) {
      for (int c = 0; c < allCoordinates[r].length; c++) {
        if (c == 0) {
          System.out.print(allCoordinates[r][c].substring(0,1) + "   ");
        }
        System.out.print(allCoordinates[r][c] + " ");
        if (c == allCoordinates[r].length - 1) {
          System.out.println();
        }
      }
    }
    System.out.print(reset);
    delay(3000);
    //cpuShips generator close









    //player ship input start
    String[][] playerShips = {{"",""}, {"","",""}, {"","",""}, {"","","",""}, {"","","","",""}};
    Scanner reader6 = new Scanner(System.in);
    
    playerShips = inputPlayerShips();

    for (int i = 0; i <= 100; i++) {
      System.out.println();
    }

// player ships input close












    
    String cpuGuess = "";
    String cpuLetter;
    String playerCordGuess;
    String cpuLastHit = "";
    String cpuOriginalHit = "";
    int cpuNum;
    int timesGuessed = 0;
    int playerHits = 0;
    int cpuHits = 0;
    int cpuTimesHit = 0;
    int rowOfHitShip = 0;
    int directionsGuessed = 0;
    int directionGoing = 0;
    int playerTimesHit = 0;
    boolean stillShips = true; 
    boolean playerHit = false;
    boolean cpuHit = false;
    boolean cpuRunHitSequence = false;
    boolean hitMiss = false;
    boolean up = true;
    boolean down = true;
    boolean left = true;
    boolean right = true;
    boolean difShip = false;
    boolean desSunk = false;
    boolean cruSunk = false;
    boolean subSunk = false;
    boolean batSunk = false;
    boolean carSunk = false;
    boolean tryGuessAgain = true;
    ArrayList<String> cpuGuesses = new ArrayList<String>();
    ArrayList<String> playerGuesses = new ArrayList<String>();
    ArrayList<String> playerHitCords = new ArrayList<String>();
    ArrayList<String> cpuHitCords = new ArrayList<String>();
    playerHitCords.add("anwejbvbewifber");
    playerGuesses.add("anwejbvbewifber");
    cpuHitCords.add("anwejbvbewifber");
    cpuGuesses.add("anwejbvbewifber");



    while (stillShips) {
  cpuHit = false;
      


  //start the cpu guessing


if (cpuRunHitSequence) {

  if (hitMiss) {

for (int r = 0; r < allCoordinates.length; r++) {
  for (int c = 0; c < allCoordinates.length; c++) {
    if (allCoordinates[r][c].equals(cpuOriginalHit)) {

      if((directionGoing == 0)) {
        cpuGuess = allCoordinates[r+1][c];
        timesGuessed++;
      }
      

      if((directionGoing == 1)) {
        cpuGuess = allCoordinates[r-1][c];
        timesGuessed++;
      }


      if((directionGoing == 2)) {
        cpuGuess = allCoordinates[r][c+1];
        timesGuessed++;
      }


      if((directionGoing == 3)) {
        cpuGuess = allCoordinates[r][c-1];
        timesGuessed++;
      }
      
      cpuGuesses.add(cpuGuess);

    }
  }
}

  } //if hitMiss

  else {
for (int r = 0; r < allCoordinates.length; r++) {
  for (int c = 0; c < allCoordinates.length; c++) {
    if (allCoordinates[r][c].equals(cpuLastHit)) {


      if((up && directionsGuessed == 0)) {
        if (r != 0) {
        cpuGuess = allCoordinates[r-1][c];
        for (int r2 = 0; r2 < playerShips.length; r2++) {
          for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
            if (playerShips[r2][c2].equals(cpuGuess)) {
              if (r2 != rowOfHitShip) {
                up = false;
                directionsGuessed++;
              }
            }
          }
        }
              if (up) {
                for (int i = 0; i < cpuGuesses.size(); i++) {
                  if (cpuGuesses.get(i).equals(cpuGuess)) {
                    up = false;
                    directionsGuessed++;
                  }
                  else {
                    if (i >= cpuGuesses.size() - 1) {
                      timesGuessed++;
                    }
                  }
                }
              }
        }
        else {
        up = false;
        directionsGuessed++;
      }
      }
      

      if((down && directionsGuessed == 1)) {
        if (r != 9) {
        cpuGuess = allCoordinates[r+1][c];
        for (int r2 = 0; r2 < playerShips.length; r2++) {
          for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
            if (playerShips[r2][c2].equals(cpuGuess)) {
              if (r2 != rowOfHitShip) {
                down = false;
                directionsGuessed++;
              }
            }
          }
        }
              if (down) {
                for (int i = 0; i < cpuGuesses.size(); i++) {
                  if (cpuGuesses.get(i).equals(cpuGuess)) {
                    down = false;
                    directionsGuessed++;
                  }
                  else {
                    if (i >= cpuGuesses.size() - 1) {
                      timesGuessed++;
                    }
                  }
                }
              }
        }
        else {
        down = false;
        directionsGuessed++;
      }
      }


      if((left && directionsGuessed == 2)) {
        if (c != 0) {
        cpuGuess = allCoordinates[r][c-1];
        for (int r2 = 0; r2 < playerShips.length; r2++) {
          for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
            if (playerShips[r2][c2].equals(cpuGuess)) {
              if (r2 != rowOfHitShip) {
                left = false;
                directionsGuessed++;
              }
            }
          }
        }
              if (left) {
                for (int i = 0; i < cpuGuesses.size(); i++) {
                  if (cpuGuesses.get(i).equals(cpuGuess)) {
                    left = false;
                    directionsGuessed++;
                  }
                  else {
                    if (i >= cpuGuesses.size() - 1) {
                      timesGuessed++;
                    }
                  }
                }
              }
        }
        else {
        left = false;
        directionsGuessed++;
      }
      }


      if((right && directionsGuessed == 3)) {
        if (c != 9) {
        cpuGuess = allCoordinates[r][c+1];
        for (int r2 = 0; r2 < playerShips.length; r2++) {
          for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
            if (playerShips[r2][c2].equals(cpuGuess)) {
              if (r2 != rowOfHitShip) {
                right = false;
                directionsGuessed++;
              }
            }
          }
        }
              if (right) {
                for (int i = 0; i < cpuGuesses.size(); i++) {
                  if (cpuGuesses.get(i).equals(cpuGuess)) {
                    right = false;
                    directionsGuessed++;
                  }
                  else {
                    if (i >= cpuGuesses.size() - 1) {
                      timesGuessed++;
                    }
                  }
                }
              }
        }
        else {
        right = false;
        directionsGuessed++;
      }
      }

      cpuGuesses.add(cpuGuess);
      directionsGuessed++;

    }
  }
}
} //else



for (int i = 0; i < playerShips[rowOfHitShip].length; i++) {
          if (cpuGuess.equals(playerShips[rowOfHitShip][i])) {

            difShip = false;

            System.out.println("\nI hit at, " + cpuGuess + "."); delay(1500);
            if (hitMiss) {
              cpuOriginalHit = cpuGuess;
            }
            else {
              cpuLastHit = cpuGuess;
              directionsGuessed--;

              for (int r = 0; r < allCoordinates.length; r++) {
                for (int c = 0; c < allCoordinates[r].length; c++) {
                  if (allCoordinates[r][c].equals(cpuLastHit)) {

              if (directionsGuessed == 0) {
                if (r != 0) {
                  for (int r2 = 0; r2 < playerShips.length; r2++) {
                    for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
                      if (playerShips[r2][c2].equals(allCoordinates[r - 1][c])) {
                        if (r2 != rowOfHitShip) {
                          difShip = true;
                        }
                      }
                    }
                  }
                }
              }

              if (directionsGuessed == 1) {
                if (r != 9) {
                  for (int r2 = 0; r2 < playerShips.length; r2++) {
                    for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
                      if (playerShips[r2][c2].equals(allCoordinates[r + 1][c])) {
                        if (r2 != rowOfHitShip) {
                          difShip = true;
                        }
                      }
                    }
                  }
                }
              }

              if (directionsGuessed == 2) {
                if (c != 0) {
                  for (int r2 = 0; r2 < playerShips.length; r2++) {
                    for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
                      if (playerShips[r2][c2].equals(allCoordinates[r][c - 1])) {
                        if (r2 != rowOfHitShip) {
                          difShip = true;
                        }
                      }
                    }
                  }
                }
              }

              if (directionsGuessed == 3) {
                if (c != 9) {
                  for (int r2 = 0; r2 < playerShips.length; r2++) {
                    for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
                      if (playerShips[r2][c2].equals(allCoordinates[r][c + 1])) {
                        if (r2 != rowOfHitShip) {
                          difShip = true;
                        }
                      }
                    }
                  }
                }
              }
                    
                  }
                }
              }

              for (int r = 0; r < allCoordinates.length; r++) {
                for (int c = 0; c < allCoordinates[r].length; c++) {
                  if (allCoordinates[r][c].equals(cpuLastHit)) {

                      if ((r == 0 && directionsGuessed == 0) || difShip) {
                        hitMiss = true;
                        directionGoing = directionsGuessed;
                      }
                      else if ((r == 9 && directionsGuessed == 1) || difShip) {
                        hitMiss = true;
                        directionGoing = directionsGuessed;
                      }
                      else if ((c == 0 && directionsGuessed == 2) || difShip) {
                        hitMiss = true;
                        directionGoing = directionsGuessed;
                      }
                      else if ((c == 9 && directionsGuessed == 3) || difShip) {
                        hitMiss = true;
                        directionGoing = directionsGuessed;
                      }
                      else { }



                    }
                  }
                }
            }
            cpuHitCords.add(cpuGuess);
            cpuTimesHit++;
            cpuHits++;
            i = 999;
          }
          else {
            if (i == playerShips[rowOfHitShip].length - 1) {
              System.out.println("\nI missed at, " + cpuGuess + "."); delay(1500);
              if (cpuTimesHit >= 2) {
                hitMiss = true;
                directionGoing = directionsGuessed - 1;
              }
            }
          }
        }



  if (cpuTimesHit == playerShips[rowOfHitShip].length) {
cpuRunHitSequence = false;
cpuTimesHit = 0;
System.out.print(red);
switch (rowOfHitShip) {
  case 0:
    System.out.println("\nI sunk your destroyer (2 tile ship)."); delay(2000);
  break;
  case 1:
    System.out.println("\nI sunk your cruiser (3 tile ship)."); delay(2000);
  break;
  case 2:
    System.out.println("\nI sunk your submarine (3 tile ship)."); delay(2000);
  break;
  case 3:
    System.out.println("\nI sunk your battleship (4 tile ship)."); delay(2000);
  break;
  case 4:
    System.out.println("\nI sunk your carrier (5 tile ship)."); delay(2000);
  break;
}
System.out.print(reset);
  }
}

    else {
    cpuLetter = numToLetter((int)(Math.random() * 10 + 1));
    cpuNum = (int)(Math.random() * 10 + 1);
    cpuGuess = cpuLetter + cpuNum;

    //text out override first guess
    //cpuGuess = "e3";

    for (int i = 0; i < cpuGuesses.size(); i++) {
      if (cpuGuess.equals(cpuGuesses.get(i))) {
        while (cpuGuess.equals(cpuGuesses.get(i))) {
          cpuLetter = numToLetter((int)(Math.random() * 10 + 1));
          cpuNum = (int)(Math.random() * 10 + 1);
          cpuGuess = cpuLetter + cpuNum;
        }
        i = 0;
      }
    }

  cpuGuesses.add(cpuGuess);
  cpuHit = false;

    for (int r = 0; r < playerShips.length; r++) {
      for (int c = 0; c < playerShips[r].length; c++) {
        if (cpuGuess.equals(playerShips[r][c])) {
          cpuHits++;
          cpuHit = true;
          cpuOriginalHit = cpuGuess;
          cpuLastHit = cpuGuess;
          cpuRunHitSequence = true;
          rowOfHitShip = r;
          cpuTimesHit++;
          hitMiss = false;
          up = true;
          down = true;
          left = true;
          right = true;
          directionsGuessed = 0;
          cpuHitCords.add(cpuGuess);
        }
      }
    }

    if (timesGuessed == 0) {
      System.out.println("\nI'll guess first..."); delay(1000);
    }

    if (cpuHit) {
      System.out.println("\nI hit at, " + cpuGuess +"."); delay(1500);
    }
    else {
      System.out.println("\nI missed at, " + cpuGuess +"."); delay(1500);
    }
    }
System.out.print(blue);
    System.out.println("\nYour ships:\n");
System.out.println("    1  2  3  4  5  6  7  8  9  10\n __|");
    for (int r = 0; r < allCoordinates.length; r++) {
      for (int c = 0; c < allCoordinates[r].length; c++) {
        if (c == 0) {
          System.out.print(allCoordinates[r][c].substring(0,1) + "   ");
        }
        

        for (int i = 0; i < cpuHitCords.size(); i++) {
          if (allCoordinates[r][c].equals(cpuHitCords.get(i))) {
            System.out.print(red + "[] " + blue);
            i = 999;
          }
          else {
            if (i == cpuHitCords.size() - 1) {
              for (int n = 0; n < cpuGuesses.size(); n++) {
                if (allCoordinates[r][c].equals(cpuGuesses.get(n))) {
                  System.out.print(white + allCoordinates[r][c] + " " + blue);
                  n = 999;
                }
                else {
                  if (n == cpuGuesses.size() - 1) {
                    for (int r2 = 0; r2 < playerShips.length; r2++) {
                      for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
                        if (allCoordinates[r][c].equals(playerShips[r2][c2])) {
                          System.out.print(cyan + "[] " + blue);
                          r2 = playerShips.length - 1;
                          c2 = 999;
                        }
                          else {
                            if (r2 == playerShips.length - 1 && c2 == playerShips[r2].length - 1) {
                              System.out.print(allCoordinates[r][c] + " ");
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }

        if (c == allCoordinates[r].length - 1) {
          System.out.println();
        }
      }
    }
    System.out.print(reset);
      
  // finish making cpu guess


//text out
//System.out.println("\n" + Arrays.toString(cpuGuesses.toArray()));

    //player guess input start

delay(5000);
for (int t = 0; t <= 100; t++) {
  System.out.println();
}
System.out.println(blue);
System.out.println("\nYour grid:\n");
System.out.println("    1  2  3  4  5  6  7  8  9  10\n __|");
    for (int r = 0; r < allCoordinates.length; r++) {
      for (int c = 0; c < allCoordinates[r].length; c++) {
        if (c == 0) {
          System.out.print(allCoordinates[r][c].substring(0,1) + "   ");
        }
        

        for (int i = 0; i < playerHitCords.size(); i++) {
          if (allCoordinates[r][c].equals(playerHitCords.get(i))) {
            System.out.print(red + allCoordinates[r][c] + " " + blue);
            i = 999;
          }
          else {
            if (i == playerHitCords.size() - 1) {
              for (int n = 0; n < playerGuesses.size(); n++) {
                if (allCoordinates[r][c].equals(playerGuesses.get(n))) {
                  System.out.print(white + allCoordinates[r][c] + " " + blue);
                  n = 999;
                }
                else {
                  if (n == playerGuesses.size() - 1) {
                    System.out.print(allCoordinates[r][c] + " ");
                  }
                }
              }
            }
          }
        }

        if (c == allCoordinates[r].length - 1) {
          System.out.println();
        }
      }
    }
System.out.println(reset);


      
      System.out.println("\nEnter your guess:");
      playerCordGuess = reader6.nextLine();

      playerHit = false;
      tryGuessAgain = true;
      
      
      if (playerCordGuess.equals("asbeccdreeftg hciojdkel")) {
        asbeccdreeftg = true;
      }

      while (tryGuessAgain) {
      tryGuessAgain = false;
      for (int i = 0; i < playerGuesses.size(); i++) {
        if (playerCordGuess.equals(playerGuesses.get(i))) {
          System.out.println("\nYou have already guessed there, try again."); delay(1000);
          tryGuessAgain = true;
        }
      }
          for (int r = 0; r < allCoordinates.length; r++) {
            for (int c = 0; c < allCoordinates.length; c++) {
              if ((allCoordinates[r][c].equals(playerCordGuess))) {
                r = 999;
                c = 999;
              }
              if (r == 9 && c == 9) {
                tryGuessAgain = true;
                System.out.println("\nInvalid coordinate, try again."); delay(1000);
              }
            }
          }

          if (asbeccdreeftg && playerCordGuess.equals("h8")) {
          System.out.println("\naSbEcCdReEfTg hCiOjDkEl mAnCoCpEqPrTsEtDu.");
          System.out.println(red + "\nNUCLEAR STRIKE INITIALIZED" + reset);
          playerHits = 17;
          }

          if (tryGuessAgain) {
          System.out.println("\nEnter your guess:");
          playerCordGuess = reader6.nextLine();
          }
      }

      playerGuesses.add(playerCordGuess);
    

    for (int r = 0; r < cpuShips.length; r++) {
         for (int c = 0; c < cpuShips[r].length; c++) {
          
          if (playerCordGuess.equals(cpuShips[r][c])) {
            System.out.println("\nHit!"); delay(2000);
            playerHitCords.add(playerCordGuess);
            playerHit = true;
            playerHits++;
            for (int r2 = 0; r2 < cpuShips.length; r2++) {
              playerTimesHit = 0;
              for (int c2 = 0; c2 < cpuShips[r2].length; c2++) {
                for (int i = 0; i < playerHitCords.size(); i++) {
                  if (cpuShips[r2][c2].equals(playerHitCords.get(i))) {
                    playerTimesHit++;
                  }
                }
              }
              if (playerTimesHit == cpuShips[r2].length) {
                System.out.print(green);
                switch (r2) {
                  case 0:
                  if (!desSunk) {
                    System.out.println("\nYou sunk my destroyer (2 tile ship)."); delay(2000);
                    desSunk = true;
                  }
                  break;
                  case 1:
                  if (!cruSunk) {
                    System.out.println("\nYou sunk my cruiser (3 tile ship)."); delay(2000);
                    cruSunk = true;
                  }
                  break;
                  case 2:
                  if (!subSunk) {
                    System.out.println("\nYou sunk my submarine (3 tile ship)."); delay(2000);
                    subSunk = true;
                  }
                  break;
                  case 3:
                  if (!batSunk) {
                    System.out.println("\nYou sunk my battleship (4 tile ship)."); delay(2000);
                    batSunk = true;
                  }
                  break;
                  case 4:
                  if (!carSunk) {
                    System.out.println("\nYou sunk my carrier (5 tile ship)."); delay(2000);
                    carSunk = true;
                  }
                  break;
                }
                System.out.print(reset);
              }
            }
          }
            
         }
       }
       if (!playerHit) {
         System.out.println("\nMiss!"); delay(2000);
       }
       
     // player done making original guess
    timesGuessed++;
    if (playerHits >= 17 || cpuHits >= 17) {
    stillShips = false;
    }
  } //loop guessing close

    if (playerHits == 17 && cpuHits == 17) {
      System.out.println("Wow... we tied. That was very intense, but good game!");
    }
    else if (playerHits == 17) {
      System.out.println("\nGood job, you beat me in battle ship.");
    }
    else {
      System.out.println("\nHa, you lost to me. Can't imagine loosing.");
    }

    } //end single player




















    else { //start two player

    System.out.println("\nPlayer 1 input ships");

    String[][] playerShips = {{"",""}, {"","",""}, {"","",""}, {"","","",""}, {"","","","",""}};
    Scanner reader6 = new Scanner(System.in);

    System.out.println("\nHere's the grid layout:\n");
System.out.println("    " + blue + "1  2  3  4  5  6  7  8  9  10\n __|");
    for (int r = 0; r < allCoordinates.length; r++) {
      for (int c = 0; c < allCoordinates[r].length; c++) {
        if (c == 0) {
          System.out.print(allCoordinates[r][c].substring(0,1) + "   ");
        }
        System.out.print(allCoordinates[r][c] + " ");
        if (c == allCoordinates[r].length - 1) {
          System.out.println();
        }
      }
    }
    System.out.print(reset);
    delay(3000);

    playerShips = inputPlayerShips();

for (int i = 0; i <= 1100; i++) {
      System.out.println();
    }

    String[][] playerShips2 = {{"",""}, {"","",""}, {"","",""}, {"","","",""}, {"","","","",""}};

    System.out.println("\nPlayer 2 input ships");

    System.out.println("\nHere's the grid layout:\n");
System.out.println("    " + blue + "1  2  3  4  5  6  7  8  9  10\n __|");
    for (int r = 0; r < allCoordinates.length; r++) {
      for (int c = 0; c < allCoordinates[r].length; c++) {
        if (c == 0) {
          System.out.print(allCoordinates[r][c].substring(0,1) + "   ");
        }
        System.out.print(allCoordinates[r][c] + " ");
        if (c == allCoordinates[r].length - 1) {
          System.out.println();
        }
      }
    }
    System.out.print(reset);
    delay(3000);

    playerShips2 = inputPlayerShips();

    for (int i = 0; i <= 1100; i++) {
      System.out.println();
    }


    String playerGuess = "";
    int playerHits = 0;
    int playerHits2 = 0;
    int playerTimesHit = 0;
    int playerTimesHit2 = 0;
    boolean stillShips2 = true;
    boolean desSunk = false;
    boolean cruSunk = false;
    boolean subSunk = false;
    boolean batSunk = false;
    boolean carSunk = false;
    boolean desSunk2 = false;
    boolean cruSunk2 = false;
    boolean subSunk2 = false;
    boolean batSunk2 = false;
    boolean carSunk2 = false;
    boolean tryGuessAgain = true;
    boolean tryGuessAgain2 = true;
    ArrayList<String> playerGuesses = new ArrayList<String>();
    ArrayList<String> playerHitCords = new ArrayList<String>();
    playerHitCords.add("anwejbvbewifber");
    playerGuesses.add("anwejbvbewifber");
    ArrayList<String> playerGuesses2 = new ArrayList<String>();
    ArrayList<String> playerHitCords2 = new ArrayList<String>();
    playerHitCords2.add("anwejbvbewifber");
    playerGuesses2.add("anwejbvbewifber");

    Scanner reader10 = new Scanner(System.in);

    while (stillShips2) {

      for (int i = 0; i <= 100; i++) {
        System.out.println();
      }

System.out.println("\nSHIP STATUS:\n");
System.out.print(white + "DESTROYER: ");
if (desSunk2) {
  System.out.println(red + "OFFLINE");
}
else {
  System.out.println(green + "ONLINE");
}
System.out.print(white + "CRUISER: ");
if (cruSunk2) {
  System.out.println(red + "OFFLINE");
}
else {
  System.out.println(green + "ONLINE");
}
System.out.print(white + "SUBMARINE: ");
if (subSunk2) {
  System.out.println(red + "OFFLINE");
}
else {
  System.out.println(green + "ONLINE");
}
System.out.print(white + "BATTLESHIP: ");
if (batSunk2) {
  System.out.println(red + "OFFLINE");
}
else {
  System.out.println(green + "ONLINE");
}
System.out.print(white + "CARRIER: ");
if (carSunk2) {
  System.out.println(red + "OFFLINE");
}
else {
  System.out.println(green + "ONLINE");
}
System.out.print(reset);

System.out.print(blue);
System.out.println("\nYour grid:\n");
System.out.println("    1  2  3  4  5  6  7  8  9  10\n __|");
    for (int r = 0; r < allCoordinates.length; r++) {
      for (int c = 0; c < allCoordinates[r].length; c++) {
        if (c == 0) {
          System.out.print(allCoordinates[r][c].substring(0,1) + "   ");
        }
        

        for (int i = 0; i < playerHitCords.size(); i++) {
          if (allCoordinates[r][c].equals(playerHitCords.get(i))) {
            System.out.print(red + allCoordinates[r][c] + " " + blue);
            i = 999;
          }
          else {
            if (i == playerHitCords.size() - 1) {
              for (int n = 0; n < playerGuesses.size(); n++) {
                if (allCoordinates[r][c].equals(playerGuesses.get(n))) {
                  System.out.print(white + allCoordinates[r][c] + " " + blue);
                  n = 999;
                }
                else {
                  if (n == playerGuesses.size() - 1) {
                    System.out.print(allCoordinates[r][c] + " ");
                  }
                }
              }
            }
          }
        }

        if (c == allCoordinates[r].length - 1) {
          System.out.println();
        }
      }
    }
System.out.print(reset);

delay(1000);

tryGuessAgain = true;
while (tryGuessAgain) {
tryGuessAgain = false;
System.out.println("\nPlayer 1, enter your guess:");
playerGuess = reader10.nextLine();

for (int r = 0; r < allCoordinates.length; r++) {
  for (int c = 0; c < allCoordinates.length; c++) {
    if (allCoordinates[r][c].equals(playerGuess)) {
      r = 999;
      c = 999;
    }
    else if (r == 9 && c == 9) {
      tryGuessAgain = true;
      System.out.println("\nInvalid coordinate, try again."); delay(1000);
    }
  }
}

  for (int i = 0; i < playerGuesses.size(); i++) {
    if (playerGuesses.get(i).equals(playerGuess)) {
      tryGuessAgain = true;
      System.out.println("\nYou have already guessed there, try again."); delay(1000);
    }
  }

}

for (int r = 0; r < playerShips2.length; r++) {
  for (int c = 0; c < playerShips2[r].length; c++) {
    if (playerShips2[r][c].equals(playerGuess)) {
      playerHits++;
      playerGuesses.add(playerGuess);
      playerHitCords.add(playerGuess);
      System.out.println("\nHit!"); delay(2000);
      r = 4;
      c = 4;
    }
    else if (c == 4) {
      playerGuesses.add(playerGuess);
      System.out.println("\nMiss!"); delay(2000);
    }
  }
}

            for (int r2 = 0; r2 < playerShips2.length; r2++) {
              playerTimesHit = 0;
              for (int c2 = 0; c2 < playerShips2[r2].length; c2++) {
                for (int i = 0; i < playerHitCords.size(); i++) {
                  if (playerShips2[r2][c2].equals(playerHitCords.get(i))) {
                    playerTimesHit++;
                  }
                }
              }
              if (playerTimesHit == playerShips2[r2].length) {
                System.out.print(green);
                switch (r2) {
                  case 0:
                  if (!desSunk) {
                    System.out.println("\nYou sunk player 2\'s destroyer (2 tile ship)."); delay(2000);
                    desSunk = true;
                  }
                  break;
                  case 1:
                  if (!cruSunk) {
                    System.out.println("\nYou sunk player 2\'s cruiser (3 tile ship)."); delay(2000);
                    cruSunk = true;
                  }
                  break;
                  case 2:
                  if (!subSunk) {
                    System.out.println("\nYou sunk player 2\'s submarine (3 tile ship)."); delay(2000);
                    subSunk = true;
                  }
                  break;
                  case 3:
                  if (!batSunk) {
                    System.out.println("\nYou sunk player 2\'s battleship (4 tile ship)."); delay(2000);
                    batSunk = true;
                  }
                  break;
                  case 4:
                  if (!carSunk) {
                    System.out.println("\nYou sunk player 2\'s carrier (5 tile ship)."); delay(2000);
                    carSunk = true;
                  }
                  break;
                }
                System.out.print(reset);
              }
            }
            delay(2000);

for (int i = 0; i <= 100; i++) {
  System.out.println();
}

System.out.println("\nSHIP STATUS:\n");
System.out.print(white + "DESTROYER: ");
if (desSunk) {
  System.out.println(red + "OFFLINE");
}
else {
  System.out.println(green + "ONLINE");
}
System.out.print(white + "CRUISER: ");
if (cruSunk) {
  System.out.println(red + "OFFLINE");
}
else {
  System.out.println(green + "ONLINE");
}
System.out.print(white + "SUBMARINE: ");
if (subSunk) {
  System.out.println(red + "OFFLINE");
}
else {
  System.out.println(green + "ONLINE");
}
System.out.print(white + "BATTLESHIP: ");
if (batSunk) {
  System.out.println(red + "OFFLINE");
}
else {
  System.out.println(green + "ONLINE");
}
System.out.print(white + "CARRIER: ");
if (carSunk) {
  System.out.println(red + "OFFLINE");
}
else {
  System.out.println(green + "ONLINE");
}
System.out.print(reset);

System.out.print(blue);
System.out.println("\nYour grid:\n");
System.out.println("    1  2  3  4  5  6  7  8  9  10\n __|");
    for (int r = 0; r < allCoordinates.length; r++) {
      for (int c = 0; c < allCoordinates[r].length; c++) {
        if (c == 0) {
          System.out.print(allCoordinates[r][c].substring(0,1) + "   ");
        }
        

        for (int i = 0; i < playerHitCords2.size(); i++) {
          if (allCoordinates[r][c].equals(playerHitCords2.get(i))) {
            System.out.print(red + allCoordinates[r][c] + " " + blue);
            i = 999;
          }
          else {
            if (i == playerHitCords2.size() - 1) {
              for (int n = 0; n < playerGuesses2.size(); n++) {
                if (allCoordinates[r][c].equals(playerGuesses2.get(n))) {
                  System.out.print(white + allCoordinates[r][c] + " " + blue);
                  n = 999;
                }
                else {
                  if (n == playerGuesses2.size() - 1) {
                    System.out.print(allCoordinates[r][c] + " ");
                  }
                }
              }
            }
          }
        }

        if (c == allCoordinates[r].length - 1) {
          System.out.println();
        }
      }
    }
System.out.print(reset);

tryGuessAgain2 = true;
while (tryGuessAgain2) {
tryGuessAgain2 = false;

System.out.println("\nPlayer 2, enter your guess:");
playerGuess = reader10.nextLine();

for (int r = 0; r < allCoordinates.length; r++) {
  for (int c = 0; c < allCoordinates.length; c++) {
    if (allCoordinates[r][c].equals(playerGuess)) {
      r = 999;
      c = 999;
    }
    else if (r == 9 && c == 9) {
      tryGuessAgain2 = true;
      System.out.println("\nInvalid coordinate, try again."); delay(1000);
    }
  }
}

  for (int i = 0; i < playerGuesses2.size(); i++) {
    if (playerGuesses2.get(i).equals(playerGuess)) {
      tryGuessAgain2 = true;
      System.out.println("\nYou have already guessed there, try again."); delay(1000);
    }
  }

}

for (int r = 0; r < playerShips.length; r++) {
  for (int c = 0; c < playerShips[r].length; c++) {
    if (playerShips[r][c].equals(playerGuess)) {
      playerHits2++;
      playerGuesses2.add(playerGuess);
      playerHitCords2.add(playerGuess);
      System.out.println("\nHit!"); delay(2000);
      r = 4;
      c = 4;
    }
    else if (c == 4) {
      playerGuesses2.add(playerGuess);
      System.out.println("\nMiss!"); delay(2000);
    }
  }
}

            for (int r2 = 0; r2 < playerShips.length; r2++) {
              playerTimesHit2 = 0;
              for (int c2 = 0; c2 < playerShips[r2].length; c2++) {
                for (int i = 0; i < playerHitCords2.size(); i++) {
                  if (playerShips[r2][c2].equals(playerHitCords2.get(i))) {
                    playerTimesHit2++;
                  }
                }
              }
              if (playerTimesHit2 == playerShips[r2].length) {
                System.out.print(green);
                switch (r2) {
                  case 0:
                  if (!desSunk2) {
                    System.out.println("\nYou sunk player 1\'s destroyer (2 tile ship)."); delay(2000);
                    desSunk2 = true;
                  }
                  break;
                  case 1:
                  if (!cruSunk2) {
                    System.out.println("\nYou sunk player 1\'s cruiser (3 tile ship)."); delay(2000);
                    cruSunk2 = true;
                  }
                  break;
                  case 2:
                  if (!subSunk2) {
                    System.out.println("\nYou sunk player 1\'s submarine (3 tile ship)."); delay(2000);
                    subSunk2 = true;
                  }
                  break;
                  case 3:
                  if (!batSunk2) {
                    System.out.println("\nYou sunk player 1\'s battleship (4 tile ship)."); delay(2000);
                    batSunk2 = true;
                  }
                  break;
                  case 4:
                  if (!carSunk2) {
                    System.out.println("\nYou sunk player 1\'s carrier (5 tile ship)."); delay(2000);
                    carSunk2 = true;
                  }
                  break;
                }
                System.out.print(reset);
              }
            }
            delay(2000);


  if (playerHits == 17 || playerHits2 == 17) {
    stillShips2 = false;
    if (playerHits == 17 && playerHits2 == 17) {
      System.out.println("\nYou tied!"); delay(2000);
    }
    else if (playerHits == 17) {
      System.out.println("\nPlayer 1 wins!"); delay(2000);
    }
    else {
      System.out.println("\nPlayer 2 wins!"); delay(2000);
    }
  }

    } //while still ships


    } //end two player


    String asdf = "";
    Scanner reader8 = new Scanner(System.in);

    delay(3000);
    System.out.println("\nWould you like to play again?");
    asdf = reader8.nextLine();
    asdf = asdf.toLowerCase();
    if (ifNo(asdf)) {
      playAgain = false;
      System.out.println("\nHope to see you again soon!");
    }
    }

  }
}