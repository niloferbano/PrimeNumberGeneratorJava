package primenumbergenerator.prime.Service;

public class ParallelPrimeGeneratorService extends Thread{

    public void getPrimeList(int lowRange, int highRange) {
        int cores = Runtime.getRuntime().availableProcessors();
        PrimeGeneratorThread[] primeThreads = new PrimeGeneratorThread[cores];
        for (int i=0; i<cores; i++)
        {
            primeThreads[i] = new PrimeGeneratorThread();
            primeThreads[i].start();
        }

    }
}
