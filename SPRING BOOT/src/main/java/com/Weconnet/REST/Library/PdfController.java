package com.Weconnet.REST.Library;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.codec.binary.Base64;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("pdf")
public class PdfController {
   protected PdfServices service = new PdfServices();
    @RequestMapping(value="upload",method = RequestMethod.POST)
   protected  ResponseEntity uploadFile(@RequestParam("file")MultipartFile obj,@RequestParam("id") String id){
        PDF ob = new PDF();
       try{
           ob.setFile(obj.getBytes());
           ob.setId(id);
           ob.setFiletype(obj.getContentType());
           ob.setSize(obj.getSize());
           ob.setUploaded_time(new Date());
           return service.uploadPDF(ob);
       }catch(Exception ex){
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }//end of the upload file method
    @RequestMapping(value="json-upload",method = RequestMethod.POST)
    ResponseEntity upload_json(@RequestBody Template pdf){
        PDF pdf1 = new PDF();
        pdf1.setFilename(pdf.getFilename());
        pdf1.setFile(new Base64().decode(pdf.getFile()));// string to byte[] decoded ???
       // pdf1.setFile(pdf.getFile());
        pdf1.setFiletype(pdf.getFiletype());
        pdf1.setSize(pdf.getSize());
        pdf1.setDescription(pdf.getDescription());
        pdf1.setId(pdf.getId());
        pdf1.setUploaded_time(new Date());
      //return new ResponseEntity(HttpStatus.ACCEPTED);
        return service.uploadPDF(pdf1);
    }
    @RequestMapping(value="getAll",method=RequestMethod.GET)
    ResponseEntity<List<Template>> getAllPdf(){
            List<Template> pdfs =service.getAll();
        return new ResponseEntity(pdfs,HttpStatus.ACCEPTED);
    }
}
