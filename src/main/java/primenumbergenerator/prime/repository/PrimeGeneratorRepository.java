package primenumbergenerator.prime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrimeGeneratorRepository  extends JpaRepository<PrimeGenerator, Long> {
    List<PrimeGenerator> findAll();
}
