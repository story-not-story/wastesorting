package school.wastesorting.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;

@Table(name = "first_class")
@Data
@Entity
public class FirstClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "first_id")
    private Integer id;

    @Column(name = "first_class_name")
    @JsonProperty(value = "name")
    private String name;

    @Column(name = "desciption")
    @JsonProperty(value = "desciption")
    private String desciption;

    @Column(name = "requirement")
    @JsonProperty(value = "requirement")
    private String requirement;
}
