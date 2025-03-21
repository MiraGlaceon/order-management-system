package mira.space.oms.data.model.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import mira.space.oms.data.model.audit.Audit;

import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "PRODUCT", schema = "PRODUCT")
@Entity(name = "oms_Product")
public class Product extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oms_product_pk_seq")
    @SequenceGenerator(name = "oms_product_pk_seq", sequenceName = "PRODUCT.PRODUCT_PK_SEQ")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "AVAILABLE_QUANTITY")
    private Integer availableQuantity;
}
