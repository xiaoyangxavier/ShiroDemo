package savy.myhome.service.impl.outlay;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import savy.myhome.dao.outlay.OutlayDao;
import savy.myhome.service.outlay.OutlayService;
import savy.myhome.vo.outlay.Outlay;

@Service
public class OutlayServiceImpl implements OutlayService{

	@Resource
	private OutlayDao outlayDao;
	
	public List<Outlay> getOutlayList(){
		
		List<Outlay> myList = outlayDao.getOutlayList();
		
		return myList;
	}
}
