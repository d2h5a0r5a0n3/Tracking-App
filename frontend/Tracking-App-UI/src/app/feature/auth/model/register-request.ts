import { Signal } from "@angular/core";

export interface RegisterRequest {
    id?:Number;
    username:string;
    password:string;
    dateOfBirth:string;
    gender:string;
    phoneNumber:string;
    mail:string;
    firstname:string;
    lastname:string;
    countryCode?:string;
    isActive:boolean;
    isLocked:boolean;
    address:{
        street?:string,
        city?:string,
        state?:string,
        zipCode?:string,
        country?:string
    }
}
