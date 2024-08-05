package Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Simulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int population;
    private int initialInfected;
    private double infectionRate;
    private double mortalityRate;
    private int recoveryTime;
    private int deathTime;
    private int simulationDays;

    @OneToMany(mappedBy = "simulation", cascade = CascadeType.ALL)
    private List<DailyReport> dailyReports;

    // Gettery i settery

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getInitialInfected() {
        return initialInfected;
    }

    public void setInitialInfected(int initialInfected) {
        this.initialInfected = initialInfected;
    }

    public double getInfectionRate() {
        return infectionRate;
    }

    public void setInfectionRate(double infectionRate) {
        this.infectionRate = infectionRate;
    }

    public double getMortalityRate() {
        return mortalityRate;
    }

    public void setMortalityRate(double mortalityRate) {
        this.mortalityRate = mortalityRate;
    }

    public int getRecoveryTime() {
        return recoveryTime;
    }

    public void setRecoveryTime(int recoveryTime) {
        this.recoveryTime = recoveryTime;
    }

    public int getDeathTime() {
        return deathTime;
    }

    public void setDeathTime(int deathTime) {
        this.deathTime = deathTime;
    }

    public int getSimulationDays() {
        return simulationDays;
    }

    public void setSimulationDays(int simulationDays) {
        this.simulationDays = simulationDays;
    }

    public List<DailyReport> getDailyReports() {
        return dailyReports;
    }

    public void setDailyReports(List<DailyReport> dailyReports) {
        this.dailyReports = dailyReports;
    }
}
