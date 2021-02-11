/*
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
*/

/*
Iterating right-to-left, for each position we check if there is a potential jump that reaches a GOOD index (currPosition + nums[currPosition] >= leftmostGoodIndex). If we can reach a GOOD index, then our position is itself GOOD. Also, this new GOOD position will be the new leftmost GOOD index. Iteration continues until the beginning of the array. If first position is a GOOD index then we can reach the last index from the first position.
*/
public class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
    
  /*
  reach the last index in the minimum number of jumps.
  Input: [2,3,1,1,4]
  Output: 2
  */
      public int jump(int[] nums) {
        int steps = 0;
        int position = nums.length - 1;
            
        while(position != 0){
            for(int i=0;i<position;i++){
                if(i+nums[i]>=position){
                    position=i;
                    steps++;
                    break;
                }             
            }
        }
        return steps;
    }
}