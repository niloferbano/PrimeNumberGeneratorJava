package primenumbergenerator.prime.PrimeGeneratorController;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import primenumbergenerator.prime.InputSanityCheck;
import primenumbergenerator.prime.PrimeGeneratorService.PrimeGeneratorByFacts;
import primenumbergenerator.prime.PrimeGeneratorService.SimplePrimeGenerator;
import primenumbergenerator.prime.PrimeGeneratorService.SmartPrimeGenerator;

import java.util.LinkedList;
import java.util.List;

@RestController
public class PrimeGeneratorController {
    @RequestMapping(path = "/primegenerator/{type}/{lowrange}/{highrange}", method = RequestMethod.GET)
    String getPrimeNumbers(@PathVariable int type, @PathVariable int lowrange, @PathVariable int highrange){
        InputSanityCheck inputSanityCheck = new InputSanityCheck();
        lowrange = inputSanityCheck.checkInputs(lowrange, highrange);
        if(lowrange == -1){
            return "Invalid request!!! Example 'http://localhost:8080/primegenerator/1/1/1000'";
        }
        switch (type){
            case 1:
                SimplePrimeGenerator simplePrimeGenerator = new SimplePrimeGenerator();
                return "Prime Number:" + simplePrimeGenerator.primeList(lowrange, highrange);
            case 2:
                SmartPrimeGenerator newPrimeGenerator = new SmartPrimeGenerator();
                return "Prime Number:" + newPrimeGenerator.primeList(lowrange, highrange);
            case 3:
                PrimeGeneratorByFacts primeGeneratorbyFacts = new PrimeGeneratorByFacts();
                return "Prime Number:" + primeGeneratorbyFacts.primeList(lowrange, highrange);
            default:
                 return "Invalid inputs in the path";
        }
    }

    @RequestMapping("/")
    public String index() {
        return "Congratulations from prime generator";
    }

}
