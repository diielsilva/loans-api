package com.diel.dev.loans_challenge.loans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanServiceTest {
    private LoanService service;

    @BeforeEach
    void setUp() {
        service = new LoanService();
    }

    @Test
    void getAvailable_ShouldHaveAllLoanTypes() {
        CustomerRequest customer = new CustomerRequest(
                "12345",
                "Alex A.",
                26L,
                new BigDecimal(7000),
                "SP"
        );

        CustomerResponse response = service.getAvailable(customer);

        assertEquals(3, response.available().size());

    }

    @Test
    void getAvailable_ShouldHaveOnlyConsignmentLoan() {
        CustomerRequest customer = new CustomerRequest(
                "12345",
                "Alex A.",
                35L,
                new BigDecimal(7000),
                "SC"
        );

        CustomerResponse response = service.getAvailable(customer);

        assertAll(() -> {
            assertEquals(1, response.available().size());
            assertEquals(LoanType.CONSIGNMENT, response.available().getFirst().type());
        });
    }

    @Test
    void getAvailable_ShouldHaveJustPersonalAndGuaranteedLoans() {
        CustomerRequest customer = new CustomerRequest(
                "12345",
                "Alex A.",
                35L,
                new BigDecimal(2900),
                "SC"
        );


        CustomerResponse response = service.getAvailable(customer);

        assertAll(() -> {
            assertEquals(2, response.available().size());
            assertEquals(LoanType.PERSONAL, response.available().getFirst().type());
            assertEquals(LoanType.GUARANTEED, response.available().getLast().type());
        });
    }

}