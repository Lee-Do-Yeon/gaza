package com.idle.gaza.db.repository;

import com.idle.gaza.db.entity.GuideDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideDocumentRepository extends JpaRepository<GuideDocument, Integer> {

}
