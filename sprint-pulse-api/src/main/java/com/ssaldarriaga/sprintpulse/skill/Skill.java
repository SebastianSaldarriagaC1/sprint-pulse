package com.ssaldarriaga.sprintpulse.skill;

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
public class Skill extends BaseEntity {

    private Integer tagId;
    private Integer userId;
    private Integer level;
    private Integer experience;
    private Integer nextLevelRequirement;
}
