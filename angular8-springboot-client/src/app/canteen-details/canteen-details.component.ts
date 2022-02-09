import { Canteen } from '../canteen';
import { Component, OnInit, Input } from '@angular/core';
import { CanteenService } from '../canteen.service';
import { CanteenListComponent } from '../canteen-list/canteen-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-canteen-details',
  templateUrl: './Canteen-details.component.html',
  styleUrls: ['./Canteen-details.component.css']
})
export class CanteenDetailsComponent implements OnInit {

  id: number;
  canteen: Canteen;
 //canteenNo: number;

  constructor(private route: ActivatedRoute,private router: Router,
    private canteenService: CanteenService) { }

  ngOnInit() {
    this.canteen = new Canteen();

    this.id = this.route.snapshot.params['canteens'];
    
    this.canteenService.getCanteen(this.id)
      .subscribe(data => {
        console.log(data)
        this.canteen = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['canteens']);
  }
}
