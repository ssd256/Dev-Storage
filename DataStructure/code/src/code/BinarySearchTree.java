package code;

public class BinarySearchTree {
	public class Node {
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		public int getData() {
			return data;
		}
		
		public void setData(int data) {
			this.data = data;
		}
		
		public Node getLeft() {
			return left;
		}
		
		public void setLeft(Node left) {
			this.left = left;
		}
		
		public Node getRight() {
			return right;
		}
		
		public void setRight(Node right) {
			this.right = right;
		}
	}
	
	public Node root;
	public BinarySearchTree() {
		this.root = null;
	}
	
	// 탐색 연산(retreive)
	public boolean find(int data) {
		Node current = root;	// 현재 노드를 루트로 지정
		while(current != null) {
			// 현재 노드 값 == 찾는 값
			if(current.getData() == data) {
				return true;
				// 현재 노드 값 >= 찾는 값
			} else if(current.getData() > data) {
				current = current.getLeft();
				// 현재 노드 값 <= 찾는 값
			} else {
				current = current.getRight();
			}
		}
		return false;
	}
	
	// 삭제 연산
	public boolean delete(int data) {
		Node parent =  root; // 부모 노드
		Node current = root; // 현재 노드
		boolean isLeftChild = false; // 왼쪽 노드인지(최소값인지)
		while(current.getData() != data) {
			parent = current; // 부모 노드에 현재 노드를 넣음
			
			// 현재 노드 값 > 찾는 값 : 왼쪽 노드랑 비교해야 함
			if(current.getData() > data) { 
				isLeftChild = true;
				current = current.getLeft();
			// 현재 노드 값 < 찾는 값 : 오른쪽 노드랑 비교해야 함
			} else {
				isLeftChild = false;
				current = current.getRight();
			}
			if(current == null) { 
				return false;
			}
		}
		
		// Case 1: 자식 노드가 없을 때(leaf)
		if(current.getLeft() == null && current.getRight() == null) {
			// current가 맨 위면 current 지움
			if(current == root) {
				root = null;
			}
			// 현재 노드 값 > 찾는 값 : 왼쪽 노드 지움
			if(isLeftChild == true) {
				parent.setLeft(null);
			// 현재 노드 값 < 찾는 값 : 오른쪽 노드 지움
			} else {
				parent.setRight(null);
			}
		}
		// Case 2: 하나의 자식 노드를 가질 때
		else if(current.getRight() == null) {
			if(current == root) {
				root = current.getLeft();
			// 현재 노드 값 > 찾는 값 
			} else if(isLeftChild) {
				parent.setLeft(current.getLeft()); 
			// 현재 노드 값 < 찾는 값
			} else {
				parent.setRight(current.getLeft());
			}
		} else if(current.getLeft() == null) {
			if(current == root) {
				root = current.getRight();
			} else if(isLeftChild) {
				parent.setLeft(current.getRight());
			} else {
				parent.setRight(current.getRight());
			}
		}
		// Case 3: 두 개의 자식 노드를 가질 때
		else if(current.getLeft() != null && current.getRight() != null) {
			// 오른쪽 서브트리의 최소값을 찾음 -> 최소값을 삭제된 노드 위치로 가져옴
			Node min = getMin(current);
			if(current == root) {
				root = min;
			} else if(isLeftChild) {
				parent.setLeft(min);
			} else {
				parent.setRight(min);
			}
			min.setLeft(current.getLeft());
		}
		
		return true;
	}
	
	public Node getMin(Node deleteNode) {
		Node min = null;
		Node minParent = null;
		Node current = deleteNode.getRight();
		while(current != null) {
			minParent = min; 
			min = current; 
			current = current.getLeft();
		}
		if(min != deleteNode.getRight()) {
			minParent.setLeft(min.getRight());
			min.setRight(deleteNode.getRight());
		}
		return min;
	}
	
	// 삽입 연산
	public void insert(int data) {
		Node newNode = new Node(data);
		if(root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true) {
			parent = current;
			if(data < current.getData()) {
				current = current.getLeft();
				if(current == null) {
					parent.setLeft(newNode);
					return;
				}
			} else {
				current = current.getRight();
				if(current == null) {
					parent.setRight(newNode);
					return;
				}
			}
		}
	}
	
	public void display(Node root) {
		if(root != null) {
			display(root.getLeft());
			System.out.println(" " + root.getData());
			display(root.getRight());
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		// 삽입
		bst.insert(3); bst.insert(8);
		bst.insert(1); bst.insert(5); bst.insert(6); bst.insert(12); bst.insert(9); 
		bst.insert(25); bst.insert(30); bst.insert(18); bst.insert(20);
		
		System.out.println("트리 삽입 결과 : ");
		bst.display(bst.root); // 1 3 5 6 8 9 12 18 20 25 30
		System.out.println();
		
		System.out.println("이진트리에서 5를 탐색 : " + bst.find(5)); // true
		System.out.println("이진트리에서 2를 삭제 : " + bst.delete(2)); // false
		bst.display(bst.root); // 1 3 5 6 8 9 12 18 20 25 30
		
		System.out.println("\n이진트리에서 5를 삭제 : " + bst.delete(5)); // true
		System.out.println("\n이진트리에서 20을 삭제 : " + bst.delete(20)); //true
		bst.display(bst.root); // 1 3 6 8 9 12 18 25 30
		
		System.out.println();
		bst.insert(15);
		bst.display(bst.root); // 1 3 6 8 9 12 15 18 25 30
	}
}
