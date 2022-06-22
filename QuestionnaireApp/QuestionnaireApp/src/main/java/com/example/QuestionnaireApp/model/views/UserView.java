package com.example.QuestionnaireApp.model.views;

import com.example.QuestionnaireApp.model.ERole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "view_users")
@Setter
@Getter
@NoArgsConstructor
public class UserView {

    @Id
    private Long id;

    @Column
    private String username;

    @Column
    private boolean status;

    @Column
    @Enumerated(value = EnumType.STRING)
    private ERole role;

    public UserView(ERole role) {
        this.role = role;
    }
}
