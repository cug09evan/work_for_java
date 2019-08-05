package com.marvel.book.coding_interview_guide.chapter01.stack_and_queue.pet;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getPetType().equals("dog")) {
            this.dogQ.add(new PetEnterQueue(pet, this.count++));
        } else if (pet.getPetType().equals("cat")) {
            this.catQ.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("error, no dog or cat");
        }
    }

    public Pet pollAll() {
        if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                return this.dogQ.peek().getPet();
            } else {
                return this.catQ.peek().getPet();
            }
        } else if (!this.dogQ.isEmpty()) {
            return this.dogQ.peek().getPet();
        } else if (!this.catQ.isEmpty()) {
            return this.catQ.peek().getPet();
        } else {
            throw new RuntimeException("error, queue is empty");
        }
    }

    public Dog pollDog() {
        if (!this.isDogQueueEmpty()) {
            return (Dog) this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("Dog queue is empty");
        }
    }

    public Cat pollCat() {
        if (!this.isCatQueueEmpty()) {
            return (Cat) this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("Cat queue is empty");
        }
    }

    public boolean isEmpty() {
        return this.isDogQueueEmpty() && this.isCatQueueEmpty();
    }

    public boolean isDogQueueEmpty() {
        return this.dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return this.catQ.isEmpty();
    }
}
