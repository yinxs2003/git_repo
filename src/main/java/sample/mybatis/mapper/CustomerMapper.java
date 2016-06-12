package sample.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import sample.mybatis.domain.Customer;

@Mapper
public interface CustomerMapper {
	public Customer findAll();
	
	public Customer findById(int customeId);

	public int buyOne(int customerId, int buyGoodsCost);

}
