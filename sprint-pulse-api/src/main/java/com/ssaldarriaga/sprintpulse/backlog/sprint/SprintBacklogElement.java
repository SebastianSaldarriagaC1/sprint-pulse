package com.ssaldarriaga.sprintpulse.backlog.sprint;

import com.ssaldarriaga.sprintpulse.backlog.project.ProjectBacklogElement;
import com.ssaldarriaga.sprintpulse.common.BaseEntity;
import com.ssaldarriaga.sprintpulse.sprint.Sprint;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class SprintBacklogElement extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;

    @OneToOne
    @JoinColumn(name = "project_backlog_element_id")
    private ProjectBacklogElement projectBacklogElement;

}
