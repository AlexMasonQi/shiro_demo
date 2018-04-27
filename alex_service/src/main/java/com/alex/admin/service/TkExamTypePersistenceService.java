package com.alex.admin.service;

import com.alex.admin.dao.TkExamTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TkExamTypePersistenceService
{
    @Autowired
    private TkExamTypeDao tkExamTypeDao;
}
