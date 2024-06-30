package com.ssaldarriaga.sprintpulse.organization;

import com.ssaldarriaga.sprintpulse.common.BaseEntity;
import jakarta.persistence.*;
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
public class Organization extends BaseEntity {

    private String name;
    private String description;

}
