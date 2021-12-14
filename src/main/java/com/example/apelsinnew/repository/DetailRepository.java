package com.example.apelsinnew.repository;

import com.example.apelsinnew.entity.Category;
import com.example.apelsinnew.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<Detail,Integer> {
}
