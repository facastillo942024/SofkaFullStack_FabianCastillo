package sofka.fcastillo.demo.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table("transactions")
public class Transaction {
    @Id
    private Long id;
    @Column("amount")
    private Double amount;

    @Column("type")
    private String type;

    @Column("commission")
    private Double commission;

    @Column("transaction_date") // Mapeo exacto al SQL
    private LocalDateTime transactionDate;
}
