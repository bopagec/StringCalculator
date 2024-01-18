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
        Assertions.assertEquals(16, stringCalculator.Add(" 123 3 7"));
        Assertions.assertEquals(6, stringCalculator.Add("+123-"));
    }
}