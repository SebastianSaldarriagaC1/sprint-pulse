package com.ssaldarriaga.sprintpulse.user;

import com.ssaldarriaga.sprintpulse.backlog.project.ProjectBacklogElement;
import com.ssaldarriaga.sprintpulse.kudos.KudoCard;
import com.ssaldarriaga.sprintpulse.medal.Medal;
import com.ssaldarriaga.sprintpulse.organization.OrganizationMember;
import com.ssaldarriaga.sprintpulse.project.ProjectMember;
import com.ssaldarriaga.sprintpulse.role.Role;
import com.ssaldarriaga.sprintpulse.skill.Skill;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_user")
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails, Principal {

    // Basic columns
    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    private Integer points;

    // Spring Security - UserDetails columns
    private boolean accountLocked;

    private boolean enabled;

    // Relationships
    @OneToMany(mappedBy = "user")
    private List<Medal> medals;

    @OneToMany(mappedBy = "user")
    private List<Skill> skills;

    @OneToMany(mappedBy = "user")
    private List<OrganizationMember> memberOrganizations;

    @OneToMany(mappedBy = "user")
    private List<ProjectMember> memberProjects;

    @OneToMany(mappedBy = "user")
    private List<ProjectBacklogElement> projectBacklogElements;

    @OneToMany(mappedBy = "sender")
    private List<KudoCard> sentKudos;

    @OneToMany(mappedBy = "receiver")
    private List<KudoCard> receivedKudos;

    // Auditing columns
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

    // Relationships
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;


    // UserDetails methods
    @Override
    public String getName() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
