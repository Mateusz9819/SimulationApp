package Entity;

import jakarta.persistence.*;

@Entity
public class DailyReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int day;
    private int infected;
    private int susceptible;
    private int deceased;
    private int recovered;

    @ManyToOne
    @JoinColumn(name = "simulation_id")
    private Simulation simulation;

    // Gettery i settery

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }

    public int getSusceptible() {
        return susceptible;
    }

    public void setSusceptible(int susceptible) {
        this.susceptible = susceptible;
    }

    public int getDeceased() {
        return deceased;
    }

    public void setDeceased(int deceased) {
        this.deceased = deceased;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }
}
