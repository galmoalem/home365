package  home365.dao;


import org.springframework.data.repository.PagingAndSortingRepository;

import home365.data.Aircraft;

public interface AircraftCrud extends PagingAndSortingRepository<Aircraft, Long>{

	
}
