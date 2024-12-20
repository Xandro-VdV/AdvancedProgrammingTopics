import { Component, Input } from '@angular/core';
import { House } from '../house';

@Component({
  selector: 'app-house',
  standalone: true,
  imports: [],
  templateUrl: './house.component.html',
  styleUrl: './house.component.css'
})
export class HouseComponent {
  @Input() house!: House;

  constructor() { }

  ngOnInit(): void {
  }
}
