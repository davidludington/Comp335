-------------------------- MODULE Elevator --------------------------

EXTENDS Integers, Sequences, FiniteSets

CONSTANTS Floors, CLOSED, OPEN

VARIABLES
    direction,
    floorRequests,
    elevatorRequests,
    position,
    time

vars == << direction, floorRequests, elevatorRequests, position, time >>

MAXTIME == 20

TypeOK == 
    /\position \in 1..Floors
    /\ direction \in {"up", "down"} 
    /\ (elevatorRequests \union floorRequests) \subseteq 1..Floors
    /\ time \in Nat 
  

Init == 
    /\ position = 1
    /\ direction = "up"
    /\ floorRequests = {}
    /\ elevatorRequests = {}
    /\ time = 0

\* Adds floor to floorRequest set if floor button is in the floor range and it isnt already in the floorRequests set
floorButtonRequest(floorButton) == 
    /\ floorButton \in 1..Floors
    /\ floorButton \notin floorRequests
    /\ floorRequests' = floorRequests \union { floorButton }
    /\ UNCHANGED << direction, elevatorRequests, position, time >>

elevatorButtonRequest(elevatorButton) == 
    /\ elevatorButton \in 1..Floors
    /\ elevatorButton \notin elevatorRequests
    /\ elevatorRequests' = elevatorRequests \union { elevatorButton }
    /\ UNCHANGED << direction, floorRequests, position, time >>

moveElevator ==
    \* if the number of requests in the union of the floorRequest and elevator requests is greater than zero and there exists an x in that combined set then it will move up  
    IF (direction = "up" /\ position < Floors /\ Cardinality({x \in (elevatorRequests \union floorRequests) : x > position}) > 0) THEN 
        /\ position \notin (elevatorRequests \union floorRequests) \* request must exist for floor to move 
        /\ position' = position + 1
        /\ elevatorRequests' = elevatorRequests \ {position}
        /\ floorRequests' = floorRequests \ {position}
        /\ time' = time + 2
        /\ UNCHANGED << direction >>
    ELSE IF (direction = "down" /\ position > 1 /\ Cardinality({x \in (elevatorRequests \union floorRequests) : x < position}) > 0) THEN
        /\ position \notin (elevatorRequests \union floorRequests) \* request must exist for floor to move 
        /\ position' = position - 1
        /\ elevatorRequests' = elevatorRequests \ {position}
        /\ floorRequests' = floorRequests \ {position}
        /\ time' = time + 2
        /\ UNCHANGED << direction >>
    ELSE UNCHANGED vars
\* if the position is in the requests then remove it from the requests set and add time 
elevatorDoesNotMove == 
    /\ position \in (floorRequests \union elevatorRequests)
    /\ elevatorRequests' = elevatorRequests \ {position}
    /\ floorRequests' = floorRequests \ {position}
    /\ time' = time + 2
    /\ UNCHANGED << direction, position >>

directionChange ==
    IF (direction = "up" /\ position > 1 /\ {x \in (elevatorRequests \union floorRequests) : x > position } = {}) THEN 
        /\ direction' = "down"
        /\ UNCHANGED << elevatorRequests, floorRequests, position, time>>
    ELSE IF (direction = "down" /\ position > 1 /\ {x \in (elevatorRequests \union floorRequests) : x < position } = {}) THEN 
        /\ direction' = "up"
        /\ UNCHANGED << elevatorRequests, floorRequests, position, time >>
    ELSE UNCHANGED vars

\* eventually, there will be no outstanding requests in the system, implying that all requests will be serviced eventually
requestLiveness == []<>(elevatorRequests = {} /\ floorRequests = {})

TimeOut == time < MAXTIME
    
Next == 
    \/ \E f \in 1..Floors : floorButtonRequest(f)
    \/ \E f \in 1..Floors : elevatorButtonRequest(f)
    \/ moveElevator
    \/ elevatorDoesNotMove
    \/ directionChange  

Spec == Init /\ [][Next]_vars    
====