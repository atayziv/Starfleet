package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CylonRaider extends Fighter {

	private int basicAnnualMaintenanceCost;
	private int maintainSpacecraftEngineCost;

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		basicAnnualMaintenanceCost=3500;
		maintainSpacecraftEngineCost=1200;

	}

	public int getAnnualMaintenanceCost(){
		return (int)(basicAnnualMaintenanceCost+ super.getAnnualCostOfMaintainWeapons(getWeapon()) + 500*getCrewMembers().size() + getMaximalSpeed()*maintainSpacecraftEngineCost);
	}

	public String toString(){
		return super.toString();
	}

	public boolean equals(Object obj){

		CylonRaider other=(CylonRaider)obj;
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
