package ch08.extended.vehicle;

public class DriverExam {

		public static void main(String[] args) {
			//운전자가 실행하는 코드
			
			Driver driver = new Driver();
			
			Vehicle vehicle = new Vehicle();
			
			vehicle.name = "탈것";
			
			driver.drive(vehicle);
			
			Bus bus = new Bus();
			bus.name = "시내버스";
			bus.type = "전기버스";
			bus.busCard();
			driver.drive(bus);
			
			Taxi taxi = new Taxi();
			taxi.model = "카카오택시";
			taxi.name = "가스형";
			taxi.meter();
			driver.drive(taxi);
			
			
			
			
			
			
			
		}
}
