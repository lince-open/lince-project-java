package work.lince.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@Table(name = "TB_PROJECT")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

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


}
