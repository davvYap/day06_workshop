Server side cmd:
java -cp target/workshop6-1.0-SNAPSHOT.jar sg.edu.nus.iss.app.server.ServerApp 3001 cookies_file.txt


Client side cmd:
java -cp target/workshop6-1.0-SNAPSHOT.jar sg.edu.nus.iss.app.client.ClientApp localhost:3001

Pseudocode:
1. NetworkIO class is to generate the response from inputStream or outputStream by taking
socket as arguments

2. CookieClientHandler class is to generate methods to response from the client server 
by creating an instance from NetWorkIO class. It consist the logic to process the 
response from client server and write back to client server using the NetworkIO 
instance created.

3. Cookie Class is to generate methods to:
	i. get random cookies from txt file
	ii. translate all the data from txt file into byte reader 
		and transform into list(called by method above)

4. ServerApp class is to generate the portnumber based on user input,subsequently call 
ExecutorService to define the number of threads to handle incoming request.
Then, it will pass CookieClientHandler instance to receive the response from client server.

5. ClientApp is to pass in the localhost:portnumber to connect with the socket with
ServerApp. User will be able to pass in the cmd such as: 
"get-cookie" -> get random cookie process by cookie class
"end" -> to end the client service
other reponse -> print "invalid response"
