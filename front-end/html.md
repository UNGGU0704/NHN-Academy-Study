# HTML(23. 11. 21)

## HTML 이란?

- 요소로 구성
- 컨텐츠의 여러 부분을 감싸고 있음
- Tags를 활용
    
    `<p> 안녕하세요 </p>`
    

### 여는 태그 `<`

→ 요소의 효과적용을 연다.

### 닫는 태그 `>`

→ 요소를 종료 

### lnline Tag

- 자신의 내용과 앞뒤 태그의 내용을 같은 라인에 출력하는 태그
- 대표적인 tag는 `<span></span>`
- **반드시 알아야할 테그**
    
    ```html
    <span>, <a>, <br> ,<button>,<img>,<input>,<select>,<textarea>,<label>,<strong>
    ```
    

### Block Tag

- 자신의 내용과 앞뒤 태그의 내용을 다른 라인에 출력하는 태그(즉 좌우 너비가 100%)
- 주로 구조를 만들 때 사용
- 대표적인 tag는 `<div></div>`
- 다만 `<p>` 태그는 내부에는 인라인 요소만 표현할 수 있습니다.
- **반드시 알아야할 테그**
    
    ```html
    <form>, <ul>, <p>, <table>, <div>,<address>
    <h1>,<h2>, <h3>, <h4>, <h5>, <h6>
    ```
    

### Sematic tags

- 의미 없는 `<div>` 태그의 사용보다 문서의 내용을 쉽게 이해할 수 있도록 의미를 가지는 새로운 태그요소
    
    
    | Tag명 | 설명 |
    | --- | --- |
    | main | 문서의 주요 콘텐츠를 포함, 문서 내에 단 하나만 존재 |
    | header | 문서 소개나 탐색을 돕는 요소들의 그룹 |
    | nav | 현재 페이지 내, 또는 다른 페이지로의 링크 |
    | aside | 주요 내용과 간접적으로만 연관된 부분 |
    | section | 문서의 일반적인 구획, 여러 줌심 내용을 감싸는 공간 |
    | footer | 문서의 아래쪽 작성자 구획, 저작권 데이터, 관련된 문서의 링크에 대한 정보 |
    | figure | 문서의 멀티미디어 요소 |
    | article | 글자가 많이 들어가는 부분(그 자체로 독립적으로 구분되거나 재사용 가능한 영역) |

---

## HTML Text

### 제목과 단락

- 대부분 구조화된 텍스트는 제목과 단락으로 구성
- HTML에서 각 단락은 `<p>` 요소
    
    ```html
    <p lang="en">On May 1, barely siz months after the midterm elections, Donald Trump appears to have abandoned the White House and abdicated his role as president.</p>
    <p lang="ko">중간선거가 끝난 지 겨우 6개월 만인 5월 1일 도널드 트럼프는 백악관을 포기하고 대통령직을 사임한 것으로 보인다.</p>
    ```
    
- 각 제목은 heading 요소 h1 ~ h6
    - `<h1>`
    - `<h2>`
    - `<h3>`
    - `<h4>`
    - `<h5>`
    - `<h6>`
    
    ```html
    <h1>h1 : 위기의 종식, 트럼프, 서둘러 백악관 출발!</h1> <-- 제일 크다 -->
    <h2>h2 : 위기의 종식, 트럼프, 서둘러 백악관 출발!</h2>
    <h3>h3 : 위기의 종식, 트럼프, 서둘러 백악관 출발!</h3>
    <h4>h4 : 위기의 종식, 트럼프, 서둘러 백악관 출발!</h4>
    <h5>h5 : 위기의 종식, 트럼프, 서둘러 백악관 출발!</h5>
    <h6>h6 : 위기의 종식, 트럼프, 서둘러 백악관 출발!</h6> <-- 제일 작다 -->
    ```
    

### List

- 계층구조(목록)을 표현
- 순서 없는 목록 : <ul>, <li>
    
    ```html
    <ul>
        <li>우유</li>
        <li>계란</li>
        <li>빵</li>
        <li>후무스(중동의 김치)</li>
        <li>베이컨</li>
    </ul>
    ```
    
- 순서 있는 목록(Ordered) : <ol>, <li>
    
    ```html
    <ol>
        <li>Avatar</li>
        <li>Avengers: Endgame</li>
        <li>Titanic</li>
        <li>Starwars: Force Awaken</li>
        <li>Avengers: Infinity War</li>
    </ol>
    ```
    

### **중요(Emphasis)와 강조(Strong importance)**

- `<string>` `<b>`
    - <strong> 요소는 콘텐츠 자체의 중요성을 강조할 때 사용됨
    - <b> tag는 콘텐츠의 중요성 보다는 텍스트 자체에 주의를 끌기 위해서 사용됨

### Code를 나타낼 때

- <code> : 일반적인 컴퓨터 코드를 나타냄

### 시간과 날짜 표시

- 기계가 읽을 수 있는 명확한 시간/날짜 첨부
- 기본 문법
    - YYYY : 2022 / 년
    - MM : 09 / 월
    - DD : 22 / 일
    - hh : 19 / 시
    - mm : 06 / 분
    - ss : 15 / 초

### Hyperlink

- HTML 파일, 텍스트 파일, 이미지, 문서, 비디오와 오디오 파일 등 웹 상에 존재할 수 있는 모든 것을 연결

```html
<a href="링크할 주소">텍스트 또는 이미지</a>
```

### **URL 과 Path**

- URL(Unified Resource Locator) : 웹 상의 어디에 위치하는지 결정하는 텍스트 문자열
- Path
    - 같은 디렉터리(폴더):파일의 이름만 지정
    - 하위 디렉터리 : 디렉터리 이름 + " / " + 파일 이름
    - 부모 디렉터리 : "../" + 파일 이름
    - 홈 디렉터리 : "~/" + 파일 이름

### 공백과 \n을 표시할려면?

- `<br/>`
    - new line
- `&nbsp;`

---

### DOCTYPE

- 브라우저가 문서를 해석 하는 방법 정의
- **DOCTYPE을 생략한다면?**
    - 브라우저는 쿼크 모드 ( Quirks Mode )로 페이지를 렌더링 함
    - 쿼크 모드에서는 이전 세대의 브라우저에 맞는 비표준적 방법의 CSS를 적용
    - 쿼크 모드는 브라우저마다 렌더링 방식이 다름
    - **결과적으로 크로스 브라우징 문제 발생**

### **image 삽입**

**img 태그를 사용하여 페이지에 이미지 삽입**

```html
<p><img src="이미지 파일 경로" alt="대체용 텍스트" /></p>
<p><img src="https://i.pinimg.com/474x/cb/da/73/cbda73c4e8117c1e7154986ec2198569.jpg" alt="랜디 로즈" /></p>
```

- width(넓이) 속성과 height(높이) 속성 사용
    
    ```html
    <img src="/randyrhoads.jpg" height="200" width="50%">
    ```
  
---

## Character

### 아스키

- 영문 알파벳을 사용하는 대표적인 문자 인코딩
- 7bit 인코딩
- 128개의 문자열로 이루어져 있음
    - 영문 : 52
    - 숫자:10
    - 특수문자:32
    - 제어문자 : 33
    - 000 0000 ~ 111 1111
- [https://ko.wikipedia.org/wiki/ASCII](https://ko.wikipedia.org/wiki/ASCII)
- 한글은 표현 불가능..

### EUC - KR

- 한글 완성형 인코딩
- 8bit 문자 인코딩
- [https://uic.io/ko/charset/show/euc-kr/](https://uic.io/ko/charset/show/euc-kr/)
- **한글, 영어 사용하는 페이지에 적합**
- 한글은 2byte를 사용하는 문자 집합
    - 16bit
    - 1 + 초성(5bit) + 중성(5bit) + 종성(5bit)

### UTF - 8

- 전세계의 모든 문자열을 하나의 코드표로 통합
- 한 문자를 저장하기 위해서 최소 1byte에서 최대 4byte 까지 동적으로 사용합니다.
    - 조합형
        - 한글의 제작 원리에 기반하여 초성, 중성, 종성에 각각 코드를 할당하는 방식
    - 완성형
        - '가','나','다’와 같이 완성형 문자열에 코드를 할당하는 방식
        - 한글 표준안
- emoji
    - 일본의 휴대폰 문자 메시지에서 시작된 그림문자.
