# 숫자 야구 게임
## 1. Event Storming 을 통한 기능 목록 작성
```
파란색 : command or action
주황색 : event
노란색 : domain
빨간색 : external system
```
### Event Storming
![img.png](png/event_storming.png)
### Diagram
![img_1.png](png/diagram.png)

## 2. 기능 구현 목록
### 2.1. 도메인 구현
- [x] 야구공 도메인 구현
- [x] 숫자 생성기 도메인 구현
- [x] 컴퓨터 도메인 구현
- [x] 플레이어 도메인 구현 
- [x] 게임결과 도메인 구현
- [x] 스트라이크, 볼을 판단하는 로직 구현
### 2.2. 서비스 구현
- [x] 컴퓨터와 플레이어가 게임한 뒤, 스트라이크/볼을 판단하는 로직 구현
- [x] 컴퓨터가 랜덤한 숫자를 요청하는 로직 구현
- [x] 재시도 처리 구현
- [x] input 검증로직 구현

## 3. 계층 간 의존성
- 야구게임 도메인과 랜덤 생성 도메인은 서로 다른 라이프사이클을 가지므로, 이를 분리한다.
- infra -> service -> domain 의 의존성을 지켜야하며, 역방향은 존재해서는 안된다.

![img.png](png/layer_dependency_graph.png)

## 4. 야구게임 도메인 내에서, 클래스간의 순환참조가 없도록 구현
- GameResult -> Baseballs -> Baseball 객체간의 역방향의 참조는 없도록 구현한다.

![img.png](png/baseball_domain_object_reference_graph.png)