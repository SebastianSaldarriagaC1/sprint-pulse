package com.ssaldarriaga.sprintpulse.organization;

import com.ssaldarriaga.sprintpulse.common.BaseEntity;
import com.ssaldarriaga.sprintpulse.project.Project;
import com.ssaldarriaga.sprintpulse.reward.Reward;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Organization extends BaseEntity {

    private String name;
    private String description;

    @OneToMany(mappedBy = "organization")
    private List<OrganizationMember> members;

    @OneToMany(mappedBy = "organization")
    private List<Project> projects;

    @OneToMany(mappedBy = "organization")
    private List<Reward> rewards;

}
