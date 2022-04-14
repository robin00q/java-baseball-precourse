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
- [ ] 플레이어 도메인 구현 
- [ ] 게임결과 도메인 구현
- [ ] 게임 도메인 구현
### 2.2. 서비스 구현
- [ ] 3 스트라이크인 경우, 결과 반환하는 서비스 구현
- [ ] 3 스트라이크가 아닌 경우, 결과 반환하는 서비스 구현
### 2.3. 컨트롤러 구현
- [ ] input 요청 (I/O) 을 처리하는 컨트롤러 구현
- [ ] output 요청 (I/O) 을 처리하는 컨트롤러 구현