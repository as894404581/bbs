package test;



public class Demos {
	public static void main(String[] args) {
		int arr[]={1,3,5,7,9,11,13,15};
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				for (int j2 = 0; j2 < arr.length; j2++) {
					System.out.println(arr[i]+arr[j]+arr[j2]);
					if((arr[i]+arr[j]+arr[j2])==30){
						break;
					}
//					System.out.println(arr[i]+"\t"+arr[j]+"\t"+arr[j2]);
				}
			}
		}
	}
	
}
