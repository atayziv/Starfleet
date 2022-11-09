package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class myAbsBattleShip extends myAbsSpaceShip {

    private List<Weapon> weaponsList;

    public myAbsBattleShip(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weaponsList) {
        super(name, commissionYear, maximalSpeed, crewMembers);
        this.weaponsList=weaponsList;
    }

    public List<Weapon> getWeapon(){
        return weaponsList;
    }

    public int getFirePower(){
        int firePower=0;
        for(Weapon weapon: weaponsList){
            firePower+=weapon.getFirePower();

        }
        return super.getFirePower()+firePower;
    }

    public int getAnnualCostOfMaintainWeapons(List<Weapon> weaponsList){
        int weaponsAnnualMaintenanceCost=0;
        for(Weapon weapon:weaponsList){
            weaponsAnnualMaintenanceCost+=weapon.getAnnualMaintenanceCost();
        }
        return weaponsAnnualMaintenanceCost ;
    }

    public int getAnnualMaintenanceCost(){
        return getAnnualCostOfMaintainWeapons(weaponsList);
    }

    public String toString(){
        return super.toString() + "\n\tAnnualMaintenanceCost=" + getAnnualMaintenanceCost() + "\n\tWeaponArray=" + getWeapon();
    }

    public boolean equals(Object obj){
        myAbsBattleShip other=(myAbsBattleShip) obj;
        boolean result = super.equals(other);
        if(result==true){
            if(this.weaponsList.equals(other.weaponsList))
                return true;
        }
        return false;
    }

    public int hashCode(){
        return Objects.hash(super.hashCode(), weaponsList);
    }



}
