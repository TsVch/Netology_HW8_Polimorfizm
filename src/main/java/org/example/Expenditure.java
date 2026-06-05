package org.example;

public class Expenditure extends Deal {
    //Внутри конструктора класса наследника, мы вызываем конструктор родителя, со значениями адаптированными под Expenditure. Expenditure является чатсным случаем Deal
    public Expenditure(String name, int price) {
        super(
                "Покупка " + name + " на " + price + " руб.",
                price,
                0);
    }

}
