import { Component, Input } from '@angular/core';
import { Device } from '../device';

@Component({
  selector: 'app-device',
  standalone: true,
  imports: [],
  templateUrl: './device.component.html',
  styleUrl: './device.component.css'
})
export class DeviceComponent {
  @Input() device!: Device;

  constructor() { }

  ngOnInit(): void {
  }
}
