package work.lince.project.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity(name = "TB_TASKS")
public class Tasks implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @NotEmpty
    @Column(name = "TITLE",length = 50)
    private String title;

    @Column(name = "DESCRIPTION",length = 250)
    private String description;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Tasks(){
        super();
    }

    public Tasks(Long id, @NotEmpty String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tasks tasks = (Tasks) o;

        return id != null ? id.equals(tasks.id) : tasks.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
