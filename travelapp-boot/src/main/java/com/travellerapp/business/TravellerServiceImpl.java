package com.travellerapp.business;

import java.util.ArrayList;
import java.util.List;

import com.travellerapp.cdd.Employee;
import com.travellerapp.client.DataClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travellerapp.domain.Traveller;
import com.travellerapp.repositories.TravellerRepository;


@Service
@RequiredArgsConstructor
public class TravellerServiceImpl implements TravellerService{

	public final DataClient client;


	@Autowired
	private TravellerRepository travellerRepository;

	public TravellerServiceImpl(DataClient client) {
		this.client = client;
	}


	@Override
	public List<Traveller> listAllTravellers() {
		// TODO Auto-generated method stub
		List<Traveller> travellers = new ArrayList<>();
		try {
			 travellers =(List<Traveller>) travellerRepository.findAll();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		 //fun with Java 8
        return travellers;
	}
	

	public List<Employee> listAllEmployeers(){
		List<Employee> sample = client.getSample();
		return sample;
	}

}
