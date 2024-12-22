import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { HouseListComponent } from './house-list/house-list.component';
import { DeviceListComponent } from './device-list/device-list.component';
import { DeviceFormComponent } from './device-form/device-form.component';
import { MessageListComponent } from './message-list/message-list.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'houses', component: HouseListComponent },
    { path: 'devices', component: DeviceListComponent },
    { path: 'device/add', component: DeviceFormComponent },
    { path: 'messages', component: MessageListComponent },
    { path: '**', redirectTo: '' }
];
