import { ApplicationConfig, provideBrowserGlobalErrorListeners } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http'; // ✅
import { provideAnimations } from '@angular/platform-browser/animations'; // ✅ Necesario para Material

import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideHttpClient(), // ✅ Esto arregla el Dashboard
    provideRouter(routes),
    provideAnimations()   // ✅ Esto arregla los errores de mat-card
  ]
};