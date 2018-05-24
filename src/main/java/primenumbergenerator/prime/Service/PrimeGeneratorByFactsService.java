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
        if(lowRange == 1 || lowRange == 0){
            start = 2;
        }
        for (int number = start; number < highRange; number++) {
            if ((number > 2 && number % 2 == 0) || (number > 5 && number % 5 == 0)) {
                continue;
            }
            if (number > 3) {
                int sum = String.valueOf(number)
                        .chars()
                        .map(Character::getNumericValue)
                        .sum();
                if (sum % 3 == 0) {
                    //System.out.print("Number " + number);
                    //System.out.print("Sum " + sum);
                    continue;
                }
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
        if(logService != null ) {
            String algorithmsName = "PrimeGeneratorByFacts";
            int countPrimes = primeIntegerList.size();
            long id = (timeStamp + range).hashCode();
            PrimeGenerator primeGeneratorDBObject = new PrimeGenerator(id, timeStamp, range, timeElapsed, algorithmsName, countPrimes);
            logService.saveEvent(primeGeneratorDBObject);
        }

        return primeIntegerList;
    }
}


