package primenumbergenerator.prime.PrimeGeneratorService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;


public class SmartPrimeGenerator {
    public List<Integer> primeList(int lowRange, int highRange) {
        List<Integer> primeIntegerList = new LinkedList<>();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));
        long start_time = System.currentTimeMillis();

        for (int number = lowRange; number < highRange; number++) {
            boolean isPrime = true;
            int square_root = (int)Math.sqrt(number);
            for (int j = 2; j <= square_root ; j++) {
                if (number % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeIntegerList.add(number);
            }
        }
        System.out.println(dtf.format(LocalDateTime.now()));
        System.out.print("Time elapsed: " + (System.currentTimeMillis() - start_time));
        System.out.print("Size: " + primeIntegerList.size());

        return primeIntegerList;
    }
}
