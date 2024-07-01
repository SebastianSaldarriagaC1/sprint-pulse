package com.ssaldarriaga.sprintpulse.backlog.userstory;

import com.ssaldarriaga.sprintpulse.backlog.project.ProjectBacklogElement;
import com.ssaldarriaga.sprintpulse.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

    private String acceptanceCriteria;
    private Integer storyPoints;

    @OneToOne
    @JoinColumn(name = "backlog_element_id")
    private ProjectBacklogElement backlogElement;

}
