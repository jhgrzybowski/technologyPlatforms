package lab4;

import lab4.entities.*;
import lab4.repository.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Application {
    public static void main(String[] args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lab4");
        MageRepository mageRepository = new MageRepository(entityManagerFactory);
        TowerRepository towerRepository = new TowerRepository(entityManagerFactory);
        init(mageRepository, towerRepository);
        // Wyświetlanie magów
        for (Mage mage : mageRepository.findAll()) System.out.println(mage);
        // Wyświetlanie wieży
        for (Tower tower : towerRepository.findAll()){
            System.out.println(tower);
        }
    }

    public static void init(MageRepository mageRepository, TowerRepository towerRepository){
        Tower tower1 = new Tower("Tower1", 20);
        towerRepository.add(tower1);

        Mage mage1 = new Mage("Mage1", 5);
        mage1.setTower(null);

        Mage mage2 = new Mage("Mage2", 4);
        mage2.setTower(tower1);

        mageRepository.add(mage1);
        mageRepository.add(mage2);

        List<Mage> mages = mageRepository.findAllGreaterThan(4);
        List<Tower> towers = towerRepository.findAllHigherThan(25);
        List<Mage> magesFromTower = mageRepository.findAllGreaterThan(2, tower1);

        // Testowanie usuwania wież i czy magowie zostają
        //towerRepository.delete(tower1);
    }

}
