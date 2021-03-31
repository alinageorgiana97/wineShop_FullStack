package com.ag.WineShop.repository;

import com.ag.WineShop.entity.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:4200")
@Repository
public interface WineRepository extends JpaRepository<Wine, Integer> {
    Wine findEntityById(Integer id);
}
