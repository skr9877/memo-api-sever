메모 api 서버

#0. 테이블 구조
- 컬럼명
MEMO_ID,
CONTENTS,
CREATE_TIME,
TITLE,
UPDATE_TIME,
USER_ID,
USER_NAME

- 인덱스
PK : MEMO_ID
INDEX : (USER_ID, CREATE_TIME)

#1. API 목록

전체리스트 : GET /memo/



메모장 조회 : GET /memo/{memo_id}



저장 : POST /memo/



수정 : PUT /memo/{memo_id}



삭제 : DELETE / memo/{memo_id}




#2. 사용법

1. 하기 두 옵션으로 DDL 및 샘플 데이터 create



spring.jpa.hibernate.ddl-auto=create



ApplicationRunnerImpl 클래스




2. DDL 및 데이터 생성 후



spring.jpa.hibernate.ddl-auto=validate



ApplicationRunnerImpl 클래스 @Component 제거 혹은 클래스 삭제
