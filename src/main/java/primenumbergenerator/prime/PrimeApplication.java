package primenumbergenerator.prime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import primenumbergenerator.prime.Service.PrimeGeneratorByFactsService;
import primenumbergenerator.prime.Service.SimplePrimeGeneratorService;
import primenumbergenerator.prime.Service.SmartPrimeGeneratorService;

import java.util.Scanner;

@SpringBootApplication
public class PrimeApplication {

    public static void main(String[] args)  {
        SpringApplication.run(PrimeApplication.class, args);
        runUserAction();
    }

    private  static  void runUserAction(){
        while (true) {
            System.out.print("\n\n****Prime Generator****\n\n");
            System.out.print("Which Prime Number generator you want to use?");
            System.out.print("1. Naive approach\n2. Smart Prime function\n3. Prime Generator by facts\n");
            int choice = new Scanner(System.in).nextInt();
            System.out.println("Enter number low range: ");
            int lowRange = new Scanner(System.in).nextInt();
            System.out.println("Enter number high range: ");
            int highRange = new Scanner(System.in).nextInt();
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
                default:
                    System.out.print("Please enter a valid option from 1 to 3");
            }
        }

    }
}
