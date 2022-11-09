package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;
import java.util.Set;

public class TransportShip extends myAbsSpaceShip{

	private int cargoCapacity;
	private int passengerCapacity;
	private int basicAnnualMaintenanceCost;

	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name,commissionYear,maximalSpeed,crewMembers);
		this.cargoCapacity=cargoCapacity;
		this.passengerCapacity=passengerCapacity;
		this.basicAnnualMaintenanceCost=3000;
	}

	public int getCargoCapacity(){
		return cargoCapacity;
	}

	public int getPassengerCapacity(){
		return passengerCapacity;
	}

	public int getAnnualMaintenanceCost(){
		return basicAnnualMaintenanceCost + 5*cargoCapacity + 3*passengerCapacity;
	}

	public String toString(){
		return super.toString() + "\n\tAnnualMaintenanceCost=" + getAnnualMaintenanceCost() + "\n\tCargoCapacity=" +
				getCargoCapacity() + "\n\tPassengerCapacity=" + getPassengerCapacity();
	}

	public boolean equals(Object obj){
		TransportShip other = (TransportShip) obj;
		boolean result=super.equals(other);
		if(result==true){
			if(this.cargoCapacity== other.cargoCapacity && this.passengerCapacity==other.passengerCapacity && this.basicAnnualMaintenanceCost== other.basicAnnualMaintenanceCost)
				return true;
		}
		return false;
	}

	public int hashCode(){
		return Objects.hash(super.hashCode() , cargoCapacity, passengerCapacity,basicAnnualMaintenanceCost);
	}


}
