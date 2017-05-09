String Permutation

public class Solution {
  public List<String> permutations(String set) {
    List<String> res = new ArrayList<String>();
    if(set == null){
      return res;
    }
    char[] arr = set.toCharArray();
    Dfs(arr, 0, res);
    return res;
  }
  private void Dfs(char[] arr, int level, List<String> res) {
    if(level == arr.length) {
      res.add(new String(arr));
      return;
    }
    for(int i = level; i < arr.length; i++) {
      swap(arr, level, i);
      Dfs(arr, level + 1, res);
      swap(arr, level, i);
    }
  }
  private void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}



Kth Smallest Sum From Two Sorted Array

public int kSmallest(int[] A, int[] B, int k) {
	int Alen = A.length;
	int Blen = B.length;
	Set<Element> set = new HashSet<Element>();
	PriorityQueue<Element> pq = new PriorityQueue<Element>(k, new Comparator<Element>() {
		@Override
		public int compare(Element e1, Element e2){
			if(e1.sum == e2.sum){
				return 0;
			}
			return e1.sum < e2.sum ? -1 : 1;
		}
	});
	Element cur = new Element(0, 0, A[0] + B[0]);
	pq.offer(cur);
	set.add(cur);
	int result = A[0] + B[0];
	for(int i = 0; i < k; i++) {
		cur = pq.poll();
		result = cur.sum;
		if(cur.Aindex < Alen - 1) {
			Element temp = new Element(cur.Aindex + 1, cur.Bindex, A[cur.Aindex + 1] + B[cur.Bindex]);
			if(set.add(temp)){
				pq.offer(temp);
			}
		}
		if(cur.Bindex < Blen - 1) {
			Element temp = new Element(cur.Aindex, cur.Bindex + 1, A[cur.Aindex] + B[cur.Bindex + 1]);
			if(set.add(temp)) {
				pq.offer(temp);
			}
		}
	}
	return result;
}

public class Element {
	private int Aindex;
	private int Bindex;
	private int sum;
	public Elememt(int Aindex, int Bindex, int sum) {
		this.Aindex = Aindex;
		this.Bindex = Bindex;
		this.sum = sum;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(!(obj instanceOf Elememt)) {
			return false;
		}
		Element another = (Element)obj;
		return another.Aindex == this.Aindex && another.Bindex == this.Bindex && another.sum == this.sum;
	}
	@Override
	public int hashCode(){
		return this.Aindex * 31 * 31 + this.Bindex * 31 + this.sum;
	}
}






