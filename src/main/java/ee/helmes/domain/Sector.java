package ee.helmes.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "sector")
@Data
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column
    private Integer value;

    @Column
    private String text;

}
