package lab4.entities;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Tower {
    @Id
    private String name;
    private int height;

    public String getName(){ return this.name; };
    public int getHeight(){ return this.height; };

    @OneToMany(mappedBy="tower", fetch= FetchType.EAGER)
    private List<Mage> mages = new ArrayList<>();
    public List<Mage> getMages(){ return this.mages; };
    public void addMage(Mage mage) { mages.add(mage); };

    public Tower(){};
    public Tower(String name, int height){
        this.name = name;
        this.height = height;
    }

    @PreRemove
    private void preRemove(){ for (Mage mage : mages) mage.setTower(null); }

    @Override
    public String toString(){ return "Wieża o nazwie " + name + " i wysokości " + height + ".\n"; };
}
