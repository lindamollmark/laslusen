package com.laslusen.laslusen.dao;

import com.laslusen.laslusen.entity.BokEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


@Transactional
public interface BokDao extends JpaRepository<BokEntity, Integer> {



}
