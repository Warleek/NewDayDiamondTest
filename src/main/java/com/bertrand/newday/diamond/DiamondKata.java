package com.bertrand.newday.diamond;

public class DiamondKata {
    public static final char LINE_BREAK = '\n';
    public static final char SPACE = ' ';
    public static final char ORIGINE = 'A';
    public static final String INVALID_LETTER_MESSAGE = "Only uppercase letter allowed.";

    public static String createDiamond(char input) {
        if(!isValidCharacter(input)) {
            return INVALID_LETTER_MESSAGE;
        }
        int diamondSize = getDiamondSize(input);
        int diamondMid = (diamondSize / 2);
        char[][] diamond = new char[diamondSize][diamondSize];
        int character = ORIGINE;
        for(int i = 0; i < diamondSize; i++){
            for(int j = 0; j < diamondSize; j++){
                if(isLetterFirstPosition(j, diamondMid, character)) {
                    diamond[i][j] = (char) character;
                }else if(isLetterSecondPosition(j, diamondMid, character)) {
                    diamond[i][j] = (char) character;
                } else {
                    diamond[i][j] = SPACE;
                }
            }
            if(i > diamondMid-1) {
                character--;
            } else {
                character++;
            }
        }
        return printDiamond(diamondSize, diamond);
    }

    private static boolean isValidCharacter(char input) {
        return input >= 'A' && input <= 'Z';
    }

    private static int getDiamondSize(int input) {
        return (((input - ORIGINE) + 1) * 2) - 1;
    }

    private static boolean isLetterSecondPosition(int j, int diamondMid, int character) {
        return j == diamondMid + (character - ORIGINE);
    }

    private static boolean isLetterFirstPosition(int j, int diamondMid, int character) {
        return j == diamondMid - (character - ORIGINE);
    }

    private static String printDiamond(int diamondWidth, char[][] diamond) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < diamondWidth; i++) {
            builder.append(new String(diamond[i]));
            if(i < diamondWidth -1) {
                builder.append(LINE_BREAK);
            }
        }
        return builder.toString();
    }
}
