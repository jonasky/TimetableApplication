import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent implements OnInit {

  constructor(private router:Router,
    private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
  }

  navigate():void{
    this.router.navigate(['/programs'],{
      relativeTo:this.activatedRoute
    })
  }
}
