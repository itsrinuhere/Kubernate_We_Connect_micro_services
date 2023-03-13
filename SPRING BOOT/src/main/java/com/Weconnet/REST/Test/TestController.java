package com.Weconnet.REST.Test;
import com.Weconnet.REST.Alert.Alert;
import com.Weconnet.REST.Library.PDF;
import com.Weconnet.REST.Test.Testing.Hibernate;
import com.Weconnet.REST.Test.Testing.Text;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value="/api")
public class TestController {
    Logger log = LoggerFactory.getLogger(TestController.class);
    @PostMapping("/test")
  public ResponseEntity helloworld(@RequestBody PDF pdf){
        System.out.println(pdf.getFilename());
        log.warn("Debug :"+pdf.getFilename());
        log.warn("debug : "+pdf.getDescription());
        log.warn("debug : "+pdf.getFiletype());
        log.warn("debug : "+pdf.getSize());
        log.warn("debug : "+pdf.getUploaded_time());
        log.warn("debug : "+pdf.getFile());
       // pdf.setUploaded_time(new Date());
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
    @RequestMapping(value="/getvalue/{id}",method= RequestMethod.GET)
        ResponseEntity testget(@PathVariable("id") String id){
                Text pdf = new Text();
                log.warn("debug :"+id);
                Session session=null;
                Transaction transaction = null;
                List ls = null;
        try {
            session = Hibernate.getsessionfactory().openSession();
            transaction = session.beginTransaction();
            Query<Text> query = session.createQuery("from com.Weconnet.REST.Test.Testing.Text object",Text.class);
            //query.setParameter("book_id",id);
            ls = query.getResultList();
        }catch(Exception ex) {
            System.out.println(ex);
        } if(session!= null) session.close();
        if(transaction!=null) session.close();
        if(ls!=null) return new ResponseEntity(ls.get(0),HttpStatus.ACCEPTED);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        @RequestMapping(value="/check",method=RequestMethod.POST)
    ResponseEntity check(@RequestParam("file") MultipartFile file, @RequestParam("key") String key){
        log.warn(key);
        return new ResponseEntity(HttpStatus.OK);
        }

}
