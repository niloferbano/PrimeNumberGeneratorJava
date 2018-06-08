package primenumbergenerator.prime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import primenumbergenerator.prime.repository.PrimeGenerator;
import primenumbergenerator.prime.repository.PrimeGeneratorDto;
import primenumbergenerator.prime.repository.PrimeGeneratorRepository;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Service
public class LogService {
    @Autowired
    private PrimeGeneratorRepository primeGeneratorRepository;

    public void saveEvent(PrimeGenerator primeGeneratorDBObject){
        primeGeneratorRepository.saveAndFlush(primeGeneratorDBObject);

    }

    public List<PrimeGeneratorDto> getLogs(){
        List<PrimeGenerator> primeGeneratorList = primeGeneratorRepository.findAll();
        primeGeneratorList.sort(Comparator.comparing(PrimeGenerator::getTimeStamp).reversed());
        List<PrimeGeneratorDto> primeGeneratorDtoList = new LinkedList<>();
        for(PrimeGenerator primeGenerator: primeGeneratorList){
            primeGeneratorDtoList.add(PrimeGeneratorMapper.mapper(primeGenerator));
        }
        return primeGeneratorDtoList;
    }
}
