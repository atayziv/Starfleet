package il.ac.tau.cs.sw1.ex9.starfleet;

public abstract class myAbsCrewMember implements CrewMember {

    private String name;
    private int age;
    private int yearsInService;



    public myAbsCrewMember( String name,int age, int yearsInService) {
        super();
        this.name = name;
        this.age = age;
        this.yearsInService = yearsInService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public  int getYearsInService() {
        return yearsInService;
    }

    public void setYearsInService(int yearsInService) {
        this.yearsInService = yearsInService;
    }

    public String toString(){
        StringBuilder str=new StringBuilder();
        str.append(getClass().getName());
        str.append("\t  Name=").append(name);
        str.append("\t  Age=").append(age);
        str.append("\t  Years in service=").append(yearsInService);
        return str.toString();
    }

    public boolean equals(Object obj){
        if(this==obj)
            return true;
        if(obj==null)
            return false;
        if(getClass()!=obj.getClass())
            return false;
        myAbsCrewMember other =(myAbsCrewMember) obj;
        if(this.age!=other.age && this.yearsInService!=other.yearsInService)
            return false;
        if(!name.equals(other.name))
            return false;
        return true;
    }

    public int hashCode(){
        final int prime=31;
        int result=1;
        result=prime*result + name.hashCode();
        result=prime*result + age;
        result=prime*result + yearsInService;
        return result;

    }

}
