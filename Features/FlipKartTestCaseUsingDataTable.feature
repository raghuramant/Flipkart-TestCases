Feature: Flipkart Page Automation 

Scenario: Searching an item and adding it to the cart 

	Given User navigates to Flipart WebPage 
	When User searches item and adds it to the cart
		|Sony Led Tv|
		|Apple Iphone X|
		|G shock watch|
		|dell monitor|
		|water purifier|
	Then User wants to verifies whether the items are available in the cart 
	