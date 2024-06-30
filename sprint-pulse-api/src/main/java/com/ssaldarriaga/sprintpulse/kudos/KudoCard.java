package com.ssaldarriaga.sprintpulse.kudos;

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
public class KudoCard extends BaseEntity {

    private Integer senderId;
    private Integer receiverId;
    private String title;
    private String message;
    private String style;

}
