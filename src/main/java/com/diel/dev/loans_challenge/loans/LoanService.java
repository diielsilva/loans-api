package com.diel.dev.loans_challenge.loans;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
class LoanService {

    CustomerResponse getAvailable(CustomerRequest customer) {
        CustomerResponse response = new CustomerResponse(
                customer.name(),
                new ArrayList<>()
        );

        if (isEligibleForPersonalAndGuaranteedLoan(customer)) {
            response.available().add(new LoanResponse(LoanType.PERSONAL, 4));
            response.available().add(new LoanResponse(LoanType.GUARANTEED, 3));
        }

        if (isEligibleForConsignmentLoan(customer)) {
            response.available().add(new LoanResponse(LoanType.CONSIGNMENT, 2));
        }

        return response;
    }

    private boolean isEligibleForPersonalAndGuaranteedLoan(CustomerRequest customer) {
        double income = customer.income().doubleValue();
        int age = customer.age().intValue();
        String location = customer.location();

        return income < 5000D || (age < 30 && location.equals("SP"));
    }

    private boolean isEligibleForConsignmentLoan(CustomerRequest customer) {
        double income = customer.income().doubleValue();

        return income >= 5000D;
    }

}
