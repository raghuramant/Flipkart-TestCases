Feature: Flipkart Page Automation 

Scenario Outline: Searching an item and adding it to the cart 

	Given User is in Flipart WebPage
	When User searches an "<item>" and adds it to the cart
	Then User verifies whether that item is in the cart
	
	Examples:
	|item|
	|Sony Led Tv|
	|Apple Iphone X|
	|G shock watch|
	|dell monitor|
	|water purifier|