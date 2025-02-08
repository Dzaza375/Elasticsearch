package com.example.elasticsearch_task.repo;

import com.example.elasticsearch_task.entity.Documentik;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentikRepo extends ElasticsearchRepository<Documentik, String> {
}
