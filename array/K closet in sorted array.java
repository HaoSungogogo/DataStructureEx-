public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    if(array == null || array.length == 0){
      return array;
    }
    int[] res = new int[k];
    int left = getLargestLessOrEqual(array, target);
    int right = left + 1;
    int count = 0;
    while(count < k){
      if(right >= array.length || left >= 0 && target - array[left] <= array[right] - target){
        res[count++] = array[left--];
      }else{
        res[count++] = array[right++];
      }
    }
    return res;
  }
  private int getLargestLessOrEqual(int[] array, int target){
    int left = 0;
    int right = array.length - 1;
    //terminate in advance
    while(left < right - 1){
      int mid = left + (right - left) / 2;
      if(array[mid] <= target){
        left = mid;
      }else{
        right = mid;
      }
    }
    //post processing
    if(array[right] <= target){
      return right;
    }
    if(array[left] <= target){
      return left;
    }
    return -1;
  }
}


Class Array{
  private int length;  //
}
