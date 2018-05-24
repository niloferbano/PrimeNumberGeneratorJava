package primenumbergenerator.prime.Service;

import primenumbergenerator.prime.Repository.PrimeGenerator;
import primenumbergenerator.prime.Repository.PrimeGeneratorDto;

public class PrimeGeneratorMapper {

    public static PrimeGeneratorDto mapper(PrimeGenerator primeGenerator) {
        PrimeGeneratorDto primeGeneratorDto = new PrimeGeneratorDto();
        primeGeneratorDto.setPrimeCount(primeGenerator.getCountPrimes());
        primeGeneratorDto.setRange(primeGenerator.getRange());
        primeGeneratorDto.setTimeELapsed(primeGenerator.getTimeELapsed());
        primeGeneratorDto.setTimeStamp(primeGenerator.getTimeStamp());
        primeGeneratorDto.setUsedAlgorithm(primeGenerator.getUsedAlgorithm());
        return primeGeneratorDto;
    }
}
