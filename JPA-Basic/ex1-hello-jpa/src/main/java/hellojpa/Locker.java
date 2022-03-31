package hellojpa;

import javax.persistence.*;

@Entity
public class Locker {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}