package com.ssaldarriaga.sprintpulse.organization;

import org.springframework.stereotype.Service;

@Service
public class OrganizationMapper {


    public Organization toOrganization(OrganizationRequest request) {

        return Organization.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .build();
    }

    public OrganizationResponse toOrganizationResponse(Organization organization) {
        return OrganizationResponse.builder()
                .id(organization.getId())
                .name(organization.getName())
                .description(organization.getDescription())
                .build();
    }
}
