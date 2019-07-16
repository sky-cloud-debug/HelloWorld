package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.water.common.bean.Page;
import com.water.dao.RegionDao;
import com.water.model.Area;
import com.water.model.MessageRecord;
import com.water.model.Region;
import com.water.model.Soil;
import com.water.model.SoilCollectStatisticsModel;
import com.water.model.User;
import com.water.model.WaterRecord;
import com.water.model.WeatherCollectStatisticsModel;
import com.water.service.AreaService;
import com.water.service.CropService;
import com.water.service.MessageRecordService;
import com.water.service.SoilService;
import com.water.service.UserService;
import com.water.service.WaterRecordService;
import com.water.service.WeatherService;

public class ServiceDaoTest {

	ApplicationContext applicationContext;

	{
		applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext**.xml");
	}
	
	SessionFactory sessionFactory;
	
	@Test
	public void testSessionFactory(){
		sessionFactory=(SessionFactory) applicationContext.getBean("sessionFactory");
		System.out.println(sessionFactory);
	}
	
	RegionDao regionDao;
	UserService userService;
	SoilService soilService;
	AreaService areaService;
	WeatherService weatherService;
	CropService cropService;
	WaterRecordService waterRecordService;
	MessageRecordService messageRecordService;
	{
		regionDao=applicationContext.getBean(RegionDao.class);
		userService=applicationContext.getBean(UserService.class);
		soilService=applicationContext.getBean(SoilService.class);
		areaService=applicationContext.getBean(AreaService.class);
		weatherService=applicationContext.getBean(WeatherService.class);
		cropService=applicationContext.getBean(CropService.class);
		waterRecordService=applicationContext.getBean(WaterRecordService.class);
		messageRecordService=applicationContext.getBean(MessageRecordService.class);
	}
	@Test
	public void testRegionDao(){
//		Region region=new Region();
//		region.setCity("aaa");
//		region.setCreateTime(new Date());
//		regionDao.save(region);
		Region region = regionDao.findOneById(1);
		System.out.println(region);
	}
	
	@Test
	public void testUserService(){
		User user = userService.findByUsernameAndPassword("admin","123456");
		System.out.println(user);
	}
	
	@Test
	public void testPermission(){
	}
	
	@Test
	public void testUserDao(){
		User user = userService.findByUsernameAndPassword("admin", "123456");
		System.out.println("=="+user);
	}
	
	
	@Test
	public void testSoilService(){
		Page<Soil> page = soilService.findListByRegionIdAndPage(0,10,1);
		List<Soil> list = page.getContent();
		System.out.println(list);
	}
	
	/*@Test
	public void testSoilStatisticService() throws Exception{
		List<SoilCollectStatisticsModel> list = soilService.statisticSoilByCreateTime(30, new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-20"),new Date(),true);
		for (SoilCollectStatisticsModel soilCollectStatisticsModel : list) {
			System.out.println(soilCollectStatisticsModel.getCreateTime());
			System.out.println(soilCollectStatisticsModel.getSoilHumi());
			System.out.println(soilCollectStatisticsModel.getSoilTemp());
		}
	}*/
	@Test
	public void testAvgSoilHumi(){
		double averageSoilHumi = soilService.getLastDayAverageSoilHumi(1);
		System.out.println(averageSoilHumi);
	}
	
	@Test
	public void testAreaList(){
		List<Area> list = areaService.findListByRegionIdAndPage(1,100,1).getContent();
		System.out.println(list);
	}
	
	@Test
	public void testWeatherService() throws Exception{
		List<WeatherCollectStatisticsModel> list = weatherService.statisticWeatherByCreateTime(1, new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-19"), new Date(),true);
		for (WeatherCollectStatisticsModel model : list) {
			System.out.println(model);
		}
	}
	
	@Test
	public void testWaterRecord(){
		WaterRecord t=new WaterRecord();
		t.setCreateTime(new Date());
		t.setIrrigationArea("232.23");
		t.setOutletNumber("1");
		t.setWaterNum("20");
		waterRecordService.save(t);
	}
	
	@Test
	public void testMessageRecord(){
		MessageRecord mr=new MessageRecord();
		mr.setContent("aaaaaaa");
		mr.setCreateTime(new Date());
		messageRecordService.save(mr);
	}
	
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://202.194.131.174:3306/irrigation","irrigation","123456");		
		System.out.println(connection);
	}
}
