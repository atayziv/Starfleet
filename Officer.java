package il.ac.tau.cs.sw1.ex9.starfleet;

public class Officer extends CrewWoman {
	private OfficerRank rank;
		
	public Officer(String name, int age, int yearsInService, OfficerRank rank) {
		super(age,yearsInService,name);
		this.rank=rank;
	}

	public OfficerRank getRank() {
		return rank;
	}

	public String toString() {
		return super.toString() + "\t 	Rank=" + rank;
	}

	public boolean equals(Object obj){
		Officer other =(Officer) obj;
		boolean eq=super.equals(other);
		if(eq==true){
			if(this.rank==other.rank)
				return true;
		}
		return false;
	}

	public int hashCode(){
		final int prime=31;
		int result=1;
		result=super.hashCode();
		result = prime*result + rank.hashCode();
		return result;
	}

}


