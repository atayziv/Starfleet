package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Bomber extends myAbsBattleShip{

	private int numberOfTechnicians;
	private int basicAnnualMaintenanceCost;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		this.numberOfTechnicians=numberOfTechnicians;
		this.basicAnnualMaintenanceCost=5000;
	}

	public int getNumberOfTechnicians(){
		return numberOfTechnicians;
	}

	public List<Weapon> getWeapon() {
		return super.getWeapon();
	}

	public int getFirePower(){
		return super.getFirePower();
	}

	public int getAnnualMaintenanceCost(){
		return basicAnnualMaintenanceCost + (int)(super.getAnnualMaintenanceCost() * (1-0.1*getNumberOfTechnicians()));

	}

	public String toString(){
		return super.toString() + "\n\tNumberOfTechnicians=" + getNumberOfTechnicians();
	}

	public boolean equals(Object obj){
		Bomber other= (Bomber) obj;
		boolean result = super.equals(other);
		if(result == true){
			if(this.basicAnnualMaintenanceCost==other.basicAnnualMaintenanceCost && this.numberOfTechnicians==other.numberOfTechnicians)
				return true;
		}
		return false;
	}

	public int hashCode(){
		return Objects.hash(super.hashCode(), basicAnnualMaintenanceCost,numberOfTechnicians);
	}


}
