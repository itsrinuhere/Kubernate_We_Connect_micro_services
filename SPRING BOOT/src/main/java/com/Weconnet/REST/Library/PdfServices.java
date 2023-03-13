package com.Weconnet.REST.Library;
import com.Weconnet.REST.Auth.AuthUtil;
import com.Weconnet.REST.Logg;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.codec.binary.Base64;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PdfServices {

    public ResponseEntity<PDF> uploadPDF(PDF ob) {
        try {
            Session session;
            Transaction transaction;
            session = PDFUtil.getsessionfactory().openSession();
            transaction = session.beginTransaction();
            session.persist(ob);
            transaction.commit();
            if (session != null) session.close();
            Logg.log("success");
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(ConstraintViolationException e){
            System.out.println(e);
            return new ResponseEntity(e.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
        }
    }
  String  update(PDF pdf){
      Session session;
      Transaction transaction;
            List<PDF> data = null;
            session = PDFUtil.getsessionfactory().getCurrentSession();
            Query<PDF> query = session.createQuery("from com.Weconnet.REST.Library object WHERE object.id=:filename",PDF.class);
            //query.
            data = query.getResultList();
            return(data!=null)?data.get(0).getFilename():"error";
    }
    boolean updatepdf(Template pdf){
        return false;
    }
    boolean deletepdf(String id){
        return false;
    }
    List<Template> getAll(){
        Session session = PDFUtil.getsessionfactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query<PDF> query = session.createQuery("FROM com.Weconnet.REST.Library.PDF",PDF.class);
        //transaction.getStatus();
       // transaction.commit();
        List<PDF> data = query.getResultList();
        List<Template> dat = new ArrayList<>();
        Template t = new Template();
        for(int i=0;i<data.size();i++){
            t.setDescription(data.get(i).getDescription());
            t.setFilename(data.get(i).getFilename());
            t.setId(data.get(i).getId());
            t.setSize(data.get(i).getSize());
            t.setUploaded_time(data.get(i).getUploaded_time());
            t.setFiletype(data.get(i).getFiletype());
            t.setFile(new Base64().encodeToString(data.get(i).getFile()));
          //  i.setFile(i.getFile());

            dat.add(t);
        }
        return dat;
    }

}
