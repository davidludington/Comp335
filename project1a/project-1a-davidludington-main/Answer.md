### Which of the NFRs listed above are dynamic or static, respectively?
- The nonfunctional requirments that are concerned with performance and behavior of the system under certain scenarios are dynamic, i.e. constantat additial space or up to arg.lenght/2 additioal space 
- The nonfunctional requirements that refer to characteristics of the system are static, i.e. DRY-dont repeat yourself if at all possible
### Why is space performance important for a predicate like isPalindrome?
- If we need to check a book for all the instances a palindrome occurs, that could require us to check a lot of words and if we have to allocate memory each time we invoke the method that would be really expensive in terms of memory and time as it takes time to allocate memory for a new object and initalize it 
### To what extent does the result of invoking one of these predicates depend on prior invocations?
- The ispalindrome() method is the most restrictive, so if a string is a palindrome then it will also be a palindrome when we ignore case and when we also ignore spaces
- They all rely on the isPalindrome method and just manipulate the string as it passed into the method
### Accordingly, what would be a relatively straightforward way to improve their performance?
- we could just check to tmake sure that the isPalindrome method is working properly since it is the foundation to the other methods, i.e. they call on the isPalindrome method to generate their output 
### What is an advantage of data-driven testing over example-based testing?
- They are easier to write, read, and add to or modify. Example based testing is more wordy and requires you to create a new method for each assertion you want to test. Data-driven testing allows you to create a table of data and the expexted result, then just have noe method to test the data 
### What is an advantage of property-based testing over example-based and data-driven testing?
- property-based testing gets more at the definition something and creates things that are always true, rather then creating a lot of test scenarios where we have to define the result. Example and data driven testing require a lot of test cases with a know result. Property-based testing allows us to create requirments that are true for every string
### Briefly discuss the pros and cons of a generate-and-check-based property as compared to a property based on a generator that generates test data more directly, such as the ones listed below under extra credit?
- generate-and-check tests are goo beceae they allow you to put in specif input, bu they only test for the strigns you pass on. A generator creates strings to pass into the method and can produce a lot more strings than the ammont of Ad-hoc tests you would be able to write. The only thing is you dont know exacly what is being passed passed into you functions besided the few parametrs you give it  
