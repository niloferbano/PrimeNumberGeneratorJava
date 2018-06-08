package primenumbergenerator.prime.repository;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="PrimeGenerateLog")
public class PrimeGenerator {
    @Id
    @Column (name = "ID")
    private Long id;
    @Column(name="timeStamp")
    private String timeStamp;
    @Column(name="range")
    private String range;
    @Column(name="timeELapsed")
    private long timeELapsed;
    @Column(name="usedAlgorithm")
    private String usedAlgorithm;
    @Column(name="countPrimes")
    private int countPrimes;

    public PrimeGenerator(){

    }
    public PrimeGenerator(long id, String timeStamp, String range, long timeELapsed, String usedAlgorithm, int countPrimes) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.range = range;
        this.timeELapsed = timeELapsed;
        this.usedAlgorithm = usedAlgorithm;
        this.countPrimes = countPrimes;
    }

}
