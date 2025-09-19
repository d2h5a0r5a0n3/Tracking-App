import { HttpInterceptorFn } from '@angular/common/http';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
    const auth = localStorage.getItem('auth');

    if(auth){
        const basicAuthHeader=`Basic ${auth}`; 

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
