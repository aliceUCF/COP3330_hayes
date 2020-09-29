public class BodyMassIndex {
    double height, weight;
    public BodyMassIndex(double givenHeight, double givenWeight){
        this.height = givenHeight;
        this.weight = givenWeight;
    }

    public double calculateBmiScore(double givenHeight, double givenWeight){
        double bmiScore = (703 * (givenWeight)) / (givenHeight*givenHeight);
        bmiScore = Math.round(bmiScore * 10) / 10.0;
        return bmiScore;
    }

    public String calculateBmiCategory(double givenHeight, double givenWeight)
    {
        String category = "None";
        double bmiScore = calculateBmiScore(givenHeight, givenWeight);
        if(bmiScore > 0 && bmiScore < 18.5)
        {
            category = "Underweight";
        }
        else if(bmiScore >= 18.5 && bmiScore < 25)
        {
            category = "Normal weight";
        }
        else if(bmiScore >= 25 && bmiScore < 30)
        {
            category = "Overweight";
        }
        else if(bmiScore >= 30)
        {
            category = "Obesity";
        }

        return category;
    }

}
