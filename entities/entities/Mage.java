package lab4.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mage {
    @Id
    private String name;
    private int level;

    public String getName(){ return this.name; };
    public int getLevel(){ return this.level; };

    @ManyToOne
    @JoinColumn(name = "tower")
    private Tower tower;
    public Tower getTower(){ return this.tower; };

    public Mage(){};
    public Mage(String name, int level){
        this.name = name;
        this.level = level;
    }

    public void setTower(Tower tower){
        this.tower = tower;
        if(tower != null){
            tower.addMage(this);
        }
    }

    @Override
    public String toString(){
        return "Mag o imieniu " + name + " i poziomie " + level + ".\n";
    }
}
