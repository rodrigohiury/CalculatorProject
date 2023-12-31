package src.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import src.data.FunctionSolver;
import src.exceptions.FormatException;
import src.exceptions.MathException;
import src.exceptions.NoNumberException;
import src.exceptions.ProcessingException;

public class FunctionSolverTest {

    FunctionSolver calculadora = new FunctionSolver();
    String equacao;

    @Test
    public void basicFunction() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "2+3*5";
        double resultado = calculadora.solve(equacao);
        assertEquals(resultado, 17, 0.001d);
    }

    @Test
    public void numberFunction() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "2";
        assertEquals(2, calculadora.solve(equacao), 0.0000001d);
    }

    @Test
    public void bigNumber() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "23350";
        assertEquals(23350, calculadora.solve(equacao), 0.0000001d);
    }

    @Test
    public void negativeNumber() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "-7";
        assertEquals(-7, calculadora.solve(equacao), 0.0000001d);
    }

    @Test
    public void negativeBigNumber() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "-57550";
        assertEquals(-57550, calculadora.solve(equacao), 0.000001d);
    }

    @Test
    public void basicSum() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "2+3";
        assertEquals(5, calculadora.solve(equacao), 0.00000001d);
    }

    @Test
    public void basicSubtraction() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "5-8";
        assertEquals(-3, calculadora.solve(equacao), 0.00000001d);
    }

    @Test
    public void basicMultiplication() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "8*9";
        assertEquals(72, calculadora.solve(equacao), 0.0000001d);
    }

    @Test
    public void basicDivision() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "10/2";
        assertEquals(5, calculadora.solve(equacao), 0.00000001d);
    }

    @Test
    public void basicAbsoluteValue() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "[-23]";
        assertEquals(23, calculadora.solve(equacao), 0.0001d);
    }

    @Test
    public void basicSquareRoot() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "√(144)";
        assertEquals(12, calculadora.solve(equacao), 0.0001d);
    }

    @Test
    public void basicSquareRootNoParentesis() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "√144";
        assertEquals(12, calculadora.solve(equacao), 0.0001d);
    }

    @Test
    public void basicPower() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "(2)^(2)";
        assertEquals(4, calculadora.solve(equacao), 0.00001d);
    }

    @Test
    public void basicPowerNoParentesis() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "2^2";
        assertEquals(4, calculadora.solve(equacao), 0.00001d);
    }

    @Test
    public void basicFunctionChangedOrder() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "(2+3)*5";
        assertEquals(25, calculadora.solve(equacao), 0.00000001d);
    }

    @Test
    public void operationsTogether() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "√([-23]+(11)^(2))-5*2+3";
        assertEquals(5, calculadora.solve(equacao), 0.0001d);
    }

    @Test
    public void operationsTogetherSquareRoot() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "√([-23]+(11)^(2))";
        assertEquals(12, calculadora.solve(equacao), 0.0001d);
    }

    @Test
    public void powerOfSquareRoot() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "2^√4";
        assertEquals(4, calculadora.solve(equacao), 0.000001d);
    }

    @Test
    public void squareRootAndSum() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "√4+2";
        assertEquals(4, calculadora.solve(equacao), 0.000001d);
    }

    @Test
    public void mediumFunction() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "[(2^√4)^[-5^2]]";
        assertEquals(1.125899906842624E15, calculadora.solve(equacao), 0.0001d);
    }

    @Test
    public void ambiguosFunction() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "8/2*(2+2)";
        assertEquals(16, calculadora.solve(equacao), 0.000001d);
    }

    @Test
    public void fluxFunction() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "√(12*(0.049770)+19*(0.049770)^(2)+2*√(4*(0.049770)^(3)+7*(0.049770)^(2))*(2*(0.049770)^(2)+(0.049770)))+√(4*(0.049770)^(3)+7*(0.049770)^(2))+2*(0.049770)^(2)+(0.049770)";
        assertEquals(1, calculadora.solve(equacao), 0.0001d);
    }

    @Test
    public void rationalNumberPower() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "16^(0.5)";
        assertEquals(4, calculadora.solve(equacao), 0.00000001d);
    }

    @Test
    public void squareRootOfNegativeNumber() throws MathException, FormatException, NoNumberException, ProcessingException{
        equacao = "√(-36)";
        assertThrows(MathException.class, () -> calculadora.solve(equacao));
    }

    @Test
    public void multiplicationOneNumber(){
        equacao = "*2";
        assertThrows(FormatException.class, () -> calculadora.solve(equacao));
    }

    @Test
    public void emptyEquation(){
        equacao = "";
        assertThrows(FormatException.class, () -> calculadora.solve(equacao));
    }

    @Test
    public void nullEquation(){
        assertThrows(NullPointerException.class, () -> calculadora.solve(equacao));
    }

    @Test
    public void oddParentesisLeft(){
        equacao = "((2+3)*5";
        assertThrows(FormatException.class, () -> calculadora.solve(equacao));
    }

    @Test
    public void oddParentesisRight(){
        equacao = "(2+3)*5)";
        assertThrows(FormatException.class, () -> calculadora.solve(equacao));
    }

    @Test
    public void oddBracketLeft(){
        equacao = "[3-6";
        assertThrows(FormatException.class, () -> calculadora.solve(equacao));
    }

    @Test
    public void oddBracketRight(){
        equacao = "3-6]";
        assertThrows(FormatException.class, () -> calculadora.solve(equacao));
    }
}