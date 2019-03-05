package DAO;

import entity.PortalUser;
import entity.PortalUser_;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

@Stateless
public class PortalUserDAO {

    @PersistenceContext(unitName = "myUnit")
    private EntityManager entityManager;

    public PortalUser loadUserByUsername(String login) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PortalUser> criteriaQuery = criteriaBuilder.createQuery(PortalUser.class);
        Root<PortalUser> root = criteriaQuery.from(PortalUser.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(PortalUser_.login), login));
        Query query = entityManager.createQuery(criteriaQuery);
        try {
            PortalUser portalUser = (PortalUser) query.getSingleResult();
            return portalUser;
        } catch (NoResultException nre){
            return null;
        }
    }

    public void addUser(PortalUser portalUser) {
        entityManager.persist( portalUser);
    }

    public void updateToken(String username, String token) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<PortalUser> criteriaQuery = criteriaBuilder.createCriteriaUpdate(PortalUser.class);
        Root<PortalUser> root = criteriaQuery.from(PortalUser.class);
        criteriaQuery.set(root.get(PortalUser_.token), token).where(criteriaBuilder.equal(root.get(PortalUser_.login), username));
        entityManager.createQuery(criteriaQuery).executeUpdate();
    }

    public PortalUser loadUserByToken(String accessToken) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PortalUser> criteriaQuery = criteriaBuilder.createQuery(PortalUser.class);
        Root<PortalUser> root = criteriaQuery.from(PortalUser.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(PortalUser_.token), accessToken));
        Query query = entityManager.createQuery(criteriaQuery);
        try {
            PortalUser portalUser = (PortalUser) query.getSingleResult();
            return portalUser;
        } catch (NoResultException nre){
            return null;
        }
    }
}
