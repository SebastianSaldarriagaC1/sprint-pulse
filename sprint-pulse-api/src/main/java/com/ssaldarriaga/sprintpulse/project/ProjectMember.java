package com.ssaldarriaga.sprintpulse.project;

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
public class ProjectMember extends BaseEntity {

    private Integer userId;
    private Integer projectId;
    private String projectRole;

}
