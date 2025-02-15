package mira.space.oms.data.model.dict;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "ORDER_STATUS", schema = "DICT")
@Entity(name = "oms_OrderStatus")
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oms_order_status_pk_seq")
    @SequenceGenerator(name = "oms_order_status_pk_seq", sequenceName = "DICT.ORDER_STATUS_PK_SEQ")
    private Long id;

    @Column(name = "CODE")
    private String code;
}
