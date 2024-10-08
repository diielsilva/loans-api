package com.diel.dev.loans_challenge.loans;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/loans")
class LoanController {
    private final LoanService service;

    LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<CustomerResponse> getAvailable(@RequestBody @Valid CustomerRequest customer) {
        CustomerResponse response = service.getAvailable(customer);

        return ResponseEntity.ok(response);
    }

}
