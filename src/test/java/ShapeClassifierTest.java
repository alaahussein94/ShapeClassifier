import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class ShapeClassifierTest {

    /**
     * This is an example test 
     */
    @DisplayName("Example Test")
    @Test
    public void example() {
        ShapeClassifier s = new ShapeClassifier();
        String answer = s.evaluateGuess("Equilateral,Large,Yes,100,100,100");
        assertNotEquals("Yes", answer);
    }

    /**
     * White-box Test: Check if an equilateral triangle is classified correctly.
     */
    @DisplayName("White-box Test: Equilateral Triangle Classification")
    @Test
    public void testEquilateralTriangle() {
        ShapeClassifier s = new ShapeClassifier();
        String answer = s.evaluateGuess("Equilateral,Large,Yes,50,50,50");
        assertEquals("Yes", answer, "Expected correct classification of equilateral triangle.");
    }

    /**
     * Black-box Test: Handle invalid shape guess.
     */
    @DisplayName("Black-box Test: Invalid Shape Guess")
    @Test
    public void testInvalidShapeGuess() {
        ShapeClassifier s = new ShapeClassifier();
        String answer = s.evaluateGuess("Triangle,Large,No,30,40,50");
        assertTrue(answer.startsWith("No:"), "Expected invalid shape guess to be handled gracefully.");
    }

    /**
     * Flexible Test: Rectangle Perimeter Calculation
     */
    @DisplayName("Flexible Test: Rectangle Perimeter Calculation")
    @Test
    public void testRectanglePerimeter() {
        ShapeClassifier s = new ShapeClassifier();
        String answer = s.evaluateGuess("Rectangle,Large,Yes,20,40,20,40");
        assertEquals("Yes", answer, "Expected correct classification and perimeter calculation for a rectangle.");
    }
}
