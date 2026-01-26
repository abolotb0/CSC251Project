import java.util.Scanner;

public class PolicyDemo
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the Policy Number: ");
        int policyNum = input.nextInt();
        input.nextLine(); // clear newline

        System.out.print("Please enter the Provider Name: ");
        String providerName = input.nextLine();

        System.out.print("Please enter the Policyholder's First Name: ");
        String firstName = input.nextLine();

        System.out.print("Please enter the Policyholder's Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Please enter the Policyholder's Age: ");
        int age = input.nextInt();
        input.nextLine(); // clear newline

        System.out.print("Please enter the Policyholder's Smoking Status (smoker/non-smoker): ");
        String smokingStatus = input.nextLine();

        System.out.print("Please enter the Policyholder's Height (in inches): ");
        double height = input.nextDouble();

        System.out.print("Please enter the Policyholder's Weight (in pounds): ");
        double weight = input.nextDouble();

        // Create Policy object
        Policy p = new Policy(policyNum, providerName, firstName, lastName, age,
                              smokingStatus, height, weight);

        // Output (match sample style)
        System.out.println();
        System.out.println("Policy Number: " + p.getPolicyNumber());
        System.out.println("Provider Name: " + p.getProviderName());
        System.out.println("Policyholder's First Name: " + p.getPolicyholderFirstName());
        System.out.println("Policyholder's Last Name: " + p.getPolicyholderLastName());
        System.out.println("Policyholder's Age: " + p.getPolicyholderAge());
        System.out.println("Policyholder's Smoking Status: " + p.getSmokingStatus());
        System.out.println("Policyholder's Height: " + String.format("%.1f", p.getPolicyholderHeight()) + " inches");
        System.out.println("Policyholder's Weight: " + String.format("%.1f", p.getPolicyholderWeight()) + " pounds");
        System.out.println("Policyholder's BMI: " + String.format("%.2f", p.calculateBMI()));
        System.out.println("Policy Price: $" + String.format("%.2f", p.calculatePolicyPrice()));

        input.close();
    }
}
