package com.lnt.homeloan.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.lnt.homeloan.model.Documents;
import com.lnt.homeloan.model.Loan;
import com.lnt.homeloan.model.User;

@Repository
public class DocDaoImpl implements DocDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public String savePan(MultipartFile aFile, int id) {
		
			try {

				User u = entityManager.find(User.class, id);

				List<Integer> uid = entityManager.createQuery("SELECT l.document_id FROM Documents l WHERE l.users= :userid").setParameter("userid", u).getResultList();

				if (uid.size() == 0) {
					Documents doc = new Documents();
					entityManager.getTransaction().begin();
					doc.setUsers(u);
					List<String> appid = entityManager.createQuery("SELECT l.applicationid FROM Loan l WHERE l.userid= :userid").setParameter("userid", u).getResultList();
					doc.setApplicationid(entityManager.find(Loan.class, appid.get(0)));
					doc.setPancard(aFile.getBytes());
					entityManager.persist(doc);
					entityManager.getTransaction().commit();
				} else {
					entityManager.getTransaction().begin();
					Documents doc = entityManager.find(Documents.class, uid.get(0));
					doc.setPancard(aFile.getBytes());
					entityManager.merge(doc);
					entityManager.getTransaction().commit();
				}
				
				return "saved";

			} catch (Exception e) {
				e.printStackTrace();
				entityManager.getTransaction().rollback();
				return "notsaved";
			}

		

	}

	@Override
	public String saveVoter(MultipartFile aFile, int id) {
		try {

			User u = entityManager.find(User.class, id);

			List<Integer> uid = entityManager.createQuery("SELECT l.document_id FROM Documents l WHERE l.users= :userid").setParameter("userid", u).getResultList();

			if (uid.size() == 0) {
				Documents doc = new Documents();
				entityManager.getTransaction().begin();
				doc.setUsers(u);
				List<String> appid = entityManager.createQuery("SELECT l.applicationid FROM Loan l WHERE l.userid= :userid").setParameter("userid", u).getResultList();
				doc.setApplicationid(entityManager.find(Loan.class, appid.get(0)));
				doc.setVoterId(aFile.getBytes());
				entityManager.persist(doc);
				entityManager.getTransaction().commit();
			} else {
				entityManager.getTransaction().begin();
				Documents doc = entityManager.find(Documents.class, uid.get(0));
				doc.setVoterId(aFile.getBytes());
				entityManager.merge(doc);
				entityManager.getTransaction().commit();
			}
			
			return "saved";

		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return "notsaved";
		}
	}

	@Override
	public String saveSalarySlip(MultipartFile aFile, int id) {
		try {

			User u = entityManager.find(User.class, id);

			List<Integer> uid = entityManager.createQuery("SELECT l.document_id FROM Documents l WHERE l.users= :userid").setParameter("userid", u).getResultList();

			if (uid.size() == 0) {
				Documents doc = new Documents();
				entityManager.getTransaction().begin();
				doc.setUsers(u);
				List<String> appid = entityManager.createQuery("SELECT l.applicationid FROM Loan l WHERE l.userid= :userid").setParameter("userid", u).getResultList();
				doc.setApplicationid(entityManager.find(Loan.class, appid.get(0)));
				doc.setSalaryslip(aFile.getBytes());
				entityManager.persist(doc);
				entityManager.getTransaction().commit();
			} else {
				entityManager.getTransaction().begin();
				Documents doc = entityManager.find(Documents.class, uid.get(0));
				doc.setSalaryslip(aFile.getBytes());
				entityManager.merge(doc);
				entityManager.getTransaction().commit();
			}
			
			return "saved";

		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return "notsaved";
		}
	}

	@Override
	public String saveLoa(MultipartFile aFile, int id) {
		try {

			User u = entityManager.find(User.class, id);

			List<Integer> uid = entityManager.createQuery("SELECT l.document_id FROM Documents l WHERE l.users= :userid").setParameter("userid", u).getResultList();

			if (uid.size() == 0) {
				Documents doc = new Documents();
				entityManager.getTransaction().begin();
				doc.setUsers(u);
				List<String> appid = entityManager.createQuery("SELECT l.applicationid FROM Loan l WHERE l.userid= :userid").setParameter("userid", u).getResultList();
				doc.setApplicationid(entityManager.find(Loan.class, appid.get(0)));
				doc.setLoa(aFile.getBytes());
				entityManager.persist(doc);
				entityManager.getTransaction().commit();
			} else {
				entityManager.getTransaction().begin();
				Documents doc = entityManager.find(Documents.class, uid.get(0));
				doc.setLoa(aFile.getBytes());
				entityManager.merge(doc);
				entityManager.getTransaction().commit();
			}
			
			return "saved";

		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return "notsaved";
		}
	}

	@Override
	public String saveNoc(MultipartFile aFile, int id) {
		try {

			User u = entityManager.find(User.class, id);

			List<Integer> uid = entityManager.createQuery("SELECT l.document_id FROM Documents l WHERE l.users= :userid").setParameter("userid", u).getResultList();

			if (uid.size() == 0) {
				Documents doc = new Documents();
				entityManager.getTransaction().begin();
				doc.setUsers(u);
				List<String> appid = entityManager.createQuery("SELECT l.applicationid FROM Loan l WHERE l.userid= :userid").setParameter("userid", u).getResultList();
				doc.setApplicationid(entityManager.find(Loan.class, appid.get(0)));
				doc.setNoc(aFile.getBytes());
				entityManager.persist(doc);
				entityManager.getTransaction().commit();
			} else {
				entityManager.getTransaction().begin();
				Documents doc = entityManager.find(Documents.class, uid.get(0));
				doc.setNoc(aFile.getBytes());
				entityManager.merge(doc);
				entityManager.getTransaction().commit();
			}
			
			return "saved";

		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return "notsaved";
		}
	}

	@Override
	public String saveAts(MultipartFile aFile, int id) {
		try {

			User u = entityManager.find(User.class, id);

			List<Integer> uid = entityManager.createQuery("SELECT l.document_id FROM Documents l WHERE l.users= :userid").setParameter("userid", u).getResultList();

			if (uid.size() == 0) {
				Documents doc = new Documents();
				entityManager.getTransaction().begin();
				doc.setUsers(u);
				List<String> appid = entityManager.createQuery("SELECT l.applicationid FROM Loan l WHERE l.userid= :userid").setParameter("userid", u).getResultList();
				doc.setApplicationid(entityManager.find(Loan.class, appid.get(0)));
				doc.setAgreement_To_Sale(aFile.getBytes());
				entityManager.persist(doc);
				entityManager.getTransaction().commit();
			} else {
				entityManager.getTransaction().begin();
				Documents doc = entityManager.find(Documents.class, uid.get(0));
				doc.setAgreement_To_Sale(aFile.getBytes());
				entityManager.merge(doc);
				entityManager.getTransaction().commit();
			}
			
			return "saved";

		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return "notsaved";
		}
	}

}
