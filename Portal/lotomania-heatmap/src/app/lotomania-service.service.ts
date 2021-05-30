import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ISweepstakes } from './models/sweepstakes';

@Injectable({
  providedIn: 'root'
})
export class LotomaniaServiceService {

  constructor(private http: HttpClient) { }

  getSweepstakes(numConcurso:number, qtdConcursos:number){
    return this.http.get<ISweepstakes>("/lotomania/sorteios?qtdConcursos="+qtdConcursos+"&numeroConcurso="+numConcurso)
  }

  getLastDrawNumber(){
    return this.http.get<number>("/lotomania/sorteio/ultimo")
  }
}
