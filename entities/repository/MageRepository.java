package lab4.repository;

import lab4.entities.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class MageRepository extends MainRepository<Mage, String> {
    public MageRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Mage.class);
    }

    public List<Mage> findAllGreaterThan(int level){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Mage> list = entityManager.createQuery("SELECT m FROM " + classEntity.getSimpleName() +
                " m WHERE m.level > " + level, classEntity).getResultList();
        entityManager.close();
        return list;
    }

    public List<Mage> findAllGreaterThan(int level, Tower tower){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Mage> list = entityManager.createQuery("SELECT m FROM " + classEntity.getSimpleName() +
                " m WHERE m.level >" + level + " AND tower = '" +
                tower.getName() + "'", classEntity).getResultList();
        entityManager.close();
        return list;
    }
}
