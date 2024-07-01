package com.ssaldarriaga.sprintpulse.project;

import com.ssaldarriaga.sprintpulse.backlog.project.ProjectBacklogElement;
import com.ssaldarriaga.sprintpulse.common.BaseEntity;
import com.ssaldarriaga.sprintpulse.meeting.Meeting;
import com.ssaldarriaga.sprintpulse.organization.Organization;
import com.ssaldarriaga.sprintpulse.sprint.Sprint;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Project extends BaseEntity {

    private String name;
    private Integer description;
    private Integer state;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToMany(mappedBy = "project")
    private List<ProjectMember> members;

    @OneToMany(mappedBy = "project")
    private List<Sprint> sprints;

    @OneToMany(mappedBy = "project")
    private List<ProjectBacklogElement> backlogElements;

    @OneToMany(mappedBy = "project")
    private List<Meeting> meetings;

}
