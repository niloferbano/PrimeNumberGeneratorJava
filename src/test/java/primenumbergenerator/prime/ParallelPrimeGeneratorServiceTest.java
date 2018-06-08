package primenumbergenerator.prime;

import org.junit.jupiter.api.Test;
import primenumbergenerator.prime.service.ParallelPrimeGeneratorService;


import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParallelPrimeGeneratorServiceTest {
    @Test
    public void testPrimeNumbers() throws InterruptedException{
        ParallelPrimeGeneratorService parallelPrimeGeneratorService = new ParallelPrimeGeneratorService();
        List<Integer> integerList = parallelPrimeGeneratorService.getPrimeList(1, 11);
        List<Integer> testList = new LinkedList<>();
        testList.add(2);
        testList.add(3);
        testList.add(5);
        testList.add(7);
        assertEquals(testList, integerList);
    }

    @Test
    public void testNegativeInput() throws InterruptedException{
        ParallelPrimeGeneratorService parallelPrimeGeneratorService = new ParallelPrimeGeneratorService();
        List<Integer> integerList = parallelPrimeGeneratorService.getPrimeList(-1, -20);
        List<Integer> testList = new LinkedList<>();
        assertEquals(testList, integerList);

    }

    @Test
    public void testEqaulInputs() throws InterruptedException{
        ParallelPrimeGeneratorService parallelPrimeGeneratorService = new ParallelPrimeGeneratorService();
        List<Integer> integerList = parallelPrimeGeneratorService.getPrimeList(10, 10);
        List<Integer> testList = new LinkedList<>();
        assertEquals(testList, integerList);

    }

    @Test
    public void testlowRange() throws InterruptedException{
        ParallelPrimeGeneratorService parallelPrimeGeneratorService = new ParallelPrimeGeneratorService();
        List<Integer> integerList = parallelPrimeGeneratorService.getPrimeList(20, 10);
        List<Integer> testList = new LinkedList<>();
        assertEquals(testList, integerList);
    }
}
