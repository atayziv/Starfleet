package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ColonialViper extends Fighter  {

	private int basicAnnualMaintenanceCost;
	private int maintainSpacecraftEngineCost;

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		basicAnnualMaintenanceCost=4000;
		maintainSpacecraftEngineCost=500;
	}

	public int getAnnualMaintenanceCost(){
		return (int)(basicAnnualMaintenanceCost + super.getAnnualCostOfMaintainWeapons(getWeapon()) + getCrewMembers().size()*500 +getMaximalSpeed()*maintainSpacecraftEngineCost);
	}

	public String toString()
	{
		return super.toString();
	}

	public boolean equals(Object obj){
		ColonialViper other= (ColonialViper)obj;
		if(super.equals(other)){
			if(this.maintainSpacecraftEngineCost==other.maintainSpacecraftEngineCost && this.basicAnnualMaintenanceCost==other.basicAnnualMaintenanceCost)
				return true;
		}
		return false;
	}

	public int hashCode(){
		return Objects.hash(super.hashCode(), basicAnnualMaintenanceCost,maintainSpacecraftEngineCost);
	}

}
