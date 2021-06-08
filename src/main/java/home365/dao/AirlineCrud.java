package   home365.dao;


import org.springframework.data.repository.PagingAndSortingRepository;

import home365.data.Airline;

public interface AirlineCrud extends PagingAndSortingRepository<Airline, Long> {
	
	
}
