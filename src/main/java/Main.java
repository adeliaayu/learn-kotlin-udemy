import section21.kotlinandjavaoperability.Job;

public class Main {

    public static void main(String[] args) {

        // Accessing Nested Kotlin Objects with Java Code
        Job.JobNames myJobs = Job.JobNames.INSTANCE;

        System.out.println(myJobs.getJob1());
        System.out.println(myJobs.getJob2());
        System.out.println(myJobs.getJob3());
        System.out.println(myJobs.getJob4());

        // Static Values and functions vs Kotlin
        System.out.println(Job.numberOfJobs);
        System.out.println(Job.Companion.maxSalary());
    }
}



