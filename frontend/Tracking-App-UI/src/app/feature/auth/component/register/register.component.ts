import { Component } from '@angular/core';
import { AuthService } from '../../../../core/service/auth.service';
import { RegisterRequest } from '../../model/register-request';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
    selector: 'app-register',
    standalone: true,
    imports: [],
    templateUrl: './register.component.html',
    styleUrl: './register.component.scss'
})
export class RegisterComponent {
    formData: FormGroup;
    constructor(
        private service: AuthService,
        private fb: FormBuilder
    ) {
        this.formData = this.fb.group(
            {
                id: [null],
                username: ['', [Validators.required]],
                password: ['', [Validators.required, Validators.minLength(6)]],
                dateOfBirth: ['', [Validators.required]],
                gender: ['', [Validators.required]],
                phoneNumber: ['', [Validators.required, Validators.pattern(/^[0-9]{10}$/)]],
                mail: ['', [Validators.required, Validators.email]],
                firstname: ['', [Validators.required]],
                lastname: ['', [Validators.required]],
                countryCode: [''],

                isActive: [true],
                isLocked: [false],

                address: this.fb.group({
                    street: [''],
                    city: [''],
                    state: [''],
                    zipCode: [''],
                    country: ['']
                })
            }
        )
    }

    onSubmit(): void {
        this.service.register(this.formData).subscribe(
             
        );
    }
}
