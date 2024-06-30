package com.ssaldarriaga.sprintpulse.backlog.userstory;

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
public class UserStory extends BaseEntity {

    private Integer assignedTo;
    private Integer backlogElementId;
    private String acceptanceCriteria;
    private Integer storyPoints;

}
