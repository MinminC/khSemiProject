# Cinema-heaven : reservation system

## Concept
- 투표를 통해 다음에 재개봉할 영화가 선정되고, 회원 가입 시 입력한 장르를 기반으로 영화를 추천하는 사이트.

## My Part

- 사용자 : 영화
    - 현재 상영작 : 영화이름, 포스터, 예매율을 '예매율' 순으로 정렬 및 페이징
    - 추천 상영작 : 원하는 장르들을 선택하여 AJAX방식 목록 조회. 기본 선택은 로그인 시 DB 정보, 미로그인 시 랜덤 1개.
    - 영화 상세 : 영화의 상세 정보를 조회. 영화 '좋아요' 버튼 클릭 시 하트에 불이 들어오고 카운트 증가. 다시 누르면 해제.
    - 영화 리뷰 : 리뷰 등록, 수정, 삭제, 신고, 좋아요. AJAX 활용한 펼쳐보기(5개씩 증가).
- 사용자 : 고객센터 FAQ, 공지사항
    - 공지사항 목록 : 상단 중요 공지 고정. 페이징. 검색(제목/내용)
    - 공지사항 상세 : 상세 조회, 다음글, 이전글, 목록 이동
    - FAQ 목록 : 조회(분류별), CCS(아코디언 방식).
-  관리자 : 영화
    - 영화 목록 : 등록/수정/삭제(체크박스로 다중 선택 가능)/검색
    - 영화 등록(추가설명) : multipart/form-data. 상영관-상영시각, 배우 임시테이블로 관리. 임시테이블은 순서변경/삭제 가능. 등록 버튼을 누르면 페이지의 전체 내용을 각 영화, 이미지, 상영일정 테이블에 전송.
    - 리뷰 신고 : 사용자의 신고를 처리(리뷰 삭제)/보류
 - 관리자 : 공지사항/FAQ
    - 등록, 수정, 삭제, 검색(제목/내용). 글 작성은 SmartEditor2 API 활용



## Presentation
<div align=center>
<img src=https://github.com/MinminC/khSemiProject/blob/main/ppt/cinema-heaven.gif?raw=true">
</div>
                                                                                           
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0001.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0002.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0003.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0004.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0005.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0006.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0007.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0008.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0009.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0010.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0011.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0012.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0013.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0014.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0015.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0016.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0017.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0018.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0019.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0020.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0021.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0022.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0023.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0024.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0025.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0026.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0027.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0030.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0031.jpg)
![Preview](https://raw.githubusercontent.com/MinminC/khSemiProject/main/ppt/cinema_heaven_0032.jpg)
