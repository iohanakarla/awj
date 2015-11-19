package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class EvaluareController {
  private List<Evaluare> Evaluari = new ArrayList<Evaluare>();

  EvaluareController() {
    Evaluare e1 = new Evaluare(1, 10, "EvaluarePerformanta");
    Evaluare e2 = new Evaluare(2, 1, "EvaluareAspect");
    Evaluare e3 = new Evaluare(3, 7, "hgdfckjmd");

    Evaluari.add(e1);
    Evaluari.add(e2);
    Evaluari.add(e3);
  }

  @RequestMapping(value="/Evaluare", method = RequestMethod.GET)
  public List<Evaluare> index() {
    return this.Evaluari;
  }
 
 
 
 
@RequestMapping(value="/Evaluare", method = RequestMethod.POST)
  public ResponseEntity post() {
    
	  Evaluare ee = new Evaluare(10, 8, "EvaluareX ");
	  Evaluari.add(ee);
    
    return new ResponseEntity <Evaluare>(ee, new HttpHeaders(), HttpStatus.OK);
  }
	

@RequestMapping(value="/Evaluare/{id}", method = RequestMethod.PUT)
public ResponseEntity put(@PathVariable("id") int id) {
	for(Evaluare e : this.Evaluari) {
      if(e.getId() == id) {
		 e.setID(5);
		 e.setName("EvaluareY");
		 e.setNota(2);
		return new ResponseEntity<Evaluare>(e, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  
  
  @RequestMapping(value="/Evaluare/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Evaluare e : this.Evaluari) {
      if(e.getId() == id) {
        return new ResponseEntity<Evaluare>(e, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  
  
  
  
  @RequestMapping(value="/Evaluare/{id}", method = RequestMethod.DEL)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Evaluare e : this.Evaluari) {
      if(e.getId() == id) {
        this.Evaluari.remove(e);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
