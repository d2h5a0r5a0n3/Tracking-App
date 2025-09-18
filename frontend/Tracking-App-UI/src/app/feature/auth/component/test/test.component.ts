import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../../../core/service/auth.service';
import { Status } from '../../model/Status';
import { ErrorResponse } from '../../../../error/error/model/error-response';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-test',
  standalone: true,
  imports: [NgIf],
  templateUrl: './test.component.html',
  styleUrl: './test.component.scss'
})
export class TestComponent implements OnInit{
    constructor(private service:AuthService){}
    status!:Status | ErrorResponse;
    welcome!:{message:string} | ErrorResponse;
    ngOnInit(): void {
        this.loadStatus();
        this.loadWelcome();
    }
    loadStatus(){
        this.service.status().subscribe(
            res=>{
                this.status=res;
            }
        );
    }

    loadWelcome(){
        this.service.welcome().subscribe(
            (next)=>{
                this.welcome=next;
            }
        )
    }

    isStatus(res:Status | ErrorResponse):res is Status  {
        return typeof res === "object" && res!==null && 'authenticated' in res;
    }

    isError(res:unknown):res is ErrorResponse{
        return typeof res === "object" && res!==null && 'error' in res && 'status' in res;
    }

    isString(res:string | ErrorResponse):res is string{
        return typeof res==='string';
    }
}
