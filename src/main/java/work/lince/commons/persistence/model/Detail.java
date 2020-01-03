package work.lince.commons.persistence.model;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

public interface Detail {

    ZonedDateTime getDate();
    void setDate(ZonedDateTime date);
    String getUser();
    void setUser(String user);

}
