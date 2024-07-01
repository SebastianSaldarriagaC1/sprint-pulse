package com.ssaldarriaga.sprintpulse.skill;

import com.ssaldarriaga.sprintpulse.backlog.project.ProjectBacklogElement;
import com.ssaldarriaga.sprintpulse.common.BaseEntity;
import jakarta.persistence.Entity;
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
public class SkillTag extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "skillTag")
    private List<ProjectBacklogElement> projectBacklogElements;

    @OneToMany(mappedBy = "skillTag")
    private List<Skill> skills;
}
