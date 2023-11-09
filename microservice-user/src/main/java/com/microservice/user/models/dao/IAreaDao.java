package com.microservice.user.models.dao;

import com.microservice.user.models.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAreaDao extends JpaRepository<Area,Long> {
}
