package com.example.listjobsproject.repositories;
import com.example.listjobsproject.models.PageJob;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageJobRepository extends CrudRepository<PageJob,Long> {

    @Override
    List<PageJob> findAll();


}
