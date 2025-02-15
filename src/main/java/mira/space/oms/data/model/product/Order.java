package mira.space.oms.data.model.product;

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
import mira.space.oms.data.model.crm.User;
import mira.space.oms.data.model.dict.OrderStatus;

import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "ORDER", schema = "PRODUCT")
@Entity(name = "oms_Order")
public class Order extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oms_order_pk_seq")
    @SequenceGenerator(name = "oms_order_pk_seq", sequenceName = "PRODUCT.ORDER_PK_SEQ")
    private Long id;

    @Column(name = "ORDER_NUMBER")
    private Integer orderNumber;

    @JoinColumn(name = "ORDER_STATUS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderStatus orderStatus;

    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;

    @JoinColumn(name = "USER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
