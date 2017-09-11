package com.github.vverrier.jackpotapi.penalty;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * @author vverrier
 */
@org.springframework.stereotype.Repository
public interface PenaltyRepository extends Repository<Penalty, String> {

    Penalty save(Penalty penalty);

    Penalty findById(Long id);
}
