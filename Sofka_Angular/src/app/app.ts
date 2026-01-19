
import { Transaction } from './transaction/transaction';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', component: Transaction }, // Esto lo carga al iniciar
  { path: '**', redirectTo: '' } // Opcional: redirige cualquier error al inicio
];
