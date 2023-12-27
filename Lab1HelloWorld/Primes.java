public class Primes{
	public static void main(String[] args){
		for(int i = 2; i <= 100; i++){
			if(isPrime(i)){
				System.out.println(i);
			}
		}
	}
	public static boolean isPrime(int num){
		if(num == 2){
			return true;
		}
		for(int i = 2; i < Math.sqrt(num) + 1; i++){
			if (num % i == 0){
				return false;
			}
		}
		return true;
	}
}