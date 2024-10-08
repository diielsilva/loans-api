package com.diel.dev.loans_challenge.shared;

import java.util.List;

record ErrorResponse(
        List<String> details
) {
}
