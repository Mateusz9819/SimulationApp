import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SimulationService } from '../simulation.service';
import { Simulation } from '../simulation';

@Component({
  selector: 'app-simulation-details',
  templateUrl: './simulation-details.component.html',
  styleUrls: ['./simulation-details.component.css']
})
export class SimulationDetailsComponent implements OnInit {
  simulation?: Simulation;

  constructor(
    private simulationService: SimulationService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    this.simulationService.getSimulation(id).subscribe(data => {
      this.simulation = data;
    });
  }
}
