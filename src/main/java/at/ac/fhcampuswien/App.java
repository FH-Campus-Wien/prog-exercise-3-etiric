package at.ac.fhcampuswien;

import java.util.*;

public class App {

    // Implement all methods as public static


    public static void oneMonthCalendar(int daysOfMonth, int firstDay) {

        int count = 0;
        int countD = 0;
        int[] monthDays = new int[daysOfMonth + 1]; //Array Länge der übergebenen Tage
        monthDays[0] = 1;

        for (int i = 0; i < daysOfMonth + 1; i++) {

            monthDays[i] = monthDays[0]++;//Füllen mit Tagen
        }

        switch (firstDay) {
            case 1:
                count = 0;
                countD = 0;
                break;
            case 2:
                count = 1;
                countD = 1;
                break;
            case 3:
                count = 4;
                countD = 2;

                break;
            case 4:
                count = 7;
                countD = 3;

                break;
            case 5:
                count = 10;
                countD = 4;

                break;
            case 6:
                count = 13;
                countD = 5;

                break;
            case 7:
                count = 16;
                countD = 6;
                break;
        }

        for (int i = 0; i <= count; i++) {
            System.out.print(" ");
        }

        for (int j = 1; j < monthDays.length; j++) {
            countD++;
            if (monthDays[j] == 1) {
                System.out.print(" ");
            }
            if (monthDays[j] < 10) {
                System.out.printf(" " + monthDays[j] + " ");
            } else {
                System.out.printf(monthDays[j] + " ");
            }

            if (countD == 7 && monthDays[j] < 28) {
                System.out.println("");
                countD = 0;
            } else if (countD == 7 && monthDays[j] > 28) {
                countD = 0;
            }
        }
        System.out.println();

    }

    public static long[] lcg(long seed) {
        long[] randomNumbers = new long[10];
        final long m = (long) Math.pow(2, 31);
        final long a = 1103515245;
        final long c = 12345;

        for (int i = 0; i <= 9; i++) {
            if (i == 0) {
                randomNumbers[i] = (a * seed + c) % m;
            } else {
                randomNumbers[i] = (a * randomNumbers[i - 1] + c) % m;

            }
        }


        return randomNumbers;
    }


    public static void guessingGame(int numberToGuess) {
        Scanner sc = new Scanner(System.in);
        int count;

        for (count = 1; count <= 10; count++) {
            System.out.print("Guess number " + count + ": ");
            int guessedNumber = sc.nextInt();

            if (guessedNumber < numberToGuess && count < 10) {
                System.out.println("The number AI picked is higher than your guess.");
            } else if (guessedNumber > numberToGuess && count < 10) {
                System.out.println("The number AI picked is lower than your guess.");
            } else if (guessedNumber == numberToGuess && count < 10) {
                System.out.println("You won wisenheimer!");
                break;
            } else if (count == 10) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");

            }
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        int min = 1;
        int max = 100;
        int randomNumber = (int) (Math.random() * (max - min) + 1);
        return randomNumber;
    }


    public static boolean swapArrays(int[] array1, int[] array2) {

        int[] array3 = new int[6];
        if (array1.length != array2.length) {
            return false;
        } else {
            for (int i = 0; i < 6; i++) {
                array3[i] = array1[i];
                array1[i] = array2[i];
                array2[i] = array3[i];

            }

            return true;
        }
    }

    public static String camelCase(String string) {

        char[] charArray = string.toCharArray(); //Satz in Buchstaben teilen und speichern

        ArrayList<String> arrayListChars = new ArrayList<>(charArray.length);

        charArray[0] = Character.toUpperCase(charArray[0]);

        for (int i = 1; i < charArray.length; i++) {

            if (Character.isLowerCase(charArray[i]) && Character.isWhitespace(charArray[i - 1])) {
                charArray[i] = Character.toUpperCase(charArray[i]);


            } else if (Character.isUpperCase(charArray[i]) && !Character.isWhitespace(charArray[i - 1])) {
                charArray[i] = Character.toLowerCase(charArray[i]);
            }

        }

        for (int i = 0; i < charArray.length; i++) {
            arrayListChars.add(String.valueOf(charArray[i]));
        }

        for (int i = 0; i < charArray.length; i++) {
            if (arrayListChars.contains(" ")) {
                arrayListChars.remove(" ");

            } else if (arrayListChars.contains(".")) {
                arrayListChars.remove(".");
            } else if (arrayListChars.contains(",")) {
                arrayListChars.remove(",");
            } else if (arrayListChars.contains(";")) {
                arrayListChars.remove(";");
            } else if (arrayListChars.contains("?")) {
                arrayListChars.remove("?");
            } else if (arrayListChars.contains("!")) {
                arrayListChars.remove("!");
            } else if (arrayListChars.contains("'")) {
                arrayListChars.remove("'");
            }
        }


        String finalString = arrayListChars.get(0);

        for (int i = 1; i < arrayListChars.size(); i++) {
            finalString = finalString + arrayListChars.get(i);


        }


        return finalString;
    }


    public static int checkDigit(int[] code) {
        int weighting = 1;
        int product = 0;
        int digit = 0;

        for (int i = 0; i < code.length; i++) {
            weighting = weighting + 1; //Gewichtung: Arrayy Position + 0
            product = product + code[i] * weighting; //Produkt = weighting * Code, Summe vom Ganzen

            //Prüfziffer als int zurückliefern
        }

        int rest = product % 11;

        digit = 11 - rest;
        if (digit == 11) {
            digit = 5;
        } else if (digit == 10) {
            digit = 0;
        }
        return digit;
    }

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.

        //AM ENDE ALLE METHODEN AUFRUFEN!
        System.out.println(camelCase("my name isn't Alice!"));
        System.out.println(camelCase("but a noisY noise annoYs an oYster more."));
        // guessingGame(randomNumberBetweenOneAndHundred()); -> Das lassen

    }
}