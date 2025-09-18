import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { RegisterComponent } from "./feature/auth/component/register/register.component";
import { LoginComponent } from "./feature/auth/component/login/login.component";
import { ErrorComponent } from "./error/error/error.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RegisterComponent, LoginComponent, ErrorComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Tracking-App-UI';
}
