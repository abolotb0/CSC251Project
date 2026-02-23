public class Policy
{
    // Constants
    private static final double BASE_FEE = 600.0;
    private static final double AGE_FEE = 75.0;
    private static final double SMOKER_FEE = 100.0;
    private static final double BMI_THRESHOLD = 35.0;
    private static final double BMI_RATE = 20.0;

    // Fields
    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;

    private static int policyCount = 0;

    public Policy()
    {
        policyNumber = 0;
        providerName = "";
        policyHolder = new PolicyHolder();
        policyCount++;
    }

    // Full constructor
    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder)
    {
        this.policyNumber = policyNumber;
        this.providerName = providerName;

        this.policyHolder = new PolicyHolder(policyHolder);

        policyCount++;
    }

    public int getPolicyNumber()
    {
        return policyNumber;
    }

    public String getProviderName()
    {
        return providerName;
    }

    public PolicyHolder getPolicyHolder()
    {
        return new PolicyHolder(policyHolder);
    }

    public static int getPolicyCount()
    {
        return policyCount;
    }

    public void setPolicyNumber(int policyNumber)
    {
        this.policyNumber = policyNumber;
    }

    public void setProviderName(String providerName)
    {
        this.providerName = providerName;
    }

    // security
    public void setPolicyHolder(PolicyHolder policyHolder)
    {
        this.policyHolder = new PolicyHolder(policyHolder);
    }

    // Calculates policy price
    public double calculatePolicyPrice()
    {
        double price = BASE_FEE;

        if (policyHolder.getAge() > 50)
        {
            price += AGE_FEE;
        }

        if (policyHolder.getSmokingStatus() != null
                && policyHolder.getSmokingStatus().trim().equalsIgnoreCase("smoker"))
        {
            price += SMOKER_FEE;
        }

        double bmi = policyHolder.calculateBMI();
        if (bmi > BMI_THRESHOLD)
        {
            price += (bmi - BMI_THRESHOLD) * BMI_RATE;
        }

        return price;
    }

    @Override
    public String toString()
    {
        return "Policy Number: " + policyNumber + "\n"
             + "Provider Name: " + providerName + "\n"
             + policyHolder.toString() + "\n"
             + "Policy Price: $" + String.format("%.2f", calculatePolicyPrice());
    }
}