import { Component, OnInit } from '@angular/core';
import { LotomaniaServiceService } from '../lotomania-service.service';

@Component({
  selector: 'app-search-lottery-sweepstakes',
  templateUrl: './search-lottery-sweepstakes.component.html',
  styleUrls: ['./search-lottery-sweepstakes.component.css']
})
export class SearchLotterySweepstakesComponent implements OnInit {
  lotteryNumber: number;
  lotteryQtd: number;

  constructor(private lotomaniService: LotomaniaServiceService) { }

  ngOnInit(): void {
  }

  search(){
    this.lotomaniService.getSweepstakes(this.lotteryNumber, this.lotteryQtd).subscribe((result) => {
      console.log(result)
    })
  }

}
