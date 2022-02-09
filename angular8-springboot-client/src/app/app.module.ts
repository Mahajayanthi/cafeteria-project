import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateCanteenComponent } from './create-canteen/create-canteen.component';
import { CanteenDetailsComponent } from './canteen-details/canteen-details.component';
import { CanteenListComponent } from './canteen-list/canteen-list.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateCanteenComponent } from './update-canteen/update-canteen.component';
@NgModule({
  declarations: [
    AppComponent,
    CreateCanteenComponent,
    CanteenDetailsComponent,
    CanteenListComponent,
    UpdateCanteenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
