# Spring-TDD-Practice

[![Build Status](https://travis-ci.com/Spring-Boot-Course/Spring-TDD-Practice.svg?branch=master)](https://travis-ci.com/Spring-Boot-Course/Spring-TDD-Practice)
[![Coverage Status](https://coveralls.io/repos/github/Spring-Boot-Course/Spring-TDD-Practice/badge.svg?branch=master)](https://coveralls.io/github/Spring-Boot-Course/Spring-TDD-Practice?branch=master)

### 통합테스트

코드
```java
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc   // MockMvc를 주입받기 위해 필요
@Transactional  // 트랜잭션을 걸어서 롤백을 해줌
public class BoardApiTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    ...
}
```

목적
* 실제 스프링 동작과 동일하게 테스트
* API 테스트 시 요청부터 응답까지 전체 테스트

장점
* 실제 운영환경과 가장 유사하게 테스트

단점
* 모든 빈이 테스트 동작 시 등록되기 때문에, 무겁고 느림
* 테스트 단위가 커서 디버깅에 어려움이 있음

### MockApi 테스트

코드
```java
@RunWith(SpringRunner.class)
@WebMvcTest(value = BoardApi.class)
public class BoardMockApiTest {
    
    @MockBean
    private BoardService boardService;
    
    ...
}
```

목적
* Controller(API)에 대한 기능 검증
* Rollback(Transactional에 의한) 처리가 어려운 경우 Mocking을 통해 기능 검증 가능

장점
* MVC 동작에 필요한 부분만 빈으로 등록되기 때문에 통합테스트에 비해 가벼움

단점
* Mocking을 통해 테스트를 진행하기 떄문에 통합테스트에 비해 실제 운영환경과 유사하지 못