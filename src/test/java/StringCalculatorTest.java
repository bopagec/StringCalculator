import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void init(){
        stringCalculator = new StringCalculator();
    }

    @Test
    public void testAddWhenStringIsEmpty() {
        Assertions.assertEquals(0, stringCalculator.Add(""));
        Assertions.assertEquals(0, stringCalculator.Add(" "));

    }

    @Test
    public void testAddWhenStringIsNull() {
        int actual = stringCalculator.Add(null);
        Assertions.assertEquals(0, actual);

    }

    @Test
    public void testAddWhenMultipleNumbersPresent(){
        Assertions.assertEquals(24, stringCalculator.Add("1,23"));
    }

    @Test
    public void testAddWhenUnknownNumbersPresent(){
        Assertions.assertEquals(133, stringCalculator.Add(" 123, 3, 7"));
    }

    @Test
    public void testAddWhenLineBetweenNumbers(){
        Assertions.assertEquals(6, stringCalculator.Add("1\n2,3"));
        Assertions.assertEquals(1, stringCalculator.Add("1,\n"));
    }

    @Test
    public void testAddWhenDifferentDelimiterIsPresent(){
        Assertions.assertEquals(3, stringCalculator.Add("//;\n1;2"));
    }

    @Test
    public void testAddWhenNegativeNumberPresent(){
        Exception exception = Assertions.assertThrows(Exception.class, () -> stringCalculator.Add("-1,2"));
        Assertions.assertEquals("Negatives not allowed:-1", exception.getMessage());

        Exception exception2 = Assertions.assertThrows(Exception.class, () -> stringCalculator.Add("-1,-2,-3,-4"));
        Assertions.assertEquals("Negatives not allowed:-1,-2,-3,-4", exception2.getMessage());
    }
}