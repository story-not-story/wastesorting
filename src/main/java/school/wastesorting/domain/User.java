package school.wastesorting.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;

@Table(name = "user")
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @JsonProperty(value = "name")
    private String name;

    @Column(name = "password")
    @JsonProperty(value = "password")
    private String password;

    @Column(name = "flag")
    @JsonProperty(value = "flag")
    private Integer flag;
}

