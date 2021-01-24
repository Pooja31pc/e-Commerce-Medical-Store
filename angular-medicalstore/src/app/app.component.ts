import { Component } from '@angular/core';
import {Product} from "./common/product";
import {LoginService} from "./services/login.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  public loggedIn=false;
  // products: Product
  constructor(private loginService:LoginService) {
  }

  ngOnInit(): void{
    this.loggedIn=this.loginService.isLoogedIn()
  }

  logoutUser()
  {
    this.loginService.logout()
    location.reload()
  }

}
