# effective-java-onebyone
* 하루에 1개씩

## 핵심 기본 원칙: Clarity & Simplicity
* 컴포넌트는 사용자를 놀라게하는 동작을 해서는 안된다
  * 정해진 동작이나 예측할 수 있는 동작만 수행해야 한다
* 컴포넌트는 가능한 한 작되, 그렇다고 너무 작아서는 안된다
* 코드는 복사되는 게 아니라 재사용되어야 한다
* 컴포넌트 사이의 의존성은 최소로 유지해야 한다
* 오류는 만들어지자마자 가능한 한 빨리 (되록 컴파일타임에) 잡아야 한다

---
## 객체 생성과 파괴
- [x] 1.생성자 대신 정적 팩터리 메서드를 고려하라 (2021.07.11)
- [x] 2.생성자에 매개변수가 많다면 빌더를 고려하라 (2021.07.12)
- [x] 3.private 생성자나 열거타입으로 싱글턴임을 보증하라 (2021.07.13)
- [x] 4.인스턴스화를 막으려거든 private 생성자를 사용하라 (2021.07.14)
- [x] 5.자원을 직접 명시하지 말고 의존 객체 주입을 사용하라 (2021.07.14)
- [x] 6.불필요한 객체 생성을 피하라 (2021.07.15)
- [x] 7.다 쓴 객체 참조를 해제하라 (2021.07.15)
- [x] 8.finalizer와 cleaner 사용을 피하라 (2021.07.16)
- [x] 9.try-finally보다는 try-with-resources를 사용하라 (2021.07.16) 

---
## 모든 객체의 공통 메서드
- [x] 10.equals는 일반 규약을 지켜 재정의하라 (2021.07.17)
- [x] 11.equals를 재정의하려거든 hashCode도 재정의하라 (2021.07.19)
- [x] 12.toString을 항상 재정의하라 (2021.07.20)
- [x] 13.clone 재정의는 주의해서 진행하라 (2021.07.21)
- [x] 14.Comparable을 구현할지 고려하라 (2021.08.12)

---
## 클래스와 인터페이스
- [x] 15.클래스와 멤버의 접근 권한을 최소화하라 (2021.08.17)
- [x] 16.public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라 (2021.08.19)
- [x] 17.변경 가능성을 최소화하라 (2021.08.20)
- [x] 18.상속보다는 컴포지션을 사용하라 (2021.08.21)
- [x] 19.상속을 고려해 설계하고 문서화화라. 그러지 않았다면 상속을 금지하라 (2021.08.21)
- [x] 20.추상 클래스보다는 인터페이스를 우선하라 (-)
- [x] 21.인터페이스는 구현하는 쪽을 생각해 설계하라 (2021.08.23)
- [x] 22.인터페이스는 타입을 정의하는 용도로만 사용하라 (2021.08.24)
- [x] 23.태그 달린 클래스보다는 클래스 계층구조를 활용하라 (2021.08.25)
- [x] 24.멤버 클래스는 되도록 static으로 만들라 (2021.08.26)
- [x] 25.톱레벨 클래스는 한 파일에 하나만 담으라 (2021.08.30)

---
## 제네릭
- [x] 26.RAW 타입은 사용하지 말라 (2021.08.31)
- [x] 27.비검사 경고를 제거하라 (2021.09.01)
- [x] 28.배열보다는 리스트를 사용하라 (2021.09.02)
- [x] 29.이왕이면 제네릭 타입으로 만들라 (2021.09.03)
- [x] 30.이왕이면 제네릭 메서드로 만들라 (2021.09.07)
- [x] 31.한정적 와일드카드를 사용해 API 유연성을 높이라 (2021.09.13)
- [x] 32.제네릭과 가변인수를 함께 쓸 때는 신중하라 (2021.09.23)
- [ ] 33.타입 안전 이종 컨테이너를 고려하라 (SKIP)

---
## 열거 타입과 어노테이션
- [x] 34.int 상수 대신 열거타입을 사용하라 (2021.10.07)
- [x] 35.ordinal 메서드 대신 인스턴스 필드를 사용하라 (2021.10.08)
- [x] 36.비트 필드 대신 EnumSet을 사용하라 (2021.10.08)
- [x] 37.ordinal 인덱싱 대신 EnumMap을 사용하라 (2021.10.12)
- [ ] 38.확장할 수 있는 열거 타입이 필요하면 인터페이스를 사용하라 (-)
- [x] 39.명명 패턴보다 애너테이션을 사용하라 (2021.10.18)
- [x] 40.@Override 애너테이션을 일관되게 사용하라 (2021.10.20)
- [x] 41.정의하려는 것이 타입이라면 마커 인터페이스를 사용하라 (2021.10.20)

---
## 람다와 스트림
- [x] 42.익명 클래스보다는 람다를 사용하라 (2021.07.03)
- [x] 43.람다보다는 메서드 참조를 사용하라 (2021.07.04)
- [x] 44.표준 함수형 인터페이스를 사용하라 (2021.07.05)
- [x] 45.스트림은 주의해서 사용하라 (20210.07.06)
- [x] 46.스트림에서는 부작용 없는 함수를 사용하라 (2021.07.07)
- [x] 47.반환 타입으로는 스트림보다 컬렉션이 낫다 (2021.07.08)
- [x] 48.스트림 병렬화는 주의해서 적용하라 (2021.07.09)

---
## 메서드
- [x] 49.매개변수가 유효한지 검사하라 (2021.10.28)
- [x] 50.적시에 방어적 복사본을 만들라 (2021.11.02)
- [x] 51.메서드 시그니처를 신중히 설계하라 (2021.11.03)
- [x] 52.다중정의는 신중히 사용하라 (2021.11.05)
- [x] 53.가변인수는 신중히 사용하라 (2021.09.16)
- [x] 54.null이 아닌, 빈 컬렉션이나 배열을 반환하라 (2021.11.09)
- [x] 55.Optional 반환은 신중히 하라 (2021.11.15)
- [ ] 56.공개된 API 요소에는 항상 문서화 주석을 작성하라 (SKIP)

---
## 일반적인 프로그래밍 원칙
- [x] 57.지역변수의 범위를 최소화하라 (2021.11.23)
- [x] 58.전통적인 for문보다는 for-each 문을 사용하라 (2021.11.25)
- [x] 59.라이브러리를 익히고 사용하라 (2021.11.29)
- [x] 60.정확한 답이 필요하다면 float과 double은 피하라 (2021.12.01)
- [x] 61.박싱된 기본 타입 보다는 기본 타입을 사용하라 (2021.12.13)
- [x] 62.다른 타입이 적절하다면 문자열 사용을 피하라 (2021.12.14)
- [x] 63.문자열 연결은 느리니 주의하라 (2021.12.28)
- [x] 64.객체는 인터페이슬르 사용해 참조하라 (2021.12.29)
- [ ] 65.리플렉션보다는 인터페이스를 사용하라
- [ ] 66.네이티브 메서드는 신중히 사용하라
- [x] 67.최적화는 신중히 하라 (2022.01.05)
- [x] 68.일반적으로 통용되는 명명 규칙을 따르라 (2022.01.06)

---
## 에외
- [x] 69.예외는 진짜 에외 상황에서만 사용하라 (2022.01.10)
- [x] 70.복구할 수 있는 상황에는 검사 예외를, 프로그래밍 오류에는 런타임 예외를 사용하라 (2022.01.11)
- [x] 71.필요 없는 검사 예외 사용은 피하라 (2022.01.12)
- [x] 72.표준 예외를 사용하라 (2021.10.27)
- [x] 73.추상화 수준에 맞는 예외를 던져라 (2022.01.18)
- [x] 74.메서드가 던지는 모든 예외를 문서화하라 (2022.01.19)
- [x] 75.예외의 상세 메시지에 싪패 관련 정보를 담으라 (2022.02.03)
- [x] 76.가능한 한 실패 원자적으로 만들라 (2021.10.25)
- [x] 77.예외를 무사하지 말라 (2022.02.03)

---
## 동시성
- [x]  78.공유 중인 가변 데이터는 동기화해서 사용하라 (2020.07.10)
- [ ]  79.과도한 동기화는 피하라
- [ ]  80.Thread보다는 Executor, Task, Stream을 애용하라
- [ ]  81.wait과 notify보다는 java.util.concurrent를 애용하라
- [ ]  82.스레드 안전성 수준을 문서화하라
- [ ]  83.지연 초기화는 신중히 사용하라
- [ ]  84.프로그램의 동작을 스레드 스케줄러에 기대지 말라

---
## 직렬화
- [ ]  85.자바 직렬화의 대안을 찾으라
- [ ]  86.Serializable을 구현할지는 신중히 결정하라
- [ ]  87.커스텀 직렬화 형태를 고려해 보라
- [ ]  88.readObjecft 메서드는 방어적으로 작성하라
- [ ]  89.인스턴스 수를 통제해야 한다면 readResolve보다는 열거타입을 사용하라
- [ ]  90.직렬화된 인스턴스 대신 직렬화 프록시 사용을 검토하라


---

#Generic Class 용어
| 한글 용어 | 영문 용어 | 예시 | 아이템 |
| ------------- | ------------- | ------------- | ------------- |
| 로 타입 | raw type | List | 아이템26 |
| 제네릭 타입 | generic type | List<E> | 아이템26, 29 |
| 제네릭 메서드 | generic method | static <E> List<E> asList(E[] a) | 아이템30 |
| 정규 타입 매개변수 | formal type parameter | E | 아이템26 |
| 매개변수화 타입 | parameterized type | List<String> | 아이템26 |
| 실제 타입 매개변수 | actual type parameter | String | 아이템26 |
| 비한정적 와일드카드 타입 | unbounded wildcard type | List<?> | 아이템26 |
| 한정적 와일드카드 타입 | bounded wildcard type | List<? extends Number> | 아이템31 |
| 한정적 타입 매개변수 | bounded type parameter | <E extends Number> | 아이템29 |
| 재귀적 타입 한정 | recursive type bound | <T extends Comparable<T>> | 아이템30 |
| 타입 토큰 | type token | String.class | 아이템33 |


## References
- [자바 - 제네릭(Generic)의 이해](https://st-lab.tistory.com/153)