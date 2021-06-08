package home365.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import home365.data.Destination;

public interface DestinationCrud  extends PagingAndSortingRepository<Destination, Long>{

}
