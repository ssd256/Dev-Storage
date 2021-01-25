### Stack(스택)

![Stack 구조](https://github.com/ssd256/TIL/blob/main/DataStructure/images/Stack%20%EA%B5%AC%EC%A1%B0.PNG)

입/출력이 **한 방향**으로 제한된 자료구조

**LIFO(Last In First Out, 후입선출)** : 마지막에 저장한 데이터를 가장 먼저 꺼냄

<br>

언제 사용할까? 수식계산, 수식괄호검사, 워드프로세서의 undo/redo, 웹브라우저의 뒤로/앞으로

<br>

| 메서드 | 설명 |   
| ----- | ---- | 

| push() | 데이터 저장 | 

| pop() | 맨 위의 데이터를 꺼내옴| 

| peek() | 맨 위의 데이터 보여줌 | 

| isEmpty() | 스택이 비었는지 확인 | 

| isFull() | 스택이 꽉 찼는지 확인 | 

+SP

<br>

push와 pop할 때는 해당 위치를 알고 있어야 하므로 '스택 포인터(SP)'가 필요함

스택 포인터는 다음 값이 들어갈 위치를 가리키고 있음(기본값은 -1)

```java
private int sp = -1;
```
<br>

* **push**

```
publish void push(Object o) {
	if(isFull(o)) {
		return;
	}
	stack[++sp] = o;
}
```

스택 포인터가 최대 크기와 같으면 값 return(값 추가X)

아니라면 스택의 최상위 위치에 값을 넣음

<br>

* **pop**

```java
public void pop() {
	if(isEmpty(sp)) {
		return null;
	}
	Object o = stack[sp--];
	return o;
}
```

스택 포인터가 0이면 null로 return

아니라면 스택의 최상위 위치의 값을 꺼내옴

<br>

* **isEmpty**

```java
private boolean isEmpty(int cnt) {
	return sp == -1 ? true : false;
}
```

스택 포인터가 -1이면 스택이 비었으니 true, 스택이 비지 않았다면 false

<br>

* **isFull**

```java
private boolean isFull(int cnt) {
	return sp + 1 == MAN_SIZE ? true : false;
}
```

스택 포인터 값 + 1 이 MAN_SIZE와 같으면 스택이 꽉 찬거니 true, 아니라면 false

[스택 포인터는 기본값이 -1이라서 +1 해줌]

<br>

### Queue(큐)

![Queue 구조](https://github.com/ssd256/TIL/blob/main/DataStructure/images/Queue%20%EA%B5%AC%EC%A1%B0.PNG)

**한 쪽은 입력, 한 쪽은 출력**으로 양 끝(front, rear)으로 제한

**FIFO(First In First Out, 선입선출)** : 먼저 넣은 데이터부터 꺼냄

<br>

언제 사용할까? 최근사용문서, 인쇄작업 대기목록, 버퍼(buffer)

<br>

큐는 들어올 때는 **rear(끝)으로 들어오지만, 나갈 때는 front부터 빠짐** -> 처음과 끝으로 접근가능

| 메서드 | 설명 |

| ---- | ---- |

| enQueue() | 큐에 데이터 넣음 |

| deQueue() | 데이터 빼고 해당 데이터를 큐에서 삭제 |

| isEmpty() | 큐가 비어있는 지 확인 |

| isFull() | 큐가 꽉차있는 지 확인  |

front : deQueue 할 위치 기억

rear : enQueue 할 위치 기억

<br>

* **기본값**

```java
private int size = 0;
private int rear = -1; 
private int front = -1;

Queue(int size) {
	this.size = size;
	this.queue = new Object[size];
}
```

<br>

* **enQueue**

```java
public void enQueue(Object o) {
	if(isFull()){
		return;
	}
	queue[++rear] = o;
}
```

enQueue를 할 때, 꽉 찬 상태라면 추가할 수 있는 자리가 없으니까 overflow 

아니라면 rear에 데이터를 넣고 1 증가

<br>

* **deQueue**

```java
public Object deQueue(Object o) {
	if(isEmpty()){
		return null;
	}
	objce o = queue[front];
	queue[front++] = null;
	return o;
}
```

deQueue를 할 때, 큐가 비었으면 꺼낼 게 없으니까 underflow 

front에 위치한 값을 object에 꺼낸 후, 꺼낸 위치는 null로 채움

<br>

* **isEmpty**

```java
public boolean isEmpty() {
	return front == rear;
}
```

front와 rear 같아지면 큐가 비어진 것

<br>

* **isFull**

```java
public boolean isFull() {
	return (rear == queueSize - 1);
}
```

rear가 큐의 사이즈 -1 과 같다면 가득 찬 것 

<br>
