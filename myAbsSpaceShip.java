package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;
import java.util.Set;

public abstract  class myAbsSpaceShip implements Spaceship {

    private String name;
    private int commissionYear;
    private float maximalSpeed;
    private final int firePower=10;
    private Set<? extends CrewMember> crewMembers;

    public myAbsSpaceShip(String name,int commissionYear,float maximalSpeed,Set<? extends CrewMember> crewMembers)
    {
        super();
        this.name=name;
        this.commissionYear=commissionYear;
        this.maximalSpeed=maximalSpeed;
        this.crewMembers=crewMembers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCommissionYear(){
        return commissionYear;
    }

    public void setCommissionYear(){
        this.commissionYear=commissionYear;
    }

    public float getMaximalSpeed(){
        return maximalSpeed;
    }

    public void setMaximalSpeed(){
        this.maximalSpeed=maximalSpeed;
    }

    public int getFirePower(){
        return firePower;
    }

    public Set<? extends CrewMember> getCrewMembers(){
        return crewMembers;
    }
    //protected abstract int okay();

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getClass().getSimpleName());
        str.append("\n\tName=").append(name);
        str.append("\n\tCommissionYear=").append(commissionYear);
        str.append("\n\tMaximalSpeed=").append(maximalSpeed);
        str.append("\n\tFirePower=").append(getFirePower());
        str.append("\n\tCrewMembers=").append(crewMembers.size());
        return str.toString();
    }

    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        myAbsSpaceShip other=(myAbsSpaceShip) obj;
        if(this.commissionYear!=other.commissionYear && this.maximalSpeed!=other.maximalSpeed && this.firePower!=other.firePower)
            return false;
        if(!this.crewMembers.equals(other.crewMembers))
            return false;
        if(!this.name.equals(other.name))
            return false;
        return true;
    }

    public int hashCode(){
        return Objects.hash(name,commissionYear,maximalSpeed,firePower,crewMembers);
    }


}
