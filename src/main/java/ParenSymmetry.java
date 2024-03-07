package src.main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParenSymmetry {


    public Boolean isBalanced(String s) {
        // implement this method
        int count = 0;

        for(char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            }else if( c == ')') {
                count --;
                if (count < 0){
                    return false;
                }
            }
        }
        return count == 0;
    }

    private void checkFile(String filename) throws FileNotFoundException {
        File file = new File("TestStrings0.txt");

        Scanner scanner = new Scanner(filename);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line + " : " + isBalanced(line));
        }

        // CLOSE the file
        scanner.close();
    }
    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
