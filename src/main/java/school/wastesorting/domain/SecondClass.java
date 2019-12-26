package school.wastesorting.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Table(name = "second_class")
@Data
@Entity
public class SecondClass {
    @Id
    @GeneratedValue
    @Column(name = "second_id")
    private Integer id;
    @Column(name = "first_id")
    @JsonProperty(value = "parent_id")
    private Integer parentId;
    @Column(name = "second_class_name")
    @JsonProperty(value = "name")
    private String name;
}
