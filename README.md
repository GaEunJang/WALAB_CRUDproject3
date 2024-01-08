# 의류 관리 시스템 + Sqlite

이 프로젝트는 [WALAB_CRUDproject1](https://github.com/GaEunJang/WALAB_CRUDproject1)에 DB 연결을 통해 데이터 관리기능을 추가한 확장 버전입니다. 데이터는 SQLite 데이터베이스에 저장되며, 이 시스템은 데이터베이스 관리와 사용자 인터페이스 간의 상호작용을 제공합니다.  

## 클래스 
- **org.example.Main**: 프로그램의 진입점, 사용자 인터페이스(UI) 제공.
- **org.example.DataManager**: 사용자로부터 입력받은 데이터를 처리하는 클래스.
- **org.example.SQLiteManager**: SQLite 데이터베이스 연결 관리.
- **org.example.DDLService**: 데이터베이스 테이블 생성 및 관리.
- **org.example.DMLService**: 데이터 삽입, 업데이트, 삭제를 담당.
- **org.example.DQLService**: 데이터 조회 및 검색 기능 제공.
- **org.example.ClothingData**: 의류 데이터를 표현하는 모델 클래스.

## 사용된 라이브러리
- SQLite JDBC: 데이터베이스 연결 및 관리.
  
## S1lite 쿼리
- 테이블명: `clothing`
- 칼럼 이름(타입):
  - `id` (INTEGER): 고유 식별자, Primary Key.
  - `type` (VARCHAR): 의류 종류 (예: 아우터, 상의, 하의).
  - `name` (VARCHAR): 의류 이름.
  - `price` (INTEGER): 의류 가격.
  - `description` (TEXT): 의류에 대한 설명.
 
## 스크린샷
<img width="250" src="https://github.com/GaEunJang/WALAB_CRUDproject3/assets/103119924/f9e05964-7940-44ca-83fc-f65d0502ef56.png"><br>
<img width="300" height="150" src="https://github.com/GaEunJang/WALAB_CRUDproject3/assets/103119924/039fb320-deb0-4b18-8928-e0309f1e0fde.png"><br>
<img width="250" src="https://github.com/GaEunJang/WALAB_CRUDproject3/assets/103119924/6edada11-1fec-4b88-a3b1-3a8646c03ba3.png"><br>
<img width="250" src="https://github.com/GaEunJang/WALAB_CRUDproject3/assets/103119924/0539452f-acf0-4ef7-b53a-f447e2522e60.png"><br>
<img width="250" src="https://github.com/GaEunJang/WALAB_CRUDproject3/assets/103119924/e6af801d-b9aa-46bf-b82c-483c84a98245.png"><br>
<img width="300" height="150" src="https://github.com/GaEunJang/WALAB_CRUDproject3/assets/103119924/b3c39502-6ea5-4786-b5af-8ceb4bc266f9.png"><br>
<img width="250" src="https://github.com/GaEunJang/WALAB_CRUDproject3/assets/103119924/3cbd4da5-1893-4234-a143-9c974383fd26.png"><br>
<img width="250" src="https://github.com/GaEunJang/WALAB_CRUDproject3/assets/103119924/75712b5c-897f-47c5-9e8c-c26efe19b413.png"><br>
<img width="300" height="150" src="https://github.com/GaEunJang/WALAB_CRUDproject3/assets/103119924/64d85e1f-e4d6-4bb1-bb6f-7c88d492f608.png"><br>
<img width="300" src="https://github.com/GaEunJang/WALAB_CRUDproject3/assets/103119924/8f921e19-38ae-4865-9971-9c64e7c57126.png"><br>
<img width="300" src="https://github.com/GaEunJang/WALAB_CRUDproject3/assets/103119924/5da9532e-6ae2-4dea-907f-dd7da01045ed.png"><br>
