import java.util.NoSuchElementException;
public class ArrList <E> {
	private  E a[];     // ����Ʈ�� �׸���� ������ �迭
    private  int size;  // ����Ʈ�� �׸� ��
   
    public  ArrList() { // ������
        a = (E[]) new Object[1];  // ���ʷ� 1���� ���Ҹ� ���� �迭 ����
        size = 0;                 // �׸� ���� 0���� �ʱ�ȭ
    }
    public boolean isEmpty() {return size == 0;} // ����Ʈ�� empty�̸� true ����
    
    public void insertLast(E newItem) {	// ���� �ڿ� �� �׸� ����              
        if (size == a.length)   	// �迭�� �� ������ ������
        	resize(2*a.length);  	// �迭 ũ�� 2��� Ȯ��
         a[size++] = newItem;    	// �� �׸� ����
    }
        
    public void insert(E newItem, int k) { // �� �׸��� k-1���� �׸� ������ ����
    	if (size == a.length)   		   // �迭�� �� ������ ������
    		resize(2*a.length);			   // �迭 ũ�� 2��� Ȯ��
    	for (int i = size-1; i >= k; i--)  a[i+1] = a[i];  // �� ĭ�� �ڷ� �̵�
    	a[k] = newItem;
    	size++;
    }

    public E delete(int k) {  // k��° �׸� ����
		if (isEmpty()) throw new NoSuchElementException(); // underflow ��쿡 ���α׷� ����
		E item = a[k];
		for (int i = k; i <size; i++)  a[i] = a[i+1];  // �� ĭ�� ������ �̵�
		size--;
		if (size > 0 && size == a.length/4) // �迭�� �׸���� 1/4�� �����Ѵٸ�
			resize(a.length/2); 			// �迭�� 1/2 ũ��� ���
		return item;
    }
    
    public E peek(int k) {  // k��° �׸��� ����, �ܼ��� �б⸸ �Ѵ�.
  		if (isEmpty()) throw new NoSuchElementException(); // underflow ��쿡 ���α׷� ����
  		return a[k];
      }
    
    private void resize(int newSize) {		// �迭 ũ�� ����
		Object[] t = new Object[newSize];   // newSize ũ���� ���ο� �迭 t ����
		for (int i = 0; i < size; i++)
			t[i] = a[i];                    // �迭 s�� �迭 t�� ���� 
		a = (E[]) t;                        // �迭 t�� �迭 s�� 
	}
    
	public void print() { // �迭�� �׸���� ���
		if (isEmpty()) 
			System.out.print("�迭�� �������.");      
		else
			for(int i = 0; i < a.length; i++)	System.out.print(a[i]+"\t ");
		System.out.println();
	}
}
