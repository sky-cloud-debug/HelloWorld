package test;

import java.util.Timer;
import java.util.TimerTask;

public class MappingTest {
	
	public static void main(String[] args) throws Exception, Exception {
//		Properties properties=new Properties();
//		properties.load(new FileReader(new File("config/db.properties")));
//
//		String driverClass = properties.getProperty("jdbc.driverClass");
//		String username = properties.getProperty("jdbc.user");
//		String password = properties.getProperty("jdbc.password");
//		String jdbcUrl = properties.getProperty("jdbc.jdbcUrl");
//		
//		Class.forName(driverClass);
//		Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
//		System.out.println(connection);
	
		Timer timer=new Timer();
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				System.out.println("a");
			}
			
		}, 0,1000);
	}
}