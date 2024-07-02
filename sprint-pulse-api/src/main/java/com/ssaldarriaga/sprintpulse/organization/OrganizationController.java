package com.ssaldarriaga.sprintpulse.organization;

import com.ssaldarriaga.sprintpulse.common.PageResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(service.create(request, connectedUser));
    }

    @GetMapping("/{organization-id}")
    public ResponseEntity<OrganizationResponse> findOrganizationById(
            @PathVariable("organization-id") Integer id
    ) {
        return ResponseEntity.ok(service.findById(id));
    }

    // TODO: Review method. Not sure if it's correct
    @GetMapping
    public ResponseEntity<PageResponse<OrganizationResponse>> findAllBooks(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(value = "page", defaultValue = "10", required = false) Integer size,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(service.findAll(page, size, connectedUser));
    }
}
