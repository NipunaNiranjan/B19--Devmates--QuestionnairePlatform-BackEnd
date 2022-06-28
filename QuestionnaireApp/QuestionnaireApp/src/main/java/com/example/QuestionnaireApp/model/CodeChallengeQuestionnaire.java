package com.example.QuestionnaireApp.model;

import javax.persistence.*;

@Entity
@Table(name = "code_challenge_questionnaires")
public class CodeChallengeQuestionnaire {
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)
private int id;
@Column
private String title;
@Column
private String description ;
 @Column
 private Integer duration;
@Column(columnDefinition = ( "varchar(255) default 'CODE'"))
private String type;


// @ManyToMany(fetch = FetchType.LAZY, cascade = {
//         CascadeType.PERSIST,
//         CascadeType.MERGE
// })
// @JoinTable(name = "questionnaire_codingChallenges", joinColumns = { @JoinColumn(name = "questionnaire_id") }, inverseJoinColumns = {
//         @JoinColumn(name = "codingChallenge_id") })


// private List<CodingChallenges> challenges ;

public CodeChallengeQuestionnaire() {
}


public CodeChallengeQuestionnaire(String title, String description, Integer duration, String type) {
   
    this.title = title;
    this.description = description;
    this.duration = duration;
    this.type = type;
}


public int getId() {
    return id;
}


public void setId(int id) {
    this.id = id;
}


public String getTitle() {
    return title;
}


public void setTitle(String title) {
    this.title = title;
}


public String getDescription() {
    return description;
}


public void setDescription(String description) {
    this.description = description;
}


public Integer getDuration() {
    return duration;
}


public void setDuration(Integer duration) {
    this.duration = duration;
}


public String getType() {
    return type;
}


public void setType(String type) {
    this.type = type;
}


@Override
public String toString() {
    return "CodeChallengeQuestionnaire [description=" + description + ", duration=" + duration + ", id=" + id
            + ", title=" + title + ", type=" + type + "]";
}



}
