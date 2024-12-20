import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { DeviceComponent } from '../device/device.component';
import { Device } from '../device';
import { DeviceService } from '../device.service';
import { RouterLink } from '@angular/router';


@Component({
  selector: 'app-device-list',
  standalone: true,
  templateUrl: './device-list.component.html',
  styleUrls: ['./device-list.component.css'],
  imports: [DeviceComponent, RouterLink],  
})
export class DeviceListComponent implements OnInit {
  deviceList!: Device[];
  deviceList$!: Observable<Device[]>;

  constructor(private deviceService: DeviceService) {}

  ngOnInit(): void {
    this.deviceService.getDevices().subscribe((result) => {
      this.deviceList = result;
    });
  }
  
}
