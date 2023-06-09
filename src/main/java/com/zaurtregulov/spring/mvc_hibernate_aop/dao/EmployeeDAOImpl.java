package com.zaurtregulov.spring.mvc_hibernate_aop.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
//        List<Employee> allEmployees = session.createQuery("from Employee "
//                        , Employee.class).getResultList();

        Query<Employee> query = session.createQuery("from Employee "
                , Employee.class);
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }
}
