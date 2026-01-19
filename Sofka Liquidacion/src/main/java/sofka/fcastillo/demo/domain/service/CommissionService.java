package sofka.fcastillo.demo.domain.service;

import sofka.fcastillo.demo.domain.model.Transaction;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class CommissionService {

    // Lógica dinámica basada en el tipo de transacción
    public Mono<Transaction> calculateCommission(Transaction transaction) {
        return Mono.just(transaction)
                .map(t -> {
                    double rate = (t.getAmount() > 10000) ? 0.05 : 0.02;
                    t.setCommission(t.getAmount() * rate);
                    t.setTransactionDate(LocalDateTime.now());
                    return t;
                });
    }
}