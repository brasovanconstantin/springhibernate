package org.packt.spring.chapter6.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.packt.spring.chapter6.hibernate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		Session session = getSession();
		// String hql = "FROM Employee";
		// String hql = "FROM Employee E WHERE E.firstName = 'RAVI'";
		// String hql = "FROM Employee E ORDER BY E.firstName DESC ";
		// String hql = "FROM Employee E ORDER BY E.firstName DESC, E.id DESC";
		// List<Employee> emList = session.createQuery(hql).list();
		// return emList;

		Criteria criteria = session.createCriteria(Employee.class);
		// retrieve all the records whose salary is equal to 5000
		// criteria.add(Restrictions.eq("salary", 5000));

		// retrieve all the records whose id is bigger than 5
		// criteria.add(Restrictions.gt("id", 5));

		// retrieve all the records whose id is less than 5
		// criteria.add(Restrictions.lt("id", 5));

		// retrieve all the records whose firstName property is like
		// "Constantin"
		// criteria.add(Restrictions.like("firstName", "Constantin"));

		// retrieve all the records whose salary is between 2000 and 40000
		// criteria.add(Restrictions.between("salary", 2000, 4000));

		// retrieve all the records whose salary isNull
		// criteria.add(Restrictions.isNull("salary"));

		// retrieve all the records whose salary isNotNull
		// criteria.add(Restrictions.isNotNull("salary"));

		// retrieve all the records whose salary is equal to 3000 AND firstName
		// is like Constantin
		// Criterion salary = Restrictions.eq("salary", 3000);
		// Criterion firstName = Restrictions.eq("firstName", "Constantin");
		// LogicalExpression andExp = Restrictions.and(salary, firstName);
		// criteria.add(andExp);

		// retrieve all the records whose job_title is like author OR lastName
		// is like Brasovan
		// Criterion jobTitle = Restrictions.eq("jobTitle", "AUTHOR");
		// Criterion lastName = Restrictions.like("lastName", "Brasovan");
		// LogicalExpression orExp = Restrictions.or(jobTitle, lastName);
		// criteria.add(orExp);
		
		// retrieve all the records from the first 2 rows
		// criteria.setFirstResult(0);
		// criteria.setMaxResults(2);
		
		// retrieve all the records ordered by id in descendent order
		criteria.addOrder(Order.desc("id"));

		List<Employee> emList = criteria.list();
		return emList;
	}

	public void insertEmployee(Employee employee) {
		Session session = getSession();
		session.save(employee);
	}

}
