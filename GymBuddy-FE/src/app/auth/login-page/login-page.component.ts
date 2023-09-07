import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  loginForm!: FormGroup;
  constructor(private fb: FormBuilder, private service: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group(
      {
        email: ['', [Validators.required, Validators.minLength(6)]],
        password: ['', [Validators.required, Validators.minLength(6)]],
      }
    )
  }
  onSubmit = () => {
    console.log("submit");
    if (this.loginForm.valid) {
      let dto = {
        email: this.loginForm.get('email')?.value,
        password: this.loginForm.get('password')?.value
      }
      console.log(dto);
    }
  }

}
