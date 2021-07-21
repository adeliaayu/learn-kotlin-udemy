import section21.kotlinandjavaoperability.FreeFunctionsKt;
import section21.kotlinandjavaoperability.Job;
import section21.kotlinandjavaoperability.PersonExtensions;

public class Person {

    private String name = "";
    private String hobbie = "";
    private Job personJob;
    private int depositMoney;
    private String computerName = "";

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public int getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(int depositMoney) {
        this.depositMoney = depositMoney;
    }

    public Job getPersonJob() {
        return personJob;
    }

    public void setPersonJob(Job personJob) {
        this.personJob = personJob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobbie() {
        return hobbie;
    }

    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }

    @Override
    public String toString() {
        return PersonExtensions.getPersonFullDescription(this) + " - " + FreeFunctionsKt.returnPersonComputerName(this, computerName);
    }
}
