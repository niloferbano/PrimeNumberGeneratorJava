package primenumbergenerator.prime.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import primenumbergenerator.prime.Repository.PrimeGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class PrimeGeneratorByFactsService {
    @Autowired
    private LogService logService;

    public List<Integer> getPrimeList(int lowRange, int highRange) {
        List<Integer> primeIntegerList = new LinkedList<>();

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        long start_time = System.currentTimeMillis();
        int start = lowRange;
        if (lowRange == 1 || lowRange == 0 || lowRange < 0) {
            start = 2;
        }
        if (lowRange > 0 && highRange > 5) {
            primeIntegerList.add(2);
            primeIntegerList.add(3);
            primeIntegerList.add(5);
            start = 5;

        }
        for (int number = start; number < highRange; number++) {
//            int sum = String.valueOf(number)
//                    .chars()
//                    .map(Character::getNumericValue)
//                    .sum();
            if (number % 2 == 0 || number % 5 == 0 /*|| sum % 3 == 0*/) {
                continue;
            }
            boolean isPrime = true;
            for (int j = 2; j < number / 2; j++) {
                if (number % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeIntegerList.add(number);
            }
        }
        String range = Integer.toString(lowRange) + "-" + Integer.toString(highRange);
        long end_time = System.currentTimeMillis();
        long timeElapsed = end_time - start_time;
        System.out.print("Time elapsed: " + timeElapsed);

        //Logging enabled only for calls from Rest Controller
        if (logService != null) {
            String algorithmsName = "PrimeGeneratorByFacts";
            int countPrimes = primeIntegerList.size();
            long id = (timeStamp + range).hashCode();
            PrimeGenerator primeGeneratorDBObject = new PrimeGenerator(id, timeStamp, range, timeElapsed, algorithmsName, countPrimes);
            logService.saveEvent(primeGeneratorDBObject);
        }

        return primeIntegerList;
    }
}


