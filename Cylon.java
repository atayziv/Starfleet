package il.ac.tau.cs.sw1.ex9.starfleet;

public class Cylon extends myAbsCrewMember {

	private int modelNumber;

	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		super(name,age,yearsInService);
		this.modelNumber=modelNumber;
	}

	public int getModelNumber(){
		return modelNumber;
	}

	public String toString() {
		return super.toString() + "\t" + "	" + "Model Number=" + modelNumber;
	}

	public boolean equals(Object obj) {
		Cylon other = (Cylon) obj;
		boolean eq=super.equals(other);
		if(eq==true){
			if(this.modelNumber==other.modelNumber)
				return true;
		}
		return false;
	}

	public int hashCode(){
		final int prime=31;
		int result=1;
		result=super.hashCode();
		result = prime*result + modelNumber;
		return result;
	}


}
