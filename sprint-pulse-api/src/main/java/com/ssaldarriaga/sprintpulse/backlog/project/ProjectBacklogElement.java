package com.ssaldarriaga.sprintpulse.backlog.project;

import com.ssaldarriaga.sprintpulse.common.BaseEntity;
import jakarta.persistence.Entity;
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

    private Integer projectId;
    private Integer tagId;
    private String type;
    private String title;
    private String description;
    private String priority;
    private String status;
    // private LocalDateTime creationDate;
    private LocalDateTime dueDate;
    private LocalDateTime completionDate;

}
