import java.util.Scanner;
public class Policy {
    // Constants
    private static final double BASE_FEE = 600.0;
    private static final double AGE_FEE = 75.0;
    private static final double SMOKER_FEE = 100.0;
    private static final double BMI_FACTOR = 703.0;
    private static final double BMI_THRESHOLD = 35.0;
    private static final double BMI_RATE = 20.0;

    // Fields
    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String smokingStatus;      // "smoker" or "non-smoker"
    private double policyholderHeight; // inches
    private double policyholderWeight; // pounds

    // No arg constructor
    public Policy()
    {
        policyNumber = 0;
        providerName = "";
        policyholderFirstName = "";
        policyholderLastName = "";
        policyholderAge = 0;
        smokingStatus = "non-smoker";
        policyholderHeight = 0.0;
        policyholderWeight = 0.0;
    }

    // Full constructor
    public Policy(int policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double height, double weight)
    {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = firstName;
        this.policyholderLastName = lastName;
        this.policyholderAge = age;
        this.smokingStatus = smokingStatus;
        this.policyholderHeight = height;
        this.policyholderWeight = weight;
    }

    // Getters
    public int getPolicyNumber()
    {
        return policyNumber;
    }

    public String getProviderName()
    {
        return providerName;
    }

    public String getPolicyholderFirstName()
    {
        return policyholderFirstName;
    }

    public String getPolicyholderLastName()
    {
        return policyholderLastName;
    }

    public int getPolicyholderAge()
    {
        return policyholderAge;
    }

    public String getSmokingStatus()
    {
        return smokingStatus;
    }

    public double getPolicyholderHeight()
    {
        return policyholderHeight;
    }

    public double getPolicyholderWeight()
    {
        return policyholderWeight;
    }

    // Setters
    public void setPolicyNumber(int policyNumber)
    {
        this.policyNumber = policyNumber;
    }

    public void setProviderName(String providerName)
    {
        this.providerName = providerName;
    }

    public void setPolicyholderFirstName(String firstName)
    {
        this.policyholderFirstName = firstName;
    }

    public void setPolicyholderLastName(String lastName)
    {
        this.policyholderLastName = lastName;
    }

    public void setPolicyholderAge(int age)
    {
        this.policyholderAge = age;
    }

    public void setSmokingStatus(String smokingStatus)
    {
        this.smokingStatus = smokingStatus;
    }

    public void setPolicyholderHeight(double height)
    {
        this.policyholderHeight = height;
    }

    public void setPolicyholderWeight(double weight)
    {
        this.policyholderWeight = weight;
    }

    // Calculates BMI
    public double calculateBMI()
    {
        if (policyholderHeight <= 0)
        {
            return 0.0;
        }

        return (policyholderWeight * BMI_FACTOR) / (policyholderHeight * policyholderHeight);
    }

    // Calculates policy price
    public double calculatePolicyPrice()
    {
        double price = BASE_FEE;

        if (policyholderAge > 50)
        {
            price += AGE_FEE;
        }

        if (smokingStatus != null && smokingStatus.trim().equalsIgnoreCase("smoker"))
        {
            price += SMOKER_FEE;
        }

        double bmi = calculateBMI();
        if (bmi > BMI_THRESHOLD)
        {
            price += (bmi - BMI_THRESHOLD) * BMI_RATE;
        }

        return price;
    }
}
