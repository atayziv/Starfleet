package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.Collections;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter {

	private static int counter;


	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		counter++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		super(name,commissionYear,maximalSpeed,crewMembers, Collections.singletonList(new Weapon("Laser Cannons",10,100)));
		counter++;
	}

	public static int getNumOfInstances() {
		return counter;
	}

	public int getAnnualMaintenanceCost(){
		return super.getAnnualMaintenanceCost() + counter*50;
	}

	public String toString(){
		return super.toString();
	}

	
}
