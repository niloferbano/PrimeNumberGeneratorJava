package primenumbergenerator.prime;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class SimplePrimeGenerator {
    public List<Integer> primeList(int lowRange, int highRange) {
        List<Integer> primeIntegerList = new LinkedList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));
        for (int number = lowRange; number <= highRange; number++) {
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
        System.out.println(dtf.format(LocalDateTime.now()));
        System.out.print("Size: " + primeIntegerList.size());
        return primeIntegerList;
    }
}
