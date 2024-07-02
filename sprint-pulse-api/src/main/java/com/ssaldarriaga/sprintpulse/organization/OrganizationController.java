package com.ssaldarriaga.sprintpulse.organization;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("organization")
@RequiredArgsConstructor
@Tag(name = "Organization", description = "Organization API")
public class OrganizationController {

    private final OrganizationService service;

    @PostMapping
    public ResponseEntity<Integer> createOrganization(
            @Valid @RequestBody OrganizationRequest request,
            Authentication connectedUser
    ) {
        return ResponseEntity.ok(service.createOrganization(request, connectedUser));
    }

}
