package domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sofka.fcastillo.demo.domain.model.Transaction;
import reactor.test.StepVerifier;
import sofka.fcastillo.demo.domain.service.CommissionService;

import static org.junit.jupiter.api.Assertions.*;


class CommissionServiceTest {

    private CommissionService commissionService;

    @BeforeEach
    void setUp() {
        commissionService = new CommissionService();
    }

    @Test
    @DisplayName("Debe calcular comisión del 5% cuando el monto es mayor a 10000")
    void calculateCommission_AboveThreshold_ReturnsFivePercent() {

        Transaction transaction = new Transaction();
        transaction.setAmount(15000.0);
        double expectedCommission = 15000.0 * 0.05; // 750.0

        StepVerifier.create(commissionService.calculateCommission(transaction))
                .assertNext(result -> {
                    assertEquals(expectedCommission, result.getCommission(),
                            "La comisión para montos > 10000 debe ser del 5%");
                    assertNotNull(result.getTransactionDate(),
                            "La fecha de transacción debe ser generada");
                })
                .verifyComplete();
    }

    @Test
    @DisplayName("Debe calcular comisión del 2% cuando el monto es menor o igual a 10000")
    void calculateCommission_BelowThreshold_ReturnsTwoPercent() {
        // Arrange
        Transaction transaction = new Transaction();
        transaction.setAmount(5000.0);
        double expectedCommission = 5000.0 * 0.02; // 100.0

        // Act & Assert
        StepVerifier.create(commissionService.calculateCommission(transaction))
                .assertNext(result -> {
                    assertEquals(expectedCommission, result.getCommission(),
                            "La comisión para montos <= 10000 debe ser del 2%");
                })
                .verifyComplete();
    }

    @Test
    @DisplayName("Debe manejar el caso exacto de 10000 con comisión del 2%")
    void calculateCommission_ExactThreshold_ReturnsTwoPercent() {
        // Arrange
        Transaction transaction = new Transaction();
        transaction.setAmount(10000.0);
        double expectedCommission = 10000.0 * 0.02;

        // Act & Assert
        StepVerifier.create(commissionService.calculateCommission(transaction))
                .assertNext(result -> {
                    assertEquals(expectedCommission, result.getCommission());
                })
                .verifyComplete();
    }
}