package pl.sda.poznan.bank.backend.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.poznan.bank.backend.model.History;
import pl.sda.poznan.bank.backend.model.User;

public interface HistoryRepository extends CrudRepository<History, Long> {
    History findById(Long id);
    History findByUser(User user);
}
