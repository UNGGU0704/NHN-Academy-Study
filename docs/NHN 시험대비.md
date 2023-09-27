## 전산 기초

> 
> 
> - 문제 푸는 방법, recursion으로 설계한 해법을 induction으로 증명하듯이 Test 코드 구조를 설계하는 방법으로 recursion은 아주 쓸모가 많음
>     - test-first programming
>     - fibonacci,factorial 같은 모두가 한 번씩은 다 만들어 본 recursion(induction)은 어떻게 induction 구조로 Testing하는가. 그게 왜 좋지?
>         - Procedure의 pre/post condition은 왜 필요하지? argument/return value의 type과는 무슨 관계가 있지?
>     - Process Visualization
>         - Procedure(Code)를 돌려보면 계산 과정(process)이 어떤 모양으로 펼쳐지는가.
>         - procedure vs process: call stack
>         - process 전개되는 지를 보고 order of growth
>         - linear process, tree process
>     - while, for 같은 iterative control structure처럼 되풀이 계산을 표현하는 수단으로 recursion을 익히는 것은 기술 대중이 즐겨 쓰는 Java를 비롯한 대부분의 프로그래밍 언어에서 거의 쓸모없음.
> - method = function = procedure = named closure = (code, enviroment) = (code, a tree-structured set of frames)

- fibonacci,factorial 같은 모두가 한 번씩은 다 만들어 본 recursion(induction)은 어떻게 induction 구조로 Testing하는가. 그게 왜 좋지?

**A.**
    
    **재귀 함수의 코드가 복잡해진다면 일일히 확인하는것은 불가능, 즉 수학적 귀납법을 이용해 정확성을 증명할 필요가 있음** 
    
    1. **p(1)이 참이면  base case**
    2. **p(n)이 참이면 p(n+1)도 참이다.**
    3. **1, 2 모두 만족하면 모든 자연수 n에 대해 참이다.**

- Procedure의 pre/post condition은 왜 필요하지? argument/return value의 type과는 무슨 관계가 있지?

**A.**

**메소드의 명세에서 말하는 전제 조건은 requires 키워드로 표시됨 프로시저를 호출하는 쪽에게 부여되는 의무 메소드 호출을 위한 상태에 대한 조건**

**클라이언트와 구현자 사이의 명확한 의사통을 가능하게 하며 소프트웨어의 품질과 안전성의 향상을 추구** 

**사후 조건 같은 경우 effect 키워드로 표시, 메서드를 구현하는 개발자의 의무 즉, 메서드 호출 후에 충족되어야 하는 조건** 

**일반적으로 Java는 `@param` 을 전제조건으로 주로 매개변수 인자(argument)와 관련된 전제조건을 적음 
*ex) 전제조건은 정수인데 인자를 실수나 문자열임*
사후조건은 `@return` , `@throws` 로 각각 반환 결과와 예상되는 예외를 적음 
return value의 타입 또한 예상한 타입과 일치해야함** 

- Process Visualization
    - Procedure(Code)를 돌려보면 계산 과정(process)이 어떤 모양으로 펼쳐지는가.
    - procedure vs process: call stack
    - process 전개되는 지를 보고 order of growth
    - linear process, tree process
    
    A. 
    **프로세스 : 메모리에 적재되어 프로세서에 의해 실행중인 프로그램** 
    
    **프로시저 : 로직을 처리하기만 하고 그 결과 값은 반환하지 않은 서브 프로그램, 데이터 조작에서 사용** 
    
    **Call Stack : 작업공간 , 호출되면 Call Stack에 메모리를 할당 종료하면 반환** 
    
    
    ```jsx
    class CallStackTest {
    	public staic void main(String[] args) {
        	firstMethod();
        }
        static void firstMethod() {
        	secondMethod();
        }
        static void secondMethod() {
        	System.out.println("secondMethod()");
        }
    }
    ```
    
    **Process의 order of growth는 쉽게 말해서 알고리즘의 성능 평가를 말한다 
    Process는 코드의 실행과정을 order of growth는 빅오 표기법
    
    특정 코드에 대한 시간복잡도 계산에 대한 문제라고 생각** 
    
    **linear process는 코드의 방향이 직선처럼 흐르는 형태 
    재귀와 함수 호출이 없는 간단한 프로세스 
    
    tree process는 재귀호출과 함수등으로 여러개의 하위 서브 문제가 생성 되는 경우 Call Stack이 이루어짐 
    
    tree process를 활용한 프로그램으로 Call Stack의 상태와 order of growth를 물을 수 있음** 
    

## ****Procedural Abstraction****

> 
> 
> - sum > product > reduce,
>     - Ad hoc polymphism - overloading
>         - software 인터페이스는 어떻게 설계하나: 정수 범위를 정의하는 Range type(class)을 왜 만들어야 했나.
>         - subtyping으로 여러 function(closure)을 넘기는 구조를 구현
>             - functional interface/lambda expression으로 function(named closure)을 parameter로 넘기는 공부
>             - anonymous class object > anonymous function > lambda expression
>         - parametric polymorphism (generic methods)

A. 

**subtyping = Java의 인터페이스 상속** 

**functional interface/ lamda → 함수형 인터페이스(추상 메소드가 1개인 인터페이스)를 만들고 전달할때** 

```jsx
@FunctionalInterface
interface CustomInterface<T> {
    // abstract method 오직 하나
    T myCall();

    // default method 는 존재해도 상관없음
    default void printDefault() {
        System.out.println("Hello Default");
    }

    // static method 는 존재해도 상관없음
    static void printStatic() {
        System.out.println("Hello Static");
    }
}

//이걸 람다 표현식으로 바꿔본다면...?

CustomInterface<String> customInterface = () -> "Hello Custom";

// abstract method
String s = customInterface.myCall();
System.out.println(s);

// default method
customInterface.printDefault();

// static method
CustomFunctionalInterface.printStatic();

/* Output
 * Hello Custom
 * Hello Default
 * Hello Static
 */
```

### **Data Abstraction**

> 
> 
> - Fractional Data Type을 설계하는 공부
>     - Data Type을 표현하는 수단이 없다면 어떻게 data abstraction 하지?
>     - class vs. type
>         - type = { operations }
>         - type definition = a set of primitive ops
>         - abstraction (what/how) barrier
>             - how = implementation/representation
>         - type(class) invariant : testing objects
>     - abstract data type: how to design types
>         - a set of primtives ops ctor/selector(getter)/modifier(setter)/predicate
>         - equals (+ hash code)
>             - reference (pointer) vs value, stack vs heap, reference semantics vs value semantics
>             - paramter passing - call by value

A.

- **Data type이 없다면 추상화 수준이 낮아져 프로그래머의 부담성 증가..**
- **클래스는 객체가 어떻게 구현될 것 그 자체의 정의, 타입은 객체의 인터페이스 클래스마다 겹칠수도 다를수도…**
- **invariant란 프로그램이 심각한 예외, 에러 상황을 피하기 위한 검증 코드**
- **value equality와 reference (pointer) equality를 차이**
    
    ```java
    String str1 = new String("hello");
    String str2 = new String("hello");
    String str3 = str1;
    
    // Value equality 비교
    boolean valueEqual = str1.equals(str2); // true (두 문자열의 내용이 동일)
    boolean valueNotEqual = (str1 == str2); // false (다른 메모리 주소를 가리킴)
    
    // Reference equality 비교
    boolean referenceEqual1 = (str1 == str3); // true (같은 메모리 주소를 가리킴)
    boolean referenceNotEqual = (str1 == str2); // false (다른 메모리 주소를 가리킴)
    ```
    

## **How to design code: Subtyping & patterns - why?**

> 
> 
> 
> 
> - Abstract Data Type을 구현하는 수단으로 (abstract) class, interface를 공부
>     - Language-oriented programming: abstract syntax tree + evaluator로 sw 구조를 설계
>         - data 구조가 정교하고 성숙해지면 끝내 언어 구조를 갖추게 됨
>     - Java에서 LOP 방식으로 sw 설계할 때 흔히 등장하는 논제
>         - Regular Expression의 AST를 interpreter pattern으로 evaluator(matcher)를 visitor 패턴으로 coding하는 연습
>         - Interpreter, Visitor pattern들이 type을 보태거나 op을 보태거나, 소프트웨어를 늘리거나 고치는 데 어떤 문제를 푸는데 유리한가? 어떤 문제가 있나?
>         - singleton pattern이 필요할 때, 안전하게 쓰는 방법.
>             - T.getInstance()가 왜 위험한가?
>                 - concurrency, critical section (synchronized), semaphor > monitor, race condition
>             - 엇비슷해 보이는 type을 왜 세 개나 만들어서 골라 쓰라고 할까?
>                 - e.g. String vs StringBuffer vs StringBuilder
>             - 꼭 이렇게 원소가 하나뿐인 집합(type)을 위험한 pattern으로 표현해야 하나?
> - subtype polymorphism
>     - 앞서 만든 reduce 연산에서 만들었던 BinaryOperator interface의 subtype, Regular Expression의 AST를 이루는 subtype 사이의 type compatabilty 확장이 code 되쓰임새를 높이는 것을 체험
>     - overriding = control abstraction of dynamic dispatch = RTTI + exception 코드의 type-safety 문제를 해결하려는 노력
>         - subclassing = delegation 그냥 코드 복붙과 별 다를 바 없음
>         - method overriding = single dispatch
>     - subtyping polymorhism, LSP
>         - vs. subclassing

A.

- **interpreter pattern 
→ 문법 규칙을 클래스화 한 구조 , 규칙적으로 정의된 문법적 언어를 해석 하는 패턴**
- **Visitor Pattern**
    
    **→ 개방 - 폐쇠 원칙을 적용함 
    → 알고리즘을 객체 구조에서 분리** 
    
- **Singleton Pattern
→ 정보의 공유 목적**
    
    ```java
    public class CompanyInfo 
    {
        private static CompanyInfo innstance;
     
        private String companyName;
        private String companyAddr;
        
        
        private CompanyInfo()
        {
        }
        
        public static CompanyInfo getInstance()
        {
            if (innstance == null)
            {
                synchronized(CompanyInfo.class)
                {
                    innstance = new CompanyInfo();
                }
            }
            
            return innstance;
        }
        
        
        // getter, setter 
        public String getCompanyName() {
            return companyName;
        }
     
        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }
     
        public String getCompanyAddr() {
            return companyAddr;
        }
     
        public void setCompanyAddr(String companyAddr) {
            this.companyAddr = companyAddr;
        }    
    }
    ```
    
    `CompanyInfo companyInfo = CompanyInfo.getInstance();`
    **이렇게 객체를 생성해서 사용한다.**
    
- `getInstance();` 는 위험하다 왜...?
**→ OOP의 DIP 위반
→ 멀티 스레드 환경에서 동시성 문제(임계구역)
→ 세마포어나 싱크로나이지드로 해결해보자…**
- **String은 불변이다.** 
- **StringBuilder / StringBuffer는 가변이다. (Heap)
→ StringBuilder는 동기화 지원 X , 단일 스레드 성능 우수
→ StringBuffer는 동기화 지원 O, 멀티 스레드 환경에서 사용**

```java
import java.util.*;
import java.util.function.*;
import java.util.ArrayList;
import java.util.Iterator;

class Mathx {
    public static <E, R> R reduce(Predicate<E> predicate, BiFunction<R, E, R> binaryFunction,
            R init, Iterator<E> iterator) {
        R result = init;
        while (iterator.hasNext())
            if (predicate.test(iterator.next()))
                result = binaryFunction.apply(result, iterator.next());
        return result;
    }

    public static <E, R> R reduce(BiFunction<R, E, R> binaryFunction, R init,
            Iterator<E> iterator) {
              // ...
    }
    public static double reduce(DoubleBinaryOperator binaryOperator, double init,
            double... numbers) {
	        return reduce((x, y) -> binaryOperator.applyAsDouble(x.doubleValue()
																		, y.doubleValue())
										                , Double.valueOf(init)
																		, java.util.stream.DoubleStream.of(numbers).iterator());
    }

    public static double product(double... numbers) {
      // ...
    }

    public static double sum(double... numbers) {
      // ...
    }

    public static long sum(Range range) {
        final var max = range.max();
        final var min = range.min();
        return (max - min + 1) * (max + min) / 2;
    }
}

public class MathxTest {

    public static void main(String[] args) {
        MathxTest.sum();
        MathxTest.product();
        MathxTest.sumWithRange();
    }

    private static void sumWithRange() {
        assert Mathx.sum(new Range(0, 0)) == 0;
        assert Mathx.sum(new Range(0, 10)) == Mathx.sum(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assert Mathx.sum(new Range(10, 99)) + 100 == Mathx.sum(new Range(10, 100));
        assert Mathx.sum(new Range(-10, 0)) == -Mathx.sum(new Range(0, 10));
        assert Mathx.sum(-2, -1, 0, 1, 2) == Mathx.sum(new Range(-2, 2));
    }

    private static void product() {
        assert Mathx.product() == 1;
        assert Mathx.product(1, 2, 3, 7, 9, 10, 5, 4, 8,
                6) == Mathx.product(1, 2, 3, 4, 5, 6, 7, 8, 9) * 10;
    }

    private static void sum() {
        assert Mathx.sum() == 0;
        assert Mathx.sum(1, 2, 3, 7, 9, 10, 5, 4, 8, 6) == Mathx.sum(1, 2, 3, 4, 5, 6, 7, 8, 9)
                + 10;
    }
}
```

- `Predicate` : 조건 연산자를 위한 함수형 인터페이스
    
    Predicate가 true인 모든 요소의 스트림을 반환
    
- `binaryFunction` : 인터페이스로써 주로  두 매개 변수를 비교하는데에 사용되는 함수 형 인터페이스
    - 추상 메소드 apply() → 구현이 필요해보임
- `binaryOperator` : 위의 인터페이스를 확장
- `binaryOperator.applyAsDouble` : 해당 메서드의 구현 부분이 없음
- `binaryFunction.apply` : 이것도 없음
