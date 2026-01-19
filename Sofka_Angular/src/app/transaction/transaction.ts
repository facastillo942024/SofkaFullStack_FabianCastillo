import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

// Angular Material
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-transaction',
  standalone: true, // ✅ CLAVE
  templateUrl: './transaction.html',
  styleUrls: ['./transaction.css'], // ✅ plural
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatCardModule,
    MatFormFieldModule, 
    MatInputModule, 
    MatSelectModule, 
    MatButtonModule,
    MatTableModule
  ]
})
export class Transaction implements OnInit {

  transactionForm!: FormGroup;
  transactions: TransactionDto[] = [];
  displayedColumns: string[] = ['id', 'amount', 'commission', 'date'];

  readonly API_URL = 'http://localhost:8080/api/commissions';

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.initForm();
    this.loadDashboard();
  }

  private initForm(): void {
    this.transactionForm = this.fb.group({
      amount: [null, [Validators.required, Validators.min(1)]],
      type: ['BASE', Validators.required]
    });
  }

  loadDashboard(): void {
    this.http.get<TransactionDto[]>(this.API_URL)
      .subscribe({
        next: data => {
          this.transactions = data;
          this.cdr.detectChanges(); //Forzar la actualización de la tabla de forma segura
        },
        error: err => console.error('Error cargando transacciones', err)
      });
  }

  onSubmit(): void {
    if (this.transactionForm.invalid) return;

    this.http.post(`${this.API_URL}/process`, this.transactionForm.value)
      .subscribe({
        next: () => {
          this.loadDashboard();
          this.transactionForm.reset({ type: 'BASE' });
        },
        error: err => console.error('Error procesando transacción', err)
      });
  }
}

/**
 * DTO tipado (buena práctica)
 */
interface TransactionDto {
  id: number;
  amount: number;
  commission: number;
  transactionDate: string;
}
