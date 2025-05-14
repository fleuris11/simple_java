import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void testAddition() {
        assertEquals(6, Calculator.add(3, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(6, Calculator.subtract(10, 4));
    }
}