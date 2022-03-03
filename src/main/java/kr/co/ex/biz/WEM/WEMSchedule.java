package kr.co.ex.biz.WEM;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.ex.biz.Util.HttpUtils;
import kr.co.ex.biz.Util.TimeUtils;

public class WEMSchedule {
	private static final Logger log = LoggerFactory.getLogger(WEMSchedule.class);
	
	public static void getAWSH() {
		log.info("강수량 정시데이터 수집...");
		
		String[] timeArray = TimeUtils.get21to9Time();
		HashMap<String, String> parameter = new HashMap<String, String>();
		// 강수 정시자료
		parameter.put("authKey", WEMConstant.AFSOAPIKEY);
		parameter.put("tm", timeArray[0]);
		
		List<String> ret = HttpUtils.excuteGetConnection(WEMConstant.AFSOAWSH, parameter);
		for(String item : ret) {
			log.info(item);
		}
		
		WEMDAO wemdao = new WEMDAO();
		List<HashMap<String,Object>> list = wemdao.selectTest();
		for(HashMap<String,Object> item : list) {
			log.info("selectTest:\n" + item.toString());
		}
	}
	
}