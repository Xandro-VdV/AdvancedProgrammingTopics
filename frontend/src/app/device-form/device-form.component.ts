import { Component } from '@angular/core';
import { DeviceService } from '../device.service';  // Import your DeviceService
import { DevicePost } from '../device';  // Import the Device interface
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-device-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './device-form.component.html',
  styleUrls: ['./device-form.component.css']
})
export class DeviceFormComponent {
  // Device model
  device: DevicePost = { 
    houseId: '', 
    name: '', 
    brand: '', 
    model: '', 
    status: '', 
    active: false 
  };

  // Bearer token input
  bearerToken: string = ''; // Token entered by the user

  isSubmitted: boolean = false;
  errorMessage: string = '';

  constructor(private router: Router, private deviceService: DeviceService) {}

  // Method for form submission (Add)
  onSubmit() {
    this.isSubmitted = true;

    // Validation: Ensure all required fields are filled out
    if (this.device.name && this.device.houseId && this.device.brand && this.device.model && this.device.status !== '') {
      if (this.bearerToken.trim() === '') {
        this.errorMessage = 'Please provide the Bearer Token.';
        return;
      }

      // Call the device service to add the device, passing the bearer token
      this.deviceService.addDevice(this.device, this.bearerToken).subscribe({
        next: (v) => {
          this.router.navigateByUrl("/devices");  // Redirect to the device list or another page
        },
        error: (e) => this.errorMessage = e.message
      });
    } else {
      // If any required field is missing, show an error message
      this.errorMessage = 'Please fill in all required fields.';
    }
  }
}
