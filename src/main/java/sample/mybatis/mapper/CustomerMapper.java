package sample.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import sample.mybatis.domain.Customer;

@Mapper
public interface CustomerMapper {
	public List<Customer> findAll();
	
	public Customer findById(int customeId);

	public int buyOne(int customerId, int buyGoodsCost);

}
