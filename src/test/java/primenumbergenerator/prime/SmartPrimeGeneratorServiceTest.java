package primenumbergenerator.prime;

import org.junit.jupiter.api.Test;
import primenumbergenerator.prime.service.SimplePrimeGeneratorService;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartPrimeGeneratorServiceTest {

    @Test
    public void testPrimeNumbers() {
        SimplePrimeGeneratorService simplePrimeGeneratorService = new SimplePrimeGeneratorService();
        List<Integer> integerList = simplePrimeGeneratorService.getPrimeList(1, 11);
        List<Integer> testList = new LinkedList<>();
        testList.add(2);
        testList.add(3);
        testList.add(5);
        testList.add(7);
        assertEquals(testList, integerList);
    }

    @Test
    public void testNegativeInput() {
        SimplePrimeGeneratorService simplePrimeGeneratorService = new SimplePrimeGeneratorService();
        List<Integer> integerList = simplePrimeGeneratorService.getPrimeList(-1, -20);
        List<Integer> testList = new LinkedList<>();
        assertEquals(testList, integerList);

    }

    @Test
    public void testEqaulInputs() {
        SimplePrimeGeneratorService simplePrimeGeneratorService = new SimplePrimeGeneratorService();
        List<Integer> integerList = simplePrimeGeneratorService.getPrimeList(10, 10);
        List<Integer> testList = new LinkedList<>();
        assertEquals(testList, integerList);

    }

    @Test
    public void testlowRange() throws InterruptedException{
        SimplePrimeGeneratorService simplePrimeGeneratorService = new SimplePrimeGeneratorService();
        List<Integer> integerList = simplePrimeGeneratorService.getPrimeList(20, 10);
        List<Integer> testList = new LinkedList<>();
        assertEquals(testList, integerList);

    }

}
