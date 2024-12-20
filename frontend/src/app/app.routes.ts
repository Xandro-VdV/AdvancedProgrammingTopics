import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { HouseListComponent } from './house-list/house-list.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'houses', component: HouseListComponent },
];
