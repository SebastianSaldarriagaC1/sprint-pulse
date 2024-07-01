package com.ssaldarriaga.sprintpulse.skill;

import com.ssaldarriaga.sprintpulse.common.BaseEntity;
import com.ssaldarriaga.sprintpulse.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Skill extends BaseEntity {

    private Integer level;
    private Integer experience;
    private Integer nextLevelRequirement;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private SkillTag skillTag;

}
