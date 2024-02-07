package edu.luc.cs271.arrayqueue;

import java.util.ArrayList;
import java.util.List;

public class FixedArrayQueue<E> implements SimpleQueue<E> {

  private final int capacity;

  private int size;

  private int front;

  private int rear;

  private final E[] data;

  // TODO why do we need an explicit constructor?

  @SuppressWarnings("unchecked")
  public FixedArrayQueue(final int capacity) {
    // TODO check argument validity
    if(capacity < 0){
      throw new IllegalArgumentException("Capacity cannot be less that zero");
    }
    this.capacity = capacity;
    this.data = (E[]) new Object[capacity];
    this.size = 0;
    this.front = 0;
    this.rear = capacity - 1;
  }

  @Override
  public boolean offer(final E obj) {
    // TODO

    if(isFull()){
      return false;
    } else{
      rear = (rear + 1) % capacity;
      data[rear] = obj;
      size++;
    }
    return true;
  }

  @Override
  public E peek() {
    // TODO
    if(isEmpty()){
      return null;
    } else{
      return data[front];
    } 
    
  }

  @Override
  public E poll() {
    // TODO

    if(isEmpty()){
      return null;
    } else {
      E element = data[front];
    front = (front + 1) % capacity;
    size--;
    return element;
    }
  }

  @Override
  public boolean isEmpty() {
    // TODO
    return size == 0;
    
  }

  @Override
  public boolean isFull() {
    // TODO
    return (size == capacity);
    
    /*
    if((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))){
      return true;
    }
    return false;
    */
    
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public int capacity() {
    return capacity;
  }

  @Override
  public List<E> asList() {
    // TODO implement using an ArrayList preallocated with the right size
    final ArrayList<E> result = new ArrayList<>(size);
    int idx = front;
    for(int i = 0; i < size; i++){
      result.add(data[idx]);
      idx = (idx + 1) % capacity;
    }
    
    return result;
  }
}
