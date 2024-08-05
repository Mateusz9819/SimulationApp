package Controller;

import Entity.Simulation;
import Service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/simulations")
public class SimulationController {
    @Autowired
    private SimulationService simulationService;

    @PostMapping
    public Simulation createSimulation(@RequestBody Simulation simulation) {
        Simulation savedSimulation = simulationService.createSimulation(simulation);
        simulationService.simulate(savedSimulation);
        return savedSimulation;
    }

    @GetMapping
    public List<Simulation> getAllSimulations() {
        return simulationService.getAllSimulations();
    }

    @GetMapping("/{id}")
    public Simulation getSimulation(@PathVariable Long id) {
        return simulationService.getSimulation(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSimulation(@PathVariable Long id) {
        simulationService.deleteSimulation(id);
    }
}
