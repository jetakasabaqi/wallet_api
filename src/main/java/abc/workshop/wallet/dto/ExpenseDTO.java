package abc.workshop.wallet.dto;

import java.util.Date;

public class ExpenseDTO {
    Date date;
    double price;

    public ExpenseDTO(Date date, double price) {
        this.date = date;
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
