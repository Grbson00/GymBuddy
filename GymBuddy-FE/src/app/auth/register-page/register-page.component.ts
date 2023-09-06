import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private service: AuthService) { }

  registrationForm!: FormGroup;

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
      console.log(this.registrationForm.value);
      this.service.register(
        {
          username: this.registrationForm.get('username')?.value,
          password: this.registrationForm.get('password')?.value
        }).subscribe((response) => {
          console.log(response);
        },
          (err) => {
            console.log(err);

          }
        )
    }
  }

}
