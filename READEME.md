# 🎓 Student Example

학생 정보를 배열 또는 리스트로 관리하며, 추가/수정/삭제/조회/정렬 등의 로직을 학습한 Java 콘솔 기반 프로젝트입니다.  
이후, Spring 기반 구조로 리팩토링하여 유지보수성과 확장성을 고려한 마이그레이션 작업을 진행합니다.

---

## 📁 프로젝트 구조
- `Student`: 학생 도메인 객체
- `StudentService`: 학생 정보를 처리하는 비즈니스 로직
- `StudentUtils`: 입력 유틸리티 클래스
- `StudentMain`: 콘솔 기반 UI 및 실행

---

## 📆 2025-04-15 (화)
- Java 프로젝트 생성
- 패키지 구조 설계
- Student 도메인 클래스 생성
- StudentMain 클래스 생성
- StudentService 클래스 생성
- StudentUtils 클래스 생성
- Main 클래스를 통해 콘솔로 Service를 호출하기 학습

## 📆 2025-04-16 (수)
- StudentService, 학생 추가시, 배열의 길이 자동증가 로직 구현
- 학생의 학번,이름, 국어,영어,수학 점수를 입력받고 생성한 객체를 배열에 추가로직 구현
- 배열에 저장된 학생의 학번, 이름, 총점, 평균 점수를 출력하는 로직 구현
- 학번을 입력받고, 배열을 순회한 후, 입력한 학번을 찾아내어 국어, 영어, 수학 점수를 수정하는 로직 구현
- 배열에서 특정 학번의 학생을 삭제하고, 이후 요소를 앞으로 당겨 정렬하는 로직 구현

## 📆 2025-04-17 (목)
- StudentService, 메서드로 분리를 위해 학번으로 배열 탐색하는 로직 분리
- 과목 점수 평균, 총점 기준 정렬 기능을 위한 메서드 추가
- 배열에서 찾을 학생을 삭제 처리하는 로직을 `System.arraycopy()`로 리팩토링
- null 처리 및 불필요한 조건문 제거로 안정성 및 가독성 향상

## 📆 2025-04-18 (금)
- Student, 학번, 이름, 국어,영어,수학, 평균점수, 총점을 출력하는 `toSring()`추가
- main이 호출하는 평균점수 출력 메서드,정렬 메서드 변경
- Service, 초기화 블럭으로 기본값 자동 생성
- 배열 출력기능 메서드 분리, 총점순 정렬 메서드, 평균순 출력 추가
- 학번을 기준으로 배열을 찾는 메서드 추가
- 각 메서드에 학번을 기준으로 유효한 값인지 체크
- 삭제 메서드 삭제추 전체 students배열을 복사하여 재정렬하는 기능 구현

## 📆 2025-04-20 (일)
- 배열의 공간이 부족할경우, 공간을 2배씩 증가시키도록 로직 변경
- 잘못된 값이 입력될 경우 예외처리 로직 추가

## 📆 2025-04-21 (월)
- student, Getter, Setter 추가
- main, 잘못된 메뉴 선택시 예외처리 추가
- service, 기본값에 랜덤한 점수를 생성하는 메서드 생성, 유효값 검증 메서드 분리
- util, 입력후, y,n 으로 입력을 확인하는 메서드 추가

## 📆 2025-04-22 (화)
- 배열로 관리하던 객체를 list로 관리하도록 변경
- `List.copyOf()`를 사용한 불변 복사 방식에서 `addAll()`을 사용하는 가변 복사 방식으로 변경
- 유효값 검증을 정규표현식으로 검증하도록 변경

## 📆 2025-04-23 (목)
- service, 별도의 석차순으로 정렬된 리스트 `sortedStudent` 추가 , 각 입력, 수정, 삭제, 조회에 해당 리스트 추가

## 📆 2025-04-24 (금)
- student, builder 패턴으로 변경, `compareTo()` 메서드를 오버라이드하여, 이름 기준으로 정렬 가능하도록 설정 
- 싱글턴 페턴으로 인스턴스생성, 호출방식 변경
- `Collections.sort()`로 정렬방식 변경

## 📆 2025-05-02 (금)
- student, Serializable implements,
- service, 직렬화후 파일시스템으로 저장하는 `save()`메서드 구현
- 초기화블럭에 저장하는 파일을 불러오는 기능 구현


---

## 🌱 Spring 마이그레이션 계획

### 🎯 마이그레이션 목표
- 기존 콘솔 기반 Java 프로젝트를 Spring 기반 구조로 개선
- MyBatis, HikariCP, MariaDB 연동을 통해 영속성 처리 구조로 전환
- Lombok, Logback 등 최신 라이브러리 도입
- 유지보수 및 확장성을 고려한 계층 구조 설계
- 콘솔 동작을 유지

---

## ⚙️ 기술 스택 (Tech Stack)
### 🔨 개발 환경
- Java 21
- Spring Boot 3.5.3
- IntelliJ IDEA Ultimate
- Gradle
### 🧩 라이브러리 및 프레임워크
- Spring Boot Starter
- Lombok
- MyBatis
- HikariCP
- MariaDB Driver
- SLF4J + Logback


---

## 🗂️ 프로젝트 구조 (Project Structure)
- `domain`: 학생 정보를 나타내는 도메인 객체
- `repository`: DB와 직접 통신하는 계층 (MyBatis Mapper)
- `service`: 비즈니스 로직 처리
- `runner`: 콘솔 기반 실행 로직 (`CommandLineRunner` 활용)
- `config`: DB 및 Mapper 설정 등


## 🔧 마이그레이션 작업 이력 (예정 및 기록용)

### 📆 2025-07-20 (토






## ✅ Spring Boot HikariCP DB 연결 실패 트러블슈팅 기록

### 🧩 문제 요약

Spring Boot 3.5.3 환경에서 `HikariCP`를 통한 MariaDB 연결 테스트 시 `DataSource` 생성에 실패하며 테스트가 중단됨.

---

### 1. ❌ 예외 메시지 확인

```
Caused by: org.springframework.boot.autoconfigure.jdbc.DataSourceProperties$DataSourceBeanCreationException: 
Failed to determine a suitable driver class
```

- `spring.datasource.hikari.jdbc-url` 사용 시 드라이버 자동 유추 실패
- `contextLoads()` 및 `@SpringBootTest` 환경에서 `IllegalStateException` 발생

---

### 2. 🔎 다른 DB 접속 도구로 확인

- **DBeaver** 및 **IntelliJ Database Tool** 등에서는 동일 DB 설정으로 정상 접속 확인
- 즉, DB 자체 문제나 방화벽 문제는 아님 → 설정 문제에 집중

---

### 3. 🔁 작동하는 프로젝트와의 비교

- 기존에 정상 작동하던 Spring Boot 2.7.18 기반 프로젝트와 비교
- 같은 AWS MariaDB 서버를 사용하고 있음에도 2.7.18에서는 정상 작동
- build.gradle, application.yml 비교를 통해 설정 차이 분석

---

### 4. ⚠️ Spring Boot 2.x ↔ 3.x 설정 차이 확인

| 항목 | Spring Boot 2.x | Spring Boot 3.x |
|------|------------------|------------------|
| DB URL 설정 키 | ✅ `spring.datasource.hikari.jdbc-url` | ⚠️ **`spring.datasource.url` 필요** |
| 드라이버 유추 | 자동 유추 가능 | 유추 실패 → 명시적 지정 필요 |

**정확한 설정 예시 (Spring Boot 3.x 기준)**:

```yaml
spring:
  datasource:
    url: jdbc:mariadb://np.dev-lumi.com:3306/student
    username: student
    password: 1234
    driver-class-name: org.mariadb.jdbc.Driver
    hikari:
      pool-name: HikariCP
```

> 🔐 주의: `spring.datasource.url`은 `spring.datasource.hikari.jdbc-url`보다 우선 순위를 가짐

---

### 5. ✅ 해결

- `spring.datasource.hikari.jdbc-url` → `spring.datasource.url` 로 변경
- `driver-class-name` 명시
- 위 설정 후 테스트 통과 및 애플리케이션 정상 구동 확인

```bash
./gradlew clean build
```

---

### 📌 참고사항

- 향후 Spring Boot 3.x 환경에서는 datasource 설정 시 반드시 공식 문서를 기준으로 할 것  
  [📚 Spring Boot Docs - Data Access](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.data)
