package com.ssaldarriaga.sprintpulse.organization;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    // TODO: Return all the organizations that the user is part of
    @Query("""
            SELECT o
            FROM Organization o
            """)
    Page<Organization> findAllDisplayableOrganizations(Pageable pageable, Integer id);
}
