import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../../../core/service/auth.service';
import { LoginRequest } from '../../model/login-request';
import { FormsModule } from '@angular/forms';

@Component({
    selector: 'app-login',
    standalone: true,
    imports: [FormsModule],
    templateUrl: './login.component.html',
    styleUrl: './login.component.scss'
})
export class LoginComponent {
    constructor(private service: AuthService) { }
    formData: LoginRequest = {
        username: '',
        password: ''
    }
    onSubmit() {
        this.service.login(this.formData).subscribe(
            (next) => {
                localStorage.setItem('username', this.formData.username);
                localStorage.setItem('password', this.formData.password);
                console.log(next);
            },
            (err) => {
                console.error(err);
            }
        );
    }
}
