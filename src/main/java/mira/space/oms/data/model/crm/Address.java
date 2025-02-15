package mira.space.oms.data.model.crm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import mira.space.oms.data.model.Audit;

@Getter
@Setter
@Table(name = "ADDRESS", schema = "CRM")
@Entity(name = "oms_Address")
public class Address extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oms_address_pk_seq")
    @SequenceGenerator(name = "oms_address_pk_seq", sequenceName = "CRM.ADDRESS_PK_SEQ")
    private Long id;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "HOUSE")
    private String house;

    @Column(name = "FULL_ADDRESS")
    private String fullAddress;

    @JoinColumn(name = "USER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
