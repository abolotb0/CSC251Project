public class PolicyHolder
{
   private String firstName;
   private String lastName;
   private int age;
   private String smokingStatus; // "smoker" or "non-smoker"
   private double height; // inches
   private double weight; // pounds

   public PolicyHolder()
   {
      firstName = "";
      lastName = "";
      age = 0;
      smokingStatus = "";
      height = 0.0;
      weight = 0.0;
   }

   public PolicyHolder(String firstName, String lastName, int age, String smokingStatus,
                       double height, double weight)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
      this.smokingStatus = smokingStatus;
      this.height = height;
      this.weight = weight;
   }

   // Copy constructor (security)
   public PolicyHolder(PolicyHolder other)
   {
      this.firstName = other.firstName;
      this.lastName = other.lastName;
      this.age = other.age;
      this.smokingStatus = other.smokingStatus;
      this.height = other.height;
      this.weight = other.weight;
   }

   // Getters
   public String getFirstName() { return firstName; }
   public String getLastName() { return lastName; }
   public int getAge() { return age; }
   public String getSmokingStatus() { return smokingStatus; }
   public double getHeight() { return height; }
   public double getWeight() { return weight; }

   // Setters
   public void setFirstName(String firstName) { this.firstName = firstName; }
   public void setLastName(String lastName) { this.lastName = lastName; }
   public void setAge(int age) { this.age = age; }
   public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }
   public void setHeight(double height) { this.height = height; }
   public void setWeight(double weight) { this.weight = weight; }

   public double calculateBMI()
   {
      if (height <= 0) return 0.0;
      return (weight * 703) / (height * height);
   }

   @Override
   public String toString()
{
    return "Policyholder's First Name: " + firstName + "\n"
         + "Policyholder's Last Name: " + lastName + "\n"
         + "Policyholder's Age: " + age + "\n"
         + "Policyholder's Smoking Status (Y/N): " + smokingStatus + "\n"
         + "Policyholder's Height: " + String.format("%.1f", height) + " inches\n"
         + "Policyholder's Weight: " + String.format("%.1f", weight) + " pounds\n"
         + "Policyholder's BMI: " + String.format("%.2f", calculateBMI());
   }
}