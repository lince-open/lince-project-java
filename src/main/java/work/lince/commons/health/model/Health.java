package work.lince.commons.health.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Health {

    private String status;
    private LocalDateTime now;
    private String user;
    private String service;
    private String version;

}
