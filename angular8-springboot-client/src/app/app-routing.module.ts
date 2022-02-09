import { CanteenDetailsComponent } from './canteen-details/canteen-details.component';
import { CreateCanteenComponent } from './create-canteen/create-canteen.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CanteenListComponent } from './canteen-list/canteen-list.component';
import { UpdateCanteenComponent } from './update-canteen/update-canteen.component';

const routes: Routes = [
  { path: '', redirectTo: 'canteen', pathMatch: 'full' },
  { path: 'canteens', component: CanteenListComponent },
  { path: 'add', component: CreateCanteenComponent },
  { path: 'update/:id', component: UpdateCanteenComponent },
  { path: 'details/:canteens', component: CanteenDetailsComponent },
  
  // { path: '', redirectTo: 'canteen', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
