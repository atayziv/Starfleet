package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.*;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<String> navySpacecraft=new ArrayList<>();
		List<Spaceship> spaceships=new ArrayList<>();
		for(Spaceship ss : fleet){
			spaceships.add(ss);
		}
		Collections.sort(spaceships,new SpaceshipComparator());
		for(Spaceship sp : spaceships){
			navySpacecraft.add(sp.toString());
		}
		return navySpacecraft;
	}

	public static class SpaceshipComparator implements Comparator<Spaceship>{
		public int compare(Spaceship s1, Spaceship s2){
			if(s2.getFirePower()== s1.getFirePower()){
				if(s2.getCommissionYear()==s1.getCommissionYear())
				{
					return s1.getName().compareTo(s2.getName());
				}
				return Integer.compare(s2.getCommissionYear(), s1.getCommissionYear());
			}
			return Integer.compare(s2.getFirePower(),s1.getFirePower());
		}
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String,Integer> instanceNum=new HashMap<>();
		for(Spaceship spaceship:fleet){
			if(instanceNum.containsKey(spaceship.getClass().getSimpleName()))
				instanceNum.put(spaceship.getClass().getSimpleName(),instanceNum.get(spaceship.getClass().getSimpleName())+1);
			else
				instanceNum.put(spaceship.getClass().getSimpleName(),1);
		}
		return instanceNum;
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int totalMaintenanceCosts=0;
		for (Spaceship spaceship:fleet) {
			totalMaintenanceCosts += spaceship.getAnnualMaintenanceCost();
		}
		return totalMaintenanceCosts;

	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> weaponsGroup=new HashSet<>();
		List<Weapon> weapons=new ArrayList<>();
		for(Spaceship spaceship:fleet){
			if(spaceship instanceof myAbsBattleShip)
			{
				weapons=((myAbsBattleShip) spaceship).getWeapon();
				for(Weapon weapon:weapons)
				{
					weaponsGroup.add(weapon.getName());
				}
			}
		}
		return weaponsGroup;
	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int numOfCrewMembers=0;
		for(Spaceship spaceship:fleet){
			numOfCrewMembers+=spaceship.getCrewMembers().size();
		}
		return numOfCrewMembers;
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		float averageAge=0;
		int officersNum=0;
		Set<? extends CrewMember> crewMembers=new HashSet<>();
		for(Spaceship spaceship:fleet){
			crewMembers=spaceship.getCrewMembers();
			for (CrewMember member:crewMembers){
				if(member instanceof Officer){
					officersNum++;
					averageAge+=member.getAge();
				}
			}
		}
		return averageAge/officersNum;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer,Spaceship> highestRank=new HashMap<>();
		Set<? extends CrewMember> crewMembers;
		for(Spaceship spaceship:fleet){
			Set<Officer> officerMembers=new HashSet<>();
			crewMembers= spaceship.getCrewMembers();
			for(CrewMember member:crewMembers){
				if(member instanceof Officer){
					officerMembers.add((Officer)member);
				}
			}
			if(officerMembers.size()==0)
				continue;
			highestRank.put(maxRank(officerMembers),spaceship);
			officerMembers.clear();
		}
		return highestRank;
	}


	private static Officer maxRank(Set<Officer> officerMembers){
		Officer off=new Officer("off",5,1,OfficerRank.Ensign);
		for(Officer officer:officerMembers){
			if(officer.getRank().compareTo(off.getRank())>=0)
				off=officer;
		}
		return off;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank,Integer> numberOfRankAppearances=new HashMap<>();
		for(Spaceship spaceship:fleet){
			Set<Officer> officerMembers=new HashSet<>();
			Set<? extends CrewMember> crewMembers=spaceship.getCrewMembers();
			for(CrewMember member:crewMembers){
				if(member instanceof Officer){
					officerMembers.add((Officer)member);
				}
			}
			for(Officer officer:officerMembers){
				if(numberOfRankAppearances.containsKey(officer.getRank()))
					numberOfRankAppearances.put(officer.getRank(),numberOfRankAppearances.get(officer.getRank())+1);
				else
					numberOfRankAppearances.put(officer.getRank(),1);
			}
		}
		List<Map.Entry<OfficerRank,Integer>> result=new ArrayList<>();
		for( Map.Entry<OfficerRank,Integer> set : numberOfRankAppearances.entrySet())
		{
			result.add(set);
		}
		Collections.sort(result,new NrankAppearnceComperator());
		return result;
	}


	public static class NrankAppearnceComperator implements Comparator<Map.Entry<OfficerRank, Integer>>{
		public int compare(Map.Entry<OfficerRank, Integer> obj1 , Map.Entry<OfficerRank, Integer> obj2){
			if(obj1.getValue().compareTo(obj2.getValue())==0)
				return obj1.getKey().compareTo(obj2.getKey());
			else
				return obj1.getValue().compareTo(obj2.getValue());
		}
	}

}

