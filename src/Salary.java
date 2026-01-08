package src;

import java.sql.Date;

public class Salary {
    private int id;
    private int employeeId;
    private double amount;
    private Date effectiveDate;

    public Salary(int id, int employeeId, double amount, Date effectiveDate) {
        this.id = id;
        this.employeeId = employeeId;
        this.amount = amount;
        this.effectiveDate = effectiveDate;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public Date getEffectiveDate() { return effectiveDate; }
    public void setEffectiveDate(Date effectiveDate) { this.effectiveDate = effectiveDate; }

    @Override
    public String toString() {
        return "Salary{" + "id=" + id + ", employeeId=" + employeeId + ", amount=" + amount + ", effectiveDate=" + effectiveDate + "}";
    }
}