# 🛫 가자 GAZA
삼성 청년 SW 아카데미 8기 공통 PJT : 웹기술
(2023.01.09 ~ 2023.02.17)
<br><br>
## 주제 및 목표
webRTC, webSocket 기술을 사용하여 가이드와 관광객이 화상으로 여행 일정에 대한 상담을 진행할 수 있는 서비스 구현
<br><br>
## 주요기능
    - 가이드와의 상담을 위한 예약.
    - openvidu를 사용한 화상 상담.
        - 소켓을 활용한 지도 공유.
        - Redis pub/sub를 활용한 채팅.
        - 여행 일정을 엑셀로 다운로드.
<br><br>
## 개발 환경 및 도구
| 종류 | 개발 환경 및 사용툴 |
| --- | --- |
| 언어 | Java11 |
| Framework | Springboot I Vue3&Vue2 I Swagger2 |
| 서버 | AWS EC2  I Ubuntu 20.04 I Docker 23.0.0 I AWS S3 |
| DB | MySQL 8.0.30 |
| 외부서비스 | Kakao MAP |

<br><br>
## 팀 구성
| 이름 | 역할 |
| --- | --- |
| 이도연 | 팀장 I 백엔드 |
| 팀원1 | 백엔드 |
| 팀원2 | 백엔드 |
| 팀원3 | 프론트엔드 |
| 팀원4 | 프론트엔드 I DevOps |

<br><br>
## 서비스 아키텍처
![가자_아키텍처_구성도](/uploads/b0907f1b80d6da178d6a4d2729180591/아키텍처_구성도.png)
<br><br>
## 대표 이미지
### 메인
![01_메인페이지(비회원)](https://user-images.githubusercontent.com/44861724/221076088-efab2947-626f-4910-a5b4-4d593f57016d.PNG)
<br>
### 예약
![03_예약페이지UI](https://user-images.githubusercontent.com/44861724/221076115-80f15eb2-7417-4bab-b9c9-b10faba413f4.PNG)
<br>
### 
![화상상담](https://user-images.githubusercontent.com/44861724/221076187-824f2516-caab-4e83-9037-a80430cd5ba7.PNG)

