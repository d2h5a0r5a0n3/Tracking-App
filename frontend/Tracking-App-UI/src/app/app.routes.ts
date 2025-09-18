import { Routes } from '@angular/router';
import { LoginComponent } from './feature/auth/component/login/login.component';
import { RegisterComponent } from './feature/auth/component/register/register.component';
import { TestComponent } from './feature/auth/component/test/test.component';

export const routes: Routes = [
    { path: "login", component: LoginComponent },
    { path: "register", component: RegisterComponent },
    { path: "test", component: TestComponent }
];
