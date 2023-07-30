/*
Dev Practice - Sort Colors:

	Given an array nums with n objects colored red, white, or blue, sort them in-place
	so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

	We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

	You must solve this problem without using the library's sort function.

	Example 1:
	Input: nums = [2,0,2,1,1,0]
	Output: [0,0,1,1,2,2]

	Example 2:
	Input: nums = [2,0,1]
	Output: [0,1,2]

	Constraints:
		n == nums.length
		1 <= n <= 300
		nums[i] is either 0, 1, or 2.


	Follow up: Could you come up with a one-pass algorithm using only constant extra space?

	0 red
	1 white
	2 blue
*/

package main

import (
	"fmt"
)

func main() {
	// colors := []int{2, 1} // response 1,2
	// colors := []int{2, 0, 1} // response 0,1,2
	colors := []int{2, 0, 2, 1, 1, 0} // response 0,0,1,1,2,2
	fmt.Println("Before: ")
	printArray(colors)

	sortColors(colors)

	fmt.Println("After: ")
	printArray(colors)
}

func sortColors(nums []int) {
	amount := len(nums) - 1
	// fmt.Printf("amount %d \n", amount)

	flag := true
	for flag {
		flag = false
		for i := amount; i >= 0; i-- {
			for j := range nums {
				if j < i {
					// fmt.Printf("%d, %d \n", i, j)
					for j >= 0 && i <= amount && nums[j] > nums[i] {
						swap(nums, j, i)
					}
				}
			}
		}
	}
}

func swap(nums []int, pos1 int, pos2 int) {
	fmt.Println("swap")
	tmp := nums[pos1]
	nums[pos1] = nums[pos2]
	nums[pos2] = tmp
}

func printArray(nums []int) {
	for _, val := range nums {
		fmt.Println(val)
	}
}

func isNotSorted(nums []int) bool {
	resp := false
	amount := len(nums)

	for i := range nums {
		if i+1 < amount && nums[i] > nums[i+1] {
			resp = true
		}
	}
	return resp
}
