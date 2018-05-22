package primenumbergenerator.prime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class PrimeApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(PrimeApplication.class, args);
        while (true) {
            System.out.print("\n\n****Prime Generator****\n\n");
            System.out.print("Which Prime Number generator you want to use?");
            System.out.print("1. Naive approach\n2. New Prime function\n");
            int choice = new Scanner(System.in).nextInt();
            System.out.println("Enter number low range: ");
            int lowRange = new Scanner(System.in).nextInt();
            System.out.println("Enter number high range: ");
            int highRange = new Scanner(System.in).nextInt();
            if (lowRange == 1 || lowRange == 0) {
                lowRange = 2;
            }
            if (highRange < 0 || lowRange < 0) {
                System.out.print("Please enter valid inputs. numbers can't be negative");
                return;
            }
            switch (choice) {
                case 1:
                    SimplePrimeGenerator simplePrimeGenerator = new SimplePrimeGenerator();
                    System.out.print(simplePrimeGenerator.primeList(lowRange, highRange));
                    break;
                case 2:
                    SmartPrimeGenerator newPrimeGenerator = new SmartPrimeGenerator();
                    System.out.print(newPrimeGenerator.primeList(lowRange, highRange));
                    break;
            }
        }
    }
}
