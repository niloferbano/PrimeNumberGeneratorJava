package primenumbergenerator.prime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import primenumbergenerator.prime.Service.ParallelPrimeGeneratorService;
import primenumbergenerator.prime.Service.PrimeGeneratorByFactsService;
import primenumbergenerator.prime.Service.SimplePrimeGeneratorService;
import primenumbergenerator.prime.Service.SmartPrimeGeneratorService;

import java.util.Scanner;

@SpringBootApplication
public class PrimeApplication {

    public static void main(String[] args)  throws InterruptedException{
        SpringApplication.run(PrimeApplication.class, args);
        runUserAction();
    }

    private  static  void runUserAction() throws InterruptedException{
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("\n\n****Prime Generator****\n\n");
            System.out.print("Which Prime Number generator you want to use?\n");
            System.out.print("1. Naive approach\n2. Smart Prime function\n3. Prime Generator by facts\n"
            + "4.Parallel Prime Generator\n\n");
            while(!sc.hasNextInt()) {
                System.out.print("Please enter an integer:");
                sc.next();
            }
            int choice = sc.nextInt();
            System.out.println("Enter number low range: ");
            int lowRange, highRange;
            while(!sc.hasNextInt()) {
                System.out.print("Please enter an integer:");
                sc.next();
            }
            lowRange = sc.nextInt();
            System.out.println("Enter number high range: ");
            while(!sc.hasNextInt()) {
                System.out.print("Please enter an integer:");
                sc.next();
            }
            highRange = sc.nextInt();
            InputSanityCheck inputSanityCheck = new InputSanityCheck();
            lowRange = inputSanityCheck.checkInputs(lowRange, highRange);
            if(lowRange == -1){
                return;
            }
            switch (choice) {
                case 1:
                    SimplePrimeGeneratorService simplePrimeGenerator = new SimplePrimeGeneratorService();
                    System.out.print("Prime Numbers between " + lowRange + " and " + highRange +":"+ simplePrimeGenerator.getPrimeList(lowRange, highRange));
                    break;
                case 2:
                    SmartPrimeGeneratorService smartPrimeGenerator = new SmartPrimeGeneratorService();
                    System.out.print("Prime Numbers between " + lowRange + " and " + highRange +":"+ smartPrimeGenerator.getPrimeList(lowRange, highRange));
                    break;
                case 3:
                    PrimeGeneratorByFactsService primeGeneratorbyFacts = new PrimeGeneratorByFactsService();
                    System.out.print("Prime Numbers between " + lowRange + " and " + highRange +":"+ primeGeneratorbyFacts.getPrimeList(lowRange, highRange));
                    break;
                case 4:
                    ParallelPrimeGeneratorService parallelPrimeGeneratorService = new ParallelPrimeGeneratorService();
                    System.out.print("Prime Numbers between " + lowRange + " and " + highRange +":"+ parallelPrimeGeneratorService.getPrimeList(lowRange,highRange));
                    break;
                default:
                    System.out.print("Please enter a valid option from 1 to 4");
            }
        }

    }
}
