package com.rakuten.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.domain.Product;

@Transactional
@Repository
@Primary
public class ProductDAOJpaImpl implements ProductDAO{

	@Autowired
	EntityManager em;
	
	public Product save(Product toBeSaved) {
		em.persist(toBeSaved);
		return toBeSaved;
	}

	public Product findById(int id) {
		return em.find(Product.class, id);
	}

	public List<Product> findAll() {
		Query q = em.createQuery("seLecT p from Product as p");
		return q.getResultList();
	}

	public void deleteById(int id) {
		Product p = em.find(Product.class, id);
		em.remove(p);
	}

}