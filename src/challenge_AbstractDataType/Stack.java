package challenge_AbstractDataType;

import challenge_AbstractDataType.Exception_EmptyStack;

public class Stack<T> implements I_Stack<T>{

	I_NodeStack<T> top;
	
	@SuppressWarnings("unchecked")
	public Stack(T... inputs) {
		for(T input: inputs) push(input);
	}
	
	@Override
	public void push(T dataObject) {
		I_NodeStack<T> topHold = top;
		top = new NodeStack<T>(dataObject);
		if(topHold!=null) top.setNextNode(topHold);
	}

	@Override
	public T peek() {
		if (top==null) throw new Exception_EmptyStack();
		else return top.getDataObject();
	}

	@Override
	public T pop() throws Exception_EmptyStack {
		if (top==null) throw new Exception_EmptyStack();
		T dataObject = top.getDataObject();
		if(top.getNextNode()!=null) {
			top=top.getNextNode();
			return dataObject;
		} else {
			top = null;
			return dataObject;
		}
	}

	@Override
	public boolean isEmpty() {
		if (top==null) return true;
		return false;
	}

	@Override
	public boolean contains(T dataObject) {
		I_NodeStack nodeStack = top; //correct me if issue
		while(nodeStack!=null) {
			if(nodeStack.getDataObject()==dataObject) return true;
			nodeStack = nodeStack.getNextNode();
		}
		return false;
	}

	@Override
	public int size() {
		int counter = 0;
		I_NodeStack<T> node = top;
		
		while (node!=null) {
			counter++;
			node = node.getNextNode();
		}
		
		return counter;
	}

}
