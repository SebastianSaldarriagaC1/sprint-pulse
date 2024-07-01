package com.ssaldarriaga.sprintpulse.meeting;

import com.ssaldarriaga.sprintpulse.common.BaseEntity;
import com.ssaldarriaga.sprintpulse.project.Project;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Meeting extends BaseEntity {

    private Integer name;
    private Integer description;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

}
