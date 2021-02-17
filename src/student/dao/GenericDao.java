package student.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import student.util.HibernateInit;
/**
 *
 * @author Eli
 * @param <X>
 */
public class GenericDao<X> {
    private final Class<X> type;

    public GenericDao(Class<X> type) {
        this.type = type;
    }
    public String create(X obj){
        Session ss=HibernateInit.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(obj);
        ss.getTransaction().commit();
        ss.close();
        return "Success";
    }
      public String update(X obj){
        Session ss=HibernateInit.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.update(obj);
        ss.getTransaction().commit();
        ss.close();
    return "Updated Successfully!";
}
    public String delete(X obj){
        Session ss=HibernateInit.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(obj);
        ss.getTransaction().commit();
        ss.close();
        return "Deleted Successfully!";
}
    public X findById(Serializable id){
         Session ss=HibernateInit.getSessionFactory().openSession();
         X obj=(X)ss.get(type, id);
         ss.close();
         return obj;
    }
     public List<X> findAll(){
         Session session=HibernateInit.getSessionFactory().openSession();
        Criteria qry=session.createCriteria(type);
        List<X> list = qry.list();
        return list;
    }
private void sampleCodes(){
     
/**
 * My Sample Codes for Additional stufs
 * Session session = null;
     public List<X> findByCategoryId(String bookId) {

        session = HibernateInit.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<X> categories = (List<X>) session.createCriteria(Bookcategory.class).add(Restrictions.eq("categoryid", bookId)).list();
        tx.commit();
        session.close();
        return categories;
    }

    public String getCategoryName(String bookId) {
        String sql = "select categoryName from Bookcategory where categoryID = '" + bookId + "'";
        session = HibernateInit.getSessionFactory().openSession();
        Object name = session.createQuery(sql).uniqueResult();
        session.close();
        return name.toString();
    }

    public String getCategoryId(String name) {
        String sql = "SELECT categoryID FROM bookcategory WHERE categoryName = '" + name + "'";
        session = HibernateInit.getSessionFactory().openSession();
        Object id = session.createQuery(sql);
        session.close();
        return id.toString();
    }

    public List<String> getCategoryNames() {
        session = HibernateInit.getSessionFactory().openSession();
        List<String> names = session.createCriteria(Bookcategory.class).setProjection(Projections.property("categoryName")).list();
        session.close();
        return names;
    }
*/
}
}
