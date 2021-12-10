package tum.seba.mobilityservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tum.seba.mobilityservices.entity.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {

}
