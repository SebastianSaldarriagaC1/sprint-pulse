package com.ssaldarriaga.sprintpulse.organization;

import com.ssaldarriaga.sprintpulse.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationMapper organizationMapper;
    private final organizationRepository organizationRepository;

    public Integer createOrganization(OrganizationRequest request, Authentication connectedUser) {
        User user = (User) connectedUser.getPrincipal();
        Organization organization = organizationMapper.toOrganization(request);
        // TODO: Add the user to the organization
        return organizationRepository.save(organization).getId();
    }
}
