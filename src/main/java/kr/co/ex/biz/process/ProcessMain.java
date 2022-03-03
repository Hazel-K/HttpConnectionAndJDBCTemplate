package kr.co.ex.biz.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.ex.biz.WEM.WEMSchedule;

public class ProcessMain {
	private static final Logger log = LoggerFactory.getLogger(ProcessMain.class);
	
	public static void run() {
		log.info("방재기상 수집 시작...");
		WEMSchedule.getAWSH();
	}
}
