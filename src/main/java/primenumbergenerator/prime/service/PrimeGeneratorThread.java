package primenumbergenerator.prime.service;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class PrimeGeneratorThread extends Thread {
    private int lowRange;
    private int highRange;
    private List<Integer> primeList;

    public PrimeGeneratorThread(int lowRange, int highRange) {
        this.lowRange = lowRange;
        this.highRange = highRange;
        this.primeList = new LinkedList<>();
    }

    public void run() {
        for (int number = lowRange; number < highRange; number++) {
            boolean isPrime = true;
            int square_root = (int) Math.sqrt(number);
            for (int j = 2; j <= square_root; j++) {
                if (number % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            synchronized (this) {
                if (isPrime) {
                    primeList.add(number);
                }
            }
        }

    }
}
