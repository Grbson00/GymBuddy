import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

interface RegistrationData {
  username: string,
  password: string,
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  register = (data: RegistrationData) => {
    return this.http.post<RegistrationData>(`${environment.api}/auth/register`, data);
  }
}
