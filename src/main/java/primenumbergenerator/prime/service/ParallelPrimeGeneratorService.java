package primenumbergenerator.prime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import primenumbergenerator.prime.repository.PrimeGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class ParallelPrimeGeneratorService {
    @Autowired
    LogService logService;

    public List<Integer> getPrimeList(int lowRange, int highRange) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        List<Integer> primeList = new LinkedList<>();
        PrimeGeneratorThread[] primeThreads = new PrimeGeneratorThread[cores];
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        long start_time = System.currentTimeMillis();
        int start = lowRange;
        if (lowRange == 1 || lowRange == 0 || lowRange < 0) {
            start = 2;
        }
        int count = highRange - start ;
        int share;
        int remaining;
        if (count % cores == 0) {
            share = count / cores;
            remaining = share;
        } else {
            remaining = count % cores;
            share = (count - remaining) / cores;
        }

        for (int i = 0; i < cores - 1; i++) {
            primeThreads[i] = new PrimeGeneratorThread(start, start + share);
            start = start + share;
            primeThreads[i].start();
        }
        primeThreads[cores - 1] = new PrimeGeneratorThread(start, start + share + remaining);
        primeThreads[cores - 1].start();

        for (int i = 0; i < cores; i++) {
            primeThreads[i].join();
            for (Integer integer : primeThreads[i].getPrimeList()) {
                primeList.add(integer);
            }
        }
        System.out.print("Size: " + primeList.size());
        long end_time = System.currentTimeMillis();
        long timeElapsed = end_time - start_time;
        System.out.print("Time elapsed: " + timeElapsed);
        //Logging enabled only for calls from Rest controller
        if (logService != null) {
            String range = Integer.toString(lowRange) + "-" + Integer.toString(highRange);
            String algorithmsName = "ParallelPrimeGenerator";
            int countPrimes = primeList.size();
            long id = (timeStamp + range).hashCode();
            PrimeGenerator primeGenerator = new PrimeGenerator(id, timeStamp, range, timeElapsed, algorithmsName, countPrimes);
            logService.saveEvent(primeGenerator);
        }

        return primeList;
    }
}
