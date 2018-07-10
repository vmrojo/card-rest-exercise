POST
http://localhost:8080/payment/card

	Request
	{
		"brand": "SCO",
		"cardNumber": "0000111122223333",
		"cardHolder": "John Doe",
		"expDate": "0818"
	}
	
	Response (Status 201)
	{
		"id": "1"
		"brand": "SCO",
		"cardNumber": "0000111122223333",
		"cardHolder": "John Doe",
		"expDate": "0818"
	}


GET
http://localhost:8080/payment/card/1

	Response (Status 200)
	{
		"brand": "SCO",
		"cardNumber": "0000111122223333",
		"cardHolder": "John Doe",
		"expDate": "0818"
	}


GET
http://localhost:8080/payment/rate?brand=SCO&amount=1

	Response (Status 200)
	{
		"brand": "SCO",
		"amount": 1,
		"rate": 4.5
	}



POST
http://localhost:8080/payment/validateCard

	Request
	{
		"brand": "SCO",
		"cardNumber": "0000111122223333",
		"cardHolder": "John Doe",
		"expDate": "0818"
	}
	
	Response (Status 200)
	
	
	Request
	{
		"brand": "SCO",
		"cardNumber": "0000111122223333",
		"cardHolder": "John Doe",
		"expDate": "0816"
	}
	
	Response (Status 400)

	
POST
http://localhost:8080/payment/validateOperation

	Request
	{
		"id": "1",
		"amount": "100"
	}
	
	Response (Status 200)
	
	
	Request
	{
		"id": "1",
		"amount": "10000"
	}
	
	Response (Status 400)
