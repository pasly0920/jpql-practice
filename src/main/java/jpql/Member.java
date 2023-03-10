package jpql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "Member.findByUsername", query = "select m from Member m where m.username = :username")
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String username;
    private int age;

    @Enumerated(EnumType.STRING)
    private MemberType type;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

}
