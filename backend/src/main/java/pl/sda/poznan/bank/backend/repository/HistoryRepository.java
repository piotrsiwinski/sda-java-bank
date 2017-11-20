package pl.sda.poznan.bank.backend.repository;

import bank.labs.model.History;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistoryRepository extends CrudRepository<History,Long> {
    List<History> findByClientId(long id);
}
