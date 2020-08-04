package CareerCup;

public class CarryOverSum {

	public static void main(String[] args) {
		int[] nums1 = {9,9,2}; 
		int[] nums2 = {0,1,3}; 
		int[] nums3 ;
		if(nums1.length > nums2.length){
			nums3 = new int[nums1.length];
		}else{
			nums3 = new int[nums2.length];
		}

		int j = nums1.length - 1;
		int k = nums2.length - 1;
		int one = 0 , two = 0 , carryOver = 0 ,sum = 0;
		for(int i = nums3.length - 1 ; i >= 0 ; i--){
			if(j < 0 ){
				one = 0;
				two = nums2[k];
			}else if(k < 0){
				two = 0;
				one = nums1[j];
			}else{
				one = nums1[j];
				two = nums2[k];
			}

			if(String.valueOf(one + two).length() > 1){
				sum = carryOver + one + two;
				carryOver = Integer.parseInt((String.valueOf(sum)).charAt(0)+"");
				nums3[i] = Integer.parseInt((String.valueOf(sum)).charAt(1)+"");

			}else{
				nums3[i] = carryOver + one + two;
			}
			j--;k--;
		}
		String result = "";
		for(int i = 0; i < nums3.length ; i++){
			if(String.valueOf(nums3[i]).length() > 1){
				result = result + String.valueOf(nums3[i]).charAt(0)+","+String.valueOf(nums3[i]).charAt(1)+",";
			}else{
				result = result + nums3[i]+",";
			}
		}
		result = new String(new StringBuffer(result).deleteCharAt(result.length() - 1));
		System.out.println(result);

	}

}
