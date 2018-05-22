package primenumbergenerator.prime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class PrimeGeneratorbyFacts {
    public List<Integer> primeList(int lowRange, int highRange) {
        List<Integer> primeIntegerList = new LinkedList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));
        for (int number = lowRange; number < highRange; number++) {
            boolean isPrime = true;
            if ((number > 2 && number %2 == 0) || (number > 5 && number % 5 == 0)) {
                continue;
            }
            if(number > 3) {
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

            for (int j = 2; j <= number/2 ; j++) {
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
        System.out.print("Size: " + primeIntegerList.size());
        return primeIntegerList;
    }
}
