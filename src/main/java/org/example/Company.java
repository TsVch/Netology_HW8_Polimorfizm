package org.example;

import org.example.taxes.TaxSystem;

public class Company {
    String title;
    int debit = 0;
    int credit = 0;
    TaxSystem taxSystem;

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            debit += amount;
        } else if (amount < 0) {
            credit += Math.abs(amount);
        }
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public void payTaxes() {
        int tax = taxSystem.calcTaxFor(debit, credit);
        System.out.printf("Компания %s уплатила налог в размере: %d руб", title, tax);
        debit = 0;
        credit = 0;
    }

    public int applyDeals(Deal[] deals) {

        for (Deal deal : deals) {
            debit += deal.getDebitChange();
            credit += deal.getCreditChange();
        }

        int profitBeforeTax = debit - credit;

        int tax = taxSystem.calcTaxFor(debit, credit);
        System.out.println("Налог: " + tax);

        debit = 0;
        credit = 0;

        return profitBeforeTax;
    }
}
