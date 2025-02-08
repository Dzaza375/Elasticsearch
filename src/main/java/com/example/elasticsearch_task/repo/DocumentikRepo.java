package com.example.elasticsearch_task.repo;

import com.example.elasticsearch_task.entity.Documentik;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentikRepo extends ElasticsearchRepository<Documentik, String> {
    List<Documentik> findByTextContainingIgnoreCase(String query);
}
