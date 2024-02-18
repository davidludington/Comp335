### Why does FixedArrayQueue require an explicit constructor?
- It requires an explicit constructor becasue the SimpleQueue interface does not include a constructor, each class that implemnets the interface must also contain an explict construtor 
### What happens when you offer an item to a full FixedArrayQueue?
- If the array is already full then the offer() method will return false, meaning that the element could not be added to the queue because the queue cannot accept any more elements i.e. the queue is at compacity
### What happens when you poll an empty FixedArrayQueue?
- If the queue is empty the poll() method will return false, mening that nothing could be polled from the queue becase it is empty
### What is the time and (extra) space complexity of each of the FixedArrayQueue methods?
- They all opereate in place with O(1) time/space complexity except the poll() method requires an object to be instianted before it is returned 
### How exhaustively does the TestSimpleQueue test suite test the implementation, both conceptually and in terms of actual coverage?
- It is as ehaustive as you make it. It only tests the things you explicitly state
### How exhaustively does the TestSimpleQueueJqwik test suite test the implementation, both conceptually and in terms of actual coverage?
- It tests the implementation with randomized input. It tests that the methods created function as we expect them to

### What kind of test cases does the simpleQueueActions method generate?
- the simpleQueueActions method generates a large number of interaction sequences with the system under test