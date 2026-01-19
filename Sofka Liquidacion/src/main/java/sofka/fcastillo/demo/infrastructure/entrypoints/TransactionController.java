package sofka.fcastillo.demo.infrastructure.entrypoints;

import sofka.fcastillo.demo.domain.model.Transaction;
import sofka.fcastillo.demo.domain.service.CommissionService;
import sofka.fcastillo.demo.infrastructure.adapters.TransactionRepository;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/commissions")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionRepository repository;
    private final CommissionService commissionService;

    @PostMapping("/process")
    public Mono<Transaction> process(@RequestBody Transaction transaction) {
        return Mono.just(transaction)
                .filter(t -> t.getAmount() > 0)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("El monto debe ser mayor a cero")))
                .flatMap(commissionService::calculateCommission)
                .flatMap(repository::save);
    }

    @GetMapping
    public Flux<Transaction> getAll() {
        return repository.findAll();
    }
}