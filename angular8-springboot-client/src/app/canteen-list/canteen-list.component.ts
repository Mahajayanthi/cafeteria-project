import { CanteenDetailsComponent } from '../canteen-details/canteen-details.component';
import { Observable } from "rxjs";
import { CanteenService } from "../canteen.service";
import { Canteen } from "../canteen";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-canteen-list",
  templateUrl: "./canteen-list.component.html",
  styleUrls: ["./canteen-list.component.css"]
})
export class CanteenListComponent implements OnInit {
  canteens: Observable<Canteen[]>;
  // canteenService: any;
  canteen: any;//herecanteens nu iruthu thu 

  constructor(private canteenService: CanteenService,private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.canteens = this.canteenService.getCanteensList();
  }

  deleteCanteen(id: number) {
    this.canteenService.deleteCanteen(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  canteenDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateCanteen(id: number){
    this.router.navigate(['update', id]);
  }
}
