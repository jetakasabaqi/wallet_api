package abc.workshop.wallet.service;

import abc.workshop.wallet.dto.ExpenseDTO;
import abc.workshop.wallet.model.Expense;
import abc.workshop.wallet.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }


    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Expense findById(int id) {
        Optional<Expense> expense = expenseRepository.findById(id);

        return expense.orElse(null);

//        if(expense.isPresent()){
//            return expense.get();
//        }
//        return null;

    }

    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }


    public void deleteById(int id) {
        expenseRepository.deleteById(id);
    }

    public List<Expense> findByDate(Date date) {
        return expenseRepository.findAllByDate(date);
    }

    public double getDailyTotal(Date date) {
        return expenseRepository.getDailyTotal(date);
    }

    public List<ExpenseDTO> getDailyExpenses() {

        return expenseRepository.getDailyExpenses();
    }

    public ExpenseDTO getMaximumExpense() {

        List<ExpenseDTO> expenses = expenseRepository.getDailyExpenses();
        
        return expenses
                .stream()
                .max(Comparator.comparing(ExpenseDTO::getPrice)).get();
    }
}
