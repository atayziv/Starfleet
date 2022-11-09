package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Fighter extends myAbsBattleShip {

	private int basicAnnualMaintenanceCost;
	private int maintainSpacecraftEngineCost;

	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		this.basicAnnualMaintenanceCost=2500;
		this.maintainSpacecraftEngineCost=1000;


	}
	public List<Weapon> getWeapon() {
		return super.getWeapon();
	}

	public int getFirePower(){
		return super.getFirePower();
	}

	public int getAnnualMaintenanceCost(){
		return (int)(basicAnnualMaintenanceCost + getMaximalSpeed()*maintainSpacecraftEngineCost +super.getAnnualMaintenanceCost());
	}

	public String toString(){
		return super.toString();
	}

	public boolean equals(Object obj){
		Fighter other=(Fighter) obj;
		boolean result= super.equals(other);
		if(result == true){
			if(this.basicAnnualMaintenanceCost==other.basicAnnualMaintenanceCost && this.maintainSpacecraftEngineCost== other.maintainSpacecraftEngineCost)
				return true;
		}
		return false;
	}

	public int hashCode(){
		return Objects.hash(super.hashCode(), basicAnnualMaintenanceCost,maintainSpacecraftEngineCost);
	}
	
}
