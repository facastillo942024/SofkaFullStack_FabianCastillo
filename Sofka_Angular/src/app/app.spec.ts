import { TestBed } from '@angular/core/testing';
import { Transaction } from './transaction/transaction';

describe('App', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Transaction],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(Transaction);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it('should render title', async () => {
    const fixture = TestBed.createComponent(Transaction);
    await fixture.whenStable();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h1')?.textContent).toContain('Hello, Sofka_Angular');
  });
});
