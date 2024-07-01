package ch07.mbcCar;

import ch07.hankook.SnowTire;
import ch07.hyundai.Engine;
import ch07.kumho.EcoTire;
import ch07.nexen.*;
// *처리는 클래스에 있는 모든 것들을 다 가져와라(클래스 내부 중복 주의)

//import ch07.hankook.Tire;

public class Car {
	//필드
	ch07.hankook.Tire hTire = new ch07.hankook.Tire(); // 한국타이어 패키지에서 가져옴. import ch07.hankook.Tire;
	ch07.kumho.Tire kTire = new ch07.kumho.Tire(); // 금호타이어 패키지에서 가져옴.
	SnowTire sTire = new SnowTire();
	EcoTire eTire = new EcoTire();
	BigWidthTire bigTire = new BigWidthTire();
	SportTire spTire = new SportTire();
	
	
	Engine engine = new Engine();
	
	//생성자
	
	
	//메서드

}
