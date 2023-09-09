import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Subscription } from 'rxjs'
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit, OnDestroy {

  constructor(private formBuilder: FormBuilder, private service: AuthService, private router: Router) { }

  registrationForm!: FormGroup;
  subscription: Subscription = new Subscription();

  ngOnInit(): void {
    this.registrationForm = this.formBuilder.group(
      {
        username: ['', [Validators.required, Validators.minLength(6)]],
        password: ['', [Validators.required, Validators.minLength(6)]],
        confirmPassword: ['', [Validators.required, Validators.minLength(6)]],
      },
      { validator: this.passwordMatchValidator }
    )
  }

  passwordMatchValidator = (formGroup: FormGroup) => {
    const password = formGroup.get('password')?.value
    const confirm = formGroup.get('confirmPassword')?.value

    return password === confirm ? null : { passwordMatch: true }
  }

  onSubmit = () => {
    if (this.registrationForm.valid) {
      let dto = {
        email: this.registrationForm.get('username')?.value,
        password: this.registrationForm.get('password')?.value
      }
      console.log(dto);

      this.subscription = this.service.register(dto).subscribe(
        {
          next: (response: any) => {
            console.log(response);
          },
          error: (err: HttpErrorResponse) => {
            console.error(err.error)
          },
          complete: () => {
            this.router.navigate(['/login'])
          }
        }
      )
    }
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

}
