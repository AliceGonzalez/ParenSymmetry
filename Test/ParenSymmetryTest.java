import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParenSymmetryTest {

    @Test
    public void isBalanced1() {
        String inputTest = "()";
        Boolean expected = true;
        Boolean actual;

        actual = new ParenSymmetry().isBalanced(inputTest);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void isBalanced2() {
        String inputTest = "())";
        Boolean expected = false;
        Boolean actual;

        actual = new ParenSymmetry().isBalanced(inputTest);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void isBalanced3() {
        String inputTest = "((";
        Boolean expected = false;
        Boolean actual;

        actual = new ParenSymmetry().isBalanced(inputTest);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void isBalanced4() {
        String inputTest = "()grand()illusion";
        Boolean expected = true;
        Boolean actual;

        actual = new ParenSymmetry().isBalanced(inputTest);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void isBalancedFalses() {
        String[] falseStrings = {"(", "((", ")", "(()())((())))"};
        Boolean expected = false;
        Boolean actual;
        for (String testString : falseStrings) {
            actual = new ParenSymmetry().isBalanced(testString);
            Assert.assertEquals(expected, actual);
        }
    }
    @Test
    public void isBalancedTrues() {
        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean expected = true;
        Boolean actual;
        for (String testString : trueStrings) {
            actual = new ParenSymmetry().isBalanced(testString);
            Assert.assertEquals(expected, actual);
        }
    }

}