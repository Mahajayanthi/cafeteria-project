import { Component, OnInit } from '@angular/core';
import { Canteen } from '../canteen';
import { ActivatedRoute, Router } from '@angular/router';
import { CanteenService } from '../canteen.service';
@Component({
selector: 'app-update-canteen',
templateUrl: './update-canteen.component.html',
styleUrls: ['./update-canteen.component.css']
})
export class UpdateCanteenComponent implements OnInit {
id: number;
canteen: Canteen;
constructor(private route: ActivatedRoute,private router: Router,
private canteenService: CanteenService) { }
ngOnInit() {
this.canteen = new Canteen();
this.id = this.route.snapshot.params['id'];

this.canteenService.getCanteen(this.id)
.subscribe(data => {
console.log(data)
this.canteen = data;
},error => console.log(error));
}
updateCanteen() {
this.canteenService.updateCanteen(this.id, this.canteen)
.subscribe(data => {
console.log(data);
this.canteen= new Canteen();
this.gotoList();
}, error => console.log(error));
}
onSubmit() {
this.updateCanteen();
}
gotoList() {
this.router.navigate(['/canteens']);
}
}