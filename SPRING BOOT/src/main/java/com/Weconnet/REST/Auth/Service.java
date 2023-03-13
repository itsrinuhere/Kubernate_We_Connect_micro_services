package com.Weconnet.REST.Auth;

import com.Weconnet.REST.Logg;
import org.apache.coyote.Response;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.List;

public class Service {
    Transaction transaction = null;
    Session session = null;
   protected ResponseEntity saveUser(User user){

       try {
           session = AuthUtil.getsessionfactory().openSession();
           transaction = session.beginTransaction();
           session.persist(user);
           transaction.commit();
           // if(transaction != null )transaction.rollback();
           if (session != null) session.close();
           Logg.log("success");
           return new ResponseEntity(HttpStatus.OK);
       }//catch(HibernateException e){
          // return new ResponseEntity("hibernateException",HttpStatus.BAD_REQUEST);
       //}
       catch(ConstraintViolationException e){
           return new ResponseEntity(e.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
       }
       //catch(Exception e){
          // Logg.log(e.toString());
           //return n
       //}
    }
    ResponseEntity<User> getAlluser(){
       session = AuthUtil.getsessionfactory().openSession();
       transaction = session.beginTransaction();
       Query<User> query = session.createQuery("FROM com.Weconnet.REST.Auth.User",User.class);
        return (query!=null)? new ResponseEntity(query.list(),HttpStatus.OK):new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    protected ResponseEntity verify(User user){
        List<User> data = null;
        try{
            session  = AuthUtil.getsessionfactory().openSession();
            transaction = session.beginTransaction();
            Query<User> query = session.createQuery("FROM com.Weconnet.REST.Auth.User object WHERE object.username = : username AND object.password = : password",User.class);
            query.setParameter("username",user.getUsername());
            query.setParameter("password",user.getPassword());
            data =  query.list();
            System.out.println(data.get(0).getUsername());
            session.flush();
        }catch(Exception ex) {
            if(transaction!= null) transaction.rollback();
            ex.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }finally{
            if(session!=null)
                session.close();
        }
        if(data==null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
