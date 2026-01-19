import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { Transaction } from './app/transaction/transaction';

bootstrapApplication(Transaction, appConfig)
  .catch((err) => console.error(err));
