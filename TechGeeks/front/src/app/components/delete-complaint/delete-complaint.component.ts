import { Component, OnInit } from '@angular/core';
import { ComplaintService } from 'src/app/service/complaint.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-delete-complaint',
  templateUrl: './delete-complaint.component.html',
  styleUrls: ['./delete-complaint.component.css']
})
export class DeleteComplaintComponent implements OnInit {
  idComplaint:any;

  constructor(private activatedroute:ActivatedRoute,private s:ComplaintService) { }

  ngOnInit(): void {
    this.idComplaint=this.activatedroute.snapshot.params['idComplaint'],
    this.s.deleteComplaint(this.idComplaint).subscribe();
  }

}
