### Big-O

- 알고리즘의 **성능을 수학적으로 표현**해주는 표기법

* 알고리즘의 **시간과 공간 복잡도를 표현**
* 알고리즘의 실제 running-time을 표시하는 것이 아니라, **데이터나 사용자의 증가율에 따라 알고리즘의 성능을 예측**하는 것이 목표!    
-> 상수와 같은 **숫자**는 표현할 때 **모두 1로 표기**
<br>
---
<br>

**1. O(1) : 상수 시간(constant time)**

```python
F(int[] n) {
    return (n[0] == 0) ? true : false;
}
```

![Big-O(O1)](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Big-O(O1).PNG)

입력한 데이터의 크기와 상관없이 언제나 일정한 시간이 걸리는 알고리즘

입력 데이터(n)가 얼마나 큰 수인지에 상관없이 언제나 일정한 속도로 일정한 값을 반환한다

-> 예시 알고리즘은 **O 원(1)의 시간 복잡도를 가진다** 라고 말할 수 있다!

<br>

**2. O(n) : 선형 시간(linear time)**

```python
F(int[] n) {
	for i = 0 to n.length
		print i
}
```

![Big-O(On)](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Big-O(On).PNG)

입력 데이터의 크기에 비례해서 처리 시간이 걸리는 알고리즘

입력 데이터(n)의 크기가 커질수록 처리 시간도 비례해서 늘어난다 -> **데이터와 시간이 같은 비율로 증가함**

 <br>

**3. O(n²) : 이차 시간(quadratic time)**

```python
F(int[] n) {
	for i = 0 to n.length
		for j = 0 to n.length
			print i + j;
}
```

![Big-O(On²)](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Big-O(On%C2%B2).PNG)

입력 [데이터의 크기(n)](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Big-O(On%C2%B2)%20%EA%B7%B8%EB%A6%BC.PNG)가 커질수록 O(n)보다 처리 시간이 수직에 가깝게 늘어난다

<br>

**4. O(nm) : 이차 시간(quadratic time)**

```python
F(int[] i, int[] m) {
    for i = 0 to n.length
    	for j = 0 to m.length
    		print i + j;
}
```

![Big-O(Onm)](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Big-O(Onm).PNG)

O(n²)과 비슷하지만, [m이 n보다 작을 수도](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Big-O(Onm)%20%EA%B7%B8%EB%A6%BC.PNG) 있기 때문에 반드시 따로 표기해 줘야 한다

O(n²)과 마찬가지로 입력 데이터의 크기(n)이 커질수록 처리 시간이 수직에 가깝게 늘어난다

<br>

**5. O(n³) : 다항 시간(polynomial / cubic time)**

```python
F(int[] n) {
	for i = 0 to n.length
		fot j = 0 to n.length
			for k = 0 to n.length
				print i + j + k;
}
```

![Big-O(On³)](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Big-O(On%C2%B3).PNG)

3개의 for문이 [중첩](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Big-O(On%C2%B3)%20%EA%B7%B8%EB%A6%BC.PNG)되기 때문에 데이터의 크기(n)가 커질수록 On²보다 더 가파르게 처리 시간이 늘어난다

<br>

**6. O(2ⁿ) : 지수 시간(exponential time)** -> O(mⁿ)으로 사용할 수도 있음

```python
F(n, r) {
    if(n <= 0) return 0;
    else if(n == 1) return r[n] = 1;
    return r[n] = F(n - 1, r) + F(n - 2, r);
}
```

[Fibonacci](https://github.com/ssd256/Dev-Storage/blob/main/%EA%B8%B0%EC%B4%88%EB%8B%A8%EC%96%B4/images/Fibonacci.PNG) 수열을 재귀함수로 구현하면, 이전 숫자(n-1)와 전전 숫자(n-2)를 알아내야 한다.

Fibonacci 수열을 재귀함수로 구현하면 2번씩 수를 호출하면서 [트리의 높이(k)](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Fibonacci%20%EC%9E%AC%EA%B7%80%ED%95%A8%EC%88%98.PNG)만큼 반복

![Big-O(2ⁿ)](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Big-O(2%E2%81%BF).PNG)

그래프로 비교하면 On²이나 On³보다 데이터가 늘어날수록 처리 시간이 더 가파르게 상승함

<br>

**7. O(log n) : 로그 시간(logarithmic time)** -> 대표적으로 [이진검색(binary search)](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/binary%20search.PNG)

```python
F(k, arr, s, e) {
    if(s > e) return -1;
    m = (s + e) / 2;
    if(arr[m] == k) return m;
    else if(arr[m] > k) return F(k, arr, s, m-1);
    else return F(k, arr, m+1, e);
}
```

처리가 진행될 때마가 검색해야 하는 데이터의 양이 절반씩 뚝뚝 떨어지는 알고리즘

![Big-O(log n)](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Big-O(log%20n).PNG)

k(찾으려는 값)과 중간값을 비교하기 때문에 순차 검색보다 처리속도가 빠르다

데이터가 증가해도 처리속도가 크게 늘어나지 않는 장점이 있다

<br>

**8. O(Sqrt(n))  / O(n^c) : 제곱근 시간(Square)** -> O(n^c)에서 c는 반복문의 횟수

![Big-O(Sqrt(n))](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/Big-O(Sqrt(n)).PNG)

제곱근에서 맨 위의 한 줄을 돌리는 알고리즘. 소수인지 확인할 때 쓰는 방법으로 순차검색보다 빠르다

<br>

Big-O 표기법에서 중요한 핵심! Drop constants! 

#### 흔히 하는 실수

* 상수 표현

```python
F(int[] n) {
	for i = 0 to n.length // 1회 검색
		print i
	for i = 0 to n.length // 2회 검색
		print i
}
```

실질적으로 for문이 각각 1번씩 총 2회 돌았지만 Big-O로 표기할 때에는 O(2n)이 아닌 **O(n)으로 표기**

=> Big-O는 실제 처리 시간을 재는 것이 아니라 장기적으로 **데이터가 증가함에 따른 처리시간의 증가율을 예측**하기 위함이기 때문이다.    
상수는 일정한 고정값이기 때문에 증가하지 않는 부분에 대해서는 고려하지 않는 것이다. 

<br>

* n끼리 더해줌

```python
F(int[] n) {
    for i 0 to n.length
    	for j = 0 to n.length
    		print i + j;
    for i 0 to n.length
    	for j = 0 to n.length
    		print i + j;
}
```

위 예시도 1번과 같이 같은 for문을 2번 반복한다고 해서 O(n²+n²)으로 더해주지 않고 **O(n²)**으로 하나만 표기 => 2번 반복해도 **일정한 시간**만큼만 걸리기 때문에

<br> 

![sort Big-O](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/sort%20Big-O.PNG)
![DataStructure Big-O](https://github.com/ssd256/Dev-Storage/blob/main/DataStructure/images/DataStructure%20Big-O.PNG)

<br>
