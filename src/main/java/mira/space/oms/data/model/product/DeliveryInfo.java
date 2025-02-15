package mira.space.oms.data.model.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import mira.space.oms.data.model.Audit;
import mira.space.oms.data.model.crm.Address;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "DELIVERY_INFO", schema = "PRODUCT")
@Entity(name = "oms_DeliveryInfo")
public class DeliveryInfo extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oms_delivery_info_pk_seq")
    @SequenceGenerator(name = "oms_delivery_info_pk_seq", sequenceName = "PRODUCT.DELIVERY_INFO_PK_SEQ")
    private Long id;

    @Column(name = "ESTIMATED_DATE")
    private LocalDateTime estimatedDate;

    @JoinColumn(name = "ADDRESS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

    @JoinColumn(name = "ORDER_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Order order;
}
