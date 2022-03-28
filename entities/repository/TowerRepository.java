package lab4.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import lab4.entities.*;
import java.util.List;

public class TowerRepository extends MainRepository<Tower, String> {
    public TowerRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Tower.class);
    }

    public List<Tower> findAllHigherThan(int height){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Tower> list = entityManager.createQuery("SELECT t FROM " + classEntity.getSimpleName() +
                " t WHERE t.height > " + height, classEntity).getResultList();
        entityManager.close();
        return list;
    }
}
