import { Component, OnInit } from '@angular/core';
import {LoginService} from "../../services/login.service";

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  credentials= {
    username:'',
    password:'',
    role:'ADMIN'
  }

  constructor(private loginService:LoginService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    //console.log("form is submitted");
    if((this.credentials.username!='' && this.credentials.password!='')&& (this.credentials.username!=null && this.credentials.password!=null)){
      console.log("We have to submit the form to server");
      this.loginService.generateToken(this.credentials).subscribe(
        (response:string)=>{
          console.log(response);
          this.loginService.loginUser(response)
          window.location.href="/adminproduct"
        },
        error => {
          console.log(error);
          return alert("Wrong Input !!");
        }
      )
    }else{
      console.log("Fields are empty !!");
      return alert("Fields are empty !!");
    }
  }

}
