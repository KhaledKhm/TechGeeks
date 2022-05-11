import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-courses',
  templateUrl: './list-courses.component.html',
  styleUrls: ['./list-courses.component.css']
})
export class ListCoursesComponent implements OnInit {

  @Input() l: any;
  constructor() { }

  ngOnInit(): void {
  }

}
