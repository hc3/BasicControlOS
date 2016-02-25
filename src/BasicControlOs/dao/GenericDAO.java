/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BasicControlOs.dao;

import java.io.Serializable;
import java.util.Collection;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;



/**
 * @param <T>
 * @date Jan 26, 2016
 * @author hc3
 */
public class GenericDAO<T> implements Serializable {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BCOSPU");
    private EntityManager em;
    private final Class<T> entityClass;
    
    public void beginTransaction(){
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public void commit() {
        em.getTransaction().commit();
    }
    
    public void closeTransaction() {
        em.close();
    }
    
    public void rollback() {
        em.getTransaction().rollback();
    }
    
    public void commitAndCloseTransaction() {
        commit();
        closeTransaction();
    }
    
    public void flush() {
        em.flush();
    }
    
    public void joinTransaction() {
        em = emf.createEntityManager();
        em.joinTransaction();
    }
    
    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    public void save(T entity) {
        em.persist(entity);
    }
    
    protected void delete(Object id , Class<T> classe) {
        T entityToBeRemoved = em.getReference(entityClass, id);
        em.remove(entityToBeRemoved);
    }
    
    public T update(T entity) {
        return em.merge(entity);
    }
    
    public T find(int entityId) {
        return em.find(entityClass, entityId);
    }
    
    public T findReferenceOnly(int entityId) {
        return em.getReference(entityClass , entityId);
    }
    
    public Collection<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }
}

