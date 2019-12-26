package school.wastesorting.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Table(name = "configuration")
@Data
@Entity
public class Config {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "configuration_value")
    @JsonProperty(value = "config_value")
    private String value;
}
