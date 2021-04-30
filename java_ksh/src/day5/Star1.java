package day5;

public class Star1 {

	public static void main(String[] args) {
		/* ****		k = 1	* = 4
		 * ****		k = 2	* = 4
		 * ****		k = 3	* = 4
		 * ****		k = 4	* = 4
		 * ****		k = 5	* = 4
		 * */
		int i, k;
		for(k = 1; k <= 5; k += 1) {
			for(i = 1; i <= 4; i += 1) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		/* *		k = 1	* = 1
		 * **   	k = 2	* = 2
		 * ***		k = 3	* = 3
		 * ****		k = 4	* = 4
		 * *****	k = 5	* = 5
		 * 					* = k
		 */
		System.out.println("----------------");
		for(k = 1; k <= 5; k += 1) {
			for(i = 1; i <= k; i += 1) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		/*     ****		k = 1	공백 = 4, * = 4
		 *     ****		k = 2	공백 = 4, * = 4
		 *     ****		k = 3	공백 = 4, * = 4
		 *     ****		k = 4	공백 = 4, * = 4
		 *     ****		k = 5	공백 = 4, * = 4
		 * */
		System.out.println("----------------");
		for(k = 1; k <= 5; k += 1) {
			for(i = 1; i <= 4; i += 1) {
				System.out.print(" ");
			}
			for(i = 1; i <= 4; i += 1) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		/*     *	k = 1	공백 = 4, 	* = 1
		 *    **	k = 2	공백 = 3, 	* = 2
		 *   ***	k = 3	공백 = 2, 	* = 3
		 *  ****	k = 4	공백 = 1, 	* = 4
		 * ***** 	k = 5	공백 = 0, 	* = 5
		 * 					공백 = 5 -k  	* = k
		 * */
		System.out.println("----------------");
		for(k = 1; k <= 5; k += 1) {
			for(i = 1; i <= 5 - k; i += 1) {
				System.out.print(" ");
			}
			for(i = 1; i <= k; i += 1) {
				System.out.print('*');
			}
			System.out.println();
		}
		/*     *
		 *    ***
		 *   *****
		 *  *******
		 * *********   
		 * */
		/* *********
		 *  *******
		 *   *****
		 *    ***
		 *     *
		 * 연습
		 * */
		
	}

}
