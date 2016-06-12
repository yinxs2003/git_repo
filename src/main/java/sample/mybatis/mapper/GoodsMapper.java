package sample.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import sample.mybatis.domain.Goods;

/**
 * Goods信息
 */
@Mapper
public interface GoodsMapper {
	public List<Goods> findAll();

	public int sellOne(int goodsId);

	public Goods findById(int goodsId);
}
