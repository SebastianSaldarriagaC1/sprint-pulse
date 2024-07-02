package com.ssaldarriaga.sprintpulse.organization;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface organizationRepository extends JpaRepository<Organization, Integer> {
    // TODO: Return all the organizations that the user is part of
    @Query("""
            SELECT o
            FROM Organization o
            JOIN o.users u
            WHERE u.id = :id
            """)
    Page<Organization> findAllDisplayableOrganizations(Pageable pageable, Integer id);
}
