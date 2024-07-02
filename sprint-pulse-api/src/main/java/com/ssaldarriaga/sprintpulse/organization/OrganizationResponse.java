package com.ssaldarriaga.sprintpulse.organization;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationResponse {

    private Integer id;
    private String name;
    private String description;

}
