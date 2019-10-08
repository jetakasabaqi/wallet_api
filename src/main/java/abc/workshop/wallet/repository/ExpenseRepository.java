package abc.workshop.wallet.repository;

import abc.workshop.wallet.dto.ExpenseDTO;
import abc.workshop.wallet.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    List<Expense> findAllByDate(Date date);

    @Query("SELECT sum(e.price) as Total FROM Expense e WHERE e.date=:date")
    double getDailyTotal(@Param("date") Date date);

    @Query(" SELECT new abc.workshop.wallet.dto.ExpenseDTO(e.date, SUM(e.price)) FROM Expense e GROUP BY Date")
    List<ExpenseDTO> getDailyExpenses();
}
