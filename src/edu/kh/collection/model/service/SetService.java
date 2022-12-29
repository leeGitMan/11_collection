package edu.kh.collection.model.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.model.vo.Member;


public class SetService {
	
	// Set(집합)
	// 특징
	// 1) 순서를 유지하지 않음 == 인덱스가 존재하지 않는다
	// 2) 중복은 허용하지 않는다. + null도 중복허용 X --> null은 1개만 저장 가능
	
	
	// ***** Set이 중복을 확인하는 방법 *****
	
	/*
	 * 컬렉션은 객체만 저장할 수 있음 (Set은 컬렉션이기 때문에, 객체만 저장가능)
	 * -> 객체가 가지고 있는 필드값이 같으면 중복으로 생각한다.
	 * --> 이 때, 필드값이 모두 같은지 비교하기 위해서
	 * 		***** 객체의 "equals()" 가 반드시 오버라이딩 되어야한다. *****
	 * Hash 라는 이름이 들어간 애들은 equals, hashcode가 오버라이딩 되어야 한다.
	 */
	
	public void ex1() {
		
		Set<String> set = new HashSet<String>();
		
		// HashSet --> Set의 대표적인 자식 클래스
		// 사용 조건
		// 1) 저장되는 객체 equals() 오버라이딩 필수
		// 2) 저장되는 객체 hashcode() 오버라이딩 필수
		// String 클래스는 equals hashcode가 이미 오버라이딩 되어있어서 할 필요가 없다
		// 그러나 다른 클래스를 제네릭 하고 HashSet을 사용할 때, equals와 hashcode를 오버라이딩 해줘야한다.
		
		
		// Set.add(String e) : 추가
		
		set.add("K뱅크");
		set.add("토스");
		set.add("금융권");
		set.add("K뱅크");
		set.add("토스");
		set.add("금융권");
		set.add("K뱅크");
		set.add("토스");
		set.add("금융권");
		set.add("K뱅크");
		set.add("토스");
		set.add("금융권");
		set.add(null);
		set.add(null);
		set.add(null);
		
		
		System.out.println(set); 
		// --> 순서가 유지 되지 않은 채 출력됨, 중복이 허용되지 않은 채 3개만 출력
		// null도 마찬가지로 하나만 들어가고 그 이상 중복허용이 안되고 있다.
		
		// size() : 리스트와 같이 저장된 객체의 수를 파악하는 것
		
		System.out.println("저장된 데이터의 수 : " +  set.size());
		
		// remove() : --> 리스트에선 remove(index) 가 들어갔지만
		// remove(String e) : -> set은 index가 없음 
		// 그래서 Set에 저장된 객체 중 매개변수 e와 필드 값이 같은 객체를 제거
		//		+ Hash라는 단어가 포함된 Set이면 hashCode()도 같아야함.
		
		
		System.out.println();
		
		System.out.println(set.remove(null)); // --> boolean 반환 // 지우면 true // 못지웠으면 false // 
		System.out.println(set);
		System.out.println(set.remove("카카오뱅크")); // --> 제거 확인용 --> false 반환
		System.out.println(set);
		System.out.println();
		
		
		// ============================================================================================
		
		// Set은 index가 없기 때문에(순서가 없다), get 메서드를 못씀
		// 그래서 데이터를 꺼내오는 게 --> Iterator(반복자)를 써서 반복적으로 전체적인 데이터를 꺼내옴
		
		/*
		 *  1. Iterator
		 *  --> Collection에서 제공하는 객체 반복 접근자
		 *  Collection에 저장된 데이터를 임의로 하나 씩, 반복적으로 꺼내는 역할
		 */ 
		
		// 작성법 Iterator<클래스명> 변수명 = set.iterator(); --> java.util에 존재
		
		Iterator<String> it = set.iterator();
		// set.iterator() : Set을 Iterator 하나 씩 꺼내갈 수 있는 모양
		// Iterator에는 size가 없다
		
		
		while(it.hasNext()) { // while문을 쓰는 건 Set의 끝을 모르기 때문에.
			// 그래서 while 조건문에 변수명.hasNext()를 쓴다.
			// 반환은 boolean 있으면 true 없으면 false
			String temp = it.next(); // 여기에 있는 next는 Iterator에 있는 next Scanner의 next와 다르다
			// it.next() --> 다음 값 객체를 얻어와서 변수에 저장시켜주는 녀석
			System.out.println(temp);
		}
		
		System.out.println();
		// ============================================================================================
		
		// 향상된 for문 사용
		
		// for( 하나씩 꺼내서 저장할 변수 : 컬렉션 )
		
		for(String temp : set) {
			System.out.println(temp); 
		}
		
	}
	
	public void ex2() {
		
		// Hash 함수 : 입력된 단어를 지정된 길이의 문자열로 전환시켜주는 함수 (절대 중복 안됨)
		// 중복이 안됨의 이유 
		// 입력 : 111(3글자) ->"asdfg" (5글자)
		// 입력 : 1231231231231231 -> "qwert" (5글자)
		// --> Hash함수는 암호화에 사용한다
		// --> 일정한 길이의 랜덤값이 생성, 중복도 안되기 때문에
		// --> 백엔드, DB는 암호화 공부 필수
		
		// hashCode() : 필드 값이 다르면 중복되지 않는 숫자를 만드는 메서드
		// -> Why? --> 빠른 데이터 검색을 위해서 (객체가 어디에 있는지 찾기 쉽다)
		
		// HashSet() : 중복 없이 데이터 저장(Set)하고 데이터 검색이 빠름(Hash)
		
		
		Member m1 = new Member("user01", "pass01", 30);
		Member m2 = new Member("user01", "pass01", 30);
		Member m3 = new Member("user02", "pass02", 20);
		
		System.out.println( m1 == m2 ); // 참조형이기에 주소를 비교하고, 주소가 다르기에 false
		// 얕은 복사 경우가 아니라면 다 false
		
		// ==> 필드가 많으면 같은지 안같은지 비교하기가 힘들다
		// 그래서 equals() 메서드 오버라이딩 해서 사용하게 됨
		System.out.println("=================================================");
		
		
		System.out.println(m1.equals(m2)); // m1과 m2의 필드가 같은가? --> true
		System.out.println(m1.equals(m3)); // m1과 m3의 필드가 같은가? --> false
	}
	
	public void ex3() {
		
		// 중복 제거
		// Set의 가장 큰 특징
		// 오버라이딩된 equals()를 이용해서 Member Set에 저장
		// KeyPoint --> 중복 제거
		
		
		Set<Member> memberSet = new HashSet<Member>();
		
		memberSet.add(new Member("user01", "pass01", 30));
		memberSet.add(new Member("user02", "pass02", 20));
		memberSet.add(new Member("user03", "pass03", 50));
		memberSet.add(new Member("user04", "pass04", 25));
		memberSet.add(new Member("user04", "pass04", 25));
		
		
		for(Member m : memberSet) {
			System.out.println(m);
			// 필드에 hashCode()를 오버라이딩 안하는 순간 중복을 제거 못하게 된다
		}	
		
		Member m1 = new Member("user01", "pass01", 30);
		Member m2 = new Member("user01", "pass01", 30);
		Member m3 = new Member("user02", "pass02", 20);
		
		
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
		System.out.println(m3.hashCode());
		// 여기서 보면 m1과 m2의 hashCode가 같은 걸 볼 수 있다.
		// 이것을 통해서, 해쉬코드가 중복되면 중복을 제거함
		
		
		
		
	}

	public void ex4() {
		
		/*
		 *  Wrapper 클래스
		 *  Collection은 객체만 들어올 수 있다
		 *  기본 자료형(int,char.....)은 들어올 수 없는데
		 *  기본 자료형을 Wrapper클래스로 객체로 포장 시켜서 들어갈 수 있게 해준다.
		 *  + 기본 자료형에 없던 추가 기능, 값을 이용하고 싶을 때 사용한다.
		 *  
		 *  Boolean, Integer, Character, Double, Float, Short, Long, Byte 
		 */
		
		int iNum = 10;
		double dNum = 3.14;
		// 기본 자료형을 포장 하자 Wrapper클래스로
		
		Integer w1 = new Integer(iNum);
		Double w2 = new Double(dNum);
		// 삭제선 -->> 곧 삭제된다.
		
		// Wrapper 클래스 사용
		
		System.out.println("int 최대값 : " + w1.MAX_VALUE); // --> 기울어진것은 static
		System.out.println("int 최소값 : " + w1.MIN_VALUE); // static은 클래스명.메서드였음
		
		System.out.println("== static 방식으로 Wrapper클래스 사용 ==");
		System.out.println("int 최대값 : " + Integer.MAX_VALUE);
		System.out.println("int 최소값 : " + Integer.MIN_VALUE);
		System.out.println("==============");
		System.out.println("double의 최대, 최소");
		System.out.println("double 최대값 : " + Double.MAX_VALUE);
		System.out.println("double 최소값 : " + Double.MIN_VALUE);
		
		//*********************************************************************
		
		// parsing : 데이터의 형식을 변환
		
		// String 데이터를 기본 데이터로 변환해보자
		
		int num1 = Integer.parseInt("100");
		double dNum2 = Double.parseDouble("1.2345");
		
		System.out.println(num1);
		System.out.println(dNum2);
		
		
		System.out.println(num1 + dNum2); // --> 연산이 된다. 문자열이 아니다
		
		
		
		//*********************************************************************
		
		
		
	}
	
	
	public void ex5() {
		
		// Wrapper 클래스의
		// AutoBoxing
		// AutoUnBoxing
		
		Integer w1 = new Integer(100);
		
		Integer w2 = 100;
		Integer w3 = 200;
		// --> w2와 100 은 원래 연산이 안되어야 하는데
		// --> Integer는 int의 포장형태인 걸 Java가 알고, int를 Integer로 자동 포장해줌
		// --> 이것을 AutoBoxing이라고 한다
		
		System.out.println(w2 + w3); // --> 300
		
		// Integer는 객체이다. 위 코드는 객체+객체이고, 원래 안됨
		// Java가 또!
		// Integer가 int의 포장형태라는 걸 알고
		// Integer의 포장 형태를 자동으로 벗겨내서 연산함
		// --> AutoUnBoxing이라고 함
		
		
	}
	
	public void lotto() {
		
		// Set의 마무리
		// 로또 박스 만들기
		
		// HashSet --> 중복 제거, 순서 유지 X
		// LinkedHashSet --> 중복 제거, 순서 유지 O --> 순서 유지 Set
		// TreeSet (오름차순) --> 중복 제거, 오름차순 순서 정렬
		
		//Set<Integer> lotto = new HashSet<Integer>();
		//Set<Integer> lotto = new LinkedHashSet<Integer>();
		Set<Integer> lotto = new TreeSet<Integer>();
		
		// Integer는 equals(), hashCode() 오버라이딩 완료 상태
		
		
		while(lotto.size() < 6) {
			// lotto에 저장된 값이 개수가 6개 미만이면 반복한다
			// 중복이 되면 개수가 하나가 비어 버릴 수 있기 때문에
			// 저렇게 조건을 둬야함
			
			int random = (int) (Math.random() * 45 + 1); // 1 ~ 45까지 난수 발생
			
			System.out.println(random); // 발생 순서 확인
			// 현재 random 은 int형
			
			
			lotto.add(random); // --> 순서 유지 X 중복 허용 X
			// random의 형태가 Integer로 포장 되었음 (AutoBoxing)
		}
		
		System.out.println("로또 번호 " + lotto);
		
		
	}

	
	
	
	
}
