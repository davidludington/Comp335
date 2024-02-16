package edu.luc.cs271.arrayqueue;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import net.jqwik.api.state.*;


class TestSimpleQueueJqwik {

  class OfferAction implements Action.Independent<SimpleQueue<String>> {
    @Override
    public boolean precondition(final SimpleQueue<String> queue) {
      // TODO implement precondition for offer method
      return !queue.isFull() && queue.capacity() > 0;
    }
    @Override
    public Arbitrary<Transformer<SimpleQueue<String>>> transformer() {
      final var offerElements = Arbitraries.strings().alpha().ofLength(5);
      return offerElements.map(element -> Transformer.mutate(
        String.format("offer(%s)", element),
        queue -> {
          // TODO capture state before offer, perform, and check postcondition
          final var sizeBefore = queue.size();
          final var peekBefore = queue.peek();
          assertTrue(queue.offer(element));
          assertFalse(queue.isEmpty());
          assertEquals(sizeBefore + 1, queue.size());
        }
      ));
    }
  }

  private Action<SimpleQueue<String>> poll() {
    return Action.<SimpleQueue<String>>builder()
      .describeAs("poll")
      .justMutate(queue -> {
        // TODO capture state before poll, perform, and check postcondition
        final var sizeBefore = queue.size();
        final var peek = queue.peek();
        final var poll = queue.poll();
        assertEquals(poll, peek);
        if(sizeBefore >= 1){
          assertEquals(queue.size(), sizeBefore - 1);
        }
        
      });
  }

  /*
  
  private Action<SimpleQueue<String>> clear() {
    return Action.<SimpleQueue<String>>builder()
      .describeAs("clear")
      .justMutate(queue -> {
        // TODO capture state before poll, perform, and check postcondition

        assertTrue(!queue.isEmpty());
        queue.clear();
        assertTrue(queue.isEmpty());
        
      });

  }
  */
  
  class clearTest implements Action.Independent<SimpleQueue<String>> {
    @Override
    public boolean precondition(final SimpleQueue<String> queue) {
      // TODO implement precondition for offer method
      return !queue.isFull() && queue.capacity() > 0;
    }
    @Override
    public Arbitrary<Transformer<SimpleQueue<String>>> transformer() {
      final var offerElements = Arbitraries.strings().alpha().ofLength(5);
      return offerElements.map(element -> Transformer.mutate(
        String.format("offer(%s)", element),
        queue -> {
          assertTrue(queue.offer(element));
          assertFalse(queue.isEmpty());
          queue.clear();
          assertTrue(queue.isEmpty());
        }
      ));
    }
  }
      

  

  
  // TODO extra credit: apply property to different queue capacities
  @Property
  void checkSimpleQueue(@ForAll("simpleQueueActions") final ActionChain<SimpleQueue<String>> chain) {
    // TODO insert observable data invariant(s) for 0 <= size <= capacity
    chain
    

    .run();
  }

  @Property
  void checkSimpleQueueDifferntSize(@ForAll("simpleQueueActionsCapacity3") final ActionChain<SimpleQueue<String>> chain) {
    // TODO insert observable data invariant(s) for 0 <= size <= capacity
    chain
    

    .run();
  }

  @Provide
  Arbitrary<ActionChain<SimpleQueue<String>>> simpleQueueActions() {
    return ActionChain
      .<SimpleQueue<String>>startWith(() -> new FixedArrayQueue<String>(5))
      .withAction(new OfferAction())
      .withAction(poll())
      .withAction(new clearTest());

  }

  @Provide
  Arbitrary<ActionChain<SimpleQueue<String>>> simpleQueueActionsCapacity3() {
    return ActionChain
      .<SimpleQueue<String>>startWith(() -> new FixedArrayQueue<String>(3))
      .withAction(new OfferAction())
      .withAction(poll())
      .withAction(new clearTest());

  }
  
}

