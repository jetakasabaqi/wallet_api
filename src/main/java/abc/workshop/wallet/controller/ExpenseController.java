package abc.workshop.wallet.controller;

import abc.workshop.wallet.dto.ExpenseDTO;
import abc.workshop.wallet.model.Expense;
import abc.workshop.wallet.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> getAll() {
        return expenseService.findAll();
    }

    @GetMapping("/{id}")
    public Expense getById(@PathVariable int id) {
        return expenseService.findById(id);
    }


    @PostMapping
    public Expense create(@RequestBody Expense expense) {
        return expenseService.save(expense);
    }

    @PutMapping
    public Expense update(@RequestBody Expense expense) {
        return expenseService.save(expense);
    }

    @GetMapping("/by_date")
    public List<Expense> findByDate(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
        return expenseService.findByDate(date);
    }

    @GetMapping("/daily_total")
    public double getDailyTotal(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
        return expenseService.getDailyTotal(date);
    }

    @GetMapping("/daily_expenses")
    public List<ExpenseDTO> getDailyExpenses() {
        return expenseService.getDailyExpenses();
    }

    @GetMapping("/maximum_expense")
    public ExpenseDTO getMaximumExpense() {
        return expenseService.getMaximumExpense();
    }
}
