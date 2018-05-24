package primenumbergenerator.prime.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import primenumbergenerator.prime.InputSanityCheck;
import primenumbergenerator.prime.Repository.PrimeGeneratorDto;
import primenumbergenerator.prime.Service.LogService;
import primenumbergenerator.prime.Service.PrimeGeneratorByFactsService;
import primenumbergenerator.prime.Service.SimplePrimeGeneratorService;
import primenumbergenerator.prime.Service.SmartPrimeGeneratorService;

import java.util.List;

@RestController
public class PrimeGeneratorController {
    @Autowired

    private SmartPrimeGeneratorService smartPrimeGenerator;
    @Autowired

    private SimplePrimeGeneratorService simplePrimeGenerator;

    @Autowired
    private PrimeGeneratorByFactsService primeGeneratorByFacts;

    @Autowired
    private LogService logService;

    @RequestMapping(path = "/primegenerator/{type}/{lowrange}/{highrange}", method = RequestMethod.GET)
    String getPrimeNumbers(@PathVariable int type, @PathVariable int lowrange, @PathVariable int highrange){
        InputSanityCheck inputSanityCheck = new InputSanityCheck();
        int start = inputSanityCheck.checkInputs(lowrange, highrange);
        if(start == -1){
            return "Invalid request!!! Example 'http://localhost:8080/primegenerator/1/1/1000'";
        }
        switch (type){
            case 1:
                return "Prime Numbers between " + lowrange + " and " + highrange + ":"  + simplePrimeGenerator.getPrimeList(start, highrange);
            case 2:
                return "Prime Numbers between " + lowrange + " and " + highrange + ":"  + smartPrimeGenerator.getPrimeList(start, highrange);
            case 3:
                return "Prime Numbers between " + lowrange + " and " + highrange + ":"  + primeGeneratorByFacts.getPrimeList(start, highrange);
            default:
                 return "Invalid inputs in the path";
        }
    }

    @RequestMapping("/getLogs")
    List<PrimeGeneratorDto> getLogs(){
        return logService.getLogs();
    }

}
