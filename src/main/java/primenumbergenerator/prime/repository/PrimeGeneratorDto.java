package primenumbergenerator.prime.repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrimeGeneratorDto {
    private String timeStamp;
    private String range;
    private long timeELapsed;
    private String usedAlgorithm;
    private int primeCount;

}
