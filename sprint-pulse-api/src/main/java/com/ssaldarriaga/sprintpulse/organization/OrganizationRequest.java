package com.ssaldarriaga.sprintpulse.organization;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record OrganizationRequest(
        Integer id,
        @NotNull(message = "100")
        @NotEmpty(message = "100")
        String name,
        String description
) {
}
