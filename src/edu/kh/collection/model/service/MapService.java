package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kh.collection.model.vo.Member;

public class MapService {
	
	
	// Map : Key와 Value 한쌍이 데이터가 되어, 이를 모아둔 객체이다
	
	// Key를 모아두면, Set의 특징을 가지고 (중복 안됨)
	// Value를 모아두면, List의 특징을 갖게 된다 (중복 허용)
	
	
	public void ex1() {
		
		// HashMap<K, V> : Map의 자식 클래스 중 가장 대표되는 Map
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		// Map.put(K, V)
		// Map.put(Integer Key, String Value) -->추가
		
		map.put(1, "홍길동");
		map.put(2, "이길동");
		map.put(3, "김길동");
		map.put(4, "박길동");
		map.put(5, "서길동");
		map.put(6, "최길동");
		
		// Key 중복 해보자
		map.put(1, "이현경");
		// Key 중복은 안되었고, 대신 새로들어온 Value(이현경)이 들어갔다. (Set방식)
		
		// Value 중복 해보자
		map.put(7, "이현경");
		// Value는 중복 되어도 상관 없다 (List방식)
		
		
		
		System.out.println(map);
		// --> map.toString() 오버라이딩이 되어있음

	}
	
	
	public void ex2() {
		
		// Map 사용 예제
		
		// VO --> ValueObject --> 값 저장용 객체
		// --> 특정 데이터 묶음의 재사용성이 많은 경우 사용
		// --> 재사용이 적은 VO는 코드 낭비이다.
		// --> Map을 이용하여 VO와 비슷한 코드를 작성할 수 있다.
		
		
		// 1) VO버전
		
		Member mem = new Member();
		
		// 값 세팅
		mem.setId("user01");
		mem.setPw("pass01");
		mem.setAge(25);
		
		// 값 출력
		System.out.println(mem.getId());
		System.out.println(mem.getPw());
		System.out.println(mem.getAge());
		
		System.out.println("========================================================");
		// 2) Map버전
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		// Value가 Object라는 건 어떤 객체든 Value에 들어올 수 있다.
		
		// 값 세팅
		
		map.put("id", "user02");
		map.put("pw", "pass02");
		map.put("age", 25); // -> int -> Integer(AutoBoxing)
		
		// 값 출력
		
		System.out.println(map.get("id").toString()); 
		// String java.lang.Object.toString() --> 정적 바인딩
		// 객체 타입이 호출한 메서드로 바뀜 --> 동적 바인딩
		System.out.println(map.get("pw"));
		System.out.println(map.get("age"));
		
		System.out.println("=========================================");
		
		
		// *** Map에 저장된 데이터를 순차적으로 접근하는 방법 ***
		
		
		// Map에서 Key만 모아두면 --> Set의 특징 --> 중복허용 X
		// -> 이를 활용할 수 있도록 Map에서 keySet() 메서드 제공
		// -> Key만 모아서 Set으로 반환
		
		Set<String> set = map.keySet(); // id, pw, age가 저장된 Set을 반환
		System.out.println(set);
		// 현재 set에 id, pw, age가 담겨있음
		
		System.out.println();
		
		
		// 향상된 for문
		
		for( String key : set) {
			System.out.println(map.get(key));
			// key가 반복될 때 마다 변경이 된다
			// -> 변경된 key에 맞는 map의 value가 출력되는 것
		}
		
		// map에 저장된 데이터가 많을 때,
		// 어떤 key가 있는지 불분명할 때,
		// map에 저장된 모든 데이터에 접근 해야할 때,
		// keySet() + 향상된 for문 코드를 사용
		
	}
	
	
	public void ex3() {
		
		// List + Map의 콜라보를 해보자 야매로 모 야매룽다
		// user --> 10명, user의 id만 리스트로 뽑을거야
		
		
		// Map을 만들어서 List에 넣을거임
		
		// K--> id, V --> user의 id
		
		List< Map<String,Object> > list = new ArrayList< Map <String,Object> > ();
		// --> 결국 ArrayList를 생성함 --> new 
		
		
		for(int i = 0; i < 10; i++) {
			// Map 생성
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("id", "user0" + i);
			map.put("pw", "pass0" + i);
			list.add(map);
		}
		// for문 종료 시점에 10개의 Map객체가 list에 들어있다.
		// * List에 저장된 Map에서 key가 "id"인 경우의 value 모두 출력
		
		
		// 향상된 for문을 이용해서 해보자
		
		for(Map<String, Object> temp : list) { // 제네릭을 안써도 오류는 안나는 데 쓰는게 국룰
			
			System.out.println(temp.get("id"));
			System.out.println(temp.get("pw"));
			// --> id(key)에 맞는 value가 출력된다.
		}
	}
}
