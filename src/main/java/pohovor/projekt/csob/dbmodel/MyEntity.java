package pohovor.projekt.csob.dbmodel;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@MappedSuperclass
public abstract class MyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = DBconstants.Entity.id)
    private Long id;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    @Column(name = DBconstants.Entity.creationDate, nullable = false)
    private Date creationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyEntity myEntity = (MyEntity) o;
        return Objects.equals(id, myEntity.id) && Objects.equals(creationDate, myEntity.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate);
    }
}
