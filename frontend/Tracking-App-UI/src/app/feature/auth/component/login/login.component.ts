import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../../../core/service/auth.service';
import { LoginRequest } from '../../model/login-request';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { COMPONENT_URL } from '../../../../common/urls/UrlComponent';

@Component({
    selector: 'app-login',
    standalone: true,
    imports: [FormsModule],
    templateUrl: './login.component.html',
    styleUrl: './login.component.scss'
})
export class LoginComponent {
    constructor(
        private service: AuthService,
        private router:Router
    ) { }
    formData: LoginRequest = {
        username: '',
        password: ''
    }
    onSubmit() {
        this.service.login(this.formData).subscribe(
            (next) => {
                const authString=btoa(`${this.formData.username}:${this.formData.password}`);
                localStorage.setItem('auth', authString);
                console.log(next);
                this.router.navigate([COMPONENT_URL.TEST]);
            },
            (err) => {
                console.error(err);
            }
        );
    }
    gotoRegisterPage():void{
        this.router.navigate([COMPONENT_URL.REGISTER]);
    }
}
