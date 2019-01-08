package challenge_FizzBuzz;

public enum FizzBuzzAnalysisResult {
	
	/**
	 * 'FizzBuzz' analysis result indicating that the given number is divisible by 3 and not 5.
	 */ 
	Fizz, 
	
	/**
	 * 'FizzBuzz' analysis result indicating that the given number is divisible by 5 and not 3.
	 */ 
	Buzz, 

	/**
	 * 'FizzBuzz' analysis result indicating that the given number is divisible by both 3 and 5.
	 */ 
	FizzBuzz, 

	/**
	 * 'FizzBuzz' analysis result indicating that the given number is divisible by neither 3 nor 5.
	 */ 
	NoResponse, 

	/**
	 * 'FizzBuzz' analysis result indicating that the given number is below the minimum number allowed for the specified analyzer.
	 */ 
	ErrorLowerBounds, 

	/**
	 * 'FizzBuzz' analysis result indicating that the given number is above the maximum number allowed for the specified analyzer.
	 */ 
	ErrorUpperBounds;
}