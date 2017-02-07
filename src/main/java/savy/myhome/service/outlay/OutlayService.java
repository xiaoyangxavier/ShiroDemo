package savy.myhome.service.outlay;

import java.util.List;

import savy.myhome.vo.outlay.Outlay;
import savy.myhome.vo.outlay.OutlayTypeOne;
import savy.myhome.vo.outlay.OutlayTypeTwo;

public interface OutlayService {

	public List<Outlay> getOutlayList();
	
public List<OutlayTypeOne> getOutlayTypeOneList();//一级支出类别列表
	
	public List<OutlayTypeTwo> getOutlayTypeTwoList(Integer id);//二级支出类别列表
	
	public boolean insertOutlay(Outlay outlay);//新增支出记录
	
}
