package sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.mybatis.domain.City;
import sample.mybatis.mapper.CityMapper;

@Service
public class CityService {
	@Autowired
	private CityMapper cityMapper;

	public City findByState(String state) {
		return cityMapper.findByState(state);
	}

	public List<City> findAll() {
		return cityMapper.findAll();
	}

	public int addCity(City city) {
		return cityMapper.addCity(city);
	}

	public int deleteById(long id) {
		return cityMapper.deleteById(id);
	}
	
	public int update(City city) {
		return cityMapper.update(city);
	}
}
