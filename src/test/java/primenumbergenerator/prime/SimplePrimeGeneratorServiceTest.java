package primenumbergenerator.prime;

import org.junit.jupiter.api.Test;
import primenumbergenerator.prime.service.SmartPrimeGeneratorService;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimplePrimeGeneratorServiceTest {
    @Test
    public void testPrimeNumbers() {
        SmartPrimeGeneratorService smartPrimeGeneratorService = new SmartPrimeGeneratorService();
        List<Integer> integerList = smartPrimeGeneratorService.getPrimeList(1, 11);
        List<Integer> testList = new LinkedList<>();
        testList.add(2);
        testList.add(3);
        testList.add(5);
        testList.add(7);
        assertEquals(testList, integerList);
    }

    @Test
    public void testNegativeInput() {
        SmartPrimeGeneratorService smartPrimeGeneratorService = new SmartPrimeGeneratorService();
        List<Integer> integerList = smartPrimeGeneratorService.getPrimeList(-1, -20);
        List<Integer> testList = new LinkedList<>();
        assertEquals(testList, integerList);

    }

    @Test
    public void testEqaulInputs() {
        SmartPrimeGeneratorService smartPrimeGeneratorService = new SmartPrimeGeneratorService();
        List<Integer> integerList = smartPrimeGeneratorService.getPrimeList(10, 10);
        List<Integer> testList = new LinkedList<>();
        assertEquals(testList, integerList);

    }

    @Test
    public void testlowRange() throws InterruptedException{
        SmartPrimeGeneratorService smartPrimeGeneratorService = new SmartPrimeGeneratorService();
        List<Integer> integerList = smartPrimeGeneratorService.getPrimeList(20, 10);
        List<Integer> testList = new LinkedList<>();
        assertEquals(testList, integerList);

    }
}
