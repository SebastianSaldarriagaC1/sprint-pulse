package com.ssaldarriaga.sprintpulse.backlog.project;

import com.ssaldarriaga.sprintpulse.backlog.sprint.SprintBacklogElement;
import com.ssaldarriaga.sprintpulse.backlog.task.Task;
import com.ssaldarriaga.sprintpulse.backlog.userstory.UserStory;
import com.ssaldarriaga.sprintpulse.common.BaseEntity;
import com.ssaldarriaga.sprintpulse.project.Project;
import com.ssaldarriaga.sprintpulse.skill.SkillTag;
import com.ssaldarriaga.sprintpulse.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProjectBacklogElement extends BaseEntity {

    private String type;
    private String title;
    private String description;
    private String priority;
    private String status;
    // private LocalDateTime creationDate;
    private LocalDateTime dueDate;
    private LocalDateTime completionDate;

    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToOne(mappedBy = "projectBacklogElement", cascade = CascadeType.ALL)
    private SprintBacklogElement sprintBacklogElement;

    @OneToOne(mappedBy = "backlogElement", cascade = CascadeType.ALL)
    private UserStory userStory;

    @OneToOne(mappedBy = "backlogElement", cascade = CascadeType.ALL)
    private Task task;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private SkillTag skillTag;

}
