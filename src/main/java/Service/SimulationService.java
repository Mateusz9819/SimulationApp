package Service;

import Entity.Simulation;
import Entity.DailyReport;
import Repository.SimulationRepository;
import Repository.DailyReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimulationService {

    @Autowired
    private SimulationRepository simulationRepository;

    @Autowired
    private DailyReportRepository dailyReportRepository;

    public Simulation createSimulation(Simulation simulation) {
        return simulationRepository.save(simulation);
    }

    public List<Simulation> getAllSimulations() {
        return simulationRepository.findAll();
    }

    public Simulation getSimulation(Long id) {
        return simulationRepository.findById(id).orElse(null);
    }

    public void deleteSimulation(Long id) {
        simulationRepository.deleteById(id);
    }

    public List<DailyReport> simulate(Simulation simulation) {
        List<DailyReport> reports = new ArrayList<>();
        int susceptible = simulation.getPopulation() - simulation.getInitialInfected();
        int infected = simulation.getInitialInfected();
        int deceased = 0;
        int recovered = 0;

        for (int day = 1; day <= simulation.getSimulationDays(); day++) {
            int newDeceased = (day >= simulation.getDeathTime()) ? (int) (infected * simulation.getMortalityRate()) : 0;
            int newRecovered = (day >= simulation.getRecoveryTime()) ? infected - newDeceased : 0;
            int newInfected = (int) (infected * simulation.getInfectionRate());

            susceptible -= newInfected;
            infected += newInfected - newDeceased - newRecovered;
            deceased += newDeceased;
            recovered += newRecovered;

            DailyReport report = new DailyReport();
            report.setDay(day);
            report.setInfected(infected);
            report.setSusceptible(susceptible);
            report.setDeceased(deceased);
            report.setRecovered(recovered);
            report.setSimulation(simulation);

            reports.add(report);
        }

        dailyReportRepository.saveAll(reports);
        return reports;
    }
}
