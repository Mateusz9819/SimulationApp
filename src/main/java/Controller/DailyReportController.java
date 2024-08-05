package Controller;

import Entity.DailyReport;
import Entity.Simulation;
import Repository.DailyReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Service.SimulationService;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class DailyReportController {
    @Autowired
    private DailyReportRepository dailyReportRepository;

    @Autowired
    private SimulationService simulationService;

    @GetMapping("/{simulationId}")
    public List<DailyReport> getReportsBySimulation(@PathVariable Long simulationId) {
        return dailyReportRepository.findBySimulationId(simulationId);
    }

    @PostMapping("/simulate")
    public List<DailyReport> simulate(@RequestBody Simulation simulation) {
        return simulationService.simulate(simulation);
    }
}
