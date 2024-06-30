package com.ssaldarriaga.sprintpulse.organization;

import com.ssaldarriaga.sprintpulse.common.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrganizationMember extends BaseEntity {

    private Integer userId;
    private Integer organizationId;
    private String organizationRole;
    private Integer points;

}
