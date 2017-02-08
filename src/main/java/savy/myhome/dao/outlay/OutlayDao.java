package savy.myhome.dao.outlay;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import savy.myhome.vo.outlay.Outlay;
import savy.myhome.vo.outlay.OutlayTypeOne;
import savy.myhome.vo.outlay.OutlayTypeTwo;

public interface OutlayDao {
	 
	/**
	 * 分页查找支出列表
	 * @param currentPage	当前页
	 * @param limitSize		每页限定数量
	 * @param column  关键字相关字段
	 * @param keyWord 关键字
	 * @param orderByClause	排序字段
	 * @return
	 */
	public List<Outlay> getOutlayAll(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize, @Param("userId") String userId, @Param("column") String column, @Param("keyWord") String keyWord);
	
	public Integer getOutlayCount(@Param("column") String column, @Param("keyWord") String keyWord);
	public List<OutlayTypeOne> getOutlayTypeOneList();//一级支出类别列表
	
	public List<OutlayTypeTwo> getOutlayTypeTwoList(Integer id);//二级支出类别列表
	
	public boolean insertOutlay(Outlay outlay);//新增支出记录
	
}
