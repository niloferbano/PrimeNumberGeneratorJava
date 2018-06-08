package primenumbergenerator.prime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import primenumbergenerator.prime.repository.PrimeGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
@Service
public  class SimplePrimeGeneratorService {
    @Autowired
    LogService logService;

    public List<Integer> getPrimeList(int lowRange, int highRange) {
        List<Integer> primeIntegerList = new LinkedList<>();

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        long start_time = System.currentTimeMillis();

        int start = lowRange;
        if(lowRange == 1 || lowRange == 0 || lowRange < 0){
            start = 2;
        }
        for (int number = start; number < highRange; number++) {
            boolean isPrime = true;
            for (int j = 2; j < number; j++) {
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
        //Logging enabled only for calls from Rest controller
        if(logService != null){
            String algorithmsName = "SimplePrimeGenerator";
            int countPrimes = primeIntegerList.size();
            long id = (timeStamp + range).hashCode();
            PrimeGenerator primeGeneratorDBObject = new PrimeGenerator(id, timeStamp, range, timeElapsed, algorithmsName, countPrimes);
            logService.saveEvent(primeGeneratorDBObject);
        }

        return primeIntegerList;
    }
}