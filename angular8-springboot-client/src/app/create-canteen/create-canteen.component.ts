 //import { CanteenService, CanteenService } from '../canteen.service';
import { Canteen } from '../canteen';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CanteenService } from '../canteen.service';

@Component({
  selector: 'app-create-canteen',
  templateUrl: './create-canteen.component.html',
  styleUrls: ['./create-canteen.component.css']
})
export class CreateCanteenComponent implements OnInit {

  canteen: Canteen = new Canteen();
  submitted = false;
  Canteen: Canteen;

  constructor(private canteenService: CanteenService,
    private router: Router) { }

  ngOnInit() {
  }

  newCanteen(): void {
    this.submitted = false;
    this.canteen = new Canteen();
  }

  save() {
    this.canteenService
    .createCanteen(this.canteen).subscribe(data => {
      console.log(data)
      this.canteen = new Canteen();
      this.gotoList();
    }, 
    error => console.log(error));
  }
  // this.canteenService.getCanteen(this.id)
  //     .subscribe(data => {
  //       console.log(data)
  //       this.canteen = data;
  //     }, error => console.log(error));
      
  // }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/canteens']);
  }
}
