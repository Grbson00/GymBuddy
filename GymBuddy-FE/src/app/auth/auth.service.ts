import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, from } from 'rxjs';
import { environment } from 'src/environments/environment';

interface RegistrationData {
  email: string,
  password: string,
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  register = (data: RegistrationData): Observable<any> => {
    return from(this.http.post<RegistrationData>(`${environment.api}/auth/register`, data))
  }
}
