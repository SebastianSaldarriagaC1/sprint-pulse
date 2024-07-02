package com.ssaldarriaga.sprintpulse.organization;

import com.ssaldarriaga.sprintpulse.common.PageResponse;
import com.ssaldarriaga.sprintpulse.user.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationMapper organizationMapper;
    private final organizationRepository organizationRepository;

    public Integer create(OrganizationRequest request, Authentication connectedUser) {
        User user = (User) connectedUser.getPrincipal();
        Organization organization = organizationMapper.toOrganization(request);
        // TODO: Add the user to the organization
        return organizationRepository.save(organization).getId();
    }

    public OrganizationResponse findById(Integer id) {
        return organizationRepository.findById(id)
                .map(organizationMapper::toOrganizationResponse)
                .orElseThrow(() -> new EntityNotFoundException("Organization not found with the ID: " + id));
    }

    public PageResponse<OrganizationResponse> findAll(Integer page, Integer size, Authentication connectedUser) {
        User user = (User) connectedUser.getPrincipal();
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
        Page<Organization> organizations = organizationRepository.findAllDisplayableOrganizations(pageable, user.getId());
        List<OrganizationResponse> organizationResponses = organizations.stream()
                .map(organizationMapper::toOrganizationResponse)
                .toList();
        return new PageResponse<>(
                organizationResponses,
                organizations.getNumber(),
                organizations.getSize(),
                organizations.getTotalElements(),
                organizations.getTotalPages(),
                organizations.isFirst(),
                organizations.isLast()
        );
    }
}
