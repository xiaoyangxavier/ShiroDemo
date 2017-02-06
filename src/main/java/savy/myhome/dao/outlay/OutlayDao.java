package savy.myhome.dao.outlay;

import java.util.List;

import savy.myhome.vo.outlay.Outlay;
import savy.myhome.vo.outlay.OutlayTypeOne;
import savy.myhome.vo.outlay.OutlayTypeTwo;

public interface OutlayDao {

	public List<Outlay> getOutlayList();//支出列表
	
	public List<OutlayTypeOne> getOutlayTypeOneList();//一级支出类别列表
	
	public List<OutlayTypeTwo> getOutlayTypeTwoList(Integer id);//二级支出类别列表
	
}
