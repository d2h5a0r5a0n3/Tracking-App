import { HttpInterceptorFn } from '@angular/common/http';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
    const username = localStorage.getItem('username');
    const password = localStorage.getItem('password');

    if(username && password){
        const basicAuthHeader='Basic '+btoa(username+':'+password);

        const authReq=req.clone(
            {
                setHeaders:{
                    Authorization:basicAuthHeader
                }
            }  
        );

        return next(authReq);
    }

    return next(req);
};
