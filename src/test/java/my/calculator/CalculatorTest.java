package my.calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class CalculatorTest  {
    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        double result = calculator.add(5, 7);
        assertEquals(12, result, 0.0001);

    }
    @Test
    public void testSubtraction (){
        Calculator calculator = new Calculator();
        double result = calculator.subtract(89,98);
        assertEquals(-9, result, 0.0001);

    }
    @Test
    public void testMultiplication(){
        Calculator calculator = new Calculator();
        double result = calculator.multiply(12,12);
        assertEquals(144, result, 0.0001);

    }

    @Test
    public void testDivision() {
        Calculator calculator = new Calculator();
        double result = calculator.divide(15, 5);
        assertEquals(3, result, 0.0001);
    }

    @Test
    public void testDivisionByZero() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }

    @Test
    public void testSquareRoot() {
        Calculator calculator = new Calculator();
        double result = calculator.sqrt(25);
        assertEquals(5, result, 0.0001);
    }

    @Test
    public void testSquareRootOfNegativeNumber() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.sqrt(-5));
    }

    @Test
    public void testExponentiation() {
        Calculator calculator = new Calculator();
        double result = calculator.power(2, 3);
        assertEquals(8, result, 0.0001);
    }
}