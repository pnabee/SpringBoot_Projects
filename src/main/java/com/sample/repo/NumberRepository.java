package com.sample.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.model.Numbers;

@Repository
public interface NumberRepository extends CrudRepository<Numbers, Long>{

	//public Numbers addNumbers(Numbers numbers);
	public Numbers findById(long id);
}
