package sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sample.mybatis.domain.City;
import sample.service.CityService;

@RestController
public class CityController {

	@Autowired
	private CityService cityService;

	/**
	 * curl -i -X POST -H "Content-Type:application/json" -d
	 * '{"name":"abc","state":"hlelo","country":"USA"}'
	 * http://172.27.12.86:8080/city/add
	 * 
	 * @param city
	 * @return
	 */
	@RequestMapping("/city/add")
	public int addCity(@RequestBody City city) {
		return cityService.addCity(city);
	}

	@RequestMapping("/city/findAll")
	public List<City> findAll() {
		return cityService.findAll();
	}

	@RequestMapping("/city/findByState")
	public City findByState(@RequestParam String state) {
		// return cityMapper.findByState(state);
		return cityService.findByState(state);
	}

	@RequestMapping("/city/deleteById")
	public int delete(@RequestParam long id) {
		return cityService.deleteById(id);
	}

	/**
	 * 提交修改命令 curl -i -X GET -H "Content-Type:application/json;charset=UTF-8" -d
	 * '{"id":55,"name":"abcdefg","state":"China","country":"China"}'
	 * http://172.27.12.86:8080/city/update
	 *
	 * @param city
	 * @return
	 */
	@RequestMapping(value = "/city/update")
	public int update(@RequestBody City city) {
		return cityService.update(city);
	}
}
