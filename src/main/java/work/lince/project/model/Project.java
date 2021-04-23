package work.lince.project.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "TB_PROJECT")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @NotEmpty
    @Column(name = "TITLE",length = 50)
    private String title;

    @Column(name = "DESCRIPTION",length = 250)
    private String description;

    @Column(name = "STATUS",length = 20)
    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    @Column(name = "OWNER",length = 50)
    private String owner;

    @OneToMany(mappedBy = "project")
    private List<Tasks> tasks = new ArrayList<>();


    public Project(){
        super();
    }

    public Project(Long id, @NotEmpty String title, String description, ProjectStatus status, String owner) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.owner = owner;
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

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }
}
