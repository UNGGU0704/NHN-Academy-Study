# JavaScript (23. 12. 11)

## JS란?

- HTML 상에서 쓸 수 있는 언어
- JAVA와 다르다.
- 기본적인 JS 함수
    
    function hello(){
         console.log('Hello!');
    }
    

## JS 기초 문법

### 자료형과 변수

- 변수
let num = 10 
num = 20 // 값 변경 
let 은 실수도 가능
- 문자열
문자열 또한 let으로 통일
let mac = “MacBook Air M2”
- 리스트와 딕셔너리

```jsx
let a_list =[]
//

let b_list = [1,2,'hey',3]

let c_list = a_list.concat(b_list) // 리스트 합치기 
a_list.push(b_list) // 리스트 합치기

/*
 * 딕셔너리
 */

let a_dict = {}

let b_dict = {'name' : 'Bob', 'age':21}
	// key와 value를 가짐
```

### 함수

- 함수 만들고 사용하기

```jsx
// 두 숫자를 입력받으면 더한 결과를 돌려주는 함수
function sum(num1, num2) {
    let result = num1 + num2
	  console.log(num1, "+", num2, "=", result)    // 콘솔에 출력
	  return result                                // 반환값
}

sum(3, 5)
// 3 + 5 = 8
//
```

## JS 연습

### Q1. 1부터 n까지의 합을 구하는 함수

```jsx
let n = 10

let sum = 10
for(let i = 0; i < n; i++){
	sum += i
}

console.log(sum)
```

### Q2. 미세먼지(IDEX_MVL)의 값이 40 미만인 구 이름(MSRSTE_NM)과 값을 출력하기

- 데이터
    
    ```jsx
    **let mise_list = [
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "도심권",
        MSRSTE_NM: "중구",
        PM10: 22,
        PM25: 14,
        O3: 0.018,
        NO2: 0.015,
        CO: 0.4,
        SO2: 0.002,
        IDEX_NM: "좋음",
        IDEX_MVL: 31,
        ARPLT_MAIN: "O3",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "도심권",
        MSRSTE_NM: "종로구",
        PM10: 24,
        PM25: 18,
        O3: 0.013,
        NO2: 0.016,
        CO: 0.4,
        SO2: 0.003,
        IDEX_NM: "좋음",
        IDEX_MVL: 39,
        ARPLT_MAIN: "PM25",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "도심권",
        MSRSTE_NM: "용산구",
        PM10: 0,
        PM25: 15,
        O3: 0.012,
        NO2: 0.027,
        CO: 0.4,
        SO2: 0.003,
        IDEX_NM: "점검중",
        IDEX_MVL: -99,
        ARPLT_MAIN: "점검중",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "서북권",
        MSRSTE_NM: "은평구",
        PM10: 36,
        PM25: 14,
        O3: 0.019,
        NO2: 0.018,
        CO: 0.5,
        SO2: 0.005,
        IDEX_NM: "좋음",
        IDEX_MVL: 42,
        ARPLT_MAIN: "PM10",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "서북권",
        MSRSTE_NM: "서대문구",
        PM10: 28,
        PM25: 9,
        O3: 0.018,
        NO2: 0.015,
        CO: 0.6,
        SO2: 0.004,
        IDEX_NM: "좋음",
        IDEX_MVL: 37,
        ARPLT_MAIN: "PM10",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "서북권",
        MSRSTE_NM: "마포구",
        PM10: 26,
        PM25: 8,
        O3: 0.012,
        NO2: 0.021,
        CO: 0.5,
        SO2: 0.003,
        IDEX_NM: "좋음",
        IDEX_MVL: 36,
        ARPLT_MAIN: "NO2",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "동북권",
        MSRSTE_NM: "광진구",
        PM10: 17,
        PM25: 9,
        O3: 0.018,
        NO2: 0.016,
        CO: 0.6,
        SO2: 0.001,
        IDEX_NM: "좋음",
        IDEX_MVL: 31,
        ARPLT_MAIN: "O3",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "동북권",
        MSRSTE_NM: "성동구",
        PM10: 21,
        PM25: 12,
        O3: 0.018,
        NO2: 0.017,
        CO: 0.4,
        SO2: 0.003,
        IDEX_NM: "좋음",
        IDEX_MVL: 33,
        ARPLT_MAIN: "PM25",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "동북권",
        MSRSTE_NM: "중랑구",
        PM10: 27,
        PM25: 10,
        O3: 0.015,
        NO2: 0.019,
        CO: 0.4,
        SO2: 0.003,
        IDEX_NM: "좋음",
        IDEX_MVL: 34,
        ARPLT_MAIN: "PM10",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "동북권",
        MSRSTE_NM: "동대문구",
        PM10: 26,
        PM25: 9,
        O3: 0.016,
        NO2: 0.017,
        CO: 0.4,
        SO2: 0.003,
        IDEX_NM: "좋음",
        IDEX_MVL: 34,
        ARPLT_MAIN: "PM10",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "동북권",
        MSRSTE_NM: "성북구",
        PM10: 27,
        PM25: 8,
        O3: 0.022,
        NO2: 0.014,
        CO: 0.5,
        SO2: 0.003,
        IDEX_NM: "좋음",
        IDEX_MVL: 37,
        ARPLT_MAIN: "PM10",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "동북권",
        MSRSTE_NM: "도봉구",
        PM10: 25,
        PM25: 12,
        O3: 0.024,
        NO2: 0.011,
        CO: 0.3,
        SO2: 0.002,
        IDEX_NM: "좋음",
        IDEX_MVL: 41,
        ARPLT_MAIN: "O3",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "동북권",
        MSRSTE_NM: "강북구",
        PM10: 30,
        PM25: 15,
        O3: 0.022,
        NO2: 0.02,
        CO: 0.4,
        SO2: 0.002,
        IDEX_NM: "좋음",
        IDEX_MVL: 39,
        ARPLT_MAIN: "PM10",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "동북권",
        MSRSTE_NM: "노원구",
        PM10: 21,
        PM25: 14,
        O3: 0.017,
        NO2: 0.016,
        CO: 0.4,
        SO2: 0.004,
        IDEX_NM: "좋음",
        IDEX_MVL: 36,
        ARPLT_MAIN: "PM25",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "서남권",
        MSRSTE_NM: "강서구",
        PM10: 36,
        PM25: 16,
        O3: 0.021,
        NO2: 0.013,
        CO: 0.4,
        SO2: 0.004,
        IDEX_NM: "좋음",
        IDEX_MVL: 42,
        ARPLT_MAIN: "PM10",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "서남권",
        MSRSTE_NM: "구로구",
        PM10: 23,
        PM25: 10,
        O3: 0.022,
        NO2: 0.016,
        CO: 0.3,
        SO2: 0.003,
        IDEX_NM: "좋음",
        IDEX_MVL: 37,
        ARPLT_MAIN: "O3",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "서남권",
        MSRSTE_NM: "영등포구",
        PM10: 29,
        PM25: 15,
        O3: 0.01,
        NO2: 0.022,
        CO: 0.4,
        SO2: 0.003,
        IDEX_NM: "좋음",
        IDEX_MVL: 41,
        ARPLT_MAIN: "PM10",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "서남권",
        MSRSTE_NM: "동작구",
        PM10: 29,
        PM25: 15,
        O3: 0.012,
        NO2: 0.023,
        CO: 0.4,
        SO2: 0.003,
        IDEX_NM: "좋음",
        IDEX_MVL: 41,
        ARPLT_MAIN: "PM10",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "서남권",
        MSRSTE_NM: "관악구",
        PM10: 27,
        PM25: 12,
        O3: 0.012,
        NO2: 0.022,
        CO: 0.4,
        SO2: 0.003,
        IDEX_NM: "좋음",
        IDEX_MVL: 37,
        ARPLT_MAIN: "NO2",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "서남권",
        MSRSTE_NM: "금천구",
        PM10: 25,
        PM25: 15,
        O3: 0.015,
        NO2: 0.02,
        CO: 0.4,
        SO2: 0.004,
        IDEX_NM: "좋음",
        IDEX_MVL: 43,
        ARPLT_MAIN: "PM25",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "서남권",
        MSRSTE_NM: "양천구",
        PM10: 0,
        PM25: 14,
        O3: 0.016,
        NO2: 0.017,
        CO: 0.4,
        SO2: 0.003,
        IDEX_NM: "점검중",
        IDEX_MVL: -99,
        ARPLT_MAIN: "점검중",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "동남권",
        MSRSTE_NM: "강남구",
        PM10: 31,
        PM25: 16,
        O3: 0.018,
        NO2: 0.018,
        CO: 0.4,
        SO2: 0.003,
        IDEX_NM: "좋음",
        IDEX_MVL: 39,
        ARPLT_MAIN: "PM10",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "동남권",
        MSRSTE_NM: "서초구",
        PM10: 34,
        PM25: 13,
        O3: 0.024,
        NO2: 0.019,
        CO: 0.3,
        SO2: 0.003,
        IDEX_NM: "좋음",
        IDEX_MVL: 41,
        ARPLT_MAIN: "PM10",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "동남권",
        MSRSTE_NM: "송파구",
        PM10: 25,
        PM25: 6,
        O3: 0.014,
        NO2: 0.025,
        CO: 0.4,
        SO2: 0.003,
        IDEX_NM: "좋음",
        IDEX_MVL: 42,
        ARPLT_MAIN: "NO2",
      },
      {
        MSRDT: "201912052100",
        MSRRGN_NM: "동남권",
        MSRSTE_NM: "강동구",
        PM10: 24,
        PM25: 14,
        O3: 0.016,
        NO2: 0.02,
        CO: 0.4,
        SO2: 0.002,
        IDEX_NM: "좋음",
        IDEX_MVL: 39,
        ARPLT_MAIN: "PM25",
      },
    ];**
    ```
    

```jsx
for(let i = 0; i < mise_list.length; i++){
		if(mise_list[i]['IDEX_MVL') < 40){
				System.log(mise_list[i]['MSRSTE_NM']);
		}
}
```

## jQuery

### jQuery란?

- JS로 이뤄진 코드를 미리 모아둔것
- 자바의 라이브러리와 비슷함
- import를 해줘야함
- `element`란 id를 가진 요소를 감춰야함

`document.getElementById("element").style.display = "none";`
를 JQ로 바꾸면
`$('#element').hide();`
- JQ 사용하기
특정 요소를 가르켜야 사용 가능 CSS에서는 class를 사용하듯이 JQ는 id를 사용저
    1. 정보 가져오기
    $`<input id = “post-url”>` 항목 추가 
    
    `let url - $(’#post-url’).val();
    url`
    id 값을 찾아 그 값을 받아오는 방식 
    
    `$(’#post-url’).val(”값을 넣는다”);`
    이러면 값을 넣음
    2. div 숨기기 / 보이기 
    
    ```jsx
    <div class="posting-box" id="post-box">
        ...
    </div>
    ```
    
    ```jsx
    // id 값이 post-box인 곳을 가리키고, hide()로 안보이게 한다.(=css의 display 값을 none으로 바꾼다)
    $('#post-box').hide();
    
    // show()로 보이게 한다.(=css의 display 값을 block으로 바꾼다)
    $('#post-box').show();
    ```
    
    1. 태그 추가하기 
    
    ```jsx
    <div id = "cards-box" class="card-columns">
    // div 구성 요소 하위 생략 
    ```
    
    ```jsx
    $('#cards-box').append("추가 텍스트");
    ```
    
    ```jsx
    // 버튼 추가 
    let temp_html = `<button>추가 버튼</button>`;
    $('#cards-box').append(temp_html);
    ```
