public class Flower{
    public int noOfPetals;
    public String species;
    public boolean fragrance;
    public String color;
    public boolean edible;
    public String name;

    public boolean bloom(String season, String name)
    {
        if ("Summer".equals(season) && "Rose".equals(name))
        {
            System.out.println("Right season for me to bloom!");
            return true;
        }
        else if (!"Summer".equals(season) || !"Lily".equals(name))
        {
            if ("Winter".equals(season) && "Rose".equals(name))
            {
                System.out.println("I can't bloom in winter.");
                return false;
            }
        }
        else {
            System.out.println("I can't bloom in summer.");
            return false;
        }
        return false;
    }
    public void pollinate()
    {
        System.out.println("This is the season for pollination!");
    }
    public static void printFlowerDetails(Flower f)
    {
        System.out.println("Flower name : " + f.name);
        System.out.println("Flower color : " + f.color);
        System.out.println("Flower species : " + f.species);
        System.out.println("Flower edible or not? : " + f.edible);
        System.out.println("Flower number of petals : " + f.noOfPetals);
        System.out.println("Flower fragrant or not? : " + f.fragrance);

    }
    public static void main(String[] args) {
        Flower f1 = new Flower();
        f1.name = "Jasmin";
        f1.color = "White";
        f1.noOfPetals = 5;
        f1.fragrance = true;
        f1.edible = false;
        f1.species = "Jasminum";
        boolean isBloomed = f1.bloom("Summer", f1.name);
        System.out.println("Is flower bloomed? " + isBloomed);
        f1.pollinate();
        printFlowerDetails(f1);
        
    }
}