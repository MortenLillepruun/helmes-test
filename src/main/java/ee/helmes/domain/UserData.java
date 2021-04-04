package ee.helmes.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_data")
@Data
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private boolean termsAgreement;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<UserSector> userSectors;
}
