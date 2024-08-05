import { Component, OnInit } from '@angular/core';
import { SimulationService } from '../simulation.service';
import { Simulation } from '../simulation';

@Component({
  selector: 'app-simulation-list',
  templateUrl: './simulation-list.component.html',
  styleUrls: ['./simulation-list.component.css']
})
export class SimulationListComponent implements OnInit {
  simulations: Simulation[] = [];

  constructor(private simulationService: SimulationService) { }

  ngOnInit(): void {
    this.simulationService.getSimulations().subscribe(data => {
      this.simulations = data;
    });
  }
}
