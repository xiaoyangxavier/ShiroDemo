package savy.myhome.service.impl.outlay;

import java.util.List;

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

	public List<Outlay> getOutlayList() {

		List<Outlay> myList = outlayDao.getOutlayList();

		return myList;
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

}
