import org.junit.jupiter.api.*;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void init(){
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("step 1 - empty string")
    public void testAddWhenStringIsEmpty() {
        Assertions.assertEquals(0, stringCalculator.Add(""));
        Assertions.assertEquals(0, stringCalculator.Add(" "));

    }

    @Test
    @DisplayName("step 2 - count unknown numbers")
    public void testAddWhenStringIsNull() {
        int actual = stringCalculator.Add(null);
        Assertions.assertEquals(0, actual);
        Assertions.assertEquals(4,stringCalculator.Add("1,a,3"));
        Assertions.assertEquals(133, stringCalculator.Add(" 123, 3, 7"));

    }

    @Test
    @DisplayName("step 1 - multiple numbers")
    public void testAddWhenMultipleNumbersPresent(){
        Assertions.assertEquals(24, stringCalculator.Add("1,23"));
    }

    @Test
    @DisplayName("step 3 - handle new lines")
    public void testAddWhenLineBetweenNumbers(){
        Assertions.assertEquals(6, stringCalculator.Add("1\n2,3"));
        Assertions.assertEquals(1, stringCalculator.Add("1,\n"));
    }

    @Test
    @DisplayName("step 4 - add different delimitter")
    public void testAddWhenDifferentDelimiterIsPresent(){
        Assertions.assertEquals(3, stringCalculator.Add("//;\n1;2"));
    }

    @Test
    @DisplayName("step 5 - negative numbers")
    public void testAddWhenNegativeNumberPresent(){
        Exception exception = Assertions.assertThrows(Exception.class, () -> stringCalculator.Add("-1,2"));
        Assertions.assertEquals("Negatives not allowed:-1", exception.getMessage());

        Exception exception2 = Assertions.assertThrows(Exception.class, () -> stringCalculator.Add("-1,-2,-3,-4"));
        Assertions.assertEquals("Negatives not allowed:-1,-2,-3,-4", exception2.getMessage());
    }

    @Test
    @DisplayName("step 6 - numbers greater than 1000")
    public void testAddWhenNumbersGreaterThan1000(){
        Assertions.assertEquals(2, stringCalculator.Add("1001,2"));
    }

    @Test
    public void testAddWhenAnyLengthDelimiterIsPresent(){
        Assertions.assertEquals(3, stringCalculator.Add("//;\n1;2"));
    }

}