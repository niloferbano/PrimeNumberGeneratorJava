package primenumbergenerator.prime.DataBaseObjects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrimeGeneratorDBObject {
    private String timeStamp;
    private String range;
    private Long timeELapsed;
    private String usedAlgorithm;
    private Integer countPrimes;
}
