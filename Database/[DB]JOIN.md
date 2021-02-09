### [DB SQL]JOIN
---
> 2개의 테이블에 대해 연관된 튜플들을 결합하여, 하나의 새로운 릴레이션으로 반환

보통 FROM절에서 기술하지만, 릴레이션이 사용되는 어느 곳에서나 사용 가능 

<br>

**JOIN 종류**

* INNER JOIN
* LEFT OUTER JOIN
* RIGHT OUTER JOIN
* FULL OUTER JOIN
* CROSS JOIN
* SELF JOIN

<br>

* INNER JOIN

![INNER JOIN](https://github.com/ssd256/Dev-Storage/blob/main/Database/images/inner%20join.PNG)

기준 테이블과 join 테이블의 중복된 값을 보여줌

```sql
SELECT A.NAME, B.TITLE
FROM A INNER JOIN B ON(A.NO = B.NO);
```

<br>

* LEFT OUTER JOIN

![LEFT OUTER JOIN](https://github.com/ssd256/Dev-Storage/blob/main/Database/images/left%20outer%20join.PNG)

기준 테이블 값과  join 테이블의 중복된 값을 보여줌 -> 왼쪽 테이블을 기준으로 합침(JOIN)

```sql
SELECT A.NAME, B.TITLE
FROM A LEFT OUTER JOIN B ON(A.NO = B.NO);
```

<br>

* RIGHT OUTER JOIN

![RIGHT OUTER JOIN](https://github.com/ssd256/Dev-Storage/blob/main/Database/images/right%20outer%20join.PNG)

오른쪽 테이블을 기준으로 합침(JOIN)

```sql
SELECT A.NAME, B.TITLE
FROM A RIGHT OUTER JOIN B ON(A.NO = B.NO);
```

<br>

* FULL OUTER JOIN

![FULL OUTER JOIN](https://github.com/ssd256/Dev-Storage/blob/main/Database/images/full%20outer%20join.PNG)

LEFT OUTER JOIN과 RIGHT OUTER JOIN을 합친 방식

```sql
SELECT A.NAME, B.TITLE
FROM A FULL OUTER JOIN B ON(A.NO = B.NO);
```

<br>

* CROSS JOIN

![CROSS JOIN](https://github.com/ssd256/Dev-Storage/blob/main/Database/images/cross%20join.PNG)

두 테이블을 join 할 때, 튜플들의 순서쌍의 모든 경우의 수를 표현하는 방식 

A가 3개, B가 4개이면 3*4 = 12개의 데이터가 검색됨

```sql
SELECT A.NAME, B.TITLE
FROM A CROSS OUTER JOIN B;
```

<br>

* SELF JOIN

![SELF JOIN](https://github.com/ssd256/Dev-Storage/blob/main/Database/images/self%20join.PNG)

자기 자신과 자기 자신을 join

하나의 테이블을 여러 번 복사해서 join하는 방식

자신이 가지고 있는 컬럼을 다양하게 변형시켜 활용할 때 자주 사용됨

```sql
SELECT A1.NO AS 학번, A1.NAME AS 학생명, A2.NAME AS 선배 
FROM A A1, A A2
WHERE A1.선배 = A2.학번;
```

<br>