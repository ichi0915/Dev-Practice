
/* Dev Practice - String compression:
	Implement a method to perform basic compression using the counts of repeated characters.
	For example, the string aabcccccaaa would become a2b1c5a3.

	If the “compressed” string would not become smaller than the original string, your method should return the original string.
	You can assume the string has only uppercase and lowercase letters(a-z).

	aabcccccaaa = a2b1c5a3
	aaaAAAA = a3A4
	abc = a1b1c1 !!! should return abc because its smaller
*/

#[allow(non_snake_case)]
fn ichiCompressor(stringToCompress:String) -> String {
	let mut finalString:String = String::from("");
	let mut previousChar:char = '1';
	let mut count:i8 = 1;

	println!("string to compress: {}", stringToCompress);

	for c in format!("{}1", stringToCompress).chars() {		//We add 1 to the end to have another iteration
		if c == previousChar {
			count+= 1;
		}
		else if previousChar != '1' {
			finalString = format!("{}{}{}", finalString, previousChar, count);
			count = 1;
		}

		if c == '\n' {
			break;
		}
		previousChar = c;
		// println!("{}", c);		//Debug
		// println!("final string: {}", finalString);
	}

	if stringToCompress.chars().count() < finalString.chars().count() {
		println!("The compressed string is longer than original one returning original");
		// println!("final string: {}", stringToCompress);						//Debug
		return stringToCompress;
	}
	// println!("final string: {}", finalString);								//Debug
	return finalString;
}

fn test() {
	println!("\n\n=== Running Tests ===");

	assert_eq!(ichiCompressor(String::from("aaaffkkAAddS")), String::from("a3f2k2A2d2S1"));
	assert_eq!(ichiCompressor(String::from("abc")), String::from("abc"));
	assert_eq!(ichiCompressor(String::from("aaaAAAA")), String::from("a3A4"));
	assert_eq!(ichiCompressor(String::from("aabcccccaaa")), String::from("a2b1c5a3"));
	assert_eq!(ichiCompressor(String::from("aaAAbcde")), String::from("aaAAbcde"));

	// This one will fail
	// assert_eq!(ichiCompressor(String::from("a")), String::from("a1"));
}

#[allow(non_snake_case)]
fn userInput(){
	let mut usrInput = String::new();
	println!("Enter string to compress:");
	let _inputLen = std::io::stdin().read_line(&mut usrInput).unwrap();

	println!("final string: {}", ichiCompressor(usrInput));
}

#[allow(non_snake_case)]
fn main() {
	println!("Dev Practice - String compression");
	userInput();		//AAADDDaaaAaAGGGgHHHHHg == A3D3a3A1a1A1G3g1H5
	test();
}
