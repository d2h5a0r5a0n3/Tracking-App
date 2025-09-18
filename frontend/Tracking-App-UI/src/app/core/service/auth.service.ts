import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, of } from 'rxjs';
import { API_URLS } from '../../../environment/api-urls';
import { LoginRequest } from '../../feature/auth/model/login-request';
import { RegisterRequest } from '../../feature/auth/model/register-request';
import { FormGroup } from '@angular/forms';
import { ErrorResponse } from '../../error/error/model/error-response';
import { Status } from '../../feature/auth/model/Status';

@Injectable({
    providedIn: 'root'
})
export class AuthService {

    constructor(
        private http: HttpClient,
    ) { }

    login(request: LoginRequest): Observable<any> {
        return this.http.post(API_URLS.AUTH.LOGIN, request);
    }
    register(request: FormGroup): Observable<any> {
        return this.http.post(API_URLS.AUTH.REGISTER, request);
    }
    status(): Observable<Status | ErrorResponse> {
        return this.http.get<Status>(API_URLS.AUTH.STATUS).pipe(
            catchError(err => {
                const errorResponse: ErrorResponse = err.error ?? {
                    path: '',
                    message: 'Unknown error',
                    error: 'Unknown',
                    status: err.status ?? 500
                };
                return of(errorResponse);
            })
        );
    }
    welcome(): Observable<{ message: string } | ErrorResponse> {
        return this.http.get<{ message: string }>(API_URLS.AUTH.WELCOME).pipe(
            catchError(err => {
                const errorResponse: ErrorResponse = err.error ?? {
                    path: '',
                    message: 'Unknown error',
                    error: 'Unknown',
                    status: err.status ?? 500
                }
                return of(errorResponse);
            })
        );
    }
}
