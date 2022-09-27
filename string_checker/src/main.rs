
/* Dev Practice - Edit Checker:
	There are three types of edits that can be performed on strings: insert a character remove a character, or replace a character.
	Given two strings, write a function to check if there are one edit (or zero edits) away.
	EXAMPLE:
	pale, ple = true
	pales, pale = true
	pale, bale = true
	pale, bake = false
	pale, ppales = false

	both lowercase and uppercase are the same
*/

fn string_checker(original_buffer:String, edited_buffer:String) -> bool {
	let mut edited:bool = true;
	let mut amount_edits:i8 = 0;
	let mut i:usize = 0;
	let buffer_loop:String;
	let buffer_other:String;

	let original_buffer_len = original_buffer.chars().count();
	let edited_buffer_len = edited_buffer.chars().count();

	println!("Original:{}, Edited:{}", original_buffer, edited_buffer);

	if original_buffer_len > edited_buffer_len {
		buffer_loop = original_buffer;
		buffer_other = edited_buffer;
	}
	else {
		buffer_loop = edited_buffer;
		buffer_other = original_buffer;
	}

	for c in buffer_loop.chars() {
		// println!("{}", c);
		if buffer_other.chars().nth(i).is_none() {
			amount_edits += 1;
			break;
		}
		if c != buffer_other.chars().nth(i).unwrap() {
			if buffer_other.chars().nth(i+1).is_some() {
				if c == buffer_other.chars().nth(i+1).unwrap() {
					amount_edits += 1;
					continue;
				}
				if buffer_loop.chars().nth(i+1).unwrap() == buffer_other.chars().nth(i).unwrap() {
					amount_edits += 1;
					continue;
				}
				else{
					amount_edits += 1;
				}
			}
			else {
				amount_edits += 1;
			}
		}
		i += 1;
	}

	if amount_edits > 1 {
		edited = false;
	}

	println!("amount_edits: {} \n", amount_edits);

	return edited;
}

fn test() {
	println!("\n\n=== Running Tests ===");

	assert_eq!(string_checker(String::from("pale"), String::from("ple")), true);
	assert_eq!(string_checker(String::from("pales"), String::from("pale")), true);
	assert_eq!(string_checker(String::from("pale"), String::from("bale")), true);
	assert_eq!(string_checker(String::from("pale"), String::from("bake")), false);
	assert_eq!(string_checker(String::from("pale"), String::from("pale")), true);
	assert_eq!(string_checker(String::from("pale"), String::from("ppales")), false);

	// This one will fail
	// assert_eq!(string_checker(String::from("pale"), String::from("pale")), false);
}

fn main() {
	println!("Dev Practice - String Edit Checker");

	test();

}
