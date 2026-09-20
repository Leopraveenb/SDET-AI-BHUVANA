Feature: Going to Validate AdactinBooking System

Scenario Outline: TC01 - Complete booking session of the hotel and validate the next page
Given To launch the Url
And Validate the homepage
When Enter the "<username>" and "<password>"
Then Click the login Button
Then Enter the booking fields such as "<location>", "<hotels>", "<roomtype>", "<numberofrooms>", "<checkindate>", "<checkoutdate>", "<adults>", "<children>"
And Validate that we enter into next page
Then Click the Continue Button
And Successfully Validate the Select Hotel
Then Enter the Payment Details "<Firstname>", "<Lastname>", "<billingAddress>", "<cardNumber>", "<cardType>", "<expMonth>", "<expYear>", "<cvv>" for booking
Then Click the Book Now Button
And Successfully Validate the Booking
Then Validate the orderid
Then Validate the orderid

Examples:
| username     | password     | location | hotels      | roomtype | numberofrooms | checkindate | checkoutdate | adults  | children | Firstname | Lastname | billingAddress | cardNumber       | cardType | expMonth | expYear | cvv |
| AmeliaParks  | 4S5A88       | Sydney   | Hotel Creek | Standard | 1 - One       | 25/08/2026  | 26/08/2026   | 2 - Two | 1 - One  | Kate      | Perks    | Chennai        | 1234567890123456 | VISA     | January  | 2028    | 123 |

Scenario Outline: TC02 - Login without username and validate the exception

Given To launch the Url
And Validate the homepage
When Enter the "<username>" and "<password>"
Then Click the login Button
And Validate the username exception message

Examples:
| username | password    |
|          | 4S5A88      |

Scenario Outline: TC03 - Booking without location and validate exception

Given To launch the Url
And Validate the homepage
When Enter the "<username>" and "<password>"
Then Click the login Button
And Enter the booking fields such as "<location>", "<hotels>", "<roomtype>", "<numberofrooms>", "<checkindate>", "<checkoutdate>", "<adults>", "<children>"
And Click the Search Button
Then Validate the location exception message

Examples:
| username     | password    | location | hotels      | roomtype | numberofrooms | checkindate | checkoutdate | adults  | children |
| AmeliaParks  | 4S5A88      |          | Hotel Creek | Standard | 1 - One       | 25/08/2026  | 26/08/2026   | 2 - Two | 1 - One  |

Scenario Outline: TC04 - Payment without CVV and validate exception

Given To launch the Url
And Validate the homepage
When Enter the "<username>" and "<password>"
Then Click the login Button
And Enter the booking fields such as "<location>", "<hotels>", "<roomtype>", "<numberofrooms>", "<checkindate>", "<checkoutdate>", "<adults>", "<children>"
And Validate that we enter into next page
Then Click the Continue Button
And Successfully Validate the Select Hotel
Then Enter the Payment Details "<Firstname>", "<Lastname>", "<billingAddress>", "<cardNumber>", "<cardType>", "<expMonth>", "<expYear>", "<cvv>" for booking
Then Click the Book Now Button
And Validate the CVV exception message

Examples:
| username     | password     | location | hotels      | roomtype | numberofrooms | checkindate | checkoutdate | adults  | children | Firstname | Lastname | billingAddress | cardNumber       | cardType | expMonth | expYear | cvv |
| AmeliaParks  | 4S5A88       | Sydney   | Hotel Creek | Standard | 1 - One       | 25/08/2026  | 26/08/2026   | 2 - Two | 1 - One  | Kate      | Perks    | Chennai        | 1234567890123456 | VISA     | January  | 2028    |     |

Scenario Outline: TC05 - Complete the booking and store the Order ID in a List

Given To launch the Url
And Validate the homepage
When Enter the "<username>" and "<password>"
Then Click the login Button
And Enter the booking fields such as "<location>", "<hotels>", "<roomtype>", "<numberofrooms>", "<checkindate>", "<checkoutdate>", "<adults>", "<children>"
And Validate that we enter into next page
Then Click the Continue Button
And Successfully Validate the Select Hotel
Then Enter the Payment Details "<Firstname>", "<Lastname>", "<billingAddress>", "<cardNumber>", "<cardType>", "<expMonth>", "<expYear>", "<cvv>" for booking
Then Click the Book Now Button
And Successfully Validate the Booking
Then Get the Order ID and store it in a List

Examples:
| username     | password    | location | hotels      | roomtype | numberofrooms | checkindate | checkoutdate | adults  | children | Firstname | Lastname | billingAddress | cardNumber       | cardType | expMonth | expYear | cvv |
| AmeliaParks  | 4S5A88      | Sydney   | Hotel Creek | Standard | 1 - One       | 25/08/2026  | 26/08/2026   | 2 - Two | 1 - One  | Kate      | Perks    | Chennai        | 1234567890123456 | VISA     | January  | 2028    | 123 |
