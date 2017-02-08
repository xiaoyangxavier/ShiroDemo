package savy.myhome.service.outlay;

import java.util.List;
import java.util.Map;

import savy.myhome.vo.outlay.Outlay;
import savy.myhome.vo.outlay.OutlayTypeOne;
import savy.myhome.vo.outlay.OutlayTypeTwo;

public interface OutlayService {

	public Map<String,Object> getOutlayAll(Integer currentPage, Integer pageSize, String userId, String column,
			String keyWord);

	public List<OutlayTypeOne> getOutlayTypeOneList();// 一级支出类别列表

	public List<OutlayTypeTwo> getOutlayTypeTwoList(Integer id);// 二级支出类别列表

	public boolean insertOutlay(Outlay outlay);// 新增支出记录

}
