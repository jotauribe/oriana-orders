package co.oriana.orders.domain.product;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Jota Uribe on 18/6/2017.
 */

@Embeddable
public class ProductId implements Serializable{

    @Column(name = "product_id")
    protected String id;

    public ProductId(){
        this.id = UUID.randomUUID().toString();
    }


    public String getId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductId productId = (ProductId) o;

        return id.equals(productId.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id;
    }
}
