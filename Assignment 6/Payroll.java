public class Payroll {

    private double healthInsurance;
    private double bonus;
    private double stockOptions;
    private double pfContribution;
    private double ptoCost;

    public Payroll(double healthInsurance, double bonus, double stockOptions,
                   double pfContribution, double ptoCost) {
        this.healthInsurance = healthInsurance;
        this.bonus = bonus;
        this.stockOptions = stockOptions;
        this.pfContribution = pfContribution;
        this.ptoCost = ptoCost;
    }

    public double totalAdditionalCost() {
        return healthInsurance + bonus + stockOptions + pfContribution + ptoCost;
    }

    public void displayPayrollBreakdown() {
        System.out.println("  -- Payroll Breakdown --");
        System.out.printf("  Health Insurance : Rs. %.2f%n", healthInsurance);
        System.out.printf("  Bonus            : Rs. %.2f%n", bonus);
        System.out.printf("  Stock Options    : Rs. %.2f%n", stockOptions);
        System.out.printf("  PF Contribution  : Rs. %.2f%n", pfContribution);
        System.out.printf("  PTO Cost         : Rs. %.2f%n", ptoCost);
        System.out.printf("  Total Additional : Rs. %.2f%n", totalAdditionalCost());
    }

    // Getters and Setters
    public double getHealthInsurance() { return healthInsurance; }
    public double getBonus() { return bonus; }
    public double getStockOptions() { return stockOptions; }
    public double getPfContribution() { return pfContribution; }
    public double getPtoCost() { return ptoCost; }

    public void setHealthInsurance(double v) { this.healthInsurance = v; }
    public void setBonus(double v) { this.bonus = v; }
    public void setStockOptions(double v) { this.stockOptions = v; }
    public void setPfContribution(double v) { this.pfContribution = v; }
    public void setPtoCost(double v) { this.ptoCost = v; }
}
