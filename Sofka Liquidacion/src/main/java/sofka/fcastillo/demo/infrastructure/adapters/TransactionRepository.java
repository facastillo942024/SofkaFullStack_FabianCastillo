package sofka.fcastillo.demo.infrastructure.adapters;

import sofka.fcastillo.demo.domain.model.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends ReactiveCrudRepository<Transaction, Long> {
}