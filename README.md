package org.example;

import org.example.taxes.TaxIncome;
import org.example.taxes.TaxIncomeAndExpenses;
import org.example.taxes.TaxSystem;

public class Main {
    public static void main(String[] args) {
        TaxIncome taxIncome = new TaxIncome();
        TaxIncomeAndExpenses taxIncomeAndExpenses = new TaxIncomeAndExpenses();
        Company company = new Company("Ромашка", taxIncome);
        company.shiftMoney(1200000);
        company.shiftMoney(-100000);
        company.shiftMoney(0);
        System.out.println("Расчет налога для УСН6%:");
        company.payTaxes();
        System.out.println();
        company.shiftMoney(1200000);
        company.shiftMoney(-100000);
        company.shiftMoney(0);
        System.out.println("Меняем систему налогообложения на УСН15%:");
        company.setTaxSystem(taxIncomeAndExpenses);
        company.payTaxes();
        System.out.println("\n");
        //Доп. задание
        System.out.println("Доп. задание");
        //Устанавливаем систему налогообложения сначала УСН6%
        System.out.println("Расчет налога для УСН6%:");
        company.setTaxSystem(taxIncome);
        //Создаем сделки
        Deal[] deals = new Deal[]{
                new Sale("Ноутбук", 100000),
                new Expenditure("Офис", 50000),
                new Sale("Телефон", 30000),
        };
        int profit = company.applyDeals(deals);
        System.out.println("Прибыль до налога: " + profit);
        System.out.println("\nРассчет налога для УСН 15%");
        //Меняем налогообложение на УСН 15%
        company.setTaxSystem(taxIncomeAndExpenses);
        profit = company.applyDeals(deals);
        System.out.println("Прибыль до налога: " + profit);
    }
}
