package savy.myhome.service.impl.outlay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import savy.myhome.dao.outlay.OutlayDao;
import savy.myhome.service.outlay.OutlayService;
import savy.myhome.vo.outlay.Outlay;
import savy.myhome.vo.outlay.OutlayTypeOne;
import savy.myhome.vo.outlay.OutlayTypeTwo;

@Service
public class OutlayServiceImpl implements OutlayService {

	@Resource
	private OutlayDao outlayDao;

	//支出列表
	public Map<String,Object> getOutlayAll(Integer currentPage, Integer pageSize, String userId, String column,String keyWord) {
		Integer offset = (currentPage-1)*pageSize;
		List<Outlay> myList = outlayDao.getOutlayAll(offset,pageSize,userId,column,keyWord);
		Integer count = outlayDao.getOutlayCount(column,keyWord);
		Map<String,Object> map = new HashMap<String, Object>() ;
			map.put("allData", myList) ;
			map.put("count", count) ;
		return map;
	}

	// 一级支出类别列表
	public List<OutlayTypeOne> getOutlayTypeOneList() {
		List<OutlayTypeOne> myList = outlayDao.getOutlayTypeOneList();
		return myList;
	}

	// 二级支出类别列表
	public List<OutlayTypeTwo> getOutlayTypeTwoList(Integer id) {
		List<OutlayTypeTwo> myList = outlayDao.getOutlayTypeTwoList(id);
		return myList;
	}

	// 新增支出记录
	public boolean insertOutlay(Outlay outlay) {
		boolean flag = false;
		flag = outlayDao.insertOutlay(outlay);
		return flag;
	}
}
