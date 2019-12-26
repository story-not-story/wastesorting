package school.wastesorting.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Table(name = "third_class")
@Data
@Entity
public class ThirdClass {
    @Id
    @GeneratedValue
    @Column(name = "third_id")
    private Integer id;
    @Column(name = "object_name")
    @JsonProperty(value = "name")
    private String name;
    @Column(name = "second_id")
    @JsonProperty(value = "parentId")
    private Integer parentId;
    @Column(name = "pic_addr")
    @JsonProperty(value = "picAddr")
    private String picAddr;
}

