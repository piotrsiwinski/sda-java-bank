package pl.sda.poznan.bank.backend.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.poznan.bank.backend.model.History;

public interface HistoryRepository extends CrudRepository<History, Long> {

}
