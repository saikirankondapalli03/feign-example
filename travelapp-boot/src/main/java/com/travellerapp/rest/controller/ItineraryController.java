package com.travellerapp.rest.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travellerapp.business.ItineraryServiceImpl;
import com.travellerapp.business.NotificationService;
import com.travellerapp.domain.Itinerary;
import com.travellerapp.domain.ReportOutputEmailWrapper;

@RestController
@RequestMapping(path = "/itinerary")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItineraryController 
{

	
	@Autowired
	private ItineraryServiceImpl itineraryService;
	 
	@RequestMapping(value = "/getAllItinerariesReport", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> getAllItinerariesReport() throws IOException {
		ReportOutputEmailWrapper bis= itineraryService.getAllItinerariesReport();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename="+bis.getKey()+".pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bis.getBs()));
	}

	@RequestMapping(value = "/getItineraryByIdReport/{Id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> getItineraryByIdReport(@PathVariable String Id) throws IOException {
		ReportOutputEmailWrapper bis= itineraryService.getItineraryByIdReport(Id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename="+bis.getKey()+".pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bis.getBs()));
	}
	
	@RequestMapping(value = "/getItineraryByEmailReport/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> getItineraryByEmailReport(@PathVariable String email) throws IOException {
		ReportOutputEmailWrapper bis= itineraryService.getItineraryByEmailReport(email);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename="+bis.getKey()+".pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bis.getBs()));
	}
	
	
	@GetMapping(path="/getAllItineraries", produces = "application/json")
    public List<Itinerary> getAllItineraries() 
    {
       return itineraryService.listAllItineraries();
    }


       
       
    @GetMapping(path="/getItineraryByEmail/{email}", produces = "application/json")
    public ResponseEntity<List<Itinerary>> getActiveItineraryByEmail(@PathVariable String email) 
    {
    	List<Itinerary> itr= itineraryService.getActiveItineraryByEmail(email);
    	if(itr !=null) {
    		return ResponseEntity.status(HttpStatus.OK).body(itr);
    	}else {
    		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    	}
	}
    
    
    @GetMapping(path="/getItineraryById/{Id}", produces = "application/json")
    public ResponseEntity<Itinerary> getActiveItineraryById(@PathVariable String Id) 
    {
    	Itinerary itr= itineraryService.getActiveItineraryById(Id);
    	if(itr !=null) {
    		return ResponseEntity.status(HttpStatus.OK).body(itr);
    	}else {
    		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    	}
	}
    
    @RequestMapping(value = "/createItinerary", method = RequestMethod.POST)
    public ResponseEntity<Itinerary> createItineraryWithDestinations(@Valid @RequestBody Itinerary itr) 
	{
    	return ResponseEntity.ok().body(itineraryService.createItinerary(itr));
	}
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Itinerary updateItinerary(@PathVariable("id") ObjectId id,@Valid @RequestBody Itinerary itr) 
	{
    	return itineraryService.updateItinerary(id,itr);
	}
    
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteItinerary(@PathVariable ObjectId id) {
		ResponseEntity<String> response= new ResponseEntity<String>(HttpStatus.OK);
		itineraryService.deleteItinerary(id);
		return response;
	}
    
    @RequestMapping(value = "/itineraries", method = RequestMethod.POST)
    public List<Itinerary> createItineraries(@Valid @RequestBody List<Itinerary> itineraries) 
	{
		return itineraryService.createItineraries(itineraries);
	}
    
    @RequestMapping(value = "/deleteAllItineraries", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAllItineraries() 
	{
    	ResponseEntity<String> response= new ResponseEntity<String>(HttpStatus.OK);
    	itineraryService.listAllItineraries().stream().forEach(x->{
    		itineraryService.deleteItinerary(new ObjectId(x.getId()));
			});;
		return response;
	}
    
    @RequestMapping(value = "/deleteDestination/{email}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDestination(@PathVariable String email,@Valid @RequestBody List<String> objectIds) 
	{
    	ResponseEntity<String> response= new ResponseEntity<String>(HttpStatus.OK);
    	itineraryService.deleteDestinationFromItinerary(email, objectIds);
		return response;
	}
    
    
 }
