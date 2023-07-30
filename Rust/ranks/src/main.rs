
/* Dev Practice - Rank:
	Imagine you are reading in a stream of integers. Periodically,
	you wish to be able to look up the rank of a number x (the number of values less than or equal to x).

	Implement the data structures, and algorithms to support these operations.
	That is, implement the method track (int x), which is called when each number is generated,
	and the method getRankOfNumber (int x), which returns the number of values less than or equal to x (not including x itself).

	Example:
	Stream (in order of appearance): 5, 1, 4, 4, 5, 9, 7, 13, 3
	getRankOfNumber (1) = 0			--No smaller number or equal
	getRankOfNumber (3) = 1			--1 smaller
	getRankOfNumber (4) = 3			--2 smaller numbers and 1 equal
	getRankOfNumber (13) = 8		--8 smaller numbers

	Clear instructions (at least for me):
		you need to return the amount of number that have a values less than or equal to the value supplied

*/

//TODO Finish this one

use std::collections::HashMap;

struct Tracker {
	fields: HashMap<i8, i8>,
}
impl Tracker {
	pub fn new() -> Self {
		Self {
			fields: HashMap::new()
		}
	}
	//Print final Hasmap
	pub fn print(&self) {
		for (key, value) in &self.fields {
			println!("[{}][{}]", key, value);
		}
	}
}

// fn track(&tracker:&Tracker, &input:&i8) {
fn track(mut tracker:Tracker, &input:&i8) -> Tracker {
	println!("{input}");

	// Get reference to the Thing containing "def" instead of removing it from the map and taking ownership
	let value = tracker.fields.get(&input);

	// Print the `content` as in previous example.
	if let Some(v) = value {
		tracker.fields.insert(input, v+1);
	}
	else{
		tracker.fields.insert(input, 0);
	}

	return tracker;
}

fn stream_input(stream:Vec<i8>) {

	let mut tracker = Tracker::new();

	// println!("Stream: {}", stream.);

	for x in &stream {
		// println!("{x}");
		tracker = track(tracker, x)
	}

	tracker.print();

}

fn main() {
	println!("Dev Practice - Rank");

	let input:Vec<i8> = vec![5, 1, 4, 4, 5, 9, 7, 13, 3];

	stream_input(input);
}
