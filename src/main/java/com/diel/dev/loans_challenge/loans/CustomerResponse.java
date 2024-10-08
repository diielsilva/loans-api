package com.diel.dev.loans_challenge.loans;

import java.util.List;

record CustomerResponse(
        String name,
        List<LoanResponse> available
) {
}
