import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { HouseComponent } from '../house/house.component';
import { House } from '../house';
import { HouseService } from '../house.service';


@Component({
  selector: 'app-house-list',
  standalone: true,
  templateUrl: './house-list.component.html',
  styleUrls: ['./house-list.component.css'],
  imports: [HouseComponent],  
})
export class HouseListComponent implements OnInit {
  houseList!: House[];
  houseList$!: Observable<House[]>;

  constructor(private houseService: HouseService) {}

  ngOnInit(): void {
    this.houseService.getHouses().subscribe((result) => {
      this.houseList = result;
    });
  }
}
