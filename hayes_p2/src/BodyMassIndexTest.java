import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BodyMassIndexTest {

    @Test
    void bmiConstructorTest() {
        BodyMassIndex testBMI = new BodyMassIndex(76, 170);
        assertEquals(76, testBMI.height);
        assertEquals(170, testBMI.weight);
    }
    @Test
    void bmiScoreTest() {
        BodyMassIndex testBMI = new BodyMassIndex(76, 170);
        assertEquals(20.7, testBMI.calculateBmiScore(testBMI.height, testBMI.weight));
    }

    @Test
    void underweightTest() {
        BodyMassIndex testBMI = new BodyMassIndex(62, 100);
        assertEquals("Underweight", testBMI.calculateBmiCategory(testBMI.height, testBMI.weight));
    }

    @Test
    void normalweightTest() {
        BodyMassIndex testBMI = new BodyMassIndex(76, 170);
        assertEquals("Normal weight", testBMI.calculateBmiCategory(testBMI.height, testBMI.weight));
    }

    @Test
    void overweightTest() {
        BodyMassIndex testBMI = new BodyMassIndex(66, 180);
        assertEquals("Overweight", testBMI.calculateBmiCategory(testBMI.height, testBMI.weight));
    }

    @Test
    void obesityTest() {
        BodyMassIndex testBMI = new BodyMassIndex(72, 250);
        assertEquals("Obesity", testBMI.calculateBmiCategory(testBMI.height, testBMI.weight));
    }
}
