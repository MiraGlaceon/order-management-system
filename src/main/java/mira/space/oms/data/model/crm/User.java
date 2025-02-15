package mira.space.oms.data.model.crm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import mira.space.oms.data.model.Audit;

@Getter
@Setter
@Table(name = "OMS_USER", schema = "CRM")
@Entity(name = "oms_User")
public class User extends Audit {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oms_user_pk_seq")
    @SequenceGenerator(name = "oms_user_pk_seq", sequenceName = "CRM.OMS_USER_PK_SEQ")
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "EMAIL")
    private String email;
}
