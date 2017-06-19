package co.oriana.orders.domain.product;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Jota Uribe on 18/6/2017.
 */

@ApplicationScoped
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    protected ProductRepository(){}

    public void save(Product product){
        entityManager.persist(product);
    }

    public Product findById(ProductId productId){
        return entityManager.createNamedQuery(
                "Product.findByProductId",
                Product.class)
                .setParameter("ProductId", productId)
                .getSingleResult();
    }

    public List<Product> findByName(String string){

        return  entityManager.createNamedQuery(
                "Product.findByProductName",
                Product.class)
                .setParameter("String", string)
                .getResultList();
    }

    public List<Product> findAll(){
        return entityManager.createNamedQuery(
                "Product.findAll",
                Product.class)
                .getResultList();
    }

}
