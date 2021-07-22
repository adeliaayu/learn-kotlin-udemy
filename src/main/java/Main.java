import section21.kotlinandjavaoperability.Job;

public class Main {

    public static void main(String[] args) {

        // Accessing Nested Kotlin Objects with Java Code
        Job2.JobNames myJobs = Job2.JobNames.INSTANCE;

        System.out.println(myJobs.getJob1());
        System.out.println(myJobs.getJob2());
        System.out.println(myJobs.getJob3());
        System.out.println(myJobs.getJob4());

        // Static Values and functions vs Kotlin
        System.out.println(Job2.numberOfJobs);
        System.out.println(Job2.Companion.maxSalary());
    }
}



