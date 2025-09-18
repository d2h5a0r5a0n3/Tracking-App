import { environment } from "./environment.prod";

export const API_URLS = {
    BASE_URL: `${environment.BASE_URL}`,

    AUTH: {
        REGISTER: `${environment.BASE_URL}/api/public/auth-service/user/create-account`,
        LOGIN: `${environment.BASE_URL}/api/public/auth-service/user/login`,
        STATUS: `${environment.BASE_URL}/api/private/auth-service/status`,
        WELCOME: `${environment.BASE_URL}/api/private/auth-service/welcome`,
    }
}