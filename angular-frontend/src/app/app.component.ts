import { Component } from '@angular/core';
import { CurrentMatchService } from './current-match.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string;

  constructor(private currentMatchService: CurrentMatchService) {}
   
  ngOnInit() {
    this.currentMatchService.loadCurrentMatch().subscribe(data => {
      this.title = data.value;
    });
  }
}
